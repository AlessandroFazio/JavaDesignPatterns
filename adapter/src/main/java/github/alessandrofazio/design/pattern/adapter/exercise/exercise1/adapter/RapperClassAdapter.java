package github.alessandrofazio.design.pattern.adapter.exercise.exercise1.adapter;

import github.alessandrofazio.design.pattern.adapter.exercise.exercise1.singer.Rapper;
import github.alessandrofazio.design.pattern.adapter.exercise.exercise1.singer.Performer;

public class RapperClassAdapter extends Rapper implements Performer {
    @Override
    public void perform() {
        talk();
    }
}
