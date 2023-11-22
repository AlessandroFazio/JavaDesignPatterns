package github.alessandrofazio.desing.pattern.composite.exercise1;

public class Person extends Contact {
    private final String email;

    public Person(String email) {
        this.email = email;
    }

    @Override
    public void sendEmail(String message) {
        System.out.println("To: " + email + " with message: " + message);
    }

    @Override
    public String toString() {
        return "Person{" +
                "email='" + email + '\'' +
                '}';
    }
}
