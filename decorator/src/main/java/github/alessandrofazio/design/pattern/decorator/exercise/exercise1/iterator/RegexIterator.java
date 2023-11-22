package github.alessandrofazio.design.pattern.decorator.exercise.exercise1.iterator;

import java.util.Iterator;

public class RegexIterator<E> implements Iterator<E> {
    private final Iterator<E> it;
    private final String regex;
    private E nextElem;

    public RegexIterator(Iterator<E> it, String regex) {
        this.it = it;
        this.regex = regex;
    }

    private E findNextElement() {
        while (it.hasNext()) {
            E elem = it.next();
            if (elem.toString().matches(regex)) {
                nextElem = elem;
                return elem;
            }
        }
        return null;
    }

    @Override
    public boolean hasNext() {
        if(!it.hasNext()) return false;
        return findNextElement() != null;
    }

    @Override
    public E next() {
        if(nextElem != null) {
            E elem = nextElem;
            nextElem = null;
            return elem;
        }
        throw new IllegalStateException();
    }
}
