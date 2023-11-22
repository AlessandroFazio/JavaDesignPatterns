package github.alessandrofazio.design.patter.acyclicvisitor;

import github.alessandrofazio.design.patter.acyclicvisitor.visitor.Visitor;

import java.util.Iterator;

public abstract class Contact {
    public void add(Contact contact) {}

    public void remove(Contact contact) {}

    public abstract void accept(Visitor visitor);

    public abstract void sendEmail(String message);
    public abstract boolean isLeaf();
    public abstract Iterator<Contact> children();
}
