<?php
class Conexao {
	
	public $db;
	
	public function getConnection(){
	
		$this->db = null;
	
		try{
	
			$this->db = new mysqli('localhost','root','','apicrudphp');
	
		}catch(Exception $e){
	
			echo "Erro ao conectar o banco de dados: " . $e->getMessage();
	
		}
	
		return $this->db;
	}
}
?>