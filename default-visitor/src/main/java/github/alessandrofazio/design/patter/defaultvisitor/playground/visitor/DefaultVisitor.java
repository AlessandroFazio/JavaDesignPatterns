package github.alessandrofazio.design.patter.defaultvisitor.playground.visitor;

import github.alessandrofazio.design.patter.defaultvisitor.playground.composite.Number;
import github.alessandrofazio.design.patter.defaultvisitor.playground.composite.Expression;
import github.alessandrofazio.design.patter.defaultvisitor.playground.composite.Minus;
import github.alessandrofazio.design.patter.defaultvisitor.playground.composite.Plus;

public interface DefaultVisitor extends Visitor {

    default void visitExpression(Expression expression) {
        // do nothing
    }
    default void visitNumber(Number number) {
        visitExpression(number);
    };

    default void visitPlus(Plus plus) {
        visitExpression(plus);
    };

    default void visitMinus(Minus minus) {
        visitExpression(minus);
    }
}
