<?php

include_once '../services/AnneeService.php';

if($_SERVER['REQUEST_METHOD'] == 'POST'){
    
    $aneeService = new AnneeService();
    
    header('Content-type: application/json');

    echo json_encode($aneeService->findAll());
}


//Traversy Media PHP PDO
