package github.alessandrofazio.design.patter.strategy.exercise.exercise1.taxstrategy;

import github.alessandrofazio.design.patter.strategy.exercise.exercise1.TaxPayer;

public interface TaxStrategy {
    double calculateTaxes(TaxPayer taxPayer);
}
