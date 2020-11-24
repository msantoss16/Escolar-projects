<?php 
	
	//abrir a sessão
	session_start();
	//limpar a sessão
	session_unset();
	//destruir a sessão
	session_destroy();

	//Enviando o usuário para o index.php
	header('Location: index.php');


 ?>