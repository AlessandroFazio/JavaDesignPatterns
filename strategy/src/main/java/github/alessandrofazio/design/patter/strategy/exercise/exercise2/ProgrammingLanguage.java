package github.alessandrofazio.design.patter.strategy.exercise.exercise2;

import java.util.Arrays;
import java.util.List;

public enum ProgrammingLanguage {
    PYTHON(0),
    JAVA(1),
    JAVASCRIPT(2),
    RUBY(3),
    GOLANG(4),
    C(5);
    private final int intValue;

    public int getIntValue() {
        return intValue;
    }

    ProgrammingLanguage(int intValue) {
        this.intValue = intValue;
    }

    public static ProgrammingLanguage getByValue(int value) {
        for (ProgrammingLanguage option : values()) {
            if (option.intValue == value) {
                return option;
            }
        }
        throw new IllegalArgumentException("No enum constant with value: " + value);
    }

    public static List<ProgrammingLanguage> getByValueList(List<Integer> values) {
        return Arrays.stream(ProgrammingLanguage.values())
                .filter(l -> values.contains(l.getIntValue()))
                .toList();
    }
}
