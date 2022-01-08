<?php

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Description of AnneeScolaire
 *
 * @author Abdelilah Boutizoua
 */
class AnneeScolaire {
    
    private $id;
    private $annee;
    
    function __construct($annee) {
        $this->annee = $annee;
    }
    
    function getId() {
        return $this->id;
    }

    function getAnnee() {
        return $this->annee;
    }

    function setId($id) {
        $this->id = $id;
    }

    function setAnnee($annee) {
        $this->annee = $annee;
    }
    
}
