<?php

include_once '../services/MatiereService.php';

if($_SERVER['REQUEST_METHOD'] == 'POST'){
    

	$idFiliere = $_POST['id'];
	$niveau = $_POST['niveau'];

    $matiereService = new MatiereService();
    
    header('Content-type: application/json');

    echo json_encode($matiereService->findByMatiere($idFiliere,$niveau));
}


