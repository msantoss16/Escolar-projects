<?php
    include('config.php');


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


    criarDb($localhost, $user_name, $password, $db);

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
                width: 50%;
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
                    // echo "<h3>Dados</h3>";
                    echo "<table class='bordered striped centered'>
                            <tr>
                                <th>ID</th>
                                <th>Nome</th>
                                <th>Endereço</th>
                                <th>Bairro</th>
                                <th>Cidade</th>
                                <th>Estado</th>
                                <th>Telefone</th>
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
                             </tr>";
                    }
                    echo "</table>";
                }
                mysqli_close($con);
            ?>
        </div>
    </body>
</html>