package Registro;

public class Main {
	public static void main(String[] args) {
		
		//instanciacao de uma turma para testes
		Turma nova = new Turma("LP2",(short)5,"Primeiro");
		
		//instanciacao de alunos
		Aluno inscrito = new Aluno("João","Banco de dados",1337);
		Aluno inscrito2 = new Aluno("Maria","Banco de dados",1338);
		Aluno inscrito3 = new Aluno("Ruanna","Banco de dados",1339);
		
		//cadastro de alunos na turma criada
		nova.cadastraAluno(inscrito);
		nova.cadastraAluno(inscrito2);
		nova.cadastraAluno(inscrito3);
		
		//instanciacao das provas e notas de cada aluno
		
		Prova joaoProva1 = new Prova(5.6,0.3);
		Prova joaoProva2 = new Prova(6.7,0.4);
		Prova joaoProva3 = new Prova(7.3,0.1);
		Prova joaoProva4 = new Prova(2.3,0.2);
		
		inscrito.darNota(joaoProva1, (byte)0);
		inscrito.darNota(joaoProva2, (byte)1);
		inscrito.darNota(joaoProva3, (byte)2);
		inscrito.darNota(joaoProva4, (byte)3);
		
		inscrito.calculaMedia();
		
		Prova mariaProva1 = new Prova(7,0.3);
		Prova mariaProva2 = new Prova(8,0.4);
		Prova mariaProva3 = new Prova(9,0.1);
		Prova mariaProva4 = new Prova(6,0.2);
		
		inscrito2.darNota(mariaProva1, (byte)0);
		inscrito2.darNota(mariaProva2, (byte)1);
		inscrito2.darNota(mariaProva3, (byte)2);
		inscrito2.darNota(mariaProva4, (byte)3);
		
		inscrito2.calculaMedia();
		
		Prova ruannaProva1 = new Prova(4,0.3);
		Prova ruannaProva2 = new Prova(2,0.4);
		Prova ruannaProva3 = new Prova(5,0.1);
		Prova ruannaProva4 = new Prova(1,0.2);
		
		inscrito3.darNota(ruannaProva1, (byte)0);
		inscrito3.darNota(ruannaProva2, (byte)1);
		inscrito3.darNota(ruannaProva3, (byte)2);
		inscrito3.darNota(ruannaProva4, (byte)3);
		
		inscrito3.calculaMedia();
		
		//imprimindo a lista de alunos por ordem alfabetica dos nomes
		System.out.println("Ordem alfabeticas: ");
		nova.imprimePorNome();
		
		//imprimindo a lista de alunos por ordem decrescente das notas(medias)
		System.out.println("Maiores notas: ");
		nova.imprimePorNota();
		
		//Consulta atraves de nome
		System.out.println("Consulta por nome: ");
		System.out.println(nova.consultaNome("João"));
		
		//Consulta atraves de matricula
		System.out.println("Consulta por matrícula: ");
		System.out.println(nova.consultaMatricula(1339));
		
		//Alteracao de dados de aluno cadastrado
		System.out.println("pre alteracao: ");
		nova.imprimePorNome();
		nova.consultaMatricula(1337).alteraDados("Joca", "Analise e desenvolvimento de sistemas", 1337);
		System.out.println("pos alteracao: ");
		nova.imprimePorNome();
		
		//Excluindo atraves do nome
		System.out.println("pre exclusao: ");
		nova.imprimePorNome();
		nova.excluiAluno("Joca");
		System.out.println("pos exclusao: ");
		nova.imprimePorNome();
		
		System.out.println("Lista completa, incluindo vagas restantes (null): ");
		nova.imprimeArray();
	}

}
