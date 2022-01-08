<?php

/**
 * Description of Groupe
 *
 * @author Abdelilah Boutizoua
 */
class Groupe {
    
    private $id;
    private $nom;
    private $code;
    private $filiere;
    private $stagiaires;
            
    function __construct($nom, $code, $filiere) {
        $this->nom = $nom;
        $this->code = $code;
        $this->filiere = $filiere;
        $this->annee = $annee;
        $this->stagiaires = array();
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

    function getFiliere() {
        return $this->filiere;
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

    function setFiliere($filiere) {
        $this->filiere = $filiere;
    }


    
    function getStagiaires() {
        return $this->stagiaires;
    }

    function setStagiaires($stagiaires) {
        $this->stagiaires = $stagiaires;
    }


    
}
