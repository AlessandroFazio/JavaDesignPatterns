package github.alessandrofazio.design.patter.strategy.exercise.exercise1.enums;

public enum TaxPayerType {
    COMPANY(0),
    EMPLOYEE(1),
    TRUST(2);

    private final int intValue;

    TaxPayerType(int intValue) {
        this.intValue = intValue;
    }

    public int getIntValue() {
        return intValue;
    }
}
