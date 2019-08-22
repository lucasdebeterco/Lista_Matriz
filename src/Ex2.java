import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Ex2 {

	public static void main(String[] args) throws IOException {
		Scanner entrada = new Scanner(System.in);
		final int tam = 5;
		double[][] matriz = new double[tam][tam];
		double mediaProd = 0, somaMerc = 0, maiorSomaMerc = 0, menorSomaMerc = 0;
		
		FileWriter arq = new FileWriter("ex2.txt");
		PrintWriter gravarArq = new PrintWriter(arq);
		String escolha = new String();
		
		
		
		for (int mer = 0; mer < tam; mer++) {
			System.out.println("Mercado " + (mer+1));
			for (int prod = 0; prod < tam; prod++) {
				System.out.print("--> ");
				matriz[mer][prod] = entrada.nextDouble();	
			}
		}
		
		for (int mer = 0; mer < 5; mer++) {
			System.out.print("Preços no mercado " + (mer+1) + ": ");
			for (int prod = 0; prod < 5; prod++) {
				System.out.print(matriz[mer][prod] + " ");
				somaMerc += matriz[mer][prod];
			} 
			System.out.print("\nSoma dos preços no mercado " + (mer+1) + ": " + somaMerc + "\n");
			
			if (somaMerc > maiorSomaMerc) {
				maiorSomaMerc = somaMerc;
			}
			
			if (mer == 0) {
				menorSomaMerc = somaMerc;
			} else if (somaMerc < menorSomaMerc) {
				menorSomaMerc = somaMerc;
			}
			
			somaMerc = 0;
			System.out.println();
		}System.out.println();
		
		for (int prod = 0; prod < 5; prod++) {
			for (int mer = 0; mer < 5; mer++) {
				mediaProd += matriz[mer][prod];
			} 
			System.out.println("Média de preços do produto " + (prod+1) + ": " + (mediaProd/5));
			mediaProd = 0;
		}System.out.println();
		
		System.out.println("Valor total mais caro: " + maiorSomaMerc);
		System.out.println("Valor total mais barato: " + menorSomaMerc);
		
		// ---------------------------------------------------------------------------------------------------
		
		System.out.println("Deseja gravar um arquivo .txt com estes dados? ");
		escolha = entrada.next();
		
		if (escolha.equalsIgnoreCase("s")) {
			
			for (int mer = 0; mer < 5; mer++) {
				gravarArq.printf("Preços no mercado " + (mer+1) + ": ");
				for (int prod = 0; prod < 5; prod++) {
					gravarArq.printf(matriz[mer][prod] + " ");
					somaMerc += matriz[mer][prod];
				} 
				gravarArq.printf("\nSoma dos preços no mercado " + (mer+1) + ": " + somaMerc + "\n");
				
				if (somaMerc > maiorSomaMerc) {
					maiorSomaMerc = somaMerc;
				}
				
				if (mer == 0) {
					menorSomaMerc = somaMerc;
				} else if (somaMerc < menorSomaMerc) {
					menorSomaMerc = somaMerc;
				}
				
				somaMerc = 0;
				gravarArq.printf("\n");
			}gravarArq.printf("\n");
			
			for (int prod = 0; prod < 5; prod++) {
				for (int mer = 0; mer < 5; mer++) {
					mediaProd += matriz[mer][prod];
				} 
				gravarArq.printf("Média de preços do produto " + (prod+1) + ": " + (mediaProd/5) + "\n");
				mediaProd = 0;
			}gravarArq.printf("\n");
			
			gravarArq.printf("Valor total mais caro: " + maiorSomaMerc);
			gravarArq.printf("Valor total mais barato: " + menorSomaMerc);
			arq.close();
			
			System.out.println("Arquivo gravado..");
			entrada.close();
		}
	}

}
