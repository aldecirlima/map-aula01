package app;

import java.util.Locale;
import java.util.Scanner;

import entities.Account;
import exceptions.BusinessException;

public class ProgramConta {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.println("Informe os dados da conta");
		System.out.print("Número: ");
		Integer number = sc.nextInt();

		System.out.print("Titular: ");
		sc.nextLine();
		String holder = sc.nextLine();

		System.out.print("Saldo inicial: ");
		Double balance = sc.nextDouble();

		System.out.print("Limite de saque: ");
		Double withdrawLimit = sc.nextDouble();

		Account acc = new Account(number, holder, balance, withdrawLimit);

		System.out.print("\nInforme uma quantia para sacar: ");
		Double amount = sc.nextDouble();

		try {
			acc.withdraw(amount);
			System.out.println("Saque efetuado com sucesso!");
			System.out.printf("Novo saldo: %.2f%n", acc.getBalance());
		} catch (BusinessException e) {
			System.out.println(e.getMessage());
		}


		sc.close();
	}

}
