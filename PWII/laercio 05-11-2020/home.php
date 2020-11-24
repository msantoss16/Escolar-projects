<?php 

	require_once 'conexao.php';

	session_start();

	if (!isset($_SESSION['logado'])) {
		header('Location: index.php');
	}

	$id_usu = $_SESSION['codUsu'];
	$sql = "SELECT * FROM tbUsuarios WHERE codUsu = '$id_usu'";
	$resultado = mysqli_query($con, $sql);
	$dados = mysqli_fetch_array($resultado);

 ?>


<!DOCTYPE html>
<html>
<head>
	<title>Página restrita</title>
	<meta charset="utf8">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.0/css/materialize.min.css">
	<style>
            body {
                width: 100%;
                height: 100vh;
                display: flex;
                align-items: center;
                justify-content: center;
                flex-direction: column;
                background-color: #ACCFB2;
                position: fixed;
            }

            .cad-wrapper {
                width: 100%;
                height: 30rem;
                box-shadow: 0 2rem 3rem rgba(0, 0, 0, 0.5);
                background-color: #ffffff;
                overflow: auto;
            }

            h3 {
                margin-top: 0.5rem;
                font-family: 'Open Sans', sans-serif;
                font-weight: 800;
                width: 100%;
                text-align: center;
                color: #000;
            }
            th {
                text-align: center;
            }
            
            .btn {
				margin: 2rem 0rem 0rem 15%;
				width: 70%;
				line-height: 38px;
				border: solid 2px #F7BF2A;
				text-transform: uppercase;
				border-radius: 12px;
				outline: none;
				transition: linear all .2s;
				background-color: #F7BF2A	;
				color: #fff;
				font-family: "Open Sans";
            }

            .btn:hover{
                box-shadow: 0.3rem 0.3rem 0.3rem rgba(0, 0, 0, 0.5);
            }
        </style>
</head>
<body>
	<div id="usuario">
		<h1>Olá <?php echo $dados['nomeUsu']?></h1>
		<a href='logout.php'>Sair</a>
	</div>
	<div id="administrador">
		<div class="cad-wrapper">
			<?php
				$dados2 =  mysqli_query($con, "SELECT * FROM tbUsuarios");
				echo "<table class='bordered striped centered'>
                            <tr>
                                <th>ID</th>
                                <th>Nome</th>
                                <th>Login</th>
                                <th>Nivel de Acesso</th>
                                <th>Eventos</th>
							</tr>";
				while($pessoa = mysqli_fetch_array($dados2)){
						echo "<tr>
							<td>".$pessoa['codUsu']."</td>
							<td>".$pessoa['nomeUsu']."</td>
							<td>".$pessoa['loginUsu']."</td>
							<td>".$pessoa['nivelAcesso']."</td>
							<td><form action='funcoes.php?id=".$pessoa['codUsu']."' method='post'>
								<input type='submit' name='apagar' value='Apagar' />
								<input type='submit' name='update' value='Atualizar' />
							</form></td>
						</tr>";
						}
				echo "</table>";
				mysqli_close($con);
			?>
		</div>
		<form action='cadastro.html' method='post'>
            <input type='submit' name='cadastro' value='Cadastrar Usuario' class="btn"/>
		</form>
		<form action='logout.php' method='post'>
            <input type='submit' name='deslogar' value='Deslogar da conta' class="btn"/>
        </form>
	</div>
	<?php
		if ($_SESSION['privilegio'] == 2){
			echo "<script>document.getElementById('usuario').remove()</script>";
		} else if ($_SESSION['privilegio'] == 1){
			echo "<script>document.getElementById('administrador').remove()</script>";
		}
	?>
</body>
</html>