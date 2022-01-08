<?php

include_once '../services/RetardService.php';

if($_SERVER['REQUEST_METHOD'] == 'POST'){
    
	$id = $_POST['idStagiaire'];
	$matiere_id = $_POST['matiere_id'];



    $absenceService = new RetardService();
    
    header('Content-type: application/json');

    echo json_encode($absenceService->RetardByMatieres($id,$matiere_id));
}


