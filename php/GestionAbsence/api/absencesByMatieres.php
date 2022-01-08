<?php

include_once '../services/AbsenceService.php';

if($_SERVER['REQUEST_METHOD'] == 'POST'){
    
	$id = $_POST['idStagiaire'];
	$matiere = $_POST['matiere_id'];


    $absenceService = new AbsenceService();
    
    header('Content-type: application/json');

    echo json_encode($absenceService->AbsencesByMatieres($id,$matiere));
}


