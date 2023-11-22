package github.alessandrofazio.design.pattern.decorator.exercise.exercise1;

import github.alessandrofazio.design.pattern.decorator.exercise.exercise1.iterable.MorphIterable;
import github.alessandrofazio.design.pattern.decorator.exercise.exercise1.iterable.RegexIterable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class DecoratorTest {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("carlo", "mario", "gianmaria");
        MorphIterable<String, Integer> morphIterable =
                new MorphIterable<>(names, String::length);

        for (Integer length: morphIterable) {
            System.out.println("lenght of name is: " + length);
        }


    }
}
