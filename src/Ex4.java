import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Ex4 {

	public static void main(String[] args) throws IOException{
		Scanner entrada = new Scanner(System.in);
		int numAtletas = 0;
		float media = 0, menor = 0;
		
		FileWriter arq = new FileWriter("ex4.txt");
		PrintWriter gravarArq = new PrintWriter(arq);
		String escolha = new String();

		System.out.println("Digite a quantidade de atletas: ");
		numAtletas = entrada.nextInt();
		float[][] atletas = new float[numAtletas][6];

		for (int lin = 0; lin < numAtletas; lin++) {
			for (int col = 0; col < 6; col++) {
				System.out.println("Salto " + col);
				atletas[lin][col] = entrada.nextFloat();
				media += atletas[lin][col];
				if (col == 1) {
					menor = atletas[lin][col];
				} else {
					if (atletas[lin][col] < menor) {
						menor = atletas[lin][col];
					}
				}

			}
			media -= menor;
			media /= 4;
			atletas[lin][5] = media;
			media = 0;
			System.out.println("Média: " + atletas[lin][5]);
		}
		System.out.println();

		for (int lin = 0; lin < numAtletas; lin++) {
			for (int col = 0; col < 6; col++) {
				if (col < 5) {
					System.out.println("Salto " + (col + 1));
					System.out.println(atletas[lin][col]);
				} else
					System.out.println("Média " + atletas[lin][col]);
			}
			System.out.println();
		}

		// -------------------------------------------------------------------------------------------------------

		System.out.println("Deseja gravar um arquivo .txt com estes dados? ");
		escolha = entrada.next();

		if (escolha.equalsIgnoreCase("s")) {

			
			for (int lin = 0; lin < numAtletas; lin++) {
				for (int col = 0; col < 6; col++) {
					media += atletas[lin][col];
					if (col == 1) {
						menor = atletas[lin][col];
					} else {
						if (atletas[lin][col] < menor) {
							menor = atletas[lin][col];
						}
					}

				}
				media -= menor;
				media /= 4;
				atletas[lin][5] = media;
				media = 0;
			}

			for (int lin = 0; lin < numAtletas; lin++) {
				for (int col = 0; col < 6; col++) {
					if (col < 5) {
						gravarArq.printf("Salto " + (col + 1) + " ");
						gravarArq.printf(""+atletas[lin][col] + "\n");
					} else
						gravarArq.printf("Média " + atletas[lin][col] + "\n");
				}
				gravarArq.printf("\n");
			}
			arq.close();

			System.out.println("Arquivo gravado..");
			entrada.close();
		}

	}

}
