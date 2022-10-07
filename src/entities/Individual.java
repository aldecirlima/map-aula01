package entities;

public class Individual extends TaxPayer {

	private Double healthExpenditures;

	public Individual(String name, Double anualIncome, Double healthExpenditures) {
		super(name, anualIncome);
		this.healthExpenditures = healthExpenditures;
	}

	public Individual() {

	}

	@Override
	public Double tax() {
		Double basicTax;
		if (this.getAnualIncome() < 20000.0) {
			basicTax = this.getAnualIncome() * 0.15;
		} else {
			basicTax = this.getAnualIncome() * 0.25;
		}
		basicTax -= (this.getHealthExpenditures() * 0.5);

		if (basicTax < 0.0) {
			return 0.0;
		}
		return basicTax;

	}

	public Double getHealthExpenditures() {
		return healthExpenditures;
	}

	public void setHealthExpenditures(Double healthExpenditures) {
		this.healthExpenditures = healthExpenditures;
	}

}
