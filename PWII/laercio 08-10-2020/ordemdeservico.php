<?php
    class ordemDeServico{
        private $OS;
        private $data;
        private $situacao;
        private $solicitante;
        private $area;
        

        public function setOS($OS){
            $this -> OS = $OS;
        }
        
        public function getOS(){
            return $this->OS;
        }
        
        public function setData($data){
            $this -> data = $data;
        }
        
        public function getData(){
            return $this->data;
        }

        public function setSituacao($situacao){
            $this -> situacao = $situacao;
        }

        public function getSituacao(){
            return $this->situacao;
        }

        public function setSolicitante($solicitante){
            $this -> solicitante = $solicitante;
        }

        public function getSolicitante(){
            return $this->solicitante;
        }

        public function setArea($area){
            $this -> area = $area;
        }

        public function getArea(){
            return $this->Area;
        }

        public function getOrdem(){
            return [
                "os" => $OS,
                "data" => $data,
                "situacao" => $situacao,
                "solicitante" => $solicitante,
                "area" => $area
            ];
        }
    }

    class dados_do_cliente{
        private $nome;
        private $telefone;
        private $endereco;
        private $bairro;
        private $cidade;
        private $UF;
        private $CEP;
    
        public function setNome($nome){
            $this->nome = $nome;
        }
    
        public function getnome(){
            return $this->nome;
        }
        
        public function setTelefone($telefone){
            $this->telefone =$telefone;
        }

        public function getTelefone(){
            return $this->telefone;
        }
    
        public function setEndereco($endereco){
            $this->endereco =$endereco;
        }
    
        public function getEndereco(){
            return $this->endereco;
        }

        public function setBairro($bairro){
            $this->bairro =$bairro;
        }

        public function getBairro(){
            return $this->bairro;
        }
    
        public function setCidade($cidade){
            $this->cidade =$cidade;
        }
    
        public function getCidade(){
            return $this->cidade;
        }

        public function setUF($UF){
            $this->UF =$UF;
        }
    
        public function getUF(){
            return $this->UF;
        }

        public function setCEP($CEP){
            $this->CEP =$CEP;
        }
    
        public function getCEP(){
            return $this->CEP;
        }
        
        public function getCliente(){
            return [
                "nome" => $nome,
                "telefone" => $telefone,
                "endereco" => $endereco,
                "bairro" => $bairro,
                "cidade" => $cidade,
                "uf" => $UF,
                "cep" => $CEP
            ];
        }
    }

    class Equipamento{
        private $equipamentos;
        private $justificativa;
        private $manutencao;
        private $observacoes;
    
        public function setEquipamentos($equipamentos){
            $this-> equipamentos = $equipamentos;
        }

        public function getEquipamentos(){
            return $this->equipamentos; 
        }


        public function setJustificativa($justificativa){
            $this-> justificativa = $justificativa;
        }

        public function getJustificativa(){
            return $this->justificativa; 
        }

        public function setManutencao($manutencao){
            $this-> manutencao = $manutencao;
        }

        public function getManutencao(){
            return $this->manutencao; 
        }

        public function setObservacoes($observacoes){
            $this-> observacoes = $observacoes;
        }

        public function getObservacoes(){
            return $this->observacoes; 
        }
    
        public function getAllEquipamentos(){
            return [
                "equipamentos" => $equipamentos,
                "justificativa" => $justificativa,
                "manutencao" => $manutencao,
                "observacoes" => $observacoes
            ];
        }
    }

    class Servicos{
        private $horaInicio;
        private $horaTermino;
        private $atividade;
        private $tecnico;
        private $tempoTotal;
    
        public function setHoraInicio($hInicio){
            $this-> horaInicio = $hInicio;
        }

        public function getHoraInicio(){
            return $this->horaInicio;
        }

        public function setHoraTermino($hTermino){
            $this-> horaTermino = $hTermino;
        }

        public function getHoraTermino(){
            return $this->horaTermino;
        }

        public function setAtividade($atividade){
            $this-> atividade = $atividade;
        }

        public function getAtividade(){
            return $this->Atividade;
        }

        public function setTecnico($tecnico){
            $this-> tecnico = $tecnico;
        }

        public function getTecnico(){
            return $this->tecnico;
        }

        public function setTempoTotal($tTotal){
            $this-> tempoTotal = $tTotal;
        }

        public function getTempoTotal(){
                return $this->tempoTotal;
        }

        public function getServicos(){
                return [
                "horaInicio" => $horaInicio,
                "horaTermino" => $horaTermino,
                "atividade" => $atividade,
                "tecnico" => $tecnico,
                "tempoTotal" => $tempoTotal,
            ];
        }
    
    }
    
?>