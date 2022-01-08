<?php

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
include_once '../dao/ICrud.php';
include_once '../connection/Connection.php';

/**
 * Description of StagiaireService
 *
 * @author Abdelilah Boutizoua
 */
class StagiaireService implements ICrud {
    
    private $conn;

    function __construct() {
        $this->conn = new Connection();
    }

    public function create($obj) {
        
        $sql = "INSERT INTO stagiaires(nom,prenom,date_naissance) VALUES(:nom,:prenom,:date_naissance)";
        $stmt = $this->conn->getConn()->prepare($sql);
        $stmt->execute(['nom'=>$obj->getNom(),'prenom' => $obj->getPrenom(),'date_naissance' => $obj->getDateNaissance()]) or die();
    }

    public function delete($id) {
        $sql = "DELETE FROM stagiaires WHERE id = :id";
        $stmt = $this->conn->getConn()->prepare($sql);
        $stmt->execute(['id' => $id]) or die();
    }

    public function findAll() {
        $sql = "SELECT * FROM stagiaires";
        $stmt = $this->conn->getConn()->prepare($sql);
        $stmt->execute() or die();
        return $stmt->fetchAll();
    }

    public function findById($id) {
        $sql = "SELECT * FROM stagiaires WHERE id = :id";
        $stmt = $this->conn->getConn()->prepare($sql);
        $stmt->execute(['id' => $id]) or die();
        return $stmt->fetch();
    }
    
    public function GetStagiairesByGroupe($idGroupe,$niveau){
        
        $sql = "SELECT s.* FROM groupe_stagiaires gs INNER JOIN stagiaires s on(s.id = gs.stagiaire_id) WHERE groupe_id = :id AND niveau = :niveau";
        $stmt = $this->conn->getConn()->prepare($sql);
        $stmt->execute(['id' => $idGroupe,'niveau' => $niveau]) or die();
        return $stmt->fetchAll();
    }

    public function Search($idGroupe,$niveau,$value){
        
        $sql = "SELECT s.* FROM groupe_stagiaires gs INNER JOIN stagiaires s on(s.id = gs.stagiaire_id) WHERE groupe_id = :id AND niveau = :niveau";
        $stmt = $this->conn->getConn()->prepare($sql);
        $stmt->execute(['id' => $idGroupe,'niveau' => $niveau]) or die();
        return $stmt->fetchAll();
    }

    public function update($obj) {
        
        $sql = "UPDATE stagiaires SET nom = :nom,prenom = :prenom ,date_naissance = :date_naissance WHERE id = :id";
        $stmt = $this->conn->getConn()->prepare($sql);
        $stmt->execute(['nom'=>$obj->getNom(),'prenom' => $obj->getPrenom(),'date_naissance' => $obj->getDateNaissance(),'id' => $obj->getId()]) or die();
    }

}
