<?php
class Empregados{
	
	private $db;

	private $db_table = "tbfuncionarios";

	public $codigo;
	public $nome;
	public $email;
	public $cargo;
	public $data_entrada;

	public $result;
	
	public function __construct($db){
		$this->db = $db;
	}

	public function getEmpregados(){
		
		$sqlQuery = "SELECT codigo, nome, email, cargo, data_entrada FROM " . $this->db_table . "";
		
		$this->result = $this->db->query($sqlQuery);
		
		return $this->result;
	}
	
	public function createEmpregados(){
		

		$this->nome=htmlspecialchars(strip_tags($this->nome));
		$this->email=htmlspecialchars(strip_tags($this->email));
		$this->cargo=htmlspecialchars(strip_tags($this->cargo));
		$this->data_entrada=htmlspecialchars(strip_tags($this->data_entrada));

		$sqlQuery = "INSERT INTO ". $this->db_table ." SET nome = '".$this->nome."', email = '".$this->email."', cargo = '".$this->cargo."',data_entrada = '".$this->data_entrada."'";

		$this->db->query($sqlQuery);
	
		if($this->db->affected_rows > 0){
			return true;
		}

		return false;
	}

	public function getIDEmpregados(){
		
		$sqlQuery = "SELECT codigo, nome, email, cargo, data_entrada FROM ". $this->db_table ." WHERE codigo = ".$this->codigo;
		
		$record = $this->db->query($sqlQuery);

		$dataRow=$record->fetch_assoc();
		
		$this->nome = $dataRow['nome'];
		$this->email = $dataRow['email'];
		$this->cargo = $dataRow['cargo'];
		$this->data_entrada = $dataRow['data_entrada'];
	}

	public function updateEmpregados(){

		$this->nome=htmlspecialchars(strip_tags($this->nome));
		$this->email=htmlspecialchars(strip_tags($this->email));
		$this->cargo=htmlspecialchars(strip_tags($this->cargo));
		$this->data_entrada=htmlspecialchars(strip_tags($this->data_entrada));
		$this->codigo=htmlspecialchars(strip_tags($this->codigo));

		$sqlQuery = "UPDATE ". $this->db_table ." SET nome = '".$this->nome."',email = '".$this->email."', cargo = '".$this->cargo."',data_entrada = '".$this->data_entrada."' WHERE codigo = ".$this->codigo;

		$this->db->query($sqlQuery);

		if($this->db->affected_rows > 0){
				return true;
		}
		return false;
	}
	function deleteEmpregados(){

	$sqlQuery = "DELETE FROM " . $this->db_table . " WHERE codigo = ".$this->codigo;
	
	$this->db->query($sqlQuery);
	
	if($this->db->affected_rows > 0){
			return true;
		}

		return false;
	}
}

?>