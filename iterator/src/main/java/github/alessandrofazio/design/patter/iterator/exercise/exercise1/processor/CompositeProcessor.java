package github.alessandrofazio.design.patter.iterator.exercise.exercise1.processor;

import java.util.ArrayList;
import java.util.List;

public class CompositeProcessor<E> implements Processor<E> {

    private final List<Processor<? super E>> processors =
            new ArrayList<>();

    public void add(Processor<? super E> processor) {
        processors.add(processor);
    }

    @Override
    public boolean process(E e) {
        for(Processor<? super E> processor: processors) {
            if(!processor.process(e)) return false;
        }
        return true;
    }
}
