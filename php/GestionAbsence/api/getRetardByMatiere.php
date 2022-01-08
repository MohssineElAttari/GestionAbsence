<?php

include_once '../services/RetardService.php';
include_once '../classes/Retard.php';

if($_SERVER['REQUEST_METHOD'] == 'POST'){
    
    $retardService = new RetardService();
    
    header('Content-type: application/json');
    
    $stagiaire_id = $_POST['stagiaire_id'];
    $annee = $_POST['annee'];
    
    echo json_encode($retardService->getRetardsByMatiere($stagiaire_id, $annee));
}
