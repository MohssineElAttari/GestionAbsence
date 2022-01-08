<?php

include_once '../services/NiveauService.php';

if($_SERVER['REQUEST_METHOD'] == 'POST'){
    
    $niveauxService = new NiveauService();
    
    header('Content-type: application/json');

    echo json_encode($niveauxService->findAll());
}


