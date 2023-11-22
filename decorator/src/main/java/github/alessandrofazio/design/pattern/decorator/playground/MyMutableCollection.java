package github.alessandrofazio.design.pattern.decorator.playground;

import java.util.Collection;

public interface MyMutableCollection<E> extends MyCollection<E> {
    boolean add(E e);

    boolean remove(Object o);

    boolean addAll(Collection<? extends E> c);
    boolean removeAll(Collection<?> c);
    boolean retainAll(Collection<?> c);
    void clear();
    MyMutableIterator<E> iterator();
}
