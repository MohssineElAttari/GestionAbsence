<?php

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
include_once '../dao/ICrud.php';
include_once '../connection/Connection.php';
/**
 * Description of FiliereService
 *
 * @author Abdelilah Boutizoua
 */
class FiliereService implements ICrud {
    
    private $conn;

    function __construct() {
        $this->conn = new Connection();
    }
    
    public function create($obj) {
        
        $sql = 'INSERT INTO filieres(code,libelle) VALUES(:code,:libelle)';
        $stmt = $this->conn->getConn()->prepare($sql);
        $stmt->execute(['code' => $obj->getCode(),'libelle' => $obj->getLibelle()]);
        
    }

    public function delete($id) {
        $sql = 'DELETE FROM filieres WHERE id = :id';
        $stmt = $this->conn->getConn()->prepare($sql);
        $stmt->execute(['id' => $id]);
    }

    public function findAll() {
        $sql = 'SELECT * FROM filieres';
        $stmt = $this->conn->getConn()->prepare($sql);
        $stmt->execute();
        return $stmt->fetchAll();
    }

    public function findById($id) {
        $sql = 'SELECT * FROM filieres where id = :id';
        $stmt = $this->conn->getConn()->prepare($sql);
        $stmt->execute(['id' => $id]);
        return $stmt->fetch();
    }

    public function update($obj) {
        
        $sql = 'UPDATE filieres SET code = :code, libelle = :libelle WHERE id = :id';
        $stmt = $this->conn->getConn()->prepare($sql);
        $stmt->execute(['code' => $obj->getCode(),'libelle' => $obj->getLibelle(),'id' => $obj->getId()]);
    }

}
