package github.alessandrofazio.desing.pattern.composite.exercise1;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class NullIterator<T> implements Iterator<T> {
    private static final NullIterator<Object> instance = new NullIterator<>();

    @SuppressWarnings("unchecked")
    public static <T> NullIterator<T> getInstance() {
        return (NullIterator<T>) instance;
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public T next() {
        throw new NoSuchElementException("null iterator has no next");
    }

    public void remove() {
        throw new IllegalStateException("cannot remove on null iterator");
    }
}
