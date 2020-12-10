<?php 

	session_start();

	require_once 'conexao_bd.php';

	if (isset($_POST['btn-alterar'])) {
		
		$nome = mysqli_escape_string($connection,$_POST['nome']);
		$descricao = mysqli_escape_string($connection,$_POST['descricao']);
		$categoria = mysqli_escape_string($connection,$_POST['categoria']);
		$preco = mysqli_escape_string($connection,$_POST['preco']);
		$codPro = mysqli_escape_string($connection,$_POST['codPro']);

		$sql = "UPDATE tbProdutos SET nomePro = '$nome', descricao = '$descricao', categoria = '$categoria', preco = '$preco' WHERE codPro = '$codPro'";

		if(mysqli_query($connection, $sql)) {

			$_SESSION['mensagem'] = "Alterado com sucesso.";

			header('Location: ../index.php');
		}
		else{

			$_SESSION['mensagem'] = "Erro ao alterar.";

			header('Location: ../index.php');	
		}
	}
