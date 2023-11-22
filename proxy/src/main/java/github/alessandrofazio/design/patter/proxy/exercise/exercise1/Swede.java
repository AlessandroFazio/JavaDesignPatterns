package github.alessandrofazio.design.patter.proxy.exercise.exercise1;

public class Swede implements Scandinavian {
    private final Lutefisk lutefisk = new LutefiskProxy();
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
