package github.alessandrofazio.design.patter.iterator.exercise.exercise1.processor;

public class PrintProcessor implements Processor<String> {
    @Override
    public boolean process(String o) {
        System.out.println(">>> " + o);
        return true;
    }
}
