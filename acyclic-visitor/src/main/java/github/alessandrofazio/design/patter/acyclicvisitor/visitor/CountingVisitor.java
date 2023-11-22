package github.alessandrofazio.design.patter.acyclicvisitor.visitor;

import github.alessandrofazio.design.patter.acyclicvisitor.Contact;
import github.alessandrofazio.design.patter.acyclicvisitor.DistributionList;
import github.alessandrofazio.design.patter.acyclicvisitor.Person;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CountingVisitor implements Visitor, PersonVisitor, DistributionListVisitor {
    private int numOfComposite;
    private int numOfLeaves;
    private int numOfEmails;
    private List<Integer> numOfChildrenPerComposite = new CopyOnWriteArrayList<>();
    private double avgNumOfChildrenPerComposite;
    private double varNumOfChildrenPerComposite;
    @Override
    public void visit(DistributionList distributionList) {
        numOfComposite++;
        numOfChildrenPerComposite.add(countChildren(distributionList));
    }

    public int getNumOfEmails() {
        return numOfEmails;
    }

    @Override
    public void visit(Person person) {
        numOfLeaves++;
        if(person.getEmail() != null) numOfEmails++;
    }

    private int countChildren(DistributionList distributionList) {
        int numOfChildren = 0;
        Iterator<Contact> it = distributionList.children();
        while(it.hasNext()) {
            it.next();
            numOfChildren++;
        }
        return numOfChildren;
    }

    public double getAvgChildrenPerComposite() {
        double avg = numOfChildrenPerComposite.stream()
                .mapToDouble(Integer::doubleValue)
                .reduce(0.0, Double::sum) / numOfComposite;
        avgNumOfChildrenPerComposite = avg;
        return avg;
    }

    public int getNumOfComposite() {
        return numOfComposite;
    }

    public int getNumOfLeaves() {
        return numOfLeaves;
    }

    public double getVarianceChildrenPerComposite() {
        double var = numOfChildrenPerComposite.stream()
                .mapToDouble(Integer::doubleValue)
                .reduce(0.0, (agg,value) ->
                        agg + Math.pow(value - getAvgChildrenPerComposite(), 2)) / numOfComposite;
        varNumOfChildrenPerComposite = var;
        return var;
    }
}
