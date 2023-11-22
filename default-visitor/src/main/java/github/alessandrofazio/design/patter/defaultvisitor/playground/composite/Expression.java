package github.alessandrofazio.design.patter.defaultvisitor.playground.composite;

import github.alessandrofazio.design.patter.defaultvisitor.playground.visitor.Visitor;

public abstract class Expression {

    public abstract void accept(Visitor visitor);
}
