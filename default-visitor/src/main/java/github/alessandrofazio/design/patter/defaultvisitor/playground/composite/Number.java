package github.alessandrofazio.design.patter.defaultvisitor.playground.composite;

import github.alessandrofazio.design.patter.defaultvisitor.playground.visitor.Visitor;

public class Number extends Expression {
    private final int value;

    public int getValue() {
        return value;
    }

    public Number(int value) {
        this.value = value;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitNumber(this);
    }
}
