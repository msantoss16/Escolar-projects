<?php
$altura = $_POST['altura'];
$peso = $_POST['peso'];
$imc = $peso / ($altura * $altura);
if ($imc > 25){
    echo "<h1>Você está acima do peso!</h1>";
} else {
    echo "<h1>Você está saudável!</h1>";
}
?>