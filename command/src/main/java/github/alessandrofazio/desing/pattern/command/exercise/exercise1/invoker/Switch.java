package github.alessandrofazio.desing.pattern.command.exercise.exercise1.invoker;

import github.alessandrofazio.desing.pattern.command.exercise.exercise1.command.Command;
import github.alessandrofazio.desing.pattern.command.exercise.exercise1.receiver.Receiver;

public final class Switch<T extends Receiver> implements Invoker<T> {
    private final Command<T> up, down;

    public Switch(Command<T> up, Command<T> down) {
        this.up = up;
        this.down = down;
    }

    public void flipUp() {
        up.execute();
    }

    public void flipDown() {
        down.execute();
    }

    public static <T extends Receiver> Switch<T> factory(Command<T> up, Command<T> down) {
        return new Switch<>(up, down);
    }
}
