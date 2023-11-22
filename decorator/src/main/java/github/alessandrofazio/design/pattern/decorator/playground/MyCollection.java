package github.alessandrofazio.design.pattern.decorator.playground;

import java.util.Collection;
import java.util.Collections;

public interface  MyCollection<E> {
    int size();

    boolean isEmpty();

    boolean contains(Object o);

    MyIterator<E> iterator();

    Object[] toArray();

    <T> T[] toArray(T... a);

    boolean containsAll(Collection<?> c);

    boolean equals(Object o);

    int hashCode();
}
