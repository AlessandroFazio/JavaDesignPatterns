package github.alessandrofazio.design.patter.proxy.exercise.exercise1;

public class LutefiskImpl implements Lutefisk {
    public LutefiskImpl() {
        System.out.println("Lutefisk created ");
    }

    @Override
    public void eat() {
        System.out.println("Eating lutefisk...");
    }
}
