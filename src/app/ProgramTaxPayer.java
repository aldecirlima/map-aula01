package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

public class ProgramTaxPayer {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in).useDelimiter("\n");

		System.out.print("Informe o número de contribuintes: ");
		Integer N = sc.nextInt();

		List<TaxPayer> list = new ArrayList<TaxPayer>();

		for (int i = 1; i <= N; i++) {
			System.out.println();
			System.out.println("Dados do " + i + "° contribuinte:");
			char type = 'a';
			while (type != 'i' && type != 'e' && type != 'I' && type != 'E') {
				System.out.print("Indivíduo ou empresa (i/e)? ");
				type = sc.next().charAt(0);
				if (type != 'i' && type != 'e' && type != 'I' && type != 'E') {
					System.out.println("Opção inválida! Digite \"e\" ou \"i\".");
				}
			}

			System.out.print("Nome: ");
			String name = sc.next();
			System.out.print("Renda anual: ");
			Double anualIncome = sc.nextDouble();

			if (type == 'i' || type == 'I') {
				System.out.print("Despesas com saúde: ");
				Double healthExpenditures = sc.nextDouble();
				list.add(new Individual(name, anualIncome, healthExpenditures));
			} else {
				System.out.print("Número de funcionários: ");
				Integer numberOfEmployees = sc.nextInt();
				list.add(new Company(name, anualIncome, numberOfEmployees));
			}

		}

		System.out.println();
		System.out.println("IMPOSTOS PAGOS:");

		for (TaxPayer taxPayer : list) {
			System.out.println(taxPayer.getName() + ": R$ " + String.format("%.2f", taxPayer.tax()));
		}

		Double sum = 0.0;
		for (TaxPayer taxPayer : list) {
			sum += taxPayer.tax();
		}

		System.out.println();
		System.out.printf("TOTAL PAGO: R$ %.2f", sum);

		sc.close();
	}

}
