package github.alessandrofazio.design.patter.iterator.exercise.exercise1.mysolution;

import com.github.javafaker.Faker;
import github.alessandrofazio.design.patter.iterator.exercise.exercise1.processor.CompositeProcessor;
import github.alessandrofazio.design.patter.iterator.exercise.exercise1.processor.PrintProcessor;
import github.alessandrofazio.design.patter.iterator.exercise.exercise1.processor.Processor;

import java.util.Iterator;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class WalkingCollection<E> implements Iterable<E>, Cloneable {
    public static void main(String[] args) throws InterruptedException {
        int numOfElements = 15;
        Faker FAKER = new Faker();
        WalkingCollection<String> wc = new WalkingCollection<>();
        for(int i=0; i < numOfElements; i++) {
            wc.add(FAKER.name().firstName());
        }
        System.out.println("Walking collection elements: ");
        wc.forEach(System.out::println);
        System.out.println("End of Walking collection");
        System.out.println();
        Processor<String> pp = new PrintProcessor();
        CompositeProcessor<String> cp = new CompositeProcessor<>();
        cp.add(new Processor<>() {
            private String previous = "";
            @Override
            public boolean process(String s) {
                boolean result = s.length() > previous.length();
                previous = s;
                return result;
            }
        });
        cp.add(pp);

        // Thread firstIteratorThread = new Thread(() -> wc.iterate(pp));
        Thread secondIteratorThread = new Thread(() -> wc.iterate(cp));

        // firstIteratorThread.start();
        secondIteratorThread.start();

        // firstIteratorThread.join();
        secondIteratorThread.join();
    }

    private Object[] array;
    private int size;
    private int capacity;
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public WalkingCollection() {
        capacity = 10;
        array = new Object[capacity];
    }

    public WalkingCollection(int capacity) {
        this.capacity = capacity;
        array = new Object[capacity];
    }

    public WalkingCollection(Object[] array) {
        this.capacity = array.length;
        this.array = new Object[array.length];
        for(int i=0; i < array.length; i++) {
            this.array[i] = array[i];
            size++;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new WalkingIterator<>(this);
    }

    public void add(E e) {
        readWriteLock.writeLock().lock();
        try {
            if (size == capacity) {
                makeArrayLarger();
            }
            array[size] = e;
            size++;
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    public E get(int index) {
        readWriteLock.readLock().lock();
        try {
            if (index >= array.length) throw new IndexOutOfBoundsException();
            return (E) array[index];
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    public int size() {
        return size;
    }

    public void iterate(Processor<E> processor) {
        for (E e : this) {
            System.out.println("Processing element: " + e.toString());
            boolean result = processor.process(e);
            if(!result) {
                System.out.println("Ending processing, processor result is false");
                return;
            }
        }
    }

    private void makeArrayLarger() {
        capacity *= 2;
        Object[] newArray = new Object[capacity];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }

    public WalkingCollection<E> clone() {
        return new WalkingCollection<>(array);
    }

    private static final class WalkingIterator<E> implements Iterator<E> {
        private final WalkingCollection<E> context;
        private int cursor = 0;
        private int numOfElements;

        public WalkingIterator(WalkingCollection<E> context) {
            this.context = context.clone();
            this.numOfElements = context.size;
        }

        @Override
        public boolean hasNext() {
            return cursor != numOfElements;
        }

        @Override
        public E next() {
            return context.get(cursor++);
        }
    }
}
