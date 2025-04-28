package treino;

import java.util.Scanner;

public class SalarioLiquido {

	public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);

		// variáveis para ler as entradas dos usuários
		double salarioBruto; // ler o salário bruto
		int numDependentes; // ler o número de dependentes
		String planoSaude; // ler o plano de saúde
		String valeTransporte; // ler o vale transporte
		String valeAlimentacao; // ler o vale alimentação
		String valeRefeicao; // ler o vale refeição

		// pede os dados para o usuário
		while (true) {
			System.out.print("Digite seu salário bruto: "); // pede o salário bruto
			if (sc.hasNextDouble()) {
				salarioBruto = sc.nextDouble();
				break;
			} else {
				System.out.println("Inválido, não digite letras!");
				sc.next();

			}
		}

		while (true) {
			System.out.println("Digite o número de dependentes: "); // pede o número de dependentes
			if (sc.hasNextDouble()) {
				numDependentes = sc.nextInt();
				break;
			} else {
				System.out.println("Digite apenas números!");
				sc.next();
			}
		}

		String nomePlano = ""; // Ler qual o plano de saúde utilizado

		System.out.println("Você utiliza plano de saúde? (Sim ou Não): "); // pergunta se utiliza plano de saúde
		planoSaude = sc.next();
		while (!planoSaude.equalsIgnoreCase("Sim") && !planoSaude.equalsIgnoreCase("Não")) {
			System.out.print("Digite 'Sim' ou 'Não': ");
			planoSaude = sc.next();
		}
		if (planoSaude.equalsIgnoreCase("Sim")) {
			System.out.println("Qual o plano utilizado? (Avançado ou Básico): ");
			nomePlano = sc.next();
			while (!nomePlano.equalsIgnoreCase("Básico") && !nomePlano.equalsIgnoreCase("Avançado")
					&& !nomePlano.equalsIgnoreCase("Basico")) {
				System.out.print("Digite 'Básico' ou 'Avançado': ");
				nomePlano = sc.next();
			}
		}

		System.out.println("Você utiliza vale transporte? (Sim ou Não): "); // pergunta se utiliza o vale transporte
		valeTransporte = sc.next();
		while (!valeTransporte.equalsIgnoreCase("Sim") && !valeTransporte.equalsIgnoreCase("Não")) {
			System.out.print("Digite 'Sim' ou 'Não': ");
			valeTransporte = sc.next();
		}

		System.out.println("Você utiliza vale alimentação? (Sim ou Não): "); // pergunta se utiliza o vale alimentação
		valeAlimentacao = sc.next();
		while (!valeAlimentacao.equalsIgnoreCase("Sim") && !valeAlimentacao.equalsIgnoreCase("Não")) {
			System.out.print("Digite 'Sim' ou 'Não': ");
			valeAlimentacao = sc.next();
		}

		System.out.println("Você utiliza vale refeição? (Sim ou Não): "); // pergunta se utiliza o vale refeição
		valeRefeicao = sc.next();
		while (!valeRefeicao.equalsIgnoreCase("Sim") && !valeRefeicao.equalsIgnoreCase("Não")) {
			System.out.print("Digite 'Sim' ou 'Não': ");
			valeRefeicao = sc.next();
		}

		// calcular o desconto do INSS
		double salarioINSS = 0; // variável para armazenar o valor após o desconto do INSS

		if (salarioBruto <= 1302) {
			salarioINSS = salarioBruto * 0.08;
		} else if (salarioBruto > 1302 && salarioBruto < 2571) {
			salarioINSS = salarioBruto * 0.09;
		} else if (salarioBruto > 2571 && salarioBruto < 3856) {
			salarioINSS = salarioBruto * 0.11;
		} else if (salarioBruto > 3856 && salarioBruto < 7087.22) {
			salarioINSS = salarioBruto * 0.14;
		} else {
			salarioINSS = 570.88;
		}

		// calcular o valor do desconto do imposto de renda
		double salarioDependentes; // variável para armazenar o valor após o número de dependentes

		salarioDependentes = salarioINSS - (189.59 * numDependentes);

		double salarioIR = 0; // variável para armazenar o valor após o desconto do imposto de renda

		if (salarioDependentes > 1903.98 && salarioDependentes < 2826.66) {
			salarioIR = (salarioDependentes * 0.075) - 142.80;
		} else if (salarioDependentes > 2826.65 && salarioDependentes < 3751.06) {
			salarioIR = (salarioDependentes * 0.15) - 354.80;
		} else if (salarioDependentes > 3751.05 && salarioDependentes < 4664.69) {
			salarioIR = (salarioDependentes * 0.225) - 636.13;
		} else if (salarioDependentes > 4664.68) {
			salarioIR = (salarioDependentes * 0.275) - 869.36;
		}

		double salarioValeTransporte = 0; // variável para ler o desconto do vale transporte
		if (valeTransporte.equalsIgnoreCase("Sim")) {
			salarioValeTransporte = salarioBruto * 0.06;
		}

		double salarioValeAlimentacao = 0; // variável para ler o desconto do vale alimentação
		if (valeAlimentacao.equalsIgnoreCase("Sim")) {
			salarioValeAlimentacao = 200;
		}

		double salarioValeRefeicao = 0; // variável para ler o desconto do vale refeição
		if (valeRefeicao.equalsIgnoreCase("Sim")) {
			salarioValeRefeicao = 200;
		}

		double salarioPlanoSaude = 0; // variável para ler o desconto do plano de saúde
		if (nomePlano.equalsIgnoreCase("Básico") && !nomePlano.equalsIgnoreCase("Basico")) {
			salarioPlanoSaude = 150;
		} else if (nomePlano.equalsIgnoreCase("Avançado")) {
			salarioPlanoSaude = 300;
		}
		System.out.println();
		// mostrar o salário bruto
		System.out.println("Salário Bruto: " + salarioBruto);

		System.out.println();
		// mostrar quantos descontou de cada um
		System.out.println("DESCONTOS:");
		System.out.printf("INSS: %.2f\n", salarioINSS);
		System.out.printf("Imposto de renda: %.2f\n ", salarioIR);
		System.out.printf("Vale Transporte: %.2f\n", salarioValeTransporte);
		System.out.printf("Vale Alimentação: %.2f\n ", salarioValeAlimentacao);
		System.out.printf("Vale Refeição: %.2f\n ", salarioValeRefeicao);
		System.out.printf("Plano de Saúde: %.2\fn", salarioPlanoSaude);

		// mostrar o total de descontos e seu percentual
		double totalDescontos = salarioIR + salarioValeTransporte + salarioValeAlimentacao + salarioValeRefeicao
				+ salarioPlanoSaude + salarioINSS;

		double percentualDesconto = (totalDescontos / salarioBruto) * 100;

		System.out.println();
		System.out.printf("Total de descontos: R$ %.2f\n", totalDescontos);
		System.out.printf("Percentual de desconto: %.2f%%\n", percentualDesconto);

		// mostrar o salário líquido
		System.out.println();
		double salarioLiquido = salarioBruto - salarioINSS - salarioIR - salarioValeTransporte - salarioValeAlimentacao
				- salarioValeRefeicao - salarioPlanoSaude;
		System.out.printf("Salário líquido: R$ %.2f\n", salarioLiquido);

		sc.close();
	}

}
