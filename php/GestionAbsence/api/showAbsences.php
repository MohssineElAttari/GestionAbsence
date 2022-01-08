<?php

include_once '../services/AbsenceService.php';
include_once '../classes/Absence.php';

if($_SERVER['REQUEST_METHOD'] == 'POST'){
    
    $absenceService = new AbsenceService();
    
    header('Content-type: application/json');
    
    $stagiaire_id = $_POST['stagiaire_id'];
    $annee = $_POST['annee'];
    $etat = $_POST['etat'];
    
    echo json_encode($absenceService->showAbsences($stagiaire_id, $annee, $etat));
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