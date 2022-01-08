<?php

include_once '../services/GroupeService.php';

if($_SERVER['REQUEST_METHOD'] == 'POST'){
    
    $idFiliere = $_POST['idFiliere'];
    
    $groupeService = new GroupeService();
    
     header('Content-type: application/json');
    
    echo json_encode($groupeService->findByFiliere($idFiliere));
}



