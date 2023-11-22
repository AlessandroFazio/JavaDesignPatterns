package github.alessandrofazio.design.pattern.adapter.exercise.exercise2;

import github.alessandrofazio.design.pattern.adapter.exercise.exercise2.singer.Performer;

import java.util.ArrayList;
import java.util.List;

public class MusicFest {
    private List<Performer> singers = new ArrayList<>();

    public void add(Performer singer) {
        singers.add(singer);
    }

    public void addAll(List<Performer> singers) {
        this.singers.addAll(singers);
    }

    public void remove(Performer singer) {
        singers.remove(singer);
    }

    public void singAll() {
        singers.forEach(Performer::perform);
    }
}
