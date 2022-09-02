import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;
/**
 * 
 * @author Lucas Andrin
 * 
 * Criar uma loteria com 6 números de 1 a 60. Solicitar ao usuário quantas cartelas deseja
 * preencher criar uma matriz deste tamanho para armazenar os valores que serão criados
 * aleatoriamente. No final analisar cada uma das cartelas e mostrar ao lado do números (ordenados
 * em ordem crescente e não repetidos dentro da mesma cartela) o total de acertos.
 */
public class Exe5 {
	
	private static final int QTD_NUMEROS = 6;
	private static final int MAX_NUM = 60;

	public static void main(String[] args) {
		
		/**
		 * Classes especiais
		 */
		Scanner entrada = new Scanner(System.in);
		Random random = new Random();
		
		/**
		 * Sorteia números da cartela "gabarito"
		 */
		int[] cartelaSorteada = new int[QTD_NUMEROS];
		for (int x = 0; x < QTD_NUMEROS; x++) {
			int num = random.nextInt(MAX_NUM + 1);
			if (!retornaComparacao(cartelaSorteada, num)) {
				cartelaSorteada[x] = num;
			} else {
				x--;
			}
		}
		
		System.out.print("Informe a quantidade de cartelas a serem preenchidas: ");
		int qtdCartelasUsuario = entrada.nextInt();
		
		/**
		 * cartela do usuario
		 */
		int[][] cartelaUsuario = new int[qtdCartelasUsuario][QTD_NUMEROS];
		
		for (int x = 0; x < qtdCartelasUsuario; x++) {
			int y = 0;
			
			while (y < QTD_NUMEROS) {
				boolean ehDiferente = true;
				System.out.print("Informe um numero: ");
				int num = entrada.nextInt();
				
				/**
				 * Para testes rápidos
				 */
//				int num = random.nextInt(MAX_NUM + 1);
				
				if (y != 0) {				
					for (int j = 0; j < y; j++) {
						if (num == cartelaUsuario[x][j]) {
							ehDiferente = false;
							break;
						}
					}
				}
				
				if (ehDiferente) {
					cartelaUsuario[x][y] = num;
					y++;
				} else {
					System.out.println("É necessário informar um número diferente!");
				}
			}
		}
		
		
		for (int x = 0; x < qtdCartelasUsuario; x++) {
			
			/**
			 * Ordena crescentemente
			 */
			Arrays.sort(cartelaUsuario[x]);
			
			System.out.println("Cartela " + (x + 1) + "{ ");
			
			for (int y = 0; y < QTD_NUMEROS; y++) {
				System.out.print("	Numero " + cartelaUsuario[x][y] + ": ");
				
				if (retornaComparacao(cartelaSorteada, cartelaUsuario[x][y])) {
					System.out.println("Acertou!");
				} else {
					System.out.println("Errou!");
				}
			}
			
			System.out.println("}\n");
		}
		
		
		entrada.close();
	}
	
	public static boolean retornaComparacao(int[] gabarito, int resposta) {
		for (int j = 0; j < QTD_NUMEROS; j++) {
			if (gabarito[j] == resposta) {
				return true;
			}
		}
		return false;
		
	}

}
