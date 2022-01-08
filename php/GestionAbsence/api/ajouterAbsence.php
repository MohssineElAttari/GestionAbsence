<?php

include_once '../services/AbsenceService.php';
include_once '../classes/Absence.php';

if($_SERVER['REQUEST_METHOD'] == 'POST'){
    
    $absenceService = new AbsenceService();
    
    header('Content-type: application/json');
    
    $input = file_get_contents('php://input');
    
    $listAbsence = json_decode($input);
    
    foreach($listAbsence as $absence){
        
        $date_absence = $absence->date_absence;
        $matiere_id = $absence->matiere_id;
        $stagiaire_id = $absence->stagiaire_id;
        $nbre_heure = $absence->nbrHeure;
        
        $absenceService->create(new Absence($stagiaire_id,$matiere_id,$date_absence,false,$nbre_heure));

        //echo $date_absence.' '.$matiere_id.' '.$stagiaire_id.' '.$nbre_heure;
        
    }
    echo 'la liste d absence a ete valider';
    
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