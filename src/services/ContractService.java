package services;

import java.util.Calendar;
import java.util.Date;

import entities.Contract;
import entities.Installment;

public class ContractService {

	private OnlinePaymentService onlinePaymentService;

	public ContractService(OnlinePaymentService onlinePaymentService) {
		this.onlinePaymentService = onlinePaymentService;
	}

	public void processContract(Contract contract, Integer months) {

		Double basicQuota = contract.getTotalValue() / months;

		for (Integer i = 1; i <= months; i++) {
			Double updatedQuota = basicQuota + onlinePaymentService.interest(basicQuota, i);

			Double fullQuota = updatedQuota + onlinePaymentService.paymentFee(updatedQuota);
			
			Date dueDate = addMonths(contract.getDate(), i);
			
			contract.getInstallments().add(new Installment(dueDate, fullQuota));
			
		}
	}

	public OnlinePaymentService getOnlinePaymentService() {
		return onlinePaymentService;
	}

	public void setOnlinePaymentService(OnlinePaymentService onlinePaymentService) {
		this.onlinePaymentService = onlinePaymentService;
	}

	private Date addMonths(Date date, Integer N) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONDAY, N);
		return calendar.getTime();
	}

}
