package github.alessandrofazio.design.patter.strategy.exercise.exercise1;

import github.alessandrofazio.design.patter.strategy.exercise.exercise1.taxstrategy.CompanyTaxStrategy;
import github.alessandrofazio.design.patter.strategy.exercise.exercise1.taxstrategy.EmployeeTaxStrategy;
import github.alessandrofazio.design.patter.strategy.exercise.exercise1.taxstrategy.TaxStrategy;
import github.alessandrofazio.design.patter.strategy.exercise.exercise1.taxstrategy.TrustTaxStrategy;

public class TaxPayer {
    public static final TaxStrategy COMPANY_STRATEGY =
            new CompanyTaxStrategy();

    public static final TaxStrategy EMPLOYEE_STRATEGY =
            new EmployeeTaxStrategy();

    public static final TaxStrategy TRUST_STRATEGY =
            new TrustTaxStrategy();
    private final double income;
    private final TaxStrategy strategy;

    public TaxPayer(TaxStrategy strategy, double income) {
        this.strategy = strategy;
        this.income = income;

    }

    public double getIncome() {
        return income;
    }

    public double extortCash() {
        return strategy.calculateTaxes(this);
    }
}
