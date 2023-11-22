package github.alessandrofazio.design.patter.strategy.exercise.exercise2.strategy;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public interface ComparatorStrategy<T> {
    Stream<T> getSortedStream(List<T> objects);
}
