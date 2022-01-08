<?php

include_once '../services/StagiaireService.php';

if($_SERVER['REQUEST_METHOD'] == 'POST'){
    
    $idGroupe = $_POST['idGroupe'];
    $niveau = $_POST['niveau'];
    
    $stagiaireService = new StagiaireService();
    
    header('Content-type: application/json');
    
    echo json_encode($stagiaireService->GetStagiairesByGroupe($idGroupe,$niveau));
}



