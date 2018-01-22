/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.stolpjakten.api.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import se.stolpjakten.api.db.facade.ConfigurationFacadeDB;
import se.stolpjakten.api.db.type.Configuration;

/**
 *
 * @author gengdahl
 */
public enum ConfigurationStore {
    //Password pattern: https://stackoverflow.com/questions/19605150/regex-for-password-must-contain-at-least-eight-characters-at-least-one-number-a
    PASSWORD_PATTERN("PASSWORD_PATTERN", "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$"),
    USERNAME_PATTERN("USERNAME_PATTERN", "[\\w]{4,20}");
    private String key;
    private String defaultValue;
    private ConfigurationFacadeDB db;
    private Map<String, Configuration> cache = new HashMap();

    ConfigurationStore(String key, String defaultValue) {
        this.key = key;
        this.defaultValue = defaultValue;
        db = new ConfigurationFacadeDB();
    }

    public String get() {

        Configuration cfg = cache.get(key);
        if (cfg == null) {
            cfg = db.find(key);
            cache.put(key, cfg);

        }
        if (cfg == null) {
            return defaultValue;
        } else {
            return cfg.getCfgValue();
        }
    }

    public synchronized void set(String value) {
        Configuration cfg = new Configuration(key, value);
        db.edit(cfg);
        cache.put(key, cfg);

    }

    public se.stolpjakten.api.rest.type.Configuration toConfiguration() {
        se.stolpjakten.api.rest.type.Configuration cfg
                = new se.stolpjakten.api.rest.type.Configuration();
        cfg.key = key;
        cfg.value = get();
        return cfg;
    }

    public static List<se.stolpjakten.api.rest.type.Configuration> toConfigurations() {
        List<se.stolpjakten.api.rest.type.Configuration> configurations
                = new ArrayList<>(ConfigurationStore.values().length);
        for (ConfigurationStore cfg : ConfigurationStore.values()) {
            cfg.get();
            configurations.add(cfg.toConfiguration());
        }
        return configurations;

    }

}
