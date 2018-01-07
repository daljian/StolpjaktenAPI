/**
 * 
 *
 * Generated by <a href="http://enunciate.webcohesion.com">Enunciate</a>.
 */
 
/**
 * UMD load definition that supports AMD, CommonJS and browser globals.
 * https://github.com/umdjs/umd/blob/992cc0d071b7ebcd7feaad2a5349bdbeab09a0fe/commonjsStrict.js
 */
(function (root, factory) {
  if (typeof define === 'function' && define.amd) {
    // AMD. Register as an anonymous module.
    define(['exports'], factory);
  } else if (typeof exports === 'object') {
    // CommonJS
    factory(exports);
  } else {
    // Browser globals
    factory(root.javascriptClient = {});
  }
}(this, function (exports) {
 
 'use strict';
 

/**
 * (no documentation provided)
 */
ensureNamespace('Se.Stolpjakten.Api.Rest');
exports.Se.Stolpjakten.Api.Rest.User = class {

    /**
     * Constructs a User from a JSON object
     *
     * @param Object o JSON object.
     */
    constructor(o) {
        var self = this;
        if (typeof o['password'] !== 'undefined') {
            this.password = o['password'];
        }
        if (typeof o['email'] !== 'undefined') {
            this.email = o['email'];
        }
        if (typeof o['userName'] !== 'undefined') {
            this.userName = o['userName'];
        }
    }

    /**
     * Password for this user.
       * &lt;br&gt;
       * Only available for add (POST) and update (PUT) requests.
       * &lt;br&gt;
       * Stored in database using xxx one-way hash algorithm with key yyy and salt length ZZZ.
       * &lt;br&gt;
       * Required: yes
     *
     * @return string
     */
    getPassword() {
        return this.password;
    }

    /**
     * Password for this user.
       * &lt;br&gt;
       * Only available for add (POST) and update (PUT) requests.
       * &lt;br&gt;
       * Stored in database using xxx one-way hash algorithm with key yyy and salt length ZZZ.
       * &lt;br&gt;
       * Required: yes
     *
     * @param string password
     */
    setPassword(password) {
        this.password = password;
    }
    /**
     * Email address for this user.
       * &lt;br&gt;
       * Required: no
     *
     * @return string
     */
    getEmail() {
        return this.email;
    }

    /**
     * Email address for this user.
       * &lt;br&gt;
       * Required: no
     *
     * @param string email
     */
    setEmail(email) {
        this.email = email;
    }
    /**
     * A globally unique username that identifies a user.
       * &lt;br&gt;
       * Required: yes
     *
     * @return string
     */
    getUserName() {
        return this.userName;
    }

    /**
     * A globally unique username that identifies a user.
       * &lt;br&gt;
       * Required: yes
     *
     * @param string userName
     */
    setUserName(userName) {
        this.userName = userName;
    }

    /**
     * Returns a JSON object for this User
     *
     * @return object
     */
    toJSON() {
        var json = {};
        var self = this;
        if (typeof this.password !== 'undefined') {
            json['password'] = this.password;
        }
        if (typeof this.email !== 'undefined') {
            json['email'] = this.email;
        }
        if (typeof this.userName !== 'undefined') {
            json['userName'] = this.userName;
        }
        return json;
    }

}

/**
 * (no documentation provided)
 */
ensureNamespace('Se.Stolpjakten.Api.Db');
exports.Se.Stolpjakten.Api.Db.Humans = class {

    /**
     * Constructs a Humans from a JSON object
     *
     * @param Object o JSON object.
     */
    constructor(o) {
        var self = this;
        if (typeof o['userName'] !== 'undefined') {
            this.userName = o['userName'];
        }
        if (typeof o['email'] !== 'undefined') {
            this.email = o['email'];
        }
        if (typeof o['password'] !== 'undefined') {
            this.password = o['password'];
        }
        if (typeof o['salt'] !== 'undefined') {
            this.salt = o['salt'];
        }
    }

    /**
     * A globally unique username that identifies a user.
       * &lt;br&gt;
       * Required: yes
     *
     * @return string
     */
    getUserName() {
        return this.userName;
    }

    /**
     * A globally unique username that identifies a user.
       * &lt;br&gt;
       * Required: yes
     *
     * @param string userName
     */
    setUserName(userName) {
        this.userName = userName;
    }
    /**
     * Email address for this user.
       * &lt;br&gt;
       * Required: no
     *
     * @return string
     */
    getEmail() {
        return this.email;
    }

    /**
     * Email address for this user.
       * &lt;br&gt;
       * Required: no
     *
     * @param string email
     */
    setEmail(email) {
        this.email = email;
    }
    /**
     * Password for this user.
       * &lt;br&gt;
       * Only available for add (POST) and update (PUT) requests.
       * &lt;br&gt;
       * Stored in database using xxx one-way hash algorithm with key yyy and salt length ZZZ.
       * &lt;br&gt;
       * Required: yes
     *
     * @return string
     */
    getPassword() {
        return this.password;
    }

    /**
     * Password for this user.
       * &lt;br&gt;
       * Only available for add (POST) and update (PUT) requests.
       * &lt;br&gt;
       * Stored in database using xxx one-way hash algorithm with key yyy and salt length ZZZ.
       * &lt;br&gt;
       * Required: yes
     *
     * @param string password
     */
    setPassword(password) {
        this.password = password;
    }
    /**
     * 
     *
     * @return integer
     */
    getSalt() {
        return this.salt;
    }

    /**
     * 
     *
     * @param integer salt
     */
    setSalt(salt) {
        this.salt = salt;
    }

    /**
     * Returns a JSON object for this Humans
     *
     * @return object
     */
    toJSON() {
        var json = {};
        var self = this;
        if (typeof this.userName !== 'undefined') {
            json['userName'] = this.userName;
        }
        if (typeof this.email !== 'undefined') {
            json['email'] = this.email;
        }
        if (typeof this.password !== 'undefined') {
            json['password'] = this.password;
        }
        if (typeof this.salt !== 'undefined') {
            json['salt'] = this.salt;
        }
        return json;
    }

}

/**
 * (no documentation provided)
 */
ensureNamespace('Se.Stolpjakten.Api.Rest');
exports.Se.Stolpjakten.Api.Rest.Token = class {

    /**
     * Constructs a Token from a JSON object
     *
     * @param Object o JSON object.
     */
    constructor(o) {
        var self = this;
        if (typeof o['accessToken'] !== 'undefined') {
            this.accessToken = o['accessToken'];
        }
        if (typeof o['type'] !== 'undefined') {
            this.type = o['type'];
        }
        if (typeof o['expire'] !== 'undefined') {
            this.expire = o['expire'];
        }
    }

    /**
     * The Bearer access token to be used for token protected endpoints.
       * &lt;br&gt;&lt;br&gt;
       * Sample value:
       * &lt;br&gt;
       * 5eb19a75-c1d2-4d57-b1ec-4c61ff3c3cf2
     *
     * @return string
     */
    getAccessToken() {
        return this.accessToken;
    }

    /**
     * The Bearer access token to be used for token protected endpoints.
       * &lt;br&gt;&lt;br&gt;
       * Sample value:
       * &lt;br&gt;
       * 5eb19a75-c1d2-4d57-b1ec-4c61ff3c3cf2
     *
     * @param string accessToken
     */
    setAccessToken(accessToken) {
        this.accessToken = accessToken;
    }
    /**
     * Type of access token, currently only Bearer tokens are supported.
       * &lt;br&gt;&lt;br&gt;
       * Sample value:
       * &lt;br&gt;
       * Bearer
     *
     * @return string
     */
    getType() {
        return this.type;
    }

    /**
     * Type of access token, currently only Bearer tokens are supported.
       * &lt;br&gt;&lt;br&gt;
       * Sample value:
       * &lt;br&gt;
       * Bearer
     *
     * @param string type
     */
    setType(type) {
        this.type = type;
    }
    /**
     * The seconds left of the token life time.
       * 
       * &lt;br&gt;&lt;br&gt;
       * Sample value:
       * &lt;br&gt; 3600
     *
     * @return integer
     */
    getExpire() {
        return this.expire;
    }

    /**
     * The seconds left of the token life time.
       * 
       * &lt;br&gt;&lt;br&gt;
       * Sample value:
       * &lt;br&gt; 3600
     *
     * @param integer expire
     */
    setExpire(expire) {
        this.expire = expire;
    }

    /**
     * Returns a JSON object for this Token
     *
     * @return object
     */
    toJSON() {
        var json = {};
        var self = this;
        if (typeof this.accessToken !== 'undefined') {
            json['accessToken'] = this.accessToken;
        }
        if (typeof this.type !== 'undefined') {
            json['type'] = this.type;
        }
        if (typeof this.expire !== 'undefined') {
            json['expire'] = this.expire;
        }
        return json;
    }

}
  
  /**
   * Ensures that a namespace exists.
   */
  function ensureNamespace(namespace){
    var current = exports;
    namespace.split('.').forEach(function(name){
      if(typeof current[name] === 'undefined'){
        current[name] = {};
      }
      current = current[name];
    });
  }

}));

