package github.alessandrofazio.design.patter.acyclicvisitor.visitor;

import github.alessandrofazio.design.patter.acyclicvisitor.Person;

public interface PersonVisitor extends Visitor {
    void visit(Person person);
}
