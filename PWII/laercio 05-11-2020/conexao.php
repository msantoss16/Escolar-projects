<?php
	$localhost = 'localhost';
	$user_name = 'root';
	$user_senha = "";
	$db = "dbUsuarios";

		$con = mysqli_connect($localhost,$user_name,$user_senha,$db);
	
		if (mysqli_connect_error()){
	
			echo "Erro ao conectar com o banco de dados: " . mysqli_connect_error();
	
		}
		else{

		//echo "Banco de dados conectado. ";
		}

 ?>