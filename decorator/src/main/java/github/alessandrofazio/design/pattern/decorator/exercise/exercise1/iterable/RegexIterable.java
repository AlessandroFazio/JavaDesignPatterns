package github.alessandrofazio.design.pattern.decorator.exercise.exercise1.iterable;

import github.alessandrofazio.design.pattern.decorator.exercise.exercise1.iterator.RegexIterator;

import java.util.Iterator;

public class RegexIterable<E> implements Iterable<E>{
    private final String regex;
    private final Iterable<E> delegate;

    public RegexIterable(Iterable<E> delegate, String regex) {
        this.delegate = delegate;
        this.regex = regex;
    }

    @Override
    public Iterator<E> iterator() {
       return new RegexIterator<>(delegate.iterator(), regex);
    }
}
