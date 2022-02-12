package AulaInterativa2;

import java.util.Scanner;

public class aulaInterativaDois {

	public static void main(String[] args) {

		/*
		 * Criar um programa que: 
		 * a) receba nomes, idades e situações de pessoas; 
		 * b) não permitir nomes vazios, idades negativas e situações diferentes de A, I e E;
		 * 
		 * Ao final, exibir: 
		 * i) todos os dados das pessoas; 
		 * ii) a maior idade encontrada; 
		 * iii) a quantidade de pessoas em cada situação;
		 */
		
		String[] nomes = new String[50];
		int[] idades = new int[50];
		char[] situacoes = new char[50];
		char continuar = 'S';
		int nPessoas = 0, maiorIdade = 0, posicaoMaiorIdade = 0;
		int[] contaSituacao = new int[3];
		Scanner entCaractere = new Scanner(System.in);
		Scanner entNumero = new Scanner(System.in);

		while (continuar == 'S' || continuar == 's') {
			System.out.printf("Digite o nome da %dº pessoa.\n", nPessoas + 1);
			nomes[nPessoas] = entCaractere.nextLine();

			while (nomes[nPessoas].equals("")) {
				System.out.printf("Nome vazio. Digite o nome da %dº pessoa.\n", nPessoas + 1);
				nomes[nPessoas] = entCaractere.nextLine();
			}

			System.out.printf("Digite a idade da %dº pessoa.\n", nPessoas + 1);
			idades[nPessoas] = entNumero.nextInt();

			while (idades[nPessoas] < 0) {
				System.out.printf("Idade negativa. Digite a idade da %dº pessoa.\n", nPessoas + 1);
				idades[nPessoas] = entNumero.nextInt();
			}
			if (idades[nPessoas] > maiorIdade) {
				maiorIdade = idades[nPessoas];
				posicaoMaiorIdade = nPessoas;
			}

			System.out.printf("Digite a situação da pessoa %dº (A - Ativo, I - Inativo, " + "E - Excluído):\n", nPessoas + 1);
			situacoes[nPessoas] = entCaractere.nextLine().charAt(0);

			while (situacoes[nPessoas] != 'A' && situacoes[nPessoas] != 'a' && situacoes[nPessoas] != 'E'
					&& situacoes[nPessoas] != 'e' && situacoes[nPessoas] != 'I' && situacoes[nPessoas] != 'i') {
				System.out.printf("Situação inválida. Digite a situação da pessoa %dº "
						+ "(A - Ativo, I - Inativo, E - Excluído):\n", nPessoas + 1);
				situacoes[nPessoas] = entCaractere.nextLine().charAt(0);
			}

			if (situacoes[nPessoas] == 'A' || situacoes[nPessoas] == 'a')
				contaSituacao[0]++;
			else if (situacoes[nPessoas] == 'E' || situacoes[nPessoas] == 'e')
				contaSituacao[1]++;
			else
				contaSituacao[2]++;

			System.out.println("Deseja continuar <S - Sim; N - Não>?");
			continuar = entCaractere.nextLine().charAt(0);

			while (continuar != 'S' && continuar != 's' && continuar != 'N' && continuar != 'n') {
				System.out.println("Opção inválida. Deseja continuar <S - Sim; N - Não>?");
				continuar = entCaractere.nextLine().charAt(0);
			}
			nPessoas++;
		} // fechamento do while principal

		System.out.println("\n*************** Resultado ***************");

		for (int i = 0; i < nPessoas; i++)
			System.out.printf("Nome: %s. Idade: %d. Situação: %c.\n", nomes[i], idades[i], situacoes[i]);

		System.out.printf("O total de pessoas cadastadas é: %d.\n", nPessoas);
		System.out.printf("A maior idade é de %s com %d anos.\n", nomes[posicaoMaiorIdade], idades[posicaoMaiorIdade]);
		System.out.printf("Total de situações: Ativo(%d); Excluído(%d); Inativo(%d);", contaSituacao[0],
				contaSituacao[1], contaSituacao[2]);

	}

}
