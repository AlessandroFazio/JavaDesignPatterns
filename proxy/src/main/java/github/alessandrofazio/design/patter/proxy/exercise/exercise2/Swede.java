package github.alessandrofazio.design.patter.proxy.exercise.exercise2;

import github.alessandrofazio.design.patter.proxy.playground.Proxies;

public class Swede implements Scandinavian {
    private final Lutefisk lutefisk = Proxies.virtual(
            Thread.currentThread().getContextClassLoader(),
            Lutefisk.class, LutefiskImpl::new);
    @Override
    public void celebrateChristmas() {
        lutefisk.eat();
    }

    @Override
    public void entertain() {
        lutefisk.eat();
    }

    @Override
    public void learn() {
        System.out.println("Swede is learning...");
    }

    @Override
    public void work() {
        System.out.println("Swede is working...");
    }
}
