<?php

    $voto = $_GET['voto'];

    if (!isset($_COOKIE['voto'])) {
        setcookie("voto", $voto,time()+3600*24*31);
        $msg = "Obrigado por votar!!!";

    } else {
        $msg = "Você já votou uma vez.";
    }

    echo $msg;

?>