package github.alessandrofazio.design.patter.strategy.exercise.exercise2;

import com.github.javafaker.Faker;
import github.alessandrofazio.design.patter.strategy.exercise.exercise2.strategy.ComparatorStrategy;
import github.alessandrofazio.design.patter.strategy.exercise.exercise2.strategy.RichestSmartestNameComparatorStrategy;
import github.alessandrofazio.design.patter.strategy.exercise.exercise2.strategy.SmartestRichestNameComparatorStrategy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class ConsultingHouse {
    public static void main(String[] args) {
        ConsultingHouse consultingHouse = new ConsultingHouse(20);
        consultingHouse.getSortedBySmartestThenRichest().forEach(System.out::println);
    }
    private static final Faker FAKER = new Faker();
    private static final Random RANDOM = new Random();
    private static final int MIN_SALARY = 1000;
    private static final int MAX_SALARY = 10000;
    private static final int MAX_NUM_LANGUAGES = ProgrammingLanguage.values().length;
    private static final ComparatorStrategy<Programmer> richestThenSmartestStrategy =
        new RichestSmartestNameComparatorStrategy();

    private static final ComparatorStrategy<Programmer> smartestThenRichestStrategy =
            new SmartestRichestNameComparatorStrategy();
    private final List<Programmer> programmers;

    public List<Programmer> getProgrammers() {
        return programmers;
    }

    public ConsultingHouse(int numProgrammers) {
        this.programmers = createProgrammers(numProgrammers);
    }

    public List<Programmer> createProgrammers(int numProgrammers) {
        List<Programmer> programmers = new ArrayList<>();
        for(int i=0; i < numProgrammers; i++) {
            int numLanguages = RANDOM.nextInt(1, MAX_NUM_LANGUAGES+1);
            List<Integer> indexes = getRandomIndexes(numLanguages);
            programmers.add(Programmer.builder()
                            .name(FAKER.name().firstName())
                            .salary(RANDOM.nextInt(MIN_SALARY, MAX_SALARY))
                            .knownLanguages(ProgrammingLanguage.getByValueList(indexes))
                    .build());
        }
        return programmers;
    }

    private List<Integer> getRandomIndexes(int numLanguages) {
        List<Integer> indexes = new ArrayList<>();

        for(int j = 0; j < numLanguages; j++) {
            indexes.add(RANDOM.nextInt(0,MAX_NUM_LANGUAGES));
        }
        return indexes;
    }

    public Stream<Programmer> getSortedByRichestTheSmartest() {
        return richestThenSmartestStrategy.getSortedStream(programmers);
    }

    public Stream<Programmer> getSortedBySmartestThenRichest() {
        return smartestThenRichestStrategy.getSortedStream(programmers);
    }

    public Stream<Programmer> getSortedByName() {
        return programmers.stream().sorted(Comparator.comparing(Programmer::getName));
    }
}
