package github.alessandrofazio.design.patter.template.exercise1;

public class Company extends TaxPayer {
    private final double income;
    private final boolean isNonProfit;

    public Company(double income, boolean isNonProfit) {
        this.income = income;
        this.isNonProfit = isNonProfit;
    }

    @Override
    protected boolean isTaxExempt() {
        return isNonProfit || income < 0;
    }

    @Override
    protected double getTaxRate() {
        return TaxRate.COMPANY_RATE.getValue();
    }

    @Override
    protected double getIncome() {
        return income;
    }
}
