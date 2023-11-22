package github.alessandrofazio.design.patter.acyclicvisitor.visitor;

import github.alessandrofazio.design.patter.acyclicvisitor.visitor.visitor.PersonVisitor;
import github.alessandrofazio.design.patter.acyclicvisitor.visitor.visitor.Visitor;

import java.util.Iterator;

public class Person extends Contact {
    private final String email;

    public Person(String email) {
        this.email = email;
    }

    @Override
    public void add(Contact contact) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove(Contact contact) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void accept(Visitor visitor) {
        if(visitor instanceof PersonVisitor) {
            ((PersonVisitor) visitor).visit(this);
        }
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
