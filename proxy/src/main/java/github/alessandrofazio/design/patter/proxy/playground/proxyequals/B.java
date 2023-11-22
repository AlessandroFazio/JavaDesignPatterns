package github.alessandrofazio.design.patter.proxy.playground.proxyequals;

import java.util.Objects;

// class B (realSubject) implementing A (subject) with same additional state
public class B implements A {
    private final int i;

    public B(int i) {
        this.i = i;
    }


    // On the realSubject if we were to keep the predefined
    // equals method, then the equality would work only in one way
    // i.e. when the proxy is compared to the instance of realSubject
    // However we need this modification to make sure that making
    // the equality the other way around, i.e. when comparing the instance
    // to the proxy, will work the same.
    // The trick is to say, if class do not equals o.getClass()
    // which is the case when o is the proxy, flip the equality
    // and return o.equals(this);
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof B) {
            B b = (B) o;
            return i == b.i;
        }
        return o.equals(this);
    }

    @Override
    public int hashCode() {
        return Objects.hash(i);
    }
}
