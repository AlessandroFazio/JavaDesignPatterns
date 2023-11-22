package github.alessandrofazio.desing.pattern.composite.exercise1;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ContactIterator implements Iterator<github.alessandrofazio.desing.pattern.composite.exercise1.Contact> {
    private github.alessandrofazio.desing.pattern.composite.exercise1.Contact nextContact;
    private final Deque<Iterator<github.alessandrofazio.desing.pattern.composite.exercise1.Contact>> unfinishedIterator =
            new ArrayDeque<>();
    private Iterator<github.alessandrofazio.desing.pattern.composite.exercise1.Contact> lastIteratorUsed;

    public ContactIterator(github.alessandrofazio.desing.pattern.composite.exercise1.Contact contact) {
        if(contact.isLeaf()) {
            nextContact = contact;
        } else {
            unfinishedIterator.addLast(contact.children());
        }
    }

    @Override
    public boolean hasNext() {
        if(nextContact == null) {
            nextContact =  findNextContact();
        }
        return nextContact != null;
    }

    private github.alessandrofazio.desing.pattern.composite.exercise1.Contact findNextContact() {
        if(unfinishedIterator.isEmpty()) return null;
        Iterator<github.alessandrofazio.desing.pattern.composite.exercise1.Contact> it = unfinishedIterator.peekLast();

        if(it.hasNext()) {
            github.alessandrofazio.desing.pattern.composite.exercise1.Contact contact = it.next();
            if(contact.isLeaf()) {
                lastIteratorUsed = it;
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

    @Override
    public github.alessandrofazio.desing.pattern.composite.exercise1.Contact next() {
        if(!hasNext()) {
            throw new NoSuchElementException();
        }
        Contact result = nextContact;
        nextContact = null;
        return result;
    }

    public void remove() {
        if(lastIteratorUsed == null) {
            throw new IllegalStateException("No elements");
        }
        lastIteratorUsed.remove();
    }
}
