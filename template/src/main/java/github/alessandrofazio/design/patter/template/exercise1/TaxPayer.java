package github.alessandrofazio.design.patter.template.exercise1;

public abstract class TaxPayer {
    public final double calculateTax() {
        return isTaxExempt() ? 0.0 : getIncome() * getTaxRate();
    }

    protected abstract boolean isTaxExempt();
    protected abstract double getTaxRate();
    protected abstract double getIncome();
}
