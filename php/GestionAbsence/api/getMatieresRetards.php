<?php

include_once '../services/RetardService.php';

if($_SERVER['REQUEST_METHOD'] == 'POST'){
    
	$id = $_POST['idStagiaire'];


    $absenceService = new RetardService();
    
    header('Content-type: application/json');

    echo json_encode($absenceService->findByMatieres($id));
}


