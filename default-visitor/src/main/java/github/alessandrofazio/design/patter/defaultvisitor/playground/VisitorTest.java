package github.alessandrofazio.design.patter.defaultvisitor.playground;

import github.alessandrofazio.design.patter.defaultvisitor.playground.composite.Number;
import github.alessandrofazio.design.patter.defaultvisitor.playground.visitor.EvalVisitor;
import github.alessandrofazio.design.patter.defaultvisitor.playground.visitor.PrintVisitor;
import github.alessandrofazio.design.patter.defaultvisitor.playground.composite.Expression;
import github.alessandrofazio.design.patter.defaultvisitor.playground.composite.Plus;

public class VisitorTest {
    public static void main(String[] args) {
        Expression expression = new Plus(new Number(10), new Number(10));
        EvalVisitor evalVisitor = new EvalVisitor();
        PrintVisitor printVisitor = new PrintVisitor();
        expression.accept(evalVisitor);
        expression.accept(printVisitor);
        System.out.println(printVisitor);
    }
}
