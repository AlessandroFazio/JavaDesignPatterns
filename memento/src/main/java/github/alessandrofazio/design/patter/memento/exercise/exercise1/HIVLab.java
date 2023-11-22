package github.alessandrofazio.design.patter.memento.exercise.exercise1;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.function.Consumer;

public class HIVLab {
    private Map<LabRat, Deque<Memento>> history = new ConcurrentHashMap<>();
    public static void main(String[] args) {
        LabRat mickey = new LabRat();
        HIVLab lab = new HIVLab();
        while(true) {
            lab.experiment(LabRat::feedDrugs, mickey);
            lab.experiment(LabRat::blastWithRadar, mickey);
        }
    }

    public void snapshot(LabRat rat) {
        Memento snapshot = rat.createMemento();
        history.computeIfAbsent(rat, k -> new ConcurrentLinkedDeque<>())
                .addLast(snapshot);
    }

    public void undo(LabRat rat) {
        Memento memento = history.getOrDefault(rat, new ArrayDeque<>()).pollLast();
        if(memento != null) rat.setMemento(memento);
    }

    public void experiment(Consumer<LabRat> experiment, LabRat rat) {
        snapshot(rat);
        experiment.accept(rat);
        if(!rat.isAlive()) undo(rat);
    }
}
