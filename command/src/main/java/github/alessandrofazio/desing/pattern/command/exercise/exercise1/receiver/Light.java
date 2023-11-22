package github.alessandrofazio.desing.pattern.command.exercise.exercise1.receiver;

public class Light implements Receiver {
    private boolean on = false;
    public void turnOn() {
        if(!on) {
            on =  true;
            System.out.println("Light is on");
        }
        else System.out.println("Light is already on");
    }

    public void turnOff() {
        if(on) {
            on = false;
            System.out.println("Light is off");
        }
        else System.out.println("Light is already off");
    }
}
