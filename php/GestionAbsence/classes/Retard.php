<?php

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Description of Retard
 *
 * @author Abdelilah Boutizoua
 */
class Retard {
    
    private $id;
    private $stagiaire;
    private $matiere;
    private $dateRetard;
    private $nbre;

    function __construct($stagiaire, $matiere, $dateRetard,$nbre) {
        $this->stagiaire = $stagiaire;
        $this->matiere = $matiere;
        $this->dateRetard = $dateRetard;
        $this->nbre = $nbre;
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

    function getDateRetard() {
        return $this->dateRetard;
    }


    function getNbreHeure() {
        return $this->nbre;
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

    function setDateRetard($dateRetard) {
        $this->dateRetard = $dateRetard;
    }

}
