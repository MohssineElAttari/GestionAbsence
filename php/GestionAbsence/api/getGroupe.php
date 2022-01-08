<?php

include_once '../services/GroupeService.php';

if($_SERVER['REQUEST_METHOD'] == 'POST'){
    
    $id = $_POST['id'];
    
    $groupeService = new GroupeService();
    
     header('Content-type: application/json');
    
    echo json_encode($groupeService->findById($id));
}



