package github.alessandrofazio.design.patter.nullobject.exercise.exercise1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TextAnalyzer {
    private final Map<Character, Long> map;
    private static final char[] characterArray =
            "aeiouAEIOUbcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ".toCharArray();

    public TextAnalyzer(String filename) throws IOException {
        Path path = Paths.get(filename);
        String contents = Files.readString(path);
        map = contents.chars()
                .filter(Character::isLetter)
                .mapToObj(i -> (char) i)
                .collect(Collectors.groupingBy(Function.identity(),
                        Collectors.counting()));

        System.out.println(map.getClass());
    }

    public Map.Entry<Character, Long> getEntry(int n) {
        Objects.checkIndex(n, characterArray.length);
        return Map.entry(characterArray[n],
                    map.getOrDefault(characterArray[n], 0L));
    }

    public static void main(String[] args) throws IOException {
        String filename = "/home/alessandrofazio/Projects/JavaDesignPatternCourse/null-object/src/main/resources/test-file.txt";
        TextAnalyzer textAnalyzer = new TextAnalyzer(filename);
    }
}
