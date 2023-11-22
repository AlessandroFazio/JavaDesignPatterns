package github.alessandrofazio.design.patter.strategy.exercise.exercise2;

import java.util.List;

public class Programmer {
    private final String name;
    private final int salary;

    @Override
    public String toString() {
        return "Programmer{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", knowsLanguages=" + knowsLanguages +
                '}';
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    public List<ProgrammingLanguage> getKnowsLanguages() {
        return knowsLanguages;
    }

    private final List<ProgrammingLanguage> knowsLanguages;

    private Programmer(Builder builder) {
        name = builder.name;
        salary = builder.salary;
        knowsLanguages = builder.knowsLanguages;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private String name;
        private int salary;
        private List<ProgrammingLanguage> knowsLanguages;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder salary(int salary) {
            this.salary = salary;
            return this;
        }

        public Builder knownLanguages(List<ProgrammingLanguage> languages) {
            this.knowsLanguages = languages;
            return this;
        }

        public Programmer build() {
            return new Programmer(this);
        }
    }
}
