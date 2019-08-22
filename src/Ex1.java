import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Ex1 {

	public static void main(String[] args) throws IOException {
		Scanner entrada = new Scanner(System.in);
		double  media = 0, soma = 0, maior = 0, menor = 0, somaDiagP = 0, somaDiagS = 0;
		int pares = 0, impares = 0;
		
		FileWriter arq = new FileWriter("ex1.txt");
		PrintWriter gravarArq = new PrintWriter(arq);
		String escolha = new String();
		
		System.out.println("Digite o tamanho da matriz (entre 3 e 11): ");
		int tam = entrada.nextInt();
		while (tam < 3 || tam > 11) {
			System.out.println("Tamanho inválido, digite novamente..");
			tam = entrada.nextInt();
		}
		double[][] matriz = new double[tam][tam];
		
		
		
		for (int lin = 0; lin < tam; lin++) {
			for (int col = 0; col < tam; col++) {
				System.out.print("--> ");
				matriz[lin][col] = entrada.nextDouble();
				soma += matriz[lin][col];
				
			}
		}
		media = soma/(tam*tam);
		menor = matriz[0][0];
		maior = matriz[0][0];
		
		for (int lin = 0; lin < tam; lin++) {
			for (int col = 0; col < tam; col++) {
				if (matriz[lin][col] > maior) {
					maior = matriz[lin][col];
				}
				if (matriz[lin][col] < menor) {
					menor = matriz[lin][col];
				}
				if (matriz[lin][col] % 2 == 0) {
					pares += 1;
				} else
					impares += 1;
				if (lin == col) {
					somaDiagP += matriz[lin][col];
				}
				if (((lin+1) + (col+1)) == (tam+1)) {
					somaDiagS += matriz[lin][col];
				}
			}
		}
		
		System.out.println("Soma: " + soma);
		System.out.println("Média: " + media);
		System.out.println("Menor: " + menor);
		System.out.println("Maior: " + maior);
		System.out.println("Quantidade de pares: " + pares);
		System.out.println("Quantidade de impares: " + impares);
		System.out.println("Soma diagonal principal: " + somaDiagP);
		System.out.println("Soma diagonal secundária: " + somaDiagS);
		System.out.println("Imprimindo a matriz: ");
		for (int lin = 0; lin < tam; lin++) {
			for (int col = 0; col < tam; col++) {
				System.out.print(matriz[lin][col] + " ");
			} System.out.println();
		}
		
		System.out.println("Deseja gravar um arquivo .txt com estes dados? ");
		escolha = entrada.next();
		if (escolha.equalsIgnoreCase("s")) {
			gravarArq.printf("Soma: " + soma + "\n");
			gravarArq.printf("Média: " + media + "\n");
			gravarArq.printf("Menor: " + menor + "\n");
			gravarArq.printf("Maior: " + maior + "\n");
			gravarArq.printf("Quantidade de pares: " + pares + "\n");
			gravarArq.printf("Quantidade de impares: " + impares + "\n");
			gravarArq.printf("Soma diagonal principal: " + somaDiagP + "\n");
			gravarArq.printf("Soma diagonal secundária: " + somaDiagS + "\n");
			gravarArq.printf("Imprimindo a matriz: " + "\n");
			for (int lin = 0; lin < tam; lin++) {
				for (int col = 0; col < tam; col++) {
					gravarArq.printf(matriz[lin][col] + " ");
				} gravarArq.printf("\n");
			}
			arq.close();
			System.out.println("Arquivo gravado..");
		}
		entrada.close();
	}

}
