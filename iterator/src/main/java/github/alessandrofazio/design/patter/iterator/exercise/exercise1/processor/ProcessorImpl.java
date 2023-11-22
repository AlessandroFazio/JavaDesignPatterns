package github.alessandrofazio.design.patter.iterator.exercise.exercise1.processor;

import java.util.Objects;

public class ProcessorImpl<E> implements Processor<E> {

    @Override
    public boolean process(E e) {
        return Objects.nonNull(e);
    }
}
