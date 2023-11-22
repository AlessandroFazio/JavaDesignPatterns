package github.alessandrofazio.desing.pattern.command.exercise.exercise1.command;

import github.alessandrofazio.desing.pattern.command.exercise.exercise1.receiver.Receiver;

public interface Command<T extends Receiver> {
    void execute();
}
