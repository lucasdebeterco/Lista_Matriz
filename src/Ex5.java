import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Ex5 {

	public static void main(String[] args) throws IOException {
		Scanner entrada = new Scanner(System.in);
		int numCartelas = 0, totalAcertos = 0;

		FileWriter arq = new FileWriter("ex5.txt");
		PrintWriter gravarArq = new PrintWriter(arq);
		String escolha = new String();

		System.out.println("Digite a quantidade de cartelas: ");
		numCartelas = entrada.nextInt();
		int[][] cartelas = new int[numCartelas][6];

		for (int lin = 0; lin < numCartelas; lin++) {
			for (int col = 0; col < 6; col++) {
				cartelas[lin][col] = (int) (Math.random() * 60);
			}
		}
		for (int lin = 0; lin < numCartelas; lin++) {
			for (int col = 0; col < 6; col++) {
				if (cartelas[lin][col] == 1) {
					totalAcertos += 1;
				}
				if (cartelas[lin][col] == 2) {
					totalAcertos += 1;
				}
				if (cartelas[lin][col] == 3) {
					totalAcertos += 1;
				}
				if (cartelas[lin][col] == 4) {
					totalAcertos += 1;
				}
				if (cartelas[lin][col] == 5) {
					totalAcertos += 1;
				}
				if (cartelas[lin][col] == 6) {
					totalAcertos += 1;
				}
				System.out.print(cartelas[lin][col] + " ");
			}
			System.out.println("Acertos: " + totalAcertos);
			totalAcertos = 0;
		}

		// -------------------------------------------------------------------------------------------------------

		System.out.println("Deseja gravar um arquivo .txt com estes dados? ");
		escolha = entrada.next();

		if (escolha.equalsIgnoreCase("s")) {

			for (int lin = 0; lin < numCartelas; lin++) {
				for (int col = 0; col < 6; col++) {
					if (cartelas[lin][col] == 1) {
						totalAcertos += 1;
					}
					if (cartelas[lin][col] == 2) {
						totalAcertos += 1;
					}
					if (cartelas[lin][col] == 3) {
						totalAcertos += 1;
					}
					if (cartelas[lin][col] == 4) {
						totalAcertos += 1;
					}
					if (cartelas[lin][col] == 5) {
						totalAcertos += 1;
					}
					if (cartelas[lin][col] == 6) {
						totalAcertos += 1;
					}
					gravarArq.printf(cartelas[lin][col] + " ");
				}
				gravarArq.printf("Acertos: " + totalAcertos + "\n");
				totalAcertos = 0;
			}
			arq.close();
			entrada.close();
		}

	}

}
