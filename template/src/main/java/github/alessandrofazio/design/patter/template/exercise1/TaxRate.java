package github.alessandrofazio.design.patter.template.exercise1;

public enum TaxRate {
    COMPANY_RATE(0.29),
    EMPLOYEE_RATE(0.35),
    TRUST_RATE(0.20);

    TaxRate(double value) {
        this.value = value;
    }

    private final double value;

    public double getValue() {
        return value;
    }
}
