package Registro;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Prova {
	private double nota;
	private double peso; //peso maximo 1, cada prova tem pesos que variam entre 0.1, 0.3, etc
	
	public Prova(double nota, double peso) {
		this.nota = nota;
		this.peso = peso;
	}
	
	//retorna a nota da prova, calculada de acordo com seu peso
	public double notaPeso() {
		return this.nota * this.peso;
	}
}
