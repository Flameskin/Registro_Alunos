package Registro;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Turma {
	private int numero;
	private String semestre;
	private Aluno[] alunos;
	private short quantVagas;
	private short vaga;
	
	public Turma (int numero, short quantVagas, String semestre) {
		this.numero = numero;
		this.semestre = semestre;
		this.quantVagas = quantVagas;
		alunos = new Aluno[quantVagas];
		vaga = 0;
	}
	
	public void cadastraAluno (Aluno inscrito) {
		if (vaga == (quantVagas-1)) {
			System.out.println("Turma cheia!");
			return;
		} else {
			alunos[vaga] = inscrito;
			this.vaga++;
		}
	}
}
