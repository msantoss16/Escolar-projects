<?php
    $id = $_GET['id'];
    if($_SERVER['REQUEST_METHOD'] == "POST" and isset($_POST['apagar']))
    {
        include('config.php');
        $con = mysqli_connect($localhost,$user_name,$password,$db);
        $tb = "DELETE FROM tbClientes WHERE codigo = ".$id;
        if (mysqli_errno($con)) {
            echo "<script>alert('Erro ao conectar!');</script>";
        } else {
            if (mysqli_query($con, $tb)) {
                mysqli_close($con);
                header('location: main.php?attbd=False');
            } else {
                echo "<script>alert('Error: ".mysqli_error($con)."');</script>";
            }
        }
        mysqli_close($con);
    }

    if($_SERVER['REQUEST_METHOD'] == "POST" and isset($_POST['updatednv']))
    {
        include('config.php');
        $con = mysqli_connect($localhost,$user_name,$password,$db);
        $tb = "UPDATE tbClientes SET nome='$_POST[nome]', endereco='$_POST[endereco]', bairro='$_POST[bairro]', cidade='$_POST[cidade]', estado='$_POST[estado]', telCel='$_POST[tel]' WHERE codigo = ".$id;
        if (mysqli_errno($con)) {
            echo "<script>alert('Erro ao conectar!');</script>";
        } else {
            if (mysqli_query($con, $tb)) {
                mysqli_close($con);
                header('location: main.php?attbd=False');
            } else {
                echo "<script>alert('Error: ".mysqli_error($con)."');</script>";
            }
        }
        mysqli_close($con);
    }
?>
<!DOCTYPE html>
<html>
    <head>
        <title>Atualizando dados</title>
        <meta charset="utf-8">
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
            width: 35%;
            height: 30rem;
            box-shadow: 0 2rem 3rem rgba(0, 0, 0, 0.5);
            background-color: #ffffff;
            }


            h3 {
            margin-top: 0.5rem;
            font-family: 'Open Sans', sans-serif;
            font-weight: 800;
            width: 100%;
            text-align: center;
            color: #F7BF2A	;
            }

            form {
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            margin: 1rem;
            }

            .field {
            width: 90%;
            padding: 10px; 
            margin-bottom: 15px;
            border: 1px solid #DDD;
            border-radius: 5px;
            margin: 0.6rem;
            }

            form input[type='submit']{
            margin: 1rem;
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

            form input[type='submit']:hover{
                box-shadow: 0.3rem 0.3rem 0.3rem rgba(0, 0, 0, 0.5);
            }
        </style>
    </head>
    <body>
        <div class="cad-wrapper">
            <?php
                echo "<form action='funcoes.php?id=".$id."' method='post'>
                        <h3>Atualizar os dados</h3>
                        <input type='text' class='field' placeholder='Nome do cliente' name='nome'>
                        <input type='text' class='field' placeholder='Endereço do cliente' name='endereco'>
                        <input type='text' class='field' placeholder='Bairro do cliente' name='bairro'>
                        <input type='text' class='field' placeholder='Cidade do cliente' name='cidade'>
                        <input type='text' class='field' placeholder='Estado do cliente' name='estado'>
                        <input type='text' class='field' placeholder='Telefone do cliente' name='tel'>
                        <input type='submit' name='updatednv' value='Enviar'>
                    </form>";
            ?>
        </div>
    </body>
</html>






