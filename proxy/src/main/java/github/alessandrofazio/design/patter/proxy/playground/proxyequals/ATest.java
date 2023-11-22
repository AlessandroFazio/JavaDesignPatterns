package github.alessandrofazio.design.patter.proxy.playground.proxyequals;

import github.alessandrofazio.design.patter.proxy.playground.Proxies;

public class ATest {
    public static void main(String[] args) {
        C c1 = new C(new B(9));
        System.out.println("The client won't be able to distinguish: " + c1.equals(new B(9)));

        C c2 = new C(new C(new C(new C(new B(42)))));
        C c3 = new C(c2);
        B b1 = new B(42);
        B b2 = new B(42);
        System.out.println();
        System.out.println(
               "> b1 == b2: " + b1.equals(b2) + "\n" +
                "> b2 == b1: " + b2.equals(b1) + "\n" +
                 "> c2 == b1: " + c2.equals(b1) + "\n" +
                       "> b1 == c2 " + b1.equals(c2) + "\n");

        A dynProxy = Proxies.makeSimpleProxy(A.class, c2);
        System.out.println();
        System.out.println(
                "> dynProxy == b1: " + dynProxy.equals(b1) + "\n" +
                        "> dynProxy == b2: " + dynProxy.equals(b2) + "\n" +
                        "> dynProxy == c2: " + dynProxy.equals(c2) + "\n" +
                        "> dynProxy == c3: " + dynProxy.equals(c3) + "\n"
        );
    }
}
