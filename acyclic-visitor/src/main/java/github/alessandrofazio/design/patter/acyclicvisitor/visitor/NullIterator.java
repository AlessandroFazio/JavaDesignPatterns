package github.alessandrofazio.design.patter.acyclicvisitor.visitor;

import java.util.Iterator;
import java.util.function.Consumer;

public class NullIterator<T> implements Iterator<T> {
    private static final NullIterator<Object> instance = new NullIterator<>();

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

    @Override
    public void forEachRemaining(Consumer<? super T> action) {
        throw new IllegalStateException("null iterator");
    }
}
