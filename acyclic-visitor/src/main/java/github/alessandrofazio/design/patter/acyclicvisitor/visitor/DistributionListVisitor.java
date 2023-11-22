package github.alessandrofazio.design.patter.acyclicvisitor.visitor;

import github.alessandrofazio.design.patter.acyclicvisitor.DistributionList;

public interface DistributionListVisitor extends Visitor {
    void visit(DistributionList distributionList);
}
