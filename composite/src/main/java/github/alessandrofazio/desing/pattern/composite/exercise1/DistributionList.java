package github.alessandrofazio.desing.pattern.composite.exercise1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DistributionList extends github.alessandrofazio.desing.pattern.composite.exercise1.Contact {
    private List<github.alessandrofazio.desing.pattern.composite.exercise1.Contact> contacts = new ArrayList<>();

    public DistributionList(List<github.alessandrofazio.desing.pattern.composite.exercise1.Contact> contacts) {
        this.contacts = contacts;
    }

    public DistributionList() {
    }

    @Override
    public void add(github.alessandrofazio.desing.pattern.composite.exercise1.Contact contact) {
        contacts.add(contact);
    }

    @Override
    public void remove(github.alessandrofazio.desing.pattern.composite.exercise1.Contact contact) {
        contacts.remove(contact);
    }

    @Override
    public boolean isLeaf() {
        return false;
    }

    @Override
    public Iterator<github.alessandrofazio.desing.pattern.composite.exercise1.Contact> children() {
        return contacts.iterator();
    }

    @Override
    public void sendEmail(String message) {
        for(Contact contact: contacts) {
            contact.sendEmail(message);
        }
    }
}
