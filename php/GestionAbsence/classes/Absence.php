<?php

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Description of Absence
 *
 * @author Abdelilah Boutizoua
 */


class Absence {
    
    private $id;
    private $stagiaire;
    private $matiere;
    private $dateAbsence;
    private $etat;
    private $nbrheure;
    
    function __construct($stagiaire, $matiere, $dateAbsence, $etat,$nbrheure) {
        $this->stagiaire = $stagiaire;
        $this->matiere = $matiere;
        $this->dateAbsence = $dateAbsence;
        $this->etat = $etat;
        $this->nbrheure=$nbrheure;
    }
    
    function getId() {
        return $this->id;
    }

    function getStagiaire() {
        return $this->stagiaire;
    }

    function getMatiere() {
        return $this->matiere;
    }

    function getDateAbsence() {
        return $this->dateAbsence;
    }

    function getEtat() {
        return $this->etat;
    }

    function getnbrheure() {
        return $this->nbrheure;
    }

    function setId($id) {
        $this->id = $id;
    }

    function setStagiaire($stagiaire) {
        $this->stagiaire = $stagiaire;
    }

    function setMatiere($matiere) {
        $this->matiere = $matiere;
    }

    function setDateAbsence($dateAbsence) {
        $this->dateAbsence = $dateAbsence;
    }

    function setEtat($etat) {
        $this->etat = $etat;
    }

    function setNbrheure($nbrheure) {
        $this->nbrheure = $nbrheure;
    }
    
}
