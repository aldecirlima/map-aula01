package entities;

public class Company extends TaxPayer {

	private Integer numberOfEmployees;

	public Company() {

	}

	public Company(String name, Double anualIncome, Integer numberOfEmployees) {
		super(name, anualIncome);
		this.numberOfEmployees = numberOfEmployees;
	}

	@Override
	public Double tax() {
		
		if (numberOfEmployees > 10) {
			return this.getAnualIncome() * 0.14;
		}
		
		return this.getAnualIncome() * 0.16;
	}

	public Integer getNumberOfEmployees() {
		return numberOfEmployees;
	}

	public void setNumberOfEmployees(Integer numberOfEmployees) {
		this.numberOfEmployees = numberOfEmployees;
	}

}
