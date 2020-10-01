<?php
    echo "Largura: ".$_POST['largura']."<br>";
    echo "Comprimento: ".$_POST['comprimento']."<br>";
    echo "O perimetro do retângulo é :".(($_POST['largura'] + $_POST['comprimento'])*2)."<br>";
    echo "A área do retângulo é :".($_POST['largura'] * $_POST['comprimento']);
?>