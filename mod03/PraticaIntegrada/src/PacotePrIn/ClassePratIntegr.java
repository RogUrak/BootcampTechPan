package PacotePrIn;

import java.util.Scanner;

public class ClassePratIntegr {

	public static void main(String[] args) {
		Scanner entChar = new Scanner(System.in);
		Scanner entNum = new Scanner(System.in);
		char operacao = ' ';
		int[] numeros = new int[1000];
		int i = 0, somatorio = 0, contaPares = 0;
		double media = 0;
		do {
			System.out.printf("Menu de opções.\n"
					+ "D = para digitar novos numeros.\n"
					+ "Z = para apresentar somatorio dos numeros.\n"
					+ "V = para visualizar todos os numeros digitados.\n"
					+ "P = para a qtde de numeros digitados.\n"
					+ "M = para a media simples dos numeros digitados.\n"
					+ "Q = para a qtde de numeros pares.\n"
					+ "S = para sair do programa");
			operacao = entChar.nextLine().charAt(0);
			
			switch (operacao) {
			case 'D':
				System.out.println("Digite o número desejado: ");
				numeros [i] = entNum.nextInt();
				i++;
				break;
			case 'Z':
				for(int j = 0; j < i; j++) {
					somatorio = somatorio + numeros[j];
				}
				System.out.printf("O somatorio dos nros é: %d\n", somatorio);
				break;
			case 'V':
				for(int j = 0; j < i; j++) {
					System.out.printf("%d\n", numeros[j]);
				}				
				break;
			case 'P':
				System.out.printf("Digitados %d números.\n", i);
				break;
			case 'M':
				for(int j = 0; j < i; j++) {
					somatorio = somatorio + numeros[j];
				}
				media = somatorio / i;
				System.out.printf("A média é: %.2f.\n", media);
				break;
			case 'Q':
				for(int j = 0; j < i; j++) {
					if (numeros[j] % 2 == 0)
						contaPares += 1;
				}
				System.out.printf("Qtde nros pares: %d.\n", contaPares);
				break;
			case 'S':
				break;

			default:
				System.out.println("Opção inválida.");
			}
		} while (operacao != 'S');
		
		System.out.println("Fim da execução.");

	}

}
