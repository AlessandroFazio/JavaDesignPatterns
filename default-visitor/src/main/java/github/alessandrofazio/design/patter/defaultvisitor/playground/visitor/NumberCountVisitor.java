package github.alessandrofazio.design.patter.defaultvisitor.playground.visitor;

import github.alessandrofazio.design.patter.defaultvisitor.playground.composite.Number;

import java.util.concurrent.atomic.LongAdder;

public class NumberCountVisitor implements DefaultVisitor {
    private final LongAdder count = new LongAdder();

    public void visitNumber(Number number) {
        count.increment();
    }

    public long getCount() {
        return count.longValue();
    }
}
