package github.alessandrofazio.design.patter.defaultvisitor.exercise.exercise1.visitor;

import github.alessandrofazio.design.patter.defaultvisitor.exercise.exercise1.composite.*;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CountingVisitor
        implements DefaultVisitor {
    private int numOfComposite;
    private int numOfLeaves;
    private int numOfEmails;
    private List<Integer> numOfChildrenPerComposite = new CopyOnWriteArrayList<>();
    private double avgNumOfChildrenPerComposite;
    private double varNumOfChildrenPerComposite;

    @Override
    public void visitAbstractCompositeContact(AbstractCompositeContact distributionList) {
        numOfComposite++;
        numOfChildrenPerComposite.add(distributionList.getNumberOfChildren());
    }

    @Override
    public void visitAbstractLeafContact(AbstractLeafContact person) {
        numOfLeaves++;
        numOfEmails++;
    }

    public int getNumOfEmails() {
        return numOfEmails;
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
