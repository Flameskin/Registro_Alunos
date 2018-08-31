package Registro;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Aluno {
	private String nome;
	private String curso;
	private int matricula;
	private Prova[] notas = new Prova[4];
	private double mediaSemestre;
	
	public Aluno (String nome, String curso, int matricula) {
		this.nome = nome;
		this.curso = curso;
		this.matricula = matricula;
	}
	
	//Registra a nota de uma prova, junto de seu indice (de 0 a 3)
	public void darNota( Prova prova, byte provax) {
		notas[provax] = prova;
	}
	
	//Calcula a media das quatro provas registradas para o aluno e registra em seu atributo
	public void calculaMedia() {
		byte i;
		double somaNotas = 0.0;
		
		for(i=0;i<3;i++) {
			somaNotas += this.notas[i].notaPeso();
		}
		
		this.mediaSemestre = somaNotas;
	}
	
	//Altera os tres principais dados do aluno
	public void alteraDados(String nome, String curso, int matricula) {
		this.nome = nome;
		this.curso = curso;
		this.matricula = matricula;
	}

	@Override
	public String toString() {
		return "\nAluno: " + this.nome + "\nMatricula: " + this.matricula +
				"\nCurso: " + this.curso + "\nMedia: " + this.mediaSemestre + "\n";
	}
	
	
}