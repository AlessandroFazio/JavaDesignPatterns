package github.alessandrofazio.design.patter.proxy.exercise.exercise1;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Scandinavia {
    public static void main(String[] args) {
        Scandinavia scandinavia = new Scandinavia(100);
        LocalDateTime dateTime = LocalDateTime.of(2023, 1, 1, 0, 0);

        while(true) {
            if(scandinavia.isChristmasTime(dateTime)) {
                scandinavia.christmasTime();
            } else {
                scandinavia.normalTime();
            }
            dateTime = dateTime.plus(1, ChronoUnit.DAYS);
        }
    }

    private final List<Scandinavian> citizens = new ArrayList<>();
    private final int numOfCitizens;
    private final Random random = new Random();

    public Scandinavia(int numOfCitizens) {
        this.numOfCitizens = numOfCitizens;
        createCitizens();
    }

    public void addCitizen(Scandinavian citizen) {
        citizens.add(citizen);
    }

    public boolean isChristmasTime(LocalDateTime localDateTime) {
        if(localDateTime.getMonthValue() == 12
                && localDateTime.getDayOfMonth() == 25) {
            return true;
        }
        return false;
    }

    public void christmasTime() {
        for(Scandinavian citizen: citizens) {
            citizen.celebrateChristmas();
        }
    }

    public void normalTime() {
        for(Scandinavian citizen: citizens) {
            citizen.learn();
            citizen.work();
        }
    }

    public void createCitizens() {
        for(int i=0; i < numOfCitizens; i++) {
            boolean isSweden = random.nextBoolean();
            if(isSweden) addCitizen(new Swede());
            else addCitizen(new Norwergian());
        }
    }
}


/* Logic:
You have Scandinavia which has citizens that could be either:
    - Norwegian
    - Sweden
You have 2 conditions:
    - isChristmas
    - isNotChristmas
 When it's Christmas:
    - all Norwegians eat Lutefisk
    - all Swedens eat and entertain with Lutefisk
 */