package github.alessandrofazio.desing.pattern.composite.exercise1;

import java.util.Iterator;

public abstract class Contact {
    public void add(Contact contact) {
    }

    public void remove(Contact contact) {
    }

    public boolean isLeaf() {
        return true;
    }

    public Iterator<Contact> children() {
        return NullIterator.getInstance();
    }

    public abstract void sendEmail(String message);

    public void accept(Visitor<Contact> visitor) {
        System.out.println("accepting the visitor");
    }
}
