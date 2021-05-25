<?php
	
	header("Access-Control-Allow-Origin: *");
	header("Content-Type: application/json; charset=UTF-8");
	
	include_once '../Conexao.php';
	include_once '../Empregados.php';

	$conexao = new Conexao();
	$db = $conexao->getConnection();
	$items = new Empregados($db);

	$records = $items->getEmpregados();
	$itemCount = $records->num_rows;

	echo json_encode($itemCount);

	if($itemCount > 0){
		
		$empregadoArr = array();
		$empregadoArr["body"] = array();
		$empregadoArr["itemCount"] = $itemCount;

		while ($row = $records->fetch_assoc()){

			array_push($empregadoArr["body"], $row);
		}
		echo json_encode($empregadoArr);
	}
	else{
		
		http_response_code(404);
		
		echo json_encode(
			array("message" => "Nenhum registro encontrado."));
	}
?>