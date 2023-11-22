package github.alessandrofazio.design.patter.proxy.playground.proxyequals;

import java.util.Objects;

// class C (proxy object) implementing class A (subject) with pointer back to A
public class C implements A {
    private final A a;

    public C(A a) {
        Objects.requireNonNull(a);
        this.a = a;
    }

    // in order to make the client to think he's using
    // the realSubject we must make sure that if he tries
    // to compare the 2 object he's using (our proxy)
    // to an instance of the realSubject, the equals method should return true
    // if the proxy is wrapping effectively an object which is equal to that
    // provided by the client
    // To do this, we make sure that both:
    //  - hashCode() on the proxy returns the hashCode() on the realSubject
    //  - equals() on the proxy returns the realSubject.equals()
    // If we set the type of the realSubject we hold in the proxy
    // as the Subject (interface the realSubject impl. and the proxy), we can chain
    // together proxies onto other proxies.
    // This holds perfectly when the client tries to compare the (last) proxy it is using
    // to an instance of the realSubject, because the code equals() and hashCode() and the last proxy
    // will call recursively the equals() and the previous proxy, until the realSubject equals() and
    // hashCode() methods are called and the client will get a true as return value.
    @Override
    public int hashCode() {
        return a.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return a.equals(obj);
    }
}
