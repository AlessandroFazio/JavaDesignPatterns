package github.alessandrofazio.design.pattern.decorator.playground;

public class MyCollectionTest {
    public static void main(String[] args) {
        MyMutableCollection<String> c = new MyArrayList<>();
        MyMutableCollections.addAll(c, "dimitry", "sasha", "davide");
        MyCollection<String> c2 = MyMutableCollections.unmodifiableCollection(c);
        MyIterator<String> it = c2.iterator();
        it.next();
        ((MyMutableIterator)  it).remove();
        System.out.println(c2);
    }
}
