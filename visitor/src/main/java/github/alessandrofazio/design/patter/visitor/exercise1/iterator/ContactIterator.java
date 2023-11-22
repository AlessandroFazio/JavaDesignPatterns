package github.alessandrofazio.design.patter.visitor.exercise1.iterator;

import github.alessandrofazio.design.patter.visitor.exercise1.Contact;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class ContactIterator implements Iterator<Contact> {
    private Contact nextContact;
    private final Deque<Iterator<Contact>> unfinishedIterator = new ArrayDeque<>();

    public ContactIterator(Contact contact) {
        if(contact.isLeaf()) nextContact = contact;
        else unfinishedIterator.addLast(contact.children());
    }

    @Override
    public boolean hasNext() {
        if(nextContact == null) nextContact = findNextContact();
        return nextContact != null;
    }

    @Override
    public Contact next() {
        if(!hasNext()) throw new IllegalStateException();
        Contact result = nextContact;
        nextContact = null;
        return result;
    }

    private Contact findNextContact() {
        if(unfinishedIterator.isEmpty()) return null;
        Iterator<Contact> it = unfinishedIterator.peekLast();

        if(it.hasNext()) {
            Contact contact = it.next();
            if(contact.isLeaf()) {
                nextContact = contact;
                return contact;
            }
            else {
                unfinishedIterator.addLast(contact.children());
            }
        }
        else {
            unfinishedIterator.removeLast();
        }
        return findNextContact();
    }
}
