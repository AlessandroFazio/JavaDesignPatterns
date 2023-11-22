package github.alessandrofazio.design.patter.acyclicvisitor.visitor.visitor;

import github.alessandrofazio.design.patter.acyclicvisitor.visitor.DistributionList;

public interface DistributionListVisitor extends Visitor {
    void visit(DistributionList distributionList);
}
