<?php

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
include_once '../dao/ICrud.php';
include_once '../connection/Connection.php';
/**
 * Description of RetardService
 *
 * @author Abdelilah Boutizoua
 */
class RetardService implements ICrud {
    
    private $conn;
    
    function __construct() {
        $this->conn = new Connection();
    }
    
    public function create($obj) {
        
        $sql = 'INSERT INTO retards(stagiaire_id,matiere_id,date_retard,nbre_heure) VALUES(?,?,?,?)';
        $stmt = $this->conn->getConn()->prepare($sql);
        $stmt->execute([$obj->getStagiaire(),$obj->getMatiere(),$obj->getDateRetard(),$obj->getNbreHeure()]);
    }

    public function delete($id) {
        
        $sql = 'DELETE FROM retards WHERE id = :?';
        $stmt = $this->conn->getConn()->prepare($sql);
        $stmt->execute([$id]);
    }

    public function findAll() {
        
        $sql = 'SELECT * FROM retards';
        $stmt = $this->conn->getConn()->prepare($sql);
        $stmt->execute();
        return $stmt->fetchAll();
    }

    public function findById($id) {
        
        $sql = 'SELECT * FROM retards WHERE id = ?';
        $stmt = $this->conn->getConn()->prepare($sql);
        $stmt->execute([$id]);
    }

    public function update($obj) {
        
        $sql = 'UPDATE retards SET stagiaire_id = ?,matiere_id = ?, date_retard = ? WHERE id = ?';
        $stmt = $this->conn->getConn()->prepare($sql);
        $stmt->execute([$obj->getStagiaire(),$boj->getMatiere(),$obj->getDateRetard(),$obj->getId()]);
    }

     public function findByMatieres($idStagiaire) {
        
        $sql = "SELECT COUNT(retards.id) as 'nbr_absence' , matieres.nom,matieres.id FROM `retards` inner JOIN matieres on retards.matiere_id=matieres.id WHERE stagiaire_id=? GROUP BY matiere_id";
        $stmt = $this->conn->getConn()->prepare($sql);
        $stmt->execute([$idStagiaire]);
        return $stmt->fetchAll();
        
    }

    public function RetardByMatieres($idStagiaire,$idMatiere) {
        
        $sql = 'SELECT matieres.nom , retards.date_retard as "date_absence",retards.nbre_heure FROM retards INNER JOIN matieres ON retards.matiere_id = matieres.id WHERE stagiaire_id = ? AND  matiere_id = ?';
        $stmt = $this->conn->getConn()->prepare($sql);
        $stmt->execute([$idStagiaire,$idMatiere]);
        return $stmt->fetchAll();
        
    }

 public function getRetardsByMatiere($stagiaire_id,$annee){
        
        $sql = "SELECT COUNT(retards.id) as 'nbre',matieres.code as 'nom' FROM `retards` 
                INNER JOIN matieres on retards.matiere_id = matieres.id 
                WHERE retards.stagiaire_id = ?
                GROUP BY retards.matiere_id";
        
        $stmt = $this->conn->getConn()->prepare($sql);
        $stmt->execute([$stagiaire_id]);
        return $stmt->fetchAll();      
        
    }
}
