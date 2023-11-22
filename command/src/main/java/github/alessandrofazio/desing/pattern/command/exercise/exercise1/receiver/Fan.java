package github.alessandrofazio.desing.pattern.command.exercise.exercise1.receiver;

public class Fan implements Receiver {
    private boolean rotating = false;
    public void startRotate() {
        if(!rotating) {
            rotating = true;
            System.out.println("Fan is rotating");
        }
        else System.out.println("Fan is already rotating");
    }

    public void stopRotate() {
        if(rotating) {
            rotating = false;
            System.out.println("Fan is not rotating");
        }
        else System.out.println("Fan is already not rotating");
    }
}
