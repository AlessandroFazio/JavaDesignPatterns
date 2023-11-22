package github.alessandrofazio.design.patter.template.exercise1;

public class Trust extends TaxPayer {
    private final boolean isDisability;
    private final double income;

    public Trust(boolean isDisability, double income) {
        this.isDisability = isDisability;
        this.income = income;
    }

    @Override
    protected boolean isTaxExempt() {
        return isDisability || income < 0;
    }

    @Override
    protected double getTaxRate() {
        return TaxRate.TRUST_RATE.getValue();
    }

    @Override
    protected double getIncome() {
        return income;
    }
}
