package github.alessandrofazio.design.patter.defaultvisitor.exercise.exercise1.visitor;

import github.alessandrofazio.design.patter.defaultvisitor.exercise.exercise1.composite.*;

public interface DefaultVisitor extends Visitor {

    default void visitContact(Contact contact) {
        // do nothing
    }

    default void visitAbstractCompositeContact(AbstractCompositeContact abstractCompositeContact) {
        visitContact(abstractCompositeContact);
    }

    default void visitAbstractLeafContact(AbstractLeafContact abstractLeafContact) {
        visitContact(abstractLeafContact);
    }

    @Override
    default void visitDistributionList(DistributionList distributionList) {
        visitAbstractCompositeContact(distributionList);
    }

    @Override
    default void visitPerson(Person person) {
        visitAbstractLeafContact(person);
    }
}
