<?php

include_once '../services/FiliereService.php';

if($_SERVER['REQUEST_METHOD'] == 'POST'){
    
    $filiereService = new FiliereService();
    
    header('Content-type: application/json');

    echo json_encode($filiereService->findAll());
}



