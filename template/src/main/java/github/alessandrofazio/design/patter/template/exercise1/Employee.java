package github.alessandrofazio.design.patter.template.exercise1;

public class Employee extends TaxPayer {
    private final boolean isForeign;
    private final double income;

    public Employee(boolean foreign, double income) {
        this.isForeign = foreign;
        this.income = income;
    }

    @Override
    protected boolean isTaxExempt() {
        return isForeign;
    }

    @Override
    protected double getTaxRate() {
        if(income < 20_000.0) return 0.0;
        if(income < 50_000) return 0.1;
        if(income < 100_000) return 0.25;
        return 0.45;
    }

    @Override
    protected double getIncome() {
        return income;
    }
}
