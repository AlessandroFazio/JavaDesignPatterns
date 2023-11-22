package github.alessandrofazio.design.patter.defaultvisitor.exercise.exercise1.composite;

import github.alessandrofazio.design.patter.defaultvisitor.exercise.exercise1.visitor.Visitor;

public abstract class AbstractCompositeContact extends Contact {
    public abstract void add(Contact contact);
    public abstract void remove(Contact contact);
    public abstract int getNumberOfChildren();
}
