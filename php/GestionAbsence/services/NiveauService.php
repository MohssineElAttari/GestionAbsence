<?php

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
include_once '../dao/ICrud.php';
include_once '../connection/Connection.php';
/**
 * Description of AbsenceService
 *
 * @author Abdelilah Boutizoua
 */
class NiveauService implements ICrud {
    
    private $conn;
    
    function __construct() {
        $this->conn = new Connection();
    }
    
    public function create($obj) {
        
    }
        
        

    public function delete($id) {
        
       
    }

    public function findAll() {
        
        $sql = 'SELECT * FROM niveau';
        $stmt = $this->conn->getConn()->prepare($sql);
        $stmt->execute();
        return $stmt->fetchAll();
    }

    public function findById($id) {
        
        
    }

    public function update($obj) {
        
       
    }
    
    
    

}
