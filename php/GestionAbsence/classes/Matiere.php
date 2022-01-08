<?php

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Description of Matiere
 *
 * @author Abdelilah Boutizoua
 */
class Matiere {
    
    private $id;
    private $nom;
    private $code;
    private $masseHoraire;
    
    function __construct($nom, $code, $masseHoraire) {
        $this->nom = $nom;
        $this->code = $code;
        $this->masseHoraire = $masseHoraire;
    }
    
    function getId() {
        return $this->id;
    }

    function getNom() {
        return $this->nom;
    }

    function getCode() {
        return $this->code;
    }

    function getMasseHoraire() {
        return $this->masseHoraire;
    }

    function setId($id) {
        $this->id = $id;
    }

    function setNom($nom) {
        $this->nom = $nom;
    }

    function setCode($code) {
        $this->code = $code;
    }

    function setMasseHoraire($masseHoraire) {
        $this->masseHoraire = $masseHoraire;
    }
    
    
}
