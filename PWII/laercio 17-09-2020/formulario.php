<?php
    echo "<h3>Pegando os dados do form</h3>";

    if (isset($_POST['feedback'])){
        echo "Feedback: ".$_POST['feedback'];
        echo "<br>";
    }
    if (isset($_POST['outro'])){
        if ($_POST['outro'] != ""){
            echo "Seção favorita: ".$_POST['outro'];
            echo "<br><br>";
        } else {
            echo "Seção favorita: ".$_POST['sections'];
            echo "<br><br>";    
        }
    }
    if(isset($_POST['mensagem'])){
        if($_POST['mensagem'] != ""){
            echo "<b>Mensagem: </b><br>".$_POST['mensagem'];
            echo "<br>";
        }
    }
    echo "<br>nome: ".$_POST['nome'];
    echo "<br>email: ".$_POST['email'];
    echo "<br>telefone: ".$_POST['fone'];
    echo "<br>fax: ".$_POST['fax'];
    echo "<br>";
    if (isset($_POST['sendmail'])){
        echo "Enviar email? ".$_POST['sendmail'];
        echo "<br>";
    }
?>