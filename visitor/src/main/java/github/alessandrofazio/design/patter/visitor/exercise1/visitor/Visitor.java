package github.alessandrofazio.design.patter.visitor.exercise1.visitor;

import github.alessandrofazio.design.patter.visitor.exercise1.DistributionList;
import github.alessandrofazio.design.patter.visitor.exercise1.Person;

public interface Visitor {
    void visit(Person person);

    void visit(DistributionList distributionList);
}
