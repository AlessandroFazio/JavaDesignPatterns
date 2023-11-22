package github.alessandrofazio.design.patter.strategy.exercise.exercise1;

import github.alessandrofazio.design.patter.strategy.exercise.exercise1.taxstrategy.CompanyTaxStrategy;
import github.alessandrofazio.design.patter.strategy.exercise.exercise1.taxstrategy.TrustTaxStrategy;

public class ReceiverOfRevenue {
    public static void main(String[] args) {
        TaxPayer heinz, maxsol, family;
        heinz = new TaxPayer(tp -> 0, 50000);
        maxsol = new TaxPayer(new CompanyTaxStrategy(), 100000);
        family = new TaxPayer(new TrustTaxStrategy(), 30000);
        System.out.println(heinz.extortCash());
        System.out.println(maxsol.extortCash());
        System.out.println(family.extortCash());
    }
}
