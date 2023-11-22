package github.alessandrofazio.design.patter.defaultvisitor.exercise.exercise1.visitor;

import github.alessandrofazio.design.patter.defaultvisitor.exercise.exercise1.composite.AbstractCompositeContact;
import github.alessandrofazio.design.patter.defaultvisitor.exercise.exercise1.composite.DistributionList;
import github.alessandrofazio.design.patter.defaultvisitor.exercise.exercise1.composite.Person;

public interface Visitor {
    void visitDistributionList(DistributionList distributionList);
    void visitPerson(Person person);
}
