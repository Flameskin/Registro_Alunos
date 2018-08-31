package Registro;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Turma {
	private String nome;
	private String semestre;
	private Aluno[] alunos; 
	private short vaga; // atributo que define ate onde o array de alunos foi preenchido.
	
	// Cria o array de alunos de acordo com o tamanho definido por quantidade de vagas 
	// Coloca a vaga atual no indice 0 do array, que ainda esta vazio.
	public Turma (String nome, short quantVagas, String semestre) {
		this.nome = nome;
		this.semestre = semestre;
		alunos = new Aluno[quantVagas]; 
		vaga = 0; 
	}
	
	// Verifica se ha espaco no array de alunos para cadastro, se houver,
	// adiciona o novo aluno no array e avanca a posicao atual de vaga.
	public void cadastraAluno (Aluno inscrito) {
		if (vaga == (this.alunos.length)) {  
			System.out.println("Turma cheia! \nAluno: " + inscrito.getNome() + 
					" \nMatricula: " + inscrito.getMatricula() + 
					"\nO cadastro do aluno não foi efetuada.");
		} else {
			alunos[vaga] = inscrito;
			this.vaga++; 
		}
	}
	
	//busca e retorna um aluno dentro do array atraves de seu nome 
	public Aluno consultaNome(String nome) {
		int i;
		
		for (i=0;i < vaga;i++) {
			if( this.alunos[i].getNome().equals(nome)) {
				return this.alunos[i];
			}
		}
		
		return null;
	}
	
	//busca e retorna um aluno dentro do array atraves da matricula
	public Aluno consultaMatricula(int matricula) {
		int i;
		
		for(i=0;i < vaga;i++) {
			if(this.alunos[i].getMatricula() == matricula) {
				return this.alunos[i];
			}
		}
		
		return null;
	}
	
	//reorganiza o array de alunos por ordem alfabetica de nomes 
	//e imprime as informacoes de cada um
	public void imprimePorNome() {
		int i;
		
		reorganizaNome();          
		for(i=0;i < vaga;i++) {
			System.out.println(this.alunos[i]);
		}
	}
	
	//reorganiza o array de alunos por ordem decrescente de suas 
	// medias de notas e imprime as informacoes de cada um
	public void imprimePorNota() { 
		int i;
		
		reorganizaNota();		   
		for(i=0;i < vaga;i++) {
			System.out.println(this.alunos[i]);
		}
	}
	
	//exclui o aluno do array atraves do nome fornecido, 
	//substituindo sua posição com o ultimo elemento da lista.
	public void excluiAluno(String nome) { 
		int i;								
		
		for(i = 0;i < this.vaga;i++) {
			if(this.alunos[i].getNome().equals(nome)) {
				this.alunos[i] = this.alunos[vaga-1];
				this.alunos[vaga-1] = null;
				this.vaga--;
				break;
			}
		}
	}
	
	//reorganiza o array de alunos em ordem alfabetica crescente,
	private void reorganizaNome() {  
		int i;
		int j;
		Aluno temp;
		
		for(i=0;i < this.vaga;i++) {
			for(j=i;j < this.vaga;j++) {
				if((this.alunos[i].getNome().compareTo(this.alunos[j].getNome())) > 0){
					temp = this.alunos[j];
					this.alunos[j] = this.alunos[i];
					this.alunos[i] = temp;
				}
			}
		}
	}
	
	//reorganiza o array de alunos por ordem decrescente de suas notas
	private void reorganizaNota() { 
		int i;
		int j;
		
		Aluno temp;
		
		for(i=0; i<this.vaga ; i++) {
			for(j=i; j < this.vaga; j++) {
				if(this.alunos[i].getMediaSemestre() < this.alunos[j].getMediaSemestre()) {
					temp = this.alunos[j];
					this.alunos[j] = this.alunos[i];
					this.alunos[i] = temp;
				}
			}
		}
	}
	
	public void imprimeArray() {
		int i;
		
		for(i=0;i<this.alunos.length;i++) {
			System.out.println(this.alunos[i]);
		}
	}
}
