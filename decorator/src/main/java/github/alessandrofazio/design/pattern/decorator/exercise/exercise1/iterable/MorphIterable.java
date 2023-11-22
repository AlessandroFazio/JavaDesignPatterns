package github.alessandrofazio.design.pattern.decorator.exercise.exercise1.iterable;

import java.util.Iterator;
import java.util.function.Function;

public class MorphIterable<E,R> implements Iterable<R> {

    private final Iterable<E> delegate;
    private final Morpher<E,R> morpher;

    public MorphIterable(Iterable<E> delegate, Morpher<E,R> morpher) {
        this.delegate = delegate;
        this.morpher = morpher;
    }

    @Override
    public Iterator<R> iterator() {
        Iterator<E> inputIt = delegate.iterator();
        return new Iterator<>() {
            @Override
            public boolean hasNext() {
                return inputIt.hasNext();
            }

            @Override
            public R next() {
                return morpher.morph(inputIt.next());
            }

            @Override
            public void remove() {
                inputIt.remove();
            }
        };
    }

    public interface Morpher<E,R> {
        R morph(E e);
    }
}
