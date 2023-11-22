package github.alessandrofazio.design.pattern.decorator.playground;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class MyArrayList<E> implements MyMutableCollection<E> {
    private final Collection<E> delegate = new ArrayList<>();
    @Override
    public int size() {
        return delegate.size();
    }

    @Override
    public boolean isEmpty() {
        return delegate.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return delegate.contains(o);
    }

    @Override
    public Object[] toArray() {
        return delegate.toArray();
    }

    @Override
    public <T> T[] toArray(T... a) {
        return null;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return delegate.containsAll(c);
    }

    @Override
    public boolean add(E e) {
        return delegate.add(e);
    }

    @Override
    public boolean remove(Object o) {
        return delegate.remove(o);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return delegate.addAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return delegate.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return delegate.retainAll(c);
    }

    @Override
    public void clear() {

    }

    @Override
    public MyMutableIterator<E> iterator() {
        return new MyMutableIterator<>() {
            private final Iterator<E> delegateIt = delegate.iterator();
            @Override
            public void remove() {
                delegateIt.remove();
            }

            @Override
            public boolean hasNext() {
                return delegateIt.hasNext();
            }

            @Override
            public E next() {
                return delegateIt.next();
            }
        };
    }

    @Override
    public String toString() {
        return delegate.toString();
    }
}
