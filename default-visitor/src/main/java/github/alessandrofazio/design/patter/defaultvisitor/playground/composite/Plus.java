package github.alessandrofazio.design.patter.defaultvisitor.playground.composite;

import github.alessandrofazio.design.patter.defaultvisitor.playground.visitor.Visitor;

public final class Plus extends Expression {
    private final Expression first, second;

    public Plus(Expression first, Expression second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public void accept(Visitor visitor) {
        first.accept(visitor);
        second.accept(visitor);
        visitor.visitPlus(this);
    }
}
