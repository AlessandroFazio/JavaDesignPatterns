package github.alessandrofazio.design.patter.defaultvisitor.playground.visitor;

import github.alessandrofazio.design.patter.defaultvisitor.playground.composite.Number;
import github.alessandrofazio.design.patter.defaultvisitor.playground.composite.Minus;
import github.alessandrofazio.design.patter.defaultvisitor.playground.composite.Plus;

public interface Visitor {
    void visitPlus(Plus plus);
    void visitNumber(Number number);
    void visitMinus(Minus minus);
}
