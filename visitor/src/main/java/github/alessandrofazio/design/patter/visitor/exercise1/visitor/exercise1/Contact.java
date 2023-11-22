package github.alessandrofazio.design.patter.visitor.exercise1.visitor.exercise1;

import github.alessandrofazio.design.patter.visitor.exercise1.visitor.exercise1.visitor.Visitor;

import java.util.Iterator;

public abstract class Contact {
    public void add(Contact contact) {}

    public void remove(Contact contact) {}

    public abstract void sendEmail(String msg);

    public abstract boolean isLeaf();

    public abstract void accept(Visitor visitor);

    public abstract Iterator<Contact> children();
}
