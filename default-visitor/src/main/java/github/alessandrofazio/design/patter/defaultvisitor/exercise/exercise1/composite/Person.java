package github.alessandrofazio.design.patter.defaultvisitor.exercise.exercise1.composite;

import github.alessandrofazio.design.patter.defaultvisitor.exercise.exercise1.visitor.Visitor;

import java.util.Iterator;

public class Person extends AbstractLeafContact {
    private final String email;

    public Person(String email) {
        this.email = email;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitPerson(this);
    }

    @Override
    public void sendEmail(String message) {
        System.out.println("Sending " + message + " to " + email);
    }

    @Override
    public boolean isLeaf() {
        return true;
    }

    @Override
    public Iterator<Contact> children() {
        return NullIterator.getInstance();
    }

    public String getEmail() {
        return email;
    }
}
