package github.alessandrofazio.design.patter.strategy.exercise.exercise1.taxstrategy;

import github.alessandrofazio.design.patter.strategy.exercise.exercise1.TaxPayer;
import github.alessandrofazio.design.patter.strategy.exercise.exercise1.enums.TaxRate;

public class TrustTaxStrategy implements TaxStrategy {
    private static final TaxRate RATE = TaxRate.TRUST;
    @Override
    public double calculateTaxes(TaxPayer taxPayer) {
        return taxPayer.getIncome() * RATE.getValue();
    }
}
