package github.alessandrofazio.design.patter.acyclicvisitor;

import github.alessandrofazio.design.patter.acyclicvisitor.visitor.DistributionListVisitor;
import github.alessandrofazio.design.patter.acyclicvisitor.visitor.Visitor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DistributionList extends Contact {
    private final List<Contact> contacts = new ArrayList<>();
    @Override
    public void add(Contact contact) {
        contacts.add(contact);
    }

    @Override
    public void remove(Contact contact) {
        contacts.remove(contact);
    }

    @Override
    public void accept(Visitor visitor) {
        if(visitor instanceof DistributionListVisitor) {
            ((DistributionListVisitor) visitor).visit(this);
        }
        contacts.forEach(c -> c.accept(visitor));
    }

    @Override
    public void sendEmail(String message) {
        contacts.forEach(c -> c.sendEmail(message));
    }

    @Override
    public boolean isLeaf() {
        return false;
    }

    @Override
    public Iterator<Contact> children() {
        return contacts.iterator();
    }
}
