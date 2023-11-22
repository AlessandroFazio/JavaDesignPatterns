package github.alessandrofazio.design.patter.visitor.exercise1.visitor.exercise1;

import java.util.Iterator;

public class NullIterator<T> implements Iterator<T> {
    public static final NullIterator<Object> instance = new NullIterator<>();

    public static <T> NullIterator<T> getInstance() {
        return (NullIterator<T>) instance;
    }
    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public T next() {
        throw new IllegalStateException("null iterator");
    }

    @Override
    public void remove() {
        throw new IllegalStateException("null iterator");
    }
}
