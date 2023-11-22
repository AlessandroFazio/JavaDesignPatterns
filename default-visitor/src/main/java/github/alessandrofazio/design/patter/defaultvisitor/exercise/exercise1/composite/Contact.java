package github.alessandrofazio.design.patter.defaultvisitor.exercise.exercise1.composite;

import github.alessandrofazio.design.patter.defaultvisitor.exercise.exercise1.visitor.Visitor;

import java.util.Iterator;

public abstract class Contact {

    public abstract void accept(Visitor visitor);

    public abstract void sendEmail(String message);
    public abstract boolean isLeaf();
    public abstract Iterator<Contact> children();
}
