<?php 

	session_start();

	require_once 'conexao_bd.php';

	if (isset($_POST['btn-cadastrar'])) {
		
		$nome = mysqli_escape_string($connection,$_POST['nome']);
		$descricao = mysqli_escape_string($connection,$_POST['descricao']);
		$categoria = mysqli_escape_string($connection,$_POST['categoria']);
		$preco = mysqli_escape_string($connection,$_POST['preco']);

		$sql = "INSERT INTO tbProdutos(nomePro,descricao,categoria,preco)VALUES('$nome','$descricao','$categoria','$preco')";

		if(mysqli_query($connection, $sql)) {

			$_SESSION['mensagem'] = "Cadastrado com sucesso.";

			header('Location: ../index.php');
		}
		else{

			$_SESSION['mensagem'] = "Erro ao cadastrar.";

			header('Location: ../index.php');	
		}
	}
