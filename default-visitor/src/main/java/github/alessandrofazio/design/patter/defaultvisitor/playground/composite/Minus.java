package github.alessandrofazio.design.patter.defaultvisitor.playground.composite;

import github.alessandrofazio.design.patter.defaultvisitor.playground.visitor.Visitor;

public class Minus extends Expression {
    private final StringBuilder sb = new StringBuilder();
    private final Number first;
    private final Number second;

    public Minus(Number first, Number second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitNumber(first);
        visitor.visitNumber(second);
        visitor.visitMinus(this);
    }

    public String toString() {
        return sb.toString().trim();
    }
}
