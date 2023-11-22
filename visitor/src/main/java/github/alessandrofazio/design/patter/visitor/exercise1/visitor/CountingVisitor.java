package github.alessandrofazio.design.patter.visitor.exercise1.visitor;

import github.alessandrofazio.design.patter.visitor.exercise1.Contact;
import github.alessandrofazio.design.patter.visitor.exercise1.DistributionList;
import github.alessandrofazio.design.patter.visitor.exercise1.Person;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CountingVisitor implements Visitor {
    private int numOfEmails = 0;
    private int numOfLeaves = 0;
    private int numOfComposite = 0;
    private final List<Integer> numChildrenPerComposite =
            new ArrayList<>();

    public int getNumOfComposite() {
        return numOfComposite;
    }

    public int getNumOfLeaves() {
        return numOfLeaves;
    }

    public void visit(Person contact) {
        countLeave(contact);
        numOfEmails++;
    }

    public void visit(DistributionList contact) {
        countComposite(contact);
        countChildren(contact);
    }

    private void countLeave(Contact contact) {
        numOfLeaves++;
    }

    private void countComposite(Contact contact) {
        numOfComposite++;
    }

    private void countChildren(Contact contact) {
        int numChildren = 0;
        Iterator<Contact> it = contact.children();
        while (it.hasNext()) {
            it.next();
            numChildren++;
        }
        numChildrenPerComposite.add(numChildren);
    }

    public int getNumOfEmails() {
        return numOfEmails;
    }

    public double getAverageChildrenPerComposite() {
        return numChildrenPerComposite.stream()
                .mapToDouble(Integer::doubleValue)
                .reduce(0.0, Double::sum) / numOfComposite;
    }

    public double getVarianceNumChildrenPerComposite() {
        double avgChildrenPerComposite = getAverageChildrenPerComposite();
        return numChildrenPerComposite.stream()
                .mapToDouble(Integer::doubleValue)
                .reduce(0.0, (agg, value) ->
                        agg + Math.pow(value - avgChildrenPerComposite, 2)
                ) / numOfComposite;
    }
}
