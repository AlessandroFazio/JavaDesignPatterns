package github.alessandrofazio.design.patter.proxy.exercise.exercise1;

public class Norwergian implements Scandinavian {
    private final Lutefisk lutefisk = new LutefiskProxy();
    @Override
    public void celebrateChristmas() {
        lutefisk.eat();
    }

    @Override
    public void entertain() {
        System.out.println("Norwegian is entertaining...");
    }

    @Override
    public void learn() {
        System.out.println("Norwegian is learning...");
    }

    @Override
    public void work() {
        System.out.println("Norwegian is working...");
    }
}
