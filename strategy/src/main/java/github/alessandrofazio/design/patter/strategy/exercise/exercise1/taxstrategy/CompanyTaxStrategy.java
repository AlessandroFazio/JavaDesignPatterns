package github.alessandrofazio.design.patter.strategy.exercise.exercise1.taxstrategy;

import github.alessandrofazio.design.patter.strategy.exercise.exercise1.TaxPayer;
import github.alessandrofazio.design.patter.strategy.exercise.exercise1.enums.TaxRate;

public class CompanyTaxStrategy implements TaxStrategy {
    private static final TaxRate RATE = TaxRate.COMPANY_RATE;

    @Override
    public double calculateTaxes(TaxPayer taxPayer) {
        return taxPayer.getIncome() * RATE.getValue();
    }
}
