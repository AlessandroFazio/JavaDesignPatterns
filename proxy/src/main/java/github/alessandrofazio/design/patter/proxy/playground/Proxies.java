package github.alessandrofazio.design.patter.proxy.playground;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.function.Supplier;

public class Proxies {
    public static <T> T virtual(
            ClassLoader loader, Class<T> subjectClass, Supplier<T> supplier) {
        return subjectClass.cast(Proxy.newProxyInstance(
                loader, new Class[]{subjectClass}, new VirtualProxy<>(supplier)));
    }

    public static <T> T makeSimpleProxy(Class<T> subjectClass, T realSubject) {
        return makeSimpleProxy(
                Thread.currentThread().getContextClassLoader(),
                subjectClass, realSubject);
    }

    private static <T> T makeSimpleProxy(ClassLoader loader, Class<T> subjectClass, T realSubject) {
        return subjectClass.cast(Proxy.newProxyInstance(loader, new Class[]{subjectClass},
                (proxy, method, args) -> method.invoke(realSubject, args)));
    }

    public static class VirtualProxy<T> implements InvocationHandler {
        private final Supplier<? extends T> supplier;
        private T realSubject;

        public VirtualProxy(Supplier<? extends T> supplier) {
            this.supplier = supplier;
        }

        private T realSubject() {
            synchronized (this) {
                if (realSubject == null)
                    realSubject = supplier.get();
            }
            return realSubject;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            return method.invoke(realSubject(), args);
        }
    }
}
