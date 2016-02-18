<?php
defined('BASEPATH') OR exit('No direct script access allowed');

class User_controller extends CI_Controller {
    
    public function __construct() {
        parent::__construct();
    }
    
    public function signup() {
        $type = $this->input->post('type');
        
        switch($type) {
            case "email":
                // sign up logic here
            break;
            default:
                // default handling
            break;    
        }
    }
    
    public function signin() {
        $type = $this->input->post('type');
        
        switch($type) {
            case "email":
                // sign in logic
            break;
            default:
                // default handling
            break;
        }
    }
}
?>