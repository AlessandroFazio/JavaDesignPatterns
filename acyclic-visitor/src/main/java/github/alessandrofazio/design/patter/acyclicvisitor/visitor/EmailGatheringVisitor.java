package github.alessandrofazio.design.patter.acyclicvisitor.visitor;

import github.alessandrofazio.design.patter.acyclicvisitor.Person;

import java.util.*;
import java.util.concurrent.ConcurrentSkipListSet;

public class EmailGatheringVisitor
        implements Visitor, PersonVisitor, Iterable<String> {
    private final Set<String> emails = new ConcurrentSkipListSet<>();
    private final Collection<String> unmodifiableEmails = Collections.unmodifiableCollection(emails);

    @Override
    public void visit(Person person) {
        emails.add(person.getEmail());
    }


    @Override
    public Iterator<String> iterator() {
        return unmodifiableEmails.iterator();
    }
}
