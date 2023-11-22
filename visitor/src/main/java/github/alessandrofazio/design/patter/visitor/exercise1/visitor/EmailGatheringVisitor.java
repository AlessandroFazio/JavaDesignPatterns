package github.alessandrofazio.design.patter.visitor.exercise1.visitor;

import github.alessandrofazio.design.patter.visitor.exercise1.DistributionList;
import github.alessandrofazio.design.patter.visitor.exercise1.Person;

import java.util.*;
import java.util.concurrent.ConcurrentSkipListSet;

public class EmailGatheringVisitor implements Visitor, Iterable<String> {
    private Set<String> emails = new ConcurrentSkipListSet<>();
    private final Collection<String> unmodifiableEmails =
            Collections.unmodifiableCollection(emails);

    public void visit(Person contact) {
        emails.add(contact.getEmail());
    }

    public void visit(DistributionList contact) {
    }

    @Override
    public Iterator<String> iterator() {
        return unmodifiableEmails.iterator();
    }
}
