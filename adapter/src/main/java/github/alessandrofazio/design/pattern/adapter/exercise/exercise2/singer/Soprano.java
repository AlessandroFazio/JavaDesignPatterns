package github.alessandrofazio.design.pattern.adapter.exercise.exercise2.singer;

public class Soprano implements Performer {
    @Override
    public void perform() {
        System.out.println("Soprano is about to sing ...");
    }
}
