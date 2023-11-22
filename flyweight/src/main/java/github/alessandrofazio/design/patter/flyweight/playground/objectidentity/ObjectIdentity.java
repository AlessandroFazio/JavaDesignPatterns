package github.alessandrofazio.design.patter.flyweight.playground.objectidentity;

import org.junit.Test;

import java.util.function.Consumer;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

public class ObjectIdentity {

    @Test
    public void testSameness() {
        String greeting = new String(
                new char[]{'h', 'e', 'l', 'l', 'o'}
        );
        /* assertTrue("hello" == new String("hello"));
        System.out.printf("System.identityHashCode(greeting) = %x%n",
                System.identityHashCode(greeting));
        greeting = greeting.intern();
        compare("hello", greeting);
        System.out.println("greeting = " + greeting);
        compare("hello", "hello");
        compare(new Holder1(), new Holder2());
        assertSame(new Holder1().name, new Holder2().name);
         */

        compare(sayHelloAction(), sayHelloAction());
    }

    private void compare(Object o1, Object o2) {
        System.out.printf("%x, %x%n", System.identityHashCode(o1),
                System.identityHashCode(o2));
        assertSame(o1,o2);
    }

    private String name;
    public Consumer<String> sayHelloAction() {
        return name -> System.out.println("Hello Wolrd " + name);
    }

}
