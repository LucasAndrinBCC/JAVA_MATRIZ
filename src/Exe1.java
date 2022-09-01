import  java.util.Scanner;
/**
 * 
 * @author Lucas Andrin
 * Faça um programa que peça ao usuário um valor inteiro impar entre 3 e 11
 * (inclusive 3 e 11, valide esta entrada), após isto crie uma matriz quadrada
 * (inteiros) do tamanho do número informado pelo usuário. Permita que o usuário
 * informe os valores para cada uma das posições da matriz. Após isto calcula
 * e mostre as seguintes informações sobre a matriz:
 * 
 * · Soma dos elementos;
 * · Média dos elementos (duas casas decimais);
 * · Maior valor;
 * · Menor valor;
 * · Contador de pares;
 * · Contador de ímpares;
 * · Soma da diagonal principal;
 * · Soma da diagonal secundária;
 * · Mostrar a Matriz (formatada);
 * 
 * Permitir gravar e ler estes dados de um arquivo.
 */
public class Exe1 {
	
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		int l;
		
		do {
			System.out.print("Entre com o tamanho da matriz: ");
			l = entrada.nextInt();
			
			if (l < 3 || l > 11) {
				System.out.println("Entrada inválida!");
			}
		} while (l < 3 || l > 11);
		
		int[][] matriz = new int[l][l];
		float media = 0.00f;
		int soma, somaDiagonalPrincipal, somaDiagonalSecundaria, maior, menor, pares, impares;
		
		soma = somaDiagonalPrincipal = somaDiagonalSecundaria = maior = menor = pares = impares = 0;
		
		for (int x = 0; x < l; x++) {
			
			for (int y = 0; y < l; y++) {
				System.out.print("Informe o valor [" + x + "][" + y + "]: ");
				matriz[x][y] = entrada.nextInt();
				
				if (x == 0 && y == 0) {
					maior = matriz[x][y];
					menor = matriz[x][y];
				} else {
					if (maior < matriz[x][y]) {
						maior = matriz[x][y];
					} else if (menor > matriz[x][y]) {
						menor = matriz[x][y];
					}
				}
				
				if (matriz[x][y] % 2 == 0) {
					pares++;
				} else {
					impares++;
				}
				
				/**
				 * [0][1][2]
				 * [1][2][3]
				 * [2][3][4]
				 */
				if (x == y) {
					somaDiagonalPrincipal += matriz[x][y];
				} else if (x + y + 1 == l) {
					somaDiagonalSecundaria += matriz[x][y];
				}
				
				soma += matriz[x][y];
			}
		}
		
		media /= (l * l);
		
		System.out.println("Soma dos elementos: " + soma);
		System.out.println("Média dos elementos: " + media);
		System.out.println("Quantidade de pares: " + pares);
		System.out.println("Quantidade de impares: " + impares);
		System.out.println("Maior valor: " + maior);
		System.out.println("Menor valor: " + menor);
		System.out.println("Soma da diagonal principal: " + somaDiagonalPrincipal);
		System.out.println("Soma da diagonal secundaria: " + somaDiagonalSecundaria);
		
		for (int x = 0; x < l; x++) {
			for (int y = 0; y < l; y ++) {
				System.out.print("[" + matriz[x][y] + "]");
			}
			System.out.print("\n");
		}
		
		entrada.close();
	}
	
}
