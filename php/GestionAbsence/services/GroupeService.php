<?php

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
include_once '../dao/ICrud.php';
include_once '../connection/Connection.php';
/**
 * Description of GroupeService
 *
 * @author Abdelilah Boutizoua
 */
class GroupeService implements ICrud {
    
    private $conn;
    
    function __construct() {
        $this->conn = new Connection();
    }
    
    public function create($obj) {
    
        $sql = 'INSERT INTO groupes(code,libelle,filiere_id) VALUES(:code,:libelle,:filiere)';
        $stmt = $this->conn->getConn()->prepare($sql);
        $stmt->execute(['code' => $obj->getCode(), 'libelle'=>$obj->getNom(),'filiere'=>$obj->getFiliere()]);
    }

    public function delete($id) {
        $sql = 'DELETE FROM groupes WHERE id = :id';
        $stmt = $this->conn->getConn()->prepare($sql);
        $stmt->execute(['id' => $id]);
    }

    public function findAll() {
        $sql = 'SELECT * FROM groupes';
        $stmt = $this->conn->getConn()->prepare($sql);
        $stmt->execute();
        return $stmt->fetchAll();
    }

    public function findById($id) {
        $sql = 'SELECT * FROM groupes WHERE id = :id';
        $stmt = $this->conn->getConn()->prepare($sql);
        $stmt->execute(['id'=>$id]);
        return $stmt->fetch();
    }
    
    public function findByFiliere($idFiliere){
        
        $sql = 'SELECT * FROM groupes WHERE filiere_id = :id';
        $stmt = $this->conn->getConn()->prepare($sql);
        $stmt->execute(['id'=>$idFiliere]);
        return $stmt->fetchAll();
        
    }

    public function update($obj) {
        $sql = 'UPDATE groupes SET code=:code,libelle=:libelle,filiere_id=:filiere_id WHERE id = :id';
        $stmt = $this->conn->getConn()->prepare($sql);
        $stmt->execute(['id'=>$obj->getId(),'code' => $obj->getCode(), 'libelle'=>$obj->getNom(),'filiere_id'=>$obj->getFiliere()]);
    }

}
