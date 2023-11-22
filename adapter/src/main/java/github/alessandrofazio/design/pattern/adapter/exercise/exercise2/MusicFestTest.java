package github.alessandrofazio.design.pattern.adapter.exercise.exercise2;

import github.alessandrofazio.design.pattern.adapter.exercise.exercise2.singer.Bass;
import github.alessandrofazio.design.pattern.adapter.exercise.exercise2.singer.Performer;
import github.alessandrofazio.design.pattern.adapter.exercise.exercise2.singer.Rapper;
import github.alessandrofazio.design.pattern.adapter.exercise.exercise2.singer.Soprano;

import java.util.List;

public class MusicFestTest {
    public static void main(String[] args) {
        MusicFest musicFest = new MusicFest();
        Performer bass = new Bass();
        Performer soprano = new Soprano();
        musicFest.addAll(List.of(bass, soprano, new Rapper()::talk));
        musicFest.singAll();
        musicFest.singAll();
    }
}
