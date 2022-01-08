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
class AbsenceService implements ICrud {
    
    private $conn;
    
    function __construct() {
        $this->conn = new Connection();
    }

    public function create($obj) {
        
        $sql = 'INSERT INTO absences(stagiaire_id,matiere_id,date_absence,nbrHeure) VALUES(:stagiaire_id,:matiere_id,:date_absence,:nbre_heure)';
        $stmt = $this->conn->getConn()->prepare($sql);
        $stmt->execute(['stagiaire_id' => $obj->getStagiaire(),'matiere_id' => $obj->getMatiere(),'date_absence' => $obj->getDateAbsence(),'nbre_heure' => $obj->getnbrheure()]);
    }

    public function delete($id) {
        
        $sql = 'DELETE FROM absences WHERE id = :id';
        $stmt = $this->conn->getConn()->prepare($sql);
        $stmt->execute(['id' => $id]);
    }

    public function findAll() {
        
        $sql = 'SELECT * FROM absences';
        $stmt = $this->conn->getConn()->prepare($sql);
        $stmt->execute();
        return $stmt->fetchAll();
    }

    public function findById($id) {
        
        $sql = 'SELECT * FROM absences WHERE id = :id';
        $stmt = $this->conn->getConn()->prepare($sql);
        $stmt->execute(['id' => $id]);
        return $stmt->fetch();
    }

    public function update($obj) {
        
        $sql = 'UPDATE absences SET stagiaire_id = :stagiaire_id, matiere_id = :matiere_id, date_absence = :date_absence, etat = :etat WHERE id = :id';
        $stmt = $this->conn->getConn()->prepare($sql);
        $stmt->execute(['id' => $obj->getId(),'stagiaire_id' => $obj->getStagiaire(),'matiere_id' => $obj->getMatiere(),'date_absence' => $obj->getDateAbsence(),'etat' => $obj->getEtat()]);
    }

    

    public function findByMatieres($idStagiaire) {
        
        $sql = "SELECT COUNT(absences.id) as 'nbr_absence' , matieres.nom,matieres.id FROM `absences` inner JOIN matieres on absences.matiere_id=matieres.id WHERE stagiaire_id=? GROUP BY matiere_id";
        $stmt = $this->conn->getConn()->prepare($sql);
        $stmt->execute([$idStagiaire]);
        return $stmt->fetchAll();
        
    }

    public function AbsencesByMatieres($idStagiaire,$idMatiere) {
        
        $sql = 'SELECT matieres.nom , absences.date_absence,absences.nbrHeure as "nbre_heure" FROM absences INNER JOIN matieres ON absences.matiere_id = matieres.id WHERE stagiaire_id = ? AND  matiere_id = ?';
        $stmt = $this->conn->getConn()->prepare($sql);
        $stmt->execute([$idStagiaire,$idMatiere]);
        return $stmt->fetchAll();
        
    }

    public function getAbsencesByMatiere($stagiaire_id,$annee){
        
        $sql ='SELECT COUNT(absences.id) as "nbre",matieres.nom '
                . 'FROM `absences` '
                . 'INNER JOIN matieres on absences.matiere_id = matieres.id '
                . 'WHERE absences.stagiaire_id = ? '
                . 'GROUP BY absences.matiere_id';
        
        $stmt = $this->conn->getConn()->prepare($sql);
        $stmt->execute([$stagiaire_id]);
        return $stmt->fetchAll();         
    }


}
