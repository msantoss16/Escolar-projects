<?php
	require_once 'conexao.php';
	session_start();
	$sql = "INSERT INTO tbUsuarios(nomeUsu,loginUsu,nivelAcesso,senhaUsu)VALUES('$_POST[nome]','$_POST[login]','1','$_POST[senha]')";
	if ($_SESSION['privilegio'] == 2) {	
		if(mysqli_query($con,$sql)){
		
			echo "Usuário inserido com sucesso!!!";
		
		}else{
		
			echo "Erro ao inserir usuário: ".mysqli_error($con);
		
		}
		
		mysqli_close($con);
	} else {
		echo "Usuário sem privilegios!!!";
	}
	echo "<br><a href='home.php'>Sair</a>";
?>
