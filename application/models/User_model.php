<?php
defined('BASEPATH') OR exit('No direct script access allowed');

class User_model extends CI_Model {
    
    /**
    * @var int
    */
    private $userID;
    
    /**
    * @var string
    */
    private $userEmail;
    
    /**
    * @var int
    */
    private $userFacebookID;
    
    /**
    * @var int
    */
    private $userTwitterID;
    
    public function __construct() {
        parent::__construct();
    }
    
    /*
    * @param string $email
    * @param string $password
    * @return array
    */
    public function signUpWithEmail($email, $password) {
        
        // Validation check
        if(empty($email) || empty($password)) {
            return array('status' => false, 'msg' => 'Missing arguments');
        }
        
        
    }
    
    /**
    * @param string $email
    * @param string $password
    * @return array
    */
    public function loginWithEmail($email, $password) {
        
        // Validation check
        if(empty($email) || empty($password)) {
            return array('status' => false, 'msg' => 'Missing arguments');
        }
    }
}
?>