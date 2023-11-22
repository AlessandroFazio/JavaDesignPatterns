package github.alessandrofazio.design.pattern.decorator.playground;

import java.util.Collections;

public class MyMutableCollections {
    public static <E> void addAll(MyMutableCollection<E> c, E... e) {
        for(E elem: e) c.add(elem);
    }

    public static <E> MyCollection<E> unmodifiableCollection(MyCollection<E> c) {
        return c;
    }
}
