package treino;

import java.util.Scanner;

public class SalarioLiquido {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// variaveis para ler as entradas dos usúarios
		double salariob; // ler o salario bruto
		int numdepen; // ler o numero de dependentes
		String planosaude; // ler o plano de saude
		String valetrans; // ler o vale transporte
		String valealimen; // ler o vale alimentação
		String valerefeicao; // ler o vale alimentação

		// pede os dados para o usuario
		System.out.print("Digite seu salário bruto:");// pede o salario bruto
		salariob = sc.nextDouble();

		System.out.println("Digite o números de dependentes:");// pede o número de dependentes
		numdepen = sc.nextInt();

		String nomeplano = "";// Ler qual o plano de saude utilizado

		System.out.println("Você utiliza plano de saúde?(Sim ou não)");// pergunta se utiliza plano de saude
		planosaude = sc.next();
		while (!planosaude.equalsIgnoreCase("Sim") && !planosaude.equalsIgnoreCase("Não")) {
			System.out.print(" Digite 'Sim' ou 'Não': ");
			planosaude = sc.next();
		}
		if (planosaude.equalsIgnoreCase("Sim")) {
			System.out.println("Qual o plano utilizado?(Avançado ou Básico)");
			nomeplano = sc.next();
			while (!nomeplano.equalsIgnoreCase("Básico") && !nomeplano.equalsIgnoreCase("Avançado")) {
				System.out.print("Digite 'Básico' ou 'Avançado': ");
				nomeplano = sc.next();
			}

		} else {

		}

		System.out.println("Você utliza vale transporte?(Sim ou não)");// pergunta se utiliza o vale transporte
		valetrans = sc.next();
		while (!valetrans.equalsIgnoreCase("Sim") && !valetrans.equalsIgnoreCase("Não")) {
			System.out.print("Digite 'Sim' ou 'Não': ");
			valetrans = sc.next();
		}

		System.out.println("Você utiliza o vale alimentação?(Sim ou não)");// pergunta se utiliza o vale alimentação
		valealimen = sc.next();
		while (!valealimen.equalsIgnoreCase("Sim") && !valealimen.equalsIgnoreCase("Não")) {
			System.out.print("Digite 'Sim' ou 'Não': ");
			valealimen = sc.next();
		}

		System.out.println("Você utiliza o vale refeição?(Sim ou não)");// pergunta se utiliza o vale refeição
		valerefeicao = sc.next();
		while (!valerefeicao.equalsIgnoreCase("Sim") && !valerefeicao.equalsIgnoreCase("Não")) {
			System.out.print("Digite 'Sim' ou 'Não': ");
			valerefeicao = sc.next();
		}

		// calcular o desconto do inss
		double salarioinss = 0; // variável pra armazenar o valor após o desconto do inss

		if (salariob <= 1302) {
			salarioinss = salariob - (salariob * 0.08);
		} else if (salariob > 1302 && salariob < 2571) {
			salarioinss = salariob - (salariob * 0.09);
		} else if (salariob > 2571 && salariob < 3856) {
			salarioinss = salariob - (salariob * 0.11);
		} else if (salariob > 3856 && salariob < 7087.22) {
			salarioinss = salariob - (salariob * 0.14);
		} else {
			salarioinss = salariob - 570.88;
		}

		// calcular o valor do desconto do imposto de renda
		double salariodep; // variavel para armazenar o valor após o numero de dependentes

		salariodep = salarioinss - (189.59 * numdepen);

		double salarioir = 0; // variavel para armazenar o valor após o desconto do imposto de renda

		if (salariodep > 1903.98 && salariodep < 2826.66) {
			salarioir = (salariodep * 0.075) - 142.80;
		} else if (salariodep > 2826.65 && salariodep < 3751.06) {
			salarioir = (salariodep * 0.15) - 354.80;
		} else if (salariodep > 3751.05 && salariodep < 4664.69) {
			salarioir = (salariodep * 0.225) - 636.13;
		} else if (salariodep > 4664.68) {
			salarioir = (salariodep * 0.275) - 869.36;
		}
		double salariovaletrans = 0; // variavel para ler o desconto do vale transporte
		if (valetrans.equalsIgnoreCase("Sim")) {
			salariovaletrans = salariob * 0.06;
		} else {

		}
		double salariovalealimen = 0;// variavel para ler o desconto do vale alimentação
		if (valealimen.equalsIgnoreCase("Sim")) {
			salariovalealimen = 200;
		} else {

		}
		double salariovalerefeicao = 0; // variavel para ler o desconto do vale refeiçao
		if (valerefeicao.equalsIgnoreCase("Sim")) {
			salariovalerefeicao = 200;
		} else {

		}
		double salarioplanos = 0; // variavel para ler o desconto do plano de saude
		if (nomeplano.equalsIgnoreCase("Básico")) {
			salarioplanos = 150;
		} else if (nomeplano.equalsIgnoreCase("Avançado")) {
			salarioplanos = 300;
		} else {

		}

		// mostrar o salario liquido
		double salariof = salarioinss - salarioir - salariovaletrans - salariovalealimen - salariovalerefeicao
				- salarioplanos;
		System.out.printf("O salario é: %.2f\n", salariof);

		// mostrar o total de descontos e seu percentual
		double totalDescontos = salarioir + salariovaletrans + salariovalealimen + salariovalerefeicao + salarioplanos
				+ (salariob - salarioinss);
		double percentualDesconto = (totalDescontos / salariob) * 100;

		System.out.printf("Total de descontos: R$ %.2f\n", totalDescontos);
		System.out.printf("Percentual de desconto: %.2f%%\n", percentualDesconto);

		sc.close();
	}

}
