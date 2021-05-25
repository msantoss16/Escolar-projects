<?php
	header("Access-Control-Allow-Origin: *");
	header("Content-Type: application/json; charset=UTF-8");
	header("Access-Control-Allow-Methods: POST");
	header("Access-Control-Max-Age: 3600");
	header("Access-Control-Allow-Headers: Content-Type,Access-Control-Allow-Headers, Authorization, X-Requested-With");
	
	include_once '../Conexao.php';
	include_once '../Empregados.php';

	$conexao = new Conexao();
	
	$db = $conexao->getConnection();

	$item = new Empregados($db);

	$item->codigo = isset($_GET['codigo']) ? $_GET['codigo'] : die();
	
	$item->getIDEmpregados();	

	if($item->nome != null){
		$emp_arr = array(
			"codigo" => $item->codigo,
			"nome" => $item->nome,
			"email" => $item->email,
			"cargo" => $item->cargo,
			"data_entrada" => $item->data_entrada);

	http_response_code(200);

	echo json_encode($emp_arr);
	
	}
	else{
		http_response_code(404);
		echo json_encode("Erro ao buscar empregados.");
}
?>