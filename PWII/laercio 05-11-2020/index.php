<?php 

	require_once 'conexao.php';

	session_start();

	if (isset($_POST['btnEntrar'])) {
		
		$erros = array();

		$login = mysqli_escape_string($con,$_POST['login']);
		$senha = mysqli_escape_string($con,$_POST['senha']);

		if (empty($login) or empty($senha)) {
			$erros[] = "<li>O campo login ou senha precisa ser preenchido.</li></br>";
		}
		else{

			$sql = "SELECT loginUsu FROM tbUsuarios WHERE loginUsu = '$login'";

			$resultado = mysqli_query($con,$sql);

			if (mysqli_num_rows($resultado) > 0 ) {

				$sql = "SELECT * FROM tbUsuarios WHERE loginUsu = '$login' AND senhaUsu = '$senha'";

				$resultado = mysqli_query($con,$sql);

				if (mysqli_num_rows($resultado) == 1) {
			
					$dados = mysqli_fetch_array($resultado);

					$_SESSION['privilegio'] = $dados[4];

					mysqli_close($con);
					
					$_SESSION['logado'] = true;

					$_SESSION['codUsu'] = $dados['codUsu'];
					
					header('Location: home.php');
					
				}else{
					
					$erros[] = "<li>Usuário e senha não conferem.</li></br>";
				}
				
			}else{

				$erros[] = "<li>Usuário inexistente.</li></br>";
			}
		}		
	}
 ?>

<!DOCTYPE html>
<html lang="pt-br">
<head>
	<meta charset="utf-8">
	<title>Sistema de Login</title>
	<link rel="stylesheet" href="style.css">
</head>
<body>
	<div class="cad-wrapper">
		<h3 style="font-size: 175%">Sistema de Login</h3>

		<?php 
			if(!empty($erros)) {
				foreach ($erros as $erro) {
					echo $erro;
				}
			}

		?>
		<form action="<?php echo $_SERVER['PHP_SELF']; ?>" method="POST" style="margin: 3rem;">

			<div class="group">      
				<input type="text" name="login" required>
				<span class="highlight"></span>
				<span class="bar"></span>
				<label>Login</label>
			</div>

			<div class="group">      
				<input type="password" name="senha" required>
				<span class="highlight"></span>
				<span class="bar"></span>
				<label>Senha</label>
			</div>
		
			<button type="submit" name="btnEntrar" class="btnsubmit">Entrar</button>

		</form>
	</div>

</body>
</html>