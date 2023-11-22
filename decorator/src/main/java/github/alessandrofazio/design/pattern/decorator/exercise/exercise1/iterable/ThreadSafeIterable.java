package github.alessandrofazio.design.pattern.decorator.exercise.exercise1.iterable;

import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.locks.Lock;
import java.util.stream.StreamSupport;

public class ThreadSafeIterable<E> implements Iterable<E> {
    private final Iterable<E> delegate;

    public ThreadSafeIterable(Iterable<E> delegate, Lock lock) {
        this.delegate = copy(delegate, lock);
    }

    public ThreadSafeIterable(Iterable<E> delegate, Object lock) {
        synchronized (lock) {
            this.delegate = copy(delegate);
        }
    }

    private Iterable<E> copy(Iterable<E> delegate) {
        return StreamSupport.stream(delegate.spliterator(), false).toList();
    }

    private Iterable<E> copy(Iterable<E> delegate, Lock lock) {
        lock.lock();
        try {
            return StreamSupport.stream(delegate.spliterator(), false).toList();
        } finally {
            lock.unlock();
        }
    }

    public Iterator<E> iterator() {
        Iterator<E> it = delegate.iterator();
        return new Iterator<E>() {
            @Override
            public boolean hasNext() {
                return it.hasNext();
            }

            @Override
            public E next() {
                return it.next();
            }
        };
    }
}
