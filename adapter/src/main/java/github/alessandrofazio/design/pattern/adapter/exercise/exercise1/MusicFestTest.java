package github.alessandrofazio.design.pattern.adapter.exercise.exercise1;

import github.alessandrofazio.design.pattern.adapter.exercise.exercise1.adapter.RapperClassAdapter;
import github.alessandrofazio.design.pattern.adapter.exercise.exercise1.singer.Bass;
import github.alessandrofazio.design.pattern.adapter.exercise.exercise1.singer.Rapper;
import github.alessandrofazio.design.pattern.adapter.exercise.exercise1.singer.Performer;
import github.alessandrofazio.design.pattern.adapter.exercise.exercise1.singer.Soprano;

import java.util.List;

public class MusicFestTest {
    public static void main(String[] args) {
        MusicFest musicFest = new MusicFest();
        Performer bass = new Bass();
        Performer soprano = new Soprano();
        RapperClassAdapter rapper = new RapperClassAdapter();
        musicFest.addAll(List.of(bass, soprano, rapper));
        musicFest.singAll();
    }
}
