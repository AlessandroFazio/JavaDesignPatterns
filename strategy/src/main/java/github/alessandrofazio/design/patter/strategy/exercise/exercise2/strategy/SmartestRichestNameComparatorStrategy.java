package github.alessandrofazio.design.patter.strategy.exercise.exercise2.strategy;

import github.alessandrofazio.design.patter.strategy.exercise.exercise2.Programmer;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class SmartestRichestNameComparatorStrategy implements ComparatorStrategy<Programmer> {
    @Override
    public Stream<Programmer> getSortedStream(List<Programmer> programmers) {
        return programmers.stream().sorted(getComparator());
    }

    private Comparator<Programmer> getComparator() {
        return Comparator
                .comparingInt((Programmer value) -> value.getKnowsLanguages().size())
                .thenComparingDouble(Programmer::getSalary)
                .reversed()
                .thenComparing(Programmer::getName);
    }
}
