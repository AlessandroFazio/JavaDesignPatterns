package github.alessandrofazio.design.patter.defaultvisitor.playground.visitor;

import github.alessandrofazio.design.patter.defaultvisitor.playground.composite.Number;
import github.alessandrofazio.design.patter.defaultvisitor.playground.composite.Expression;
import github.alessandrofazio.design.patter.defaultvisitor.playground.composite.Plus;

public class PrintVisitor implements DefaultVisitor {
    protected final StringBuilder sb = new StringBuilder();

    public void visitNumber(Number number) {
        sb.append(number.getValue()).append(' ');
    }

    public void visitPlus(Plus plus) {
        sb.append("+ ");
    }

    public void visitExpression(Expression expression) {
        sb.append("? ");
    }

    public String toString() {
        return sb.toString().trim();
    }
}
