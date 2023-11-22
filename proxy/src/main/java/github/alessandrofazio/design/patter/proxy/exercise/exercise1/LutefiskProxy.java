package github.alessandrofazio.design.patter.proxy.exercise.exercise1;

public class LutefiskProxy implements Lutefisk {
    private Lutefisk realSubject;

    private Lutefisk realSubject() {
        if (realSubject == null) realSubject = new LutefiskImpl();
        return realSubject;
    }

    @Override
    public void eat() {
        realSubject().eat();
    }
}
