package github.alessandrofazio.design.patter.visitor.exercise1;

import github.alessandrofazio.design.patter.visitor.exercise1.iterator.ContactIterator;
import github.alessandrofazio.design.patter.visitor.exercise1.visitor.Visitor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DistributionList extends Contact {
    private final List<Contact> contacts = new ArrayList<>();
    @Override
    public void sendEmail(String msg) {
        contacts.forEach(contact -> contact.sendEmail(msg));
    }

    @Override
    public void add(Contact contact) {
        contacts.add(contact);
    }

    @Override
    public void remove(Contact contact) {
        contacts.remove(contact);
    }

    public Iterator<Contact> children() {
        return contacts.iterator();
    }

    public boolean isLeaf() {
        return false;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
        Iterator<Contact> it = children();
        while (it.hasNext()) {
            it.next().accept(visitor);
        }
    }

    public ContactIterator iterator() {
        return new ContactIterator(this);
    }
}
