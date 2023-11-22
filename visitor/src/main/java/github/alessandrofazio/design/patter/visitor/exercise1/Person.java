package github.alessandrofazio.design.patter.visitor.exercise1;

import github.alessandrofazio.design.patter.visitor.exercise1.visitor.Visitor;

import java.util.Iterator;

public class Person extends Contact {
    private final String email;

    public Person(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public void sendEmail(String msg) {
        System.out.println("Sending " + msg + " to " + email);
    }

    @Override
    public Iterator<Contact> children() {
        return NullIterator.getInstance();
    }

    public boolean isLeaf() {
        return true;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
