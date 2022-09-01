import java.util.Scanner;
/**
 * 
 * @author Lucas Andrin
 * Crie um programa que solicite o preço de cinco produtos em
 * cinco supermercados diferentes, ao final o programa deve
 * mostrar:
 * 
 * · Os preços em cada um dos supermercados;
 * · A média de preço por produto;
 * · A soma de preços por supermercado;
 * · O valor total no supermercado mais barato e no mais caro;
 * Permitir gravar e ler estes dados de um arquivo.
 */
public class Exe2 {
	
	private static final int QTD_PRODUTOS = 2;
	private static final int QTD_SUPERMERCADOS = 2;

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		float[][] matriz = new float[QTD_PRODUTOS][QTD_SUPERMERCADOS];
		float[] media = new float[QTD_PRODUTOS];
		float[] soma = new float[QTD_SUPERMERCADOS];
		int menor = 0, maior = 0;
		
		for (int x = 0; x < QTD_SUPERMERCADOS; x++) {
			for (int y = 0; y < QTD_PRODUTOS; y++) {
				System.out.print("Mercado " + x + ". Preco do produto: ");
				matriz[x][y] = entrada.nextFloat();
				
				media[y] += matriz[x][y];
				
				soma[x] += matriz[x][y];
			}
			
			if (soma[x] > soma[maior]) {
				maior = x;
			} else if (soma[x] < soma[menor]) {
				menor = x;
			}
		}
		
		for (int y = 0; y < QTD_PRODUTOS; y++) {
			media[y] /= QTD_PRODUTOS;
			System.out.println("Media de preco por produto: " + media[y]);
		}
		
		for (int x = 0; x < QTD_SUPERMERCADOS; x++) {
			System.out.println("Supermercado " + x + " {");
			for (int y = 0; y < QTD_PRODUTOS; y++) {
				System.out.println(y + " produto: " + matriz[x][y]);
			}
			System.out.println("Soma: " + soma[x]);
			System.out.println("}");
		}
		
		System.out.println("Mercado mais caro: " + soma[maior]);
		System.out.println("Mercado mais barato: " + soma[menor]);
		
		entrada.close();
	}

}
