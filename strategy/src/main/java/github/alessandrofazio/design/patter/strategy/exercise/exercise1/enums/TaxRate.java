package github.alessandrofazio.design.patter.strategy.exercise.exercise1.enums;

public enum TaxRate {
    COMPANY_RATE(0.30),
    EMPLOYEE_RATE(0.45),
    TRUST(0.20);
    private final double value;

    public double getValue() {
        return value;
    }

    TaxRate(double value) {
        this.value = value;
    }
}
