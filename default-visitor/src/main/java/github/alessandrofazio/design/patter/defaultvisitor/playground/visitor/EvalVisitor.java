package github.alessandrofazio.design.patter.defaultvisitor.playground.visitor;

import github.alessandrofazio.design.patter.defaultvisitor.playground.composite.Number;
import github.alessandrofazio.design.patter.defaultvisitor.playground.composite.Minus;
import github.alessandrofazio.design.patter.defaultvisitor.playground.composite.Plus;

import java.util.ArrayDeque;
import java.util.Deque;

public class EvalVisitor implements Visitor {
    @Override
    public void visitMinus(Minus minus) {
        checkForBasicOperation();
        stack.push(-stack.pop() + stack.pop());
    }

    private final Deque<Integer> stack = new ArrayDeque<>();

    protected int pop() {
        return stack.pop();
    }

    @Override
    public void visitNumber(Number number) {
        stack.push(number.getValue());
    }

    @Override
    public void visitPlus(Plus plus) {
        checkForBasicOperation();
        stack.push(stack.pop() + stack.pop());
    }

    private void checkForBasicOperation() {
        if(stack.size() < 2) throw new IllegalStateException(
                "Stack contains less than 2 values");
    }

    protected void push(int value) {
        stack.push(value);
    }
}