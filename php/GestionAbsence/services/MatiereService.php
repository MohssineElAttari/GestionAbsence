<?php

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
include_once '../dao/ICrud.php';
include_once '../connection/Connection.php';
/**
 * Description of MatiereService
 *
 * @author Abdelilah Boutizoua
 */
class MatiereService implements ICrud{
    
    private $conn;
    
    function __construct() {
        $this->conn = new Connection();
    }

    public function create($obj) {
        
        $sql = 'INSERT INTO matieres(nom,code,masse_horaire) VALUES(:nom,:code,:masse_horaire)';
        $stmt = $this->conn->getConn()->prepare($sql);
        $stmt->execute(['nom' => $obj->getNom(),'code' => $obj->getCode(),'masse_horaire' => $obj->getMasseHoraire()]);
    }

    public function delete($id) {
        
        $sql = 'DELETE FROM matieres WHERE id = :id';
        $stmt = $this->conn->getConn()->prepare($sql);
        $stmt->execute(['id' => $id]);
    }

    public function findAll() {
        
        $sql = 'SELECT * FROM matieres';
        $stmt = $this->conn->getConn()->prepare($sql);
        $stmt->execute();
        return $stmt->fetchAll();
    }

    public function findById($id) {
        
        $sql = 'SELECT * FROM matieres WHERE id = :id';
        $stmt = $this->conn->getConn()->prepare($sql);
        $stmt->execute(['id' => $id]);
        return $stmt->fetch();
    }

    public function update($obj) {
        
        $sql = 'UPDATE matieres SET nom = :nom, code = :code, masse_horaire = :masse_horaire WHERE id = :id';
        $stmt = $this->conn->getConn()->prepare($sql);
        $stmt->execute(['nom' => $obj->getNom(),'code' => $obj->getCode(),'masse_horaire' => $obj->getMasseHoraire(),'id' => $obj->getId()]);
    }

    public function findByMatiere($idFiliere,$niveaux) {
        
        $sql = 'SELECT matieres.* FROM `matieres_filieres` INNER JOIN matieres ON matieres_filieres.matiere_id = matieres.id WHERE matieres_filieres.filiere_id = :filiere_id AND matieres_filieres.niveau = :niveau';
        $stmt = $this->conn->getConn()->prepare($sql);
        $stmt->execute(['filiere_id' => $idFiliere,'niveau' => $niveaux]);
        return $stmt->fetchAll();
    }

}
