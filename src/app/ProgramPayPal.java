package app;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Scanner;

import entities.Contract;
import entities.Installment;
import services.ContractService;
import services.PaypalService;

public class ProgramPayPal {

	public static void main(String[] args) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.println("Entre com os dados do contrato");

		System.out.print("Número: ");
		Integer number = sc.nextInt();

		System.out.print("Date (dd/MM/YYYY): ");
		Date date = sdf.parse(sc.next());

		System.out.print("Valor do contrato: ");
		Double totaValue = sc.nextDouble();

		Contract contract = new Contract(number, date, totaValue);

		ContractService cs = new ContractService(new PaypalService());

		System.out.print("Informe o número de parcelas: ");
		Integer months = sc.nextInt();

		cs.processContract(contract, months);

		System.out.println("Parcelas:");

		for (Installment it : contract.getInstallments()) {
			System.out.println(it);
		}

		sc.close();
	}

}
