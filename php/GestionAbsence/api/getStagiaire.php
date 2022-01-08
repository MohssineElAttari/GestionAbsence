<?php

include_once '../services/StagiaireService.php';

if($_SERVER['REQUEST_METHOD'] == 'POST'){
    
    $id = $_POST['id'];
    
    $stagiaireService = new StagiaireService();
    
    header('Content-type: application/json');
    
    echo json_encode($stagiaireService->findById($id));
}



