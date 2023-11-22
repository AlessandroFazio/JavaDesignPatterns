package github.alessandrofazio.design.patter.memento.exercise.exercise1;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.concurrent.ThreadLocalRandom;

public class LabRat {
    private double cd4ratio = 0.5;
    private boolean alive = true;

    public boolean isAlive() {
        return alive;
    }

    public void blastWithRadar() {
        if(!alive) throw new IllegalStateException("Lab rat is not alive");
        cd4ratio /= ThreadLocalRandom.current().nextDouble();
        cd4ratio -= Math.floor(cd4ratio);
        cd4ratio -= Math.floor(cd4ratio);
        checkPulse();
    }

    public void feedDrugs() {
        if(!alive) throw new IllegalStateException("Lab rat is not alive");
        cd4ratio *= ThreadLocalRandom.current().nextDouble();
        cd4ratio -= Math.floor(cd4ratio);
        checkPulse();
    }

    public void checkPulse() {
        if(cd4ratio < 0.1) alive = false;
        System.out.printf("Lab rat ha%s cd4ratio of %.2f%n",
                (alive ? "s":"d"), cd4ratio);
    }

    public Memento createMemento() {
        return new LabRatMemento(this);
    }

    public void setMemento(Memento memento) {
        LabRatMemento labRatMemento = (LabRatMemento) memento;
        if(this != labRatMemento.labRatRef.get())
            throw new IllegalArgumentException();
        this.cd4ratio = labRatMemento.cd4ratio;
        this.alive = labRatMemento.alive;
    }

    public static class LabRatMemento implements Memento {
        private final double cd4ratio;
        private final boolean alive;
        private final Reference<LabRat> labRatRef;

        public LabRatMemento(LabRat rat) {
            this.cd4ratio = rat.cd4ratio;
            this.alive = rat.alive;
            this.labRatRef = new WeakReference<>(rat);
        }
    }
}
