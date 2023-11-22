package github.alessandrofazio.design.patter.acyclicvisitor.visitor.visitor;

import github.alessandrofazio.design.patter.acyclicvisitor.visitor.Person;

public interface PersonVisitor extends Visitor {
    void visit(Person person);
}
