<?php
    include('config.php');
    $attbD = $_GET['attbd'];

    function criarDb($localhost, $user_name, $password, $db2){
        $con = mysqli_connect($localhost, $user_name, $password);

        $db = "CREATE DATABASE IF NOT EXISTS dbLivraria";
        if (mysqli_errno($con)) {
            echo "<script>alert('Erro ao conectar!');</script>";
        } else {
            if (mysqli_query($con, $db)) {
                echo "<script>alert('Banco de dados criado!');</script>";
            } else {
                echo "<script>alert('Error: ".mysqli_error($con)."');</script>";
            }
        }

        mysqli_close($con);
        criarTb($localhost, $user_name, $password, $db2);
    }

    function criarTb($localhost, $user_name, $password, $db){
        $con = mysqli_connect($localhost, $user_name, $password, $db);
        $tb = "CREATE TABLE IF NOT EXISTS tbClientes(
                codigo INT NOT NULL AUTO_INCREMENT,
                nome VARCHAR(100),
                endereco VARCHAR(100),
                bairro VARCHAR(100),
                cidade VARCHAR(50),
                estado VARCHAR(2),
                telCel VARCHAR(9),
                PRIMARY KEY (codigo)
            )";
        if (mysqli_errno($con)) {
            echo "<script>alert('Erro ao conectar!');</script>";
        }   else   { 
            if (mysqli_query($con, $tb)) {
                echo "<script>alert('Tabela criada!');</script>";
            } else {
                echo "<script>alert('Error: ".mysqli_error($con)."');</script>";
            }
        }

        mysqli_close($con);
        inserirTb($localhost, $user_name, $password, $db);
    }

    function inserirTb($localhost, $user_name, $password, $db){
        $con = mysqli_connect($localhost,$user_name,$password,$db);
        if (mysqli_errno($con)) {
            echo "<script>alert('Erro ao conectar!');</script>";
        }else{
            $ins = "INSERT INTO tbClientes 
            (nome, endereco, bairro, cidade, estado,telCel)
            values('$_POST[nome]','$_POST[endereco]','$_POST[bairro]','$_POST[cidade]','$_POST[estado]','$_POST[tel]')";
                if(mysqli_query($con, $ins)) {
                    echo "<script>alert('Registro inserido!');</script>";
                }else{
                    echo "<script>alert('Erro ao inserir: ".mysqli_error($con)."');</script>";
                }
                mysqli_close($con);
        }
    }

    if ($attbD == "True") {criarDb($localhost, $user_name, $password, $db);}

?>

<!DOCTYPE html>
<html>
    <head>
        <title>Mostrar os links</title>
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
                width: 80%;
                height: 40rem;
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
            width: 30%;
            padding: 0 20px;
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
        <h3>Dados</h3>
        <div class="cad-wrapper">
            <?php
                $con = mysqli_connect($localhost,$user_name,$password,$db);

                if (mysqli_errno($con)) {
                    echo "<script>alert('Erro ao conectar!');</script>";
                } else {
                    $dados = mysqli_query($con, "SELECT * FROM tbClientes");
                    if (isset($_POST['ASC'])) {
                        $dados = mysqli_query($con, "SELECT * FROM tbClientes ORDER BY codigo ASC");
                    }
                    if (isset($_POST['DESC'])) {
                        $dados = mysqli_query($con, "SELECT * FROM tbClientes ORDER BY codigo DESC");
                    }
                    if (isset($_POST['LIMIT'])) {
                        if ($_POST['LIMIT'] != 0) {
                            if (isset($_POST['ASC'])) {
                                $dados = mysqli_query($con, "SELECT * FROM tbClientes ORDER BY codigo ASC LIMIT ".$_POST['LIMIT']);
                            }
                            if (isset($_POST['DESC'])) {
                                $dados = mysqli_query($con, "SELECT * FROM tbClientes ORDER BY codigo DESC LIMIT ".$_POST['LIMIT']);
                            }
                        } else {
                            if (isset($_POST['ASC'])) {
                                $dados = mysqli_query($con, "SELECT * FROM tbClientes ORDER BY codigo ASC");
                            }
                            if (isset($_POST['DESC'])) {
                                $dados = mysqli_query($con, "SELECT * FROM tbClientes ORDER BY codigo DESC");
                            }
                        }
                    }
                    echo "<table class='bordered striped centered'>
                            <tr>
                                <th>ID</th>
                                <th>Nome</th>
                                <th>Endereço</th>
                                <th>Bairro</th>
                                <th>Cidade</th>
                                <th>Estado</th>
                                <th>Telefone</th>
                                <th>Eventos</th>
                            </tr>";
                    while($pessoa = mysqli_fetch_array($dados)){
                        echo "<tr>
                                <td>".$pessoa['codigo']."</td>
                                <td>".$pessoa['nome']."</td>
                                <td>".$pessoa['endereco']."</td>
                                <td>".$pessoa['bairro']."</td>
                                <td>".$pessoa['cidade']."</td>
                                <td>".$pessoa['estado']."</td>
                                <td>".$pessoa['telCel']."</td>
                                <td><form action='funcoes.php?id=".$pessoa['codigo']."' method='post'>
                                    <input type='submit' name='apagar' value='Apagar' />
                                    <input type='submit' name='update' value='Atualizar' />
                                </form></td>
                             </tr>";
                    }
                    echo "</table>";
                }
                mysqli_close($con);
            ?>
        </div>
        <form action='main.php?attbd=False' method='post'>
            <input type='number' name='LIMIT'  min="0" placeholder='LIMIT'>
            <input type='submit' name='ASC' value='ASC' class="btn"/>
            <input type='submit' name='DESC' value='DESC' class="btn" style="margin-left: 5rem;"/>
        </form>
    </body>
</html>