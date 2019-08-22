import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Ex3 {

	public static void main(String[] args) throws IOException{
		Scanner entrada = new Scanner(System.in);
		int qntAlunos = 0;
		float media = 0, maiorNota = 0, menorNota = 0, maiorMedia = 0, menorMedia = 0, mediaTurma = 0;
		String nomeMaiorNota = new String();
		String nomeMenorNota = new String();
		String nomeMaiorMedia = new String();
		String nomeMenorMedia = new String();
		
		FileWriter arq = new FileWriter("ex3.txt");
		PrintWriter gravarArq = new PrintWriter(arq);
		String escolha = new String();
		
		System.out.println("Digite a quantidade de alunos do colégio: ");
		qntAlunos = entrada.nextInt();

		String[][] alunos = new String[qntAlunos][3];

		for (int lin = 0; lin < qntAlunos; lin++) {
			System.out.println("Nome do aluno: ");
			alunos[lin][0] = entrada.next();
			System.out.println("Prova 1: ");
			alunos[lin][1] = entrada.next();
			System.out.println("Prova 2: ");
			alunos[lin][2] = entrada.next();
		}

		for (int lin = 0; lin < qntAlunos; lin++) {
			for (int col = 0; col < 3; col++) {
				System.out.print(alunos[lin][col] + " | ");
			}
			System.out.println();
		}

		for (int lin = 0; lin < qntAlunos; lin++) {
			float nota1Int = Float.parseFloat(alunos[lin][1]);
			float nota2Int = Float.parseFloat(alunos[lin][2]);
			mediaTurma += nota1Int;
			mediaTurma += nota2Int;
			
			media = (nota1Int + nota2Int) / 2;
			System.out.print("\nMédia do aluno: " + media);
			
			if(lin == 0) {
				nomeMaiorMedia = alunos[lin][0];
				maiorMedia = media;
			} else {
				if (media > maiorMedia) {
					nomeMaiorMedia = alunos[lin][0];
					maiorMedia = media;
				}
			}
			
			if(lin == 0) {
				nomeMenorMedia = alunos[lin][0];
				menorMedia = media;
			} else {
				if (media < menorMedia) {
					nomeMenorMedia = alunos[lin][0];
					menorMedia = media;
				}
			}	
			
			if(lin == 0) {
				nomeMaiorNota = alunos[lin][0];
				maiorNota = nota1Int;
				if (nota2Int > maiorNota) {
					maiorNota = nota2Int;
				}
			} else {
				if (nota1Int > maiorNota) {
					nomeMaiorNota = alunos[lin][0];
					maiorNota = nota1Int;
				}
				if (nota2Int > maiorNota) {
					nomeMaiorNota = alunos[lin][0];
					maiorNota = nota2Int;
				}
			}
			
			if(lin == 0) {
				nomeMenorNota = alunos[lin][0];
				menorNota = nota1Int;
				if (nota2Int < menorNota) {
					menorNota = nota2Int;
				}
			} else {
				if (nota1Int < menorNota) {
					nomeMenorNota = alunos[lin][0];
					menorNota = nota1Int;
				}
				if (nota2Int < menorNota) {
					nomeMenorNota = alunos[lin][0];
					menorNota = nota2Int;
				}
			}
			media = 0;
			
		}
		
		System.out.println("Nome maior nota: " + nomeMaiorNota);
		System.out.println("Menor nota: " + maiorNota);
		
		System.out.println("Nome menor nota: " + nomeMenorNota);
		System.out.println("Menor nota: " + menorNota);
		
		System.out.println("Nome maior media: " + nomeMaiorMedia);
		System.out.println("Maior media: " + maiorMedia);
		
		System.out.println("Nome menor media: " + nomeMenorMedia);
		System.out.println("Menor media: " + menorMedia);
		
		System.out.println("Media geral da turma: " + mediaTurma/(qntAlunos*2));
		
		//-------------------------------------------------------------------------------------------------------
		
		System.out.println("Deseja gravar um arquivo .txt com estes dados? ");
		escolha = entrada.next();
		
		if (escolha.equalsIgnoreCase("s")) {
			
			
			for (int lin = 0; lin < qntAlunos; lin++) {
				for (int col = 0; col < 3; col++) {
					gravarArq.printf(alunos[lin][col] + " | ");
				}
				gravarArq.printf("\n");
			}
				
			gravarArq.printf("\nNome maior nota: " + nomeMaiorNota);
			gravarArq.printf("\nMenor nota: " + maiorNota);
			
			gravarArq.printf("\nNome menor nota: " + nomeMenorNota);
			gravarArq.printf("\nMenor nota: " + menorNota);
			
			gravarArq.printf("\nNome maior media: " + nomeMaiorNota);
			gravarArq.printf("\nMaior media: " + maiorNota);
			
			gravarArq.printf("\nNome menor media: " + nomeMenorNota);
			gravarArq.printf("\nMenor media: " + menorNota);
			gravarArq.printf("\nMedia geral da turma: " + mediaTurma/(qntAlunos*2));
			
			arq.close();
			
			System.out.println("Arquivo gravado..");
			entrada.close();
		}

	}

}
