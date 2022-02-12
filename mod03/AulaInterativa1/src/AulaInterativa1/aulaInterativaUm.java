package AulaInterativa1;

import java.util.*;

public class aulaInterativaUm {

	public static void main(String[] args) {

		// Prática para verificar a idade
		/*int ano = 0, idade = 0;
		Scanner entrada = new Scanner(System.in);		
		System.out.print("Digite o ano que vc nasceu: ");		
		ano = entrada.nextInt();
		idade = 2021 - ano;
		System.out.printf("Você nasceu no ano de %d e tem %d anos.\n", ano, idade);		
			
		if (idade >= 0 && idade <= 12)
			System.out.printf("Você ainda é uma criança");
		else if (idade > 12 && idade <= 17)
			System.out.printf("Você é um adolescente");
		else if (idade >= 18 && idade < 60)
			System.out.printf("Você já é um adulto");
		else if (idade >= 60 )
			System.out.printf("Você está na melhor idade");
		else 
		    System.out.println("Você ainda nem nasceu");*/
		
		// Prática para fazer uma simples operação matemática
		double n1 = 0, n2 = 0, total = 0;
        Scanner entrada = new Scanner(System.in);                
        char operacao;
        
        System.out.println("Digite o primeiro número:");
        n1 = entrada.nextDouble(); 
        
        System.out.println("Digite o segundo número:");
        n2 = entrada.nextDouble();
        
        entrada.nextLine();
        
        System.out.println("Digite a operação desejada (+, -, *, /):");
        operacao = entrada.nextLine().charAt(0);
        
        if (operacao == '+') 
        	total = n1 + n2;                
        else if (operacao == '-') 
           total = n1 - n2;        
        else if (operacao == '*' || operacao == 'x')
           total = n1 * n2;         
        else 
           total = n1 / n2;        
       
        System.out.printf("%.2f %c %.2f = %.2f", n1, operacao, n2, total);

	}	
}
