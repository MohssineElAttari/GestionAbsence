<?php

include_once '../services/RetardService.php';
include_once '../classes/Retard.php';

if($_SERVER['REQUEST_METHOD'] == 'POST'){
    
    $retardService = new RetardService();
    
    header('Content-type: application/json');
    
    $stagiaire_id = $_POST['stagiaire_id'];
    $annee = _POST['annee'];
    
    echo json_encode($retardService->ShowRetards($stagiaire, $annee));
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