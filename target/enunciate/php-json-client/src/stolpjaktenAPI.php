<?php

/**
 *
 * 
 *
 * Generated by <a href="http://enunciate.webcohesion.com">Enunciate</a>.
 *
 */
 

namespace Se\Stolpjakten\Api\Rest\Type;

/**
 * (no documentation provided)
 */
class Configuration
{

    /**
     * Configuration key.
     *
     * @var string
     */
    private $key;

    /**
     * Configuration value.
     *
     * @var string
     */
    private $value;

    /**
     * Constructs a Configuration from a (parsed) JSON hash
     *
     * @param mixed $o JSON array.
     */
    public function __construct($o = null)
    {
        $this->initFromArray($o);
    }

    /**
     * Configuration key.
     *
     * @return string
     */
    public function getKey()
    {
        return $this->key;
    }

    /**
     * Configuration key.
     *
     * @param string $key
     */
    public function setKey($key)
    {
        $this->key = $key;
    }
    /**
     * Configuration value.
     *
     * @return string
     */
    public function getValue()
    {
        return $this->value;
    }

    /**
     * Configuration value.
     *
     * @param string $value
     */
    public function setValue($value)
    {
        $this->value = $value;
    }
    /**
     * Returns the associative array for this Configuration
     *
     * @return array
     */
    public function toArray()
    {
        $a = array();
        if ($this->key) {
            $a["key"] = $this->key;
        }
        if ($this->value) {
            $a["value"] = $this->value;
        }
        return $a;
    }

    /**
     * Returns the JSON string for this Configuration
     *
     * @return string
     */
    public function toJson()
    {
        return json_encode($this->toArray());
    }

    /**
     * Initializes this Configuration from an associative array
     *
     * @param array $o
     */
    public function initFromArray($o)
    {
        if (isset($o['key'])) {
            $this->key = $o["key"];
        }
        if (isset($o['value'])) {
            $this->value = $o["value"];
        }
    }
}

namespace Se\Stolpjakten\Api\Rest\Type;

/**
 * (no documentation provided)
 */
class Token
{

    /**
     * The Bearer access token to be used for token protected endpoints.
     * &lt;br&gt;&lt;br&gt;
     * Sample value:
     * &lt;br&gt;
     * 5eb19a75-c1d2-4d57-b1ec-4c61ff3c3cf2
     *
     * @var string
     */
    private $accessToken;

    /**
     * Type of access token, currently only Bearer tokens are supported.
     * &lt;br&gt;&lt;br&gt;
     * Sample value:
     * &lt;br&gt;
     * Bearer
     *
     * @var string
     */
    private $type;

    /**
     * The seconds left of the token life time.
     * 
     * &lt;br&gt;&lt;br&gt;
     * Sample value:
     * &lt;br&gt; 3600
     *
     * @var integer
     */
    private $expire;

    /**
     * Constructs a Token from a (parsed) JSON hash
     *
     * @param mixed $o JSON array.
     */
    public function __construct($o = null)
    {
        $this->initFromArray($o);
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
    public function getAccessToken()
    {
        return $this->accessToken;
    }

    /**
     * The Bearer access token to be used for token protected endpoints.
       * &lt;br&gt;&lt;br&gt;
       * Sample value:
       * &lt;br&gt;
       * 5eb19a75-c1d2-4d57-b1ec-4c61ff3c3cf2
     *
     * @param string $accessToken
     */
    public function setAccessToken($accessToken)
    {
        $this->accessToken = $accessToken;
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
    public function getType()
    {
        return $this->type;
    }

    /**
     * Type of access token, currently only Bearer tokens are supported.
       * &lt;br&gt;&lt;br&gt;
       * Sample value:
       * &lt;br&gt;
       * Bearer
     *
     * @param string $type
     */
    public function setType($type)
    {
        $this->type = $type;
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
    public function getExpire()
    {
        return $this->expire;
    }

    /**
     * The seconds left of the token life time.
       * 
       * &lt;br&gt;&lt;br&gt;
       * Sample value:
       * &lt;br&gt; 3600
     *
     * @param integer $expire
     */
    public function setExpire($expire)
    {
        $this->expire = $expire;
    }
    /**
     * Returns the associative array for this Token
     *
     * @return array
     */
    public function toArray()
    {
        $a = array();
        if ($this->accessToken) {
            $a["accessToken"] = $this->accessToken;
        }
        if ($this->type) {
            $a["type"] = $this->type;
        }
        if ($this->expire) {
            $a["expire"] = $this->expire;
        }
        return $a;
    }

    /**
     * Returns the JSON string for this Token
     *
     * @return string
     */
    public function toJson()
    {
        return json_encode($this->toArray());
    }

    /**
     * Initializes this Token from an associative array
     *
     * @param array $o
     */
    public function initFromArray($o)
    {
        if (isset($o['accessToken'])) {
            $this->accessToken = $o["accessToken"];
        }
        if (isset($o['type'])) {
            $this->type = $o["type"];
        }
        if (isset($o['expire'])) {
            $this->expire = $o["expire"];
        }
    }
}

namespace Se\Stolpjakten\Api\Rest\Type;

/**
 * (no documentation provided)
 */
class User
{

    /**
     * Email address for this user.
     * &lt;br&gt;
     * Required: no
     *
     * @var string
     */
    private $email;

    /**
     * A globally unique username that identifies a user.
     * &lt;br&gt;
     * Required: yes
     *
     * @var string
     */
    private $userName;

    /**
     * Password for this user.
     * &lt;br&gt;
     * Only available for add (POST) and update (PUT) requests.
     * &lt;br&gt;
     * Stored in database using salted one-way hash algorithm with.
     * &lt;br&gt;
     * Required: yes
     *
     * @var string
     */
    private $password;

    /**
     * Constructs a User from a (parsed) JSON hash
     *
     * @param mixed $o JSON array.
     */
    public function __construct($o = null)
    {
        $this->initFromArray($o);
    }

    /**
     * Email address for this user.
       * &lt;br&gt;
       * Required: no
     *
     * @return string
     */
    public function getEmail()
    {
        return $this->email;
    }

    /**
     * Email address for this user.
       * &lt;br&gt;
       * Required: no
     *
     * @param string $email
     */
    public function setEmail($email)
    {
        $this->email = $email;
    }
    /**
     * A globally unique username that identifies a user.
       * &lt;br&gt;
       * Required: yes
     *
     * @return string
     */
    public function getUserName()
    {
        return $this->userName;
    }

    /**
     * A globally unique username that identifies a user.
       * &lt;br&gt;
       * Required: yes
     *
     * @param string $userName
     */
    public function setUserName($userName)
    {
        $this->userName = $userName;
    }
    /**
     * Password for this user.
       * &lt;br&gt;
       * Only available for add (POST) and update (PUT) requests.
       * &lt;br&gt;
       * Stored in database using salted one-way hash algorithm with.
       * &lt;br&gt;
       * Required: yes
     *
     * @return string
     */
    public function getPassword()
    {
        return $this->password;
    }

    /**
     * Password for this user.
       * &lt;br&gt;
       * Only available for add (POST) and update (PUT) requests.
       * &lt;br&gt;
       * Stored in database using salted one-way hash algorithm with.
       * &lt;br&gt;
       * Required: yes
     *
     * @param string $password
     */
    public function setPassword($password)
    {
        $this->password = $password;
    }
    /**
     * Returns the associative array for this User
     *
     * @return array
     */
    public function toArray()
    {
        $a = array();
        if ($this->email) {
            $a["email"] = $this->email;
        }
        if ($this->userName) {
            $a["userName"] = $this->userName;
        }
        if ($this->password) {
            $a["password"] = $this->password;
        }
        return $a;
    }

    /**
     * Returns the JSON string for this User
     *
     * @return string
     */
    public function toJson()
    {
        return json_encode($this->toArray());
    }

    /**
     * Initializes this User from an associative array
     *
     * @param array $o
     */
    public function initFromArray($o)
    {
        if (isset($o['email'])) {
            $this->email = $o["email"];
        }
        if (isset($o['userName'])) {
            $this->userName = $o["userName"];
        }
        if (isset($o['password'])) {
            $this->password = $o["password"];
        }
    }
}

namespace Se\Stolpjakten\Api\Rest\Error;

/**
 * (no documentation provided)
 */
class BaseError
{

    /**
     * Human readable description for this error.
     *
     * @var string
     */
    private $description;

    /**
     * Constructs a BaseError from a (parsed) JSON hash
     *
     * @param mixed $o JSON array.
     */
    public function __construct($o = null)
    {
        $this->initFromArray($o);
    }

    /**
     * Human readable description for this error.
     *
     * @return string
     */
    public function getDescription()
    {
        return $this->description;
    }

    /**
     * Human readable description for this error.
     *
     * @param string $description
     */
    public function setDescription($description)
    {
        $this->description = $description;
    }
    /**
     * Returns the associative array for this BaseError
     *
     * @return array
     */
    public function toArray()
    {
        $a = array();
        if ($this->description) {
            $a["description"] = $this->description;
        }
        return $a;
    }

    /**
     * Returns the JSON string for this BaseError
     *
     * @return string
     */
    public function toJson()
    {
        return json_encode($this->toArray());
    }

    /**
     * Initializes this BaseError from an associative array
     *
     * @param array $o
     */
    public function initFromArray($o)
    {
        if (isset($o['description'])) {
            $this->description = $o["description"];
        }
    }
}

namespace Se\Stolpjakten\Api\Db\Type;

/**
 * (no documentation provided)
 */
class Users
{

    /**
     * A globally unique username that identifies a user.
     * &lt;br&gt;
     * Required: yes
     *
     * @var string
     */
    private $userName;

    /**
     * Email address for this user.
     * &lt;br&gt;
     * Required: no
     *
     * @var string
     */
    private $email;

    /**
     * Password for this user.
     * &lt;br&gt;
     * Only available for add (POST) and update (PUT) requests.
     * &lt;br&gt;
     * Stored in database using salted one-way hash algorithm with.
     * &lt;br&gt;
     * Required: yes
     *
     * @var string
     */
    private $password;

    /**
     * Constructs a Users from a (parsed) JSON hash
     *
     * @param mixed $o JSON array.
     */
    public function __construct($o = null)
    {
        $this->initFromArray($o);
    }

    /**
     * A globally unique username that identifies a user.
       * &lt;br&gt;
       * Required: yes
     *
     * @return string
     */
    public function getUserName()
    {
        return $this->userName;
    }

    /**
     * A globally unique username that identifies a user.
       * &lt;br&gt;
       * Required: yes
     *
     * @param string $userName
     */
    public function setUserName($userName)
    {
        $this->userName = $userName;
    }
    /**
     * Email address for this user.
       * &lt;br&gt;
       * Required: no
     *
     * @return string
     */
    public function getEmail()
    {
        return $this->email;
    }

    /**
     * Email address for this user.
       * &lt;br&gt;
       * Required: no
     *
     * @param string $email
     */
    public function setEmail($email)
    {
        $this->email = $email;
    }
    /**
     * Password for this user.
       * &lt;br&gt;
       * Only available for add (POST) and update (PUT) requests.
       * &lt;br&gt;
       * Stored in database using salted one-way hash algorithm with.
       * &lt;br&gt;
       * Required: yes
     *
     * @return string
     */
    public function getPassword()
    {
        return $this->password;
    }

    /**
     * Password for this user.
       * &lt;br&gt;
       * Only available for add (POST) and update (PUT) requests.
       * &lt;br&gt;
       * Stored in database using salted one-way hash algorithm with.
       * &lt;br&gt;
       * Required: yes
     *
     * @param string $password
     */
    public function setPassword($password)
    {
        $this->password = $password;
    }
    /**
     * Returns the associative array for this Users
     *
     * @return array
     */
    public function toArray()
    {
        $a = array();
        if ($this->userName) {
            $a["userName"] = $this->userName;
        }
        if ($this->email) {
            $a["email"] = $this->email;
        }
        if ($this->password) {
            $a["password"] = $this->password;
        }
        return $a;
    }

    /**
     * Returns the JSON string for this Users
     *
     * @return string
     */
    public function toJson()
    {
        return json_encode($this->toArray());
    }

    /**
     * Initializes this Users from an associative array
     *
     * @param array $o
     */
    public function initFromArray($o)
    {
        if (isset($o['userName'])) {
            $this->userName = $o["userName"];
        }
        if (isset($o['email'])) {
            $this->email = $o["email"];
        }
        if (isset($o['password'])) {
            $this->password = $o["password"];
        }
    }
}

namespace Se\Stolpjakten\Api\Rest\Error;

/**
 * (no documentation provided)
 */
class ErrorCode
{

    /**
     *  JSON is not syntactically  correct.
    *  &lt;br&gt;
    *  Please make sure to use JSON lib to create your payload.
     */
    const JSON_SYNTAX = "JSON_SYNTAX";

    /**
     *  JSON is not semantically correct.
    *  &lt;br&gt;
    *  Please consult API documentation to assert you follow the correct format.
     */
    const JSON_SEMATIC = "JSON_SEMATIC";

    /**
     *  JSON field &quot;userName&quot; is not correct.
    *  &lt;br&gt;
    *  Please consult Configuration setting: USERNAME_PATTERN 
     */
    const JSON_FIELD_USERNAME = "JSON_FIELD_USERNAME";

    /**
     *  JSON field &quot;email&quot; is not correct.
    *  &lt;br&gt;
    *  Email address must pass validation by javax.mail.internet.InternetAddress
     */
    const JSON_FIELD_EMAIL = "JSON_FIELD_EMAIL";

    /**
     *  JSON field &quot;password&quot; is not correct.
    *  &lt;br&gt;
    *  Please consult Configuration setting: PASSWORD_PATTERN 
     */
    const JSON_FIELD_PASSWORD = "JSON_FIELD_PASSWORD";

    /**
     *  Can not create resource, because it already exists.
    *  &lt;br&gt;
    *  POST another resource or use PUT to edit existing resource.
     */
    const RESOURCE_EXISTS = "RESOURCE_EXISTS";

    /**
     *  Requested resource was not found.
    *  &lt;br&gt;
    *  Could not find requested resource, maybe you want to POST to create it?
     */
    const RESOURCE_NOT_EXISTS = "RESOURCE_NOT_EXISTS";
}

namespace Se\Stolpjakten\Api\Rest\Error;

/**
 * (no documentation provided)
 */
class InternalServerError extends \Se\Stolpjakten\Api\Rest\Error\BaseError
{

    /**
     * 
     *
     * @var string
     */
    private $identifier;

    /**
     * Constructs a InternalServerError from a (parsed) JSON hash
     *
     * @param mixed $o JSON array.
     */
    public function __construct($o = null)
    {
        $this->initFromArray($o);
    }

    /**
     * 
     *
     * @return string
     */
    public function getIdentifier()
    {
        return $this->identifier;
    }

    /**
     * 
     *
     * @param string $identifier
     */
    public function setIdentifier($identifier)
    {
        $this->identifier = $identifier;
    }
    /**
     * Returns the associative array for this InternalServerError
     *
     * @return array
     */
    public function toArray()
    {
        $a = parent::toArray();
        if ($this->identifier) {
            $a["identifier"] = $this->identifier;
        }
        return $a;
    }


    /**
     * Initializes this InternalServerError from an associative array
     *
     * @param array $o
     */
    public function initFromArray($o)
    {
        parent::initFromArray($o);
        if (isset($o['identifier'])) {
            $this->identifier = $o["identifier"];
        }
    }
}

namespace Se\Stolpjakten\Api\Rest\Error;

/**
 * (no documentation provided)
 */
class NotFound extends \Se\Stolpjakten\Api\Rest\Error\BaseError
{

    /**
     * Constructs a NotFound from a (parsed) JSON hash
     *
     * @param mixed $o JSON array.
     */
    public function __construct($o = null)
    {
        $this->initFromArray($o);
    }

    /**
     * Returns the associative array for this NotFound
     *
     * @return array
     */
    public function toArray()
    {
        $a = parent::toArray();
        return $a;
    }


    /**
     * Initializes this NotFound from an associative array
     *
     * @param array $o
     */
    public function initFromArray($o)
    {
        parent::initFromArray($o);
    }
}

namespace Se\Stolpjakten\Api\Rest\Error;

/**
 * (no documentation provided)
 */
class Unauthorized extends \Se\Stolpjakten\Api\Rest\Error\BaseError
{

    /**
     * Constructs a Unauthorized from a (parsed) JSON hash
     *
     * @param mixed $o JSON array.
     */
    public function __construct($o = null)
    {
        $this->initFromArray($o);
    }

    /**
     * Returns the associative array for this Unauthorized
     *
     * @return array
     */
    public function toArray()
    {
        $a = parent::toArray();
        return $a;
    }


    /**
     * Initializes this Unauthorized from an associative array
     *
     * @param array $o
     */
    public function initFromArray($o)
    {
        parent::initFromArray($o);
    }
}

namespace Se\Stolpjakten\Api\Rest\Error;

/**
 * (no documentation provided)
 */
class BadRequest extends \Se\Stolpjakten\Api\Rest\Error\BaseError
{

    /**
     * The Error code.
     *
     * @var string
     */
    private $errorCode;

    /**
     * Constructs a BadRequest from a (parsed) JSON hash
     *
     * @param mixed $o JSON array.
     */
    public function __construct($o = null)
    {
        $this->initFromArray($o);
    }

    /**
     * The Error code.
     *
     * @return string
     */
    public function getErrorCode()
    {
        return $this->errorCode;
    }

    /**
     * The Error code.
     *
     * @param string $errorCode
     */
    public function setErrorCode($errorCode)
    {
        $this->errorCode = $errorCode;
    }
    /**
     * Returns the associative array for this BadRequest
     *
     * @return array
     */
    public function toArray()
    {
        $a = parent::toArray();
        if ($this->errorCode) {
            $a["errorCode"] = $this->errorCode;
        }
        return $a;
    }


    /**
     * Initializes this BadRequest from an associative array
     *
     * @param array $o
     */
    public function initFromArray($o)
    {
        parent::initFromArray($o);
        if (isset($o['errorCode'])) {
            $this->errorCode = $o["errorCode"];
        }
    }
}

namespace Se\Stolpjakten\Api\Rest\Error;

/**
 * (no documentation provided)
 */
class Forbidden extends \Se\Stolpjakten\Api\Rest\Error\BaseError
{

    /**
     * Constructs a Forbidden from a (parsed) JSON hash
     *
     * @param mixed $o JSON array.
     */
    public function __construct($o = null)
    {
        $this->initFromArray($o);
    }

    /**
     * Returns the associative array for this Forbidden
     *
     * @return array
     */
    public function toArray()
    {
        $a = parent::toArray();
        return $a;
    }


    /**
     * Initializes this Forbidden from an associative array
     *
     * @param array $o
     */
    public function initFromArray($o)
    {
        parent::initFromArray($o);
    }
}
