import java.util.Scanner;
/**
 * 
 * @author Lucas Andrin
 * Utilizando a estrutura de matriz, faça um programa que para um colégio que
 * tem N (deve ser informado no início do programa) alunos e estes são avaliados
 * em duas provas. O programa deve permitir digitação do nome do aluno e das
 * duas notas e após isto mostrar as seguintes informações:
 * 
 * Nome e as duas Notas de cada aluno;
 * A média de cada aluno; ok
 * A maior e menor nota (nome do aluno junto); ok
 * A maior e menor média (nome do aluno junto); ok
 * A média geral da turma; ok
 * O nome dos alunos acima e abaixo da Media Geral da Turma;
 */
public class Exe3 {
	
	private static final int QTD_NOTAS = 2;

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		int qtdAlunos,
			maiorNotaX, maiorNotaY,
			menorNotaX, menorNotaY,
			maiorMediaX,
			menorMediaX;
		
		float soma, mediaGeral = 0f;
		
		/**
		 * Quantidade de Alunos		
		 */
		System.out.print("Entre com a quantidade de alunos: ");
		qtdAlunos = entrada.nextInt();
		
		maiorNotaX = maiorNotaY = menorNotaX = menorNotaY = maiorMediaX = menorMediaX = 0;
		
		String[] alunos = new String[qtdAlunos];
		float[][] notas = new float[qtdAlunos][QTD_NOTAS + 1];
		
		for (int x = 0; x < qtdAlunos; x++) {
			entrada.nextLine();
			soma = 0f;
			
			System.out.print("Entre com o nome do aluno: ");
			alunos[x] = entrada.nextLine();
			
			for (int y = 0; y < QTD_NOTAS; y++) {
				
				System.out.print("Entre com a nota do aluno: ");
				notas[x][y] = entrada.nextFloat();
				
				/**
				 * Verifica Notas Maiores e Menores				
				 */
				if (notas[x][y] > notas[maiorNotaX][maiorNotaY]) {
					maiorNotaX = x;
					maiorNotaY = y;
				} else if (notas[x][y] < notas[menorNotaX][menorNotaY]) {
					menorNotaX = x;
					menorNotaY = y;
				}
				
				soma += notas[x][y];
			}
			
			/**
			 * Média do aluno
			 */
			notas[x][QTD_NOTAS] = soma / QTD_NOTAS;
			
			/**
			 * Média Geral da Turma
			 */
			mediaGeral += notas[x][QTD_NOTAS];
			
			/**
			 * Verifica Médias Maiores e Menores		
			 */
			if (notas[x][QTD_NOTAS] > notas[maiorMediaX][QTD_NOTAS]) {
				maiorMediaX = x;
			} else if (notas[x][QTD_NOTAS] < notas[menorMediaX][QTD_NOTAS]) {
				maiorMediaX = x;
			}
		}
		
		mediaGeral /= qtdAlunos;
		
		/**
		 * Mostra as notas e médias dos alunos com seus respectivos nomes		
		 */
		for (int x = 0; x < qtdAlunos; x++) {
			System.out.println(alunos[x] + " {");
			for (int y = 1; y <= QTD_NOTAS; y++) {
				System.out.println("	Nota " + y + ": " + notas[x][y]);
			}
			System.out.println("	Media: " + notas[x][QTD_NOTAS]);
			System.out.println("}");
		}
		
		System.out.println("Media Geral da Turma: " + mediaGeral);
		
		System.out.println(alunos[maiorNotaX] + " teve a maior nota: " + notas[maiorNotaX][maiorNotaY]);
		System.out.println(alunos[menorNotaX] + " teve a maior nota: " + notas[menorNotaX][menorNotaY]);
		
		System.out.println(alunos[maiorMediaX] + " teve a maior media: " + notas[maiorMediaX][QTD_NOTAS]);
		System.out.println(alunos[menorMediaX] + " teve a menor media: " + notas[menorMediaX][QTD_NOTAS]);
		
		entrada.close();
	}

}
