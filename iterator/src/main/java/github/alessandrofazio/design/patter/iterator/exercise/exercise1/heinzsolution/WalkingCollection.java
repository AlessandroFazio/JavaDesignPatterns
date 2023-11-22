package github.alessandrofazio.design.patter.iterator.exercise.exercise1.heinzsolution;

import github.alessandrofazio.design.patter.iterator.exercise.exercise1.processor.Processor;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class WalkingCollection <E> extends AbstractCollection<E> {
    private final Collection<E> wrapperCollection;
    private final ReentrantReadWriteLock readWriteLock =
            new ReentrantReadWriteLock();

    public WalkingCollection(Collection<E> wrapperCollection) {
        this.wrapperCollection = wrapperCollection;
    }

    @Override
    public Iterator<E> iterator() {
        readWriteLock.readLock().lock();
        try {
            Iterator<E> it = wrapperCollection.iterator();
            return new Iterator<>() {
                @Override
                public boolean hasNext() {
                    readWriteLock.readLock().lock();
                    try {
                        return it.hasNext();
                    } finally {
                        readWriteLock.readLock().unlock();
                    }
                }

                @Override
                public E next() {
                    readWriteLock.readLock().lock();
                    try {
                        return it.next();
                    } finally {
                        readWriteLock.readLock().unlock();
                    }
                }

                @Override
                public void remove() {
                    readWriteLock.writeLock().lock();
                    try {
                        it.remove();
                    } finally {
                        readWriteLock.writeLock().unlock();
                    }
                }
            };
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    @Override
    public int size() {
        readWriteLock.readLock().lock();
        try {
            return wrapperCollection.size();
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    public synchronized void iterate(Processor<? super E> processor) {
        readWriteLock.readLock().lock();
        try {
            for (E e : wrapperCollection) {
                if (!processor.process(e)) return;
            }
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    public boolean add(E e) {
        checkReadLockStatus();
        readWriteLock.writeLock().lock();
        try {
            return wrapperCollection.add(e);
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    private void checkReadLockStatus() {
        if(readWriteLock.getReadLockCount() > 0) {
            throw new IllegalMonitorStateException(
                    "tried to upgrade read lock to write lock"
            );

        }
    }
}
