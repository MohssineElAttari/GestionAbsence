<?php

include_once '../services/RetardService.php';
include_once '../classes/Retard.php';

if($_SERVER['REQUEST_METHOD'] == 'POST'){
    
    $retardService = new RetardService();
    
    header('Content-type: application/json');
    
    $input = file_get_contents('php://input');
    
    $listRetard = json_decode($input);
    
    foreach($listRetard as $retard){
        
        $date_retard = $retard->date_retard;
        $matiere_id = $retard->matiere_id;
        $stagiaire_id = $retard->stagiaire_id;
        $nbre_heure = $retard->nbre_heure;
        
        $retardService->create(new Retard($stagiaire_id,$matiere_id,$date_retard,$nbre_heure));
    }
}

//<?php
//
//// read the incoming POST body (the JSON)
//$input = file_get_contents('php://input');
//
//// decode/unserialize it back into a PHP data structure
//$data = json_decode($input);
//
//// $data is now the same thing it was line 1 of your given sample code
//If you wanted to be more succinct, you could obviously just nest those calls:
//
//<?php
//$data = json_decode(file_get_contents('php://input'));