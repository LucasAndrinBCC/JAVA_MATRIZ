import java.util.Scanner;
/**
 * 
 * @author Lucas Andrin
 * Nas Olimpíadas do IFC estão ocorrendo várias competições, entre elas salto em 
 * distância, nesta competição cada atleta tem direito a cinco saltos, para valorizar o atleta
 * mais constante é feita a média dos saltos, desprezando o pior salto. Você foi contratado para
 * implementar um sistema que fará o controle desta competição, utilizando o recurso de Matriz,
 * resolva os itens abaixo:
 * 
 * · Solicitar os cinco saltos de cada atleta;
 * · Após o atleta saltar mostrar a média;
 * · Permitir a utilização do sistema por N atletas (informado no inicio da aplicação);
 * · Ao final, ou seja, após os N atletas digitarem os saltos o programa deve mostrar:
 * · Saltos de cada atleta, seguidos de sua média;
 * · A média dos saltos do campeão e do último lugar;
 */
public class Exe4 {
	
	private static final int QTD_SALTOS = 5;

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		System.out.print("Entre com a quantidade de atletas: ");
		int qtdAtletas = entrada.nextInt(),
			primeiroLugarX, ultimoLugarX;
		
		primeiroLugarX = ultimoLugarX = 0;
		
		float[][] atletas = new float[qtdAtletas][QTD_SALTOS + 1];
		
		for (int x = 0; x < qtdAtletas; x++) {
			entrada.nextLine();
			int piorSaltoY = 0;
			float somaSaltos = 0f;
			
			for (int y = 0; y < QTD_SALTOS; y++) {
				System.out.print("Entre com o tamanho do salto: ");
				atletas[x][y] = entrada.nextFloat();
				
				if (atletas[x][y] < atletas[x][piorSaltoY]) {
					piorSaltoY = y;
				}
				
				somaSaltos += atletas[x][y];
			}
			
			atletas[x][QTD_SALTOS] = (somaSaltos - atletas[x][piorSaltoY]) / (QTD_SALTOS - 1);
			
			if (atletas[x][QTD_SALTOS] > atletas[primeiroLugarX][QTD_SALTOS]) {
				primeiroLugarX = x;
			} else if (atletas[x][QTD_SALTOS] < atletas[ultimoLugarX][QTD_SALTOS]) {
				ultimoLugarX = x;
			}
			
			System.out.println("Media: " + atletas[x][QTD_SALTOS]);
		}
		
		for (int x = 0; x < qtdAtletas; x++) {
			System.out.println("Atleta "+ (x + 1) + " {");
			for (int y = 0; y < QTD_SALTOS; y++) {
				System.out.println("	Salto: " + (y + 1) + ": " + atletas[x][y]);
			}
			System.out.println("	Media: " + atletas[x][QTD_SALTOS]);
			System.out.println("}");
		}
		
		System.out.println("Primeiro Lugar!!");
		System.out.println("Atleta "+ (primeiroLugarX + 1) + " {");
		for (int y = 0; y < QTD_SALTOS; y++) {
			System.out.println("	Salto: " + (y + 1) + ": " + atletas[primeiroLugarX][y]);
		}
		System.out.println("	Media: " + atletas[primeiroLugarX][QTD_SALTOS]);
		System.out.println("}");
		
		
		System.out.println("Ultimo Lugar!!");
		System.out.println("Atleta "+ (ultimoLugarX + 1) + " {");
		for (int y = 0; y < QTD_SALTOS; y++) {
			System.out.println("	Salto: " + (y + 1) + ": " + atletas[ultimoLugarX][y]);
		}
		System.out.println("	Media: " + atletas[ultimoLugarX][QTD_SALTOS]);
		System.out.println("}");
		
		entrada.close();
	}

}
