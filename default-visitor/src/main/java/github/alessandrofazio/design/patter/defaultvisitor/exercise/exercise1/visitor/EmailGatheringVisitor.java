package github.alessandrofazio.design.patter.defaultvisitor.exercise.exercise1.visitor;

import github.alessandrofazio.design.patter.defaultvisitor.exercise.exercise1.composite.Person;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

public class EmailGatheringVisitor
        implements DefaultVisitor, Iterable<String> {
    private final Set<String> emails = new ConcurrentSkipListSet<>();
    private final Collection<String> unmodifiableEmails = Collections.unmodifiableCollection(emails);

    @Override
    public void visitPerson(Person person) {
        emails.add(person.getEmail());
    }

    @Override
    public Iterator<String> iterator() {
        return unmodifiableEmails.iterator();
    }
}
