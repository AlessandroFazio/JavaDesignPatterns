package github.alessandrofazio.design.patter.strategy.exercise.exercise2.strategy;

import github.alessandrofazio.design.patter.strategy.exercise.exercise2.Programmer;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class RichestSmartestNameComparatorStrategy implements ComparatorStrategy<Programmer> {

    @Override
    public Stream<Programmer> getSortedStream(List<Programmer> programmers) {
        return programmers.stream().sorted(getComparator());
    }

    private Comparator<Programmer> getComparator() {
        return Comparator
                .comparingDouble(Programmer::getSalary)
                .thenComparingInt(value -> value.getKnowsLanguages().size())
                .reversed()
                .thenComparing(Programmer::getName);
    }
}
