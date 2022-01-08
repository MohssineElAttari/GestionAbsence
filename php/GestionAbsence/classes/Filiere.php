<?php

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Description of Filiere
 *
 * @author Abdelilah Boutizoua
 */
class Filiere {
    //put your code here
    
    private $id;
    private $libelle;
    private $code;
    
    function __construct($libelle, $code) {
        $this->libelle = $libelle;
        $this->code = $code;
    }
    
    function getId() {
        return $this->id;
    }

    function getLibelle() {
        return $this->libelle;
    }

    function getCode() {
        return $this->code;
    }

    function setId($id) {
        $this->id = $id;
    }

    function setLibelle($libelle) {
        $this->libelle = $libelle;
    }

    function setCode($code) {
        $this->code = $code;
    }

}
