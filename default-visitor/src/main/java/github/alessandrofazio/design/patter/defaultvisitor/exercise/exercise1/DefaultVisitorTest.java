package github.alessandrofazio.design.patter.defaultvisitor.exercise.exercise1;

import com.github.javafaker.Faker;
import github.alessandrofazio.design.patter.defaultvisitor.exercise.exercise1.composite.DistributionList;
import github.alessandrofazio.design.patter.defaultvisitor.exercise.exercise1.composite.Person;
import github.alessandrofazio.design.patter.defaultvisitor.exercise.exercise1.visitor.CountingVisitor;
import github.alessandrofazio.design.patter.defaultvisitor.exercise.exercise1.visitor.EmailGatheringVisitor;

public class DefaultVisitorTest {
    private static final Faker FAKER = new Faker();
    public static void main(String[] args) {
        CountingVisitor countingVisitor = new CountingVisitor();
        EmailGatheringVisitor emailGatheringVisitor = new EmailGatheringVisitor();
        DistributionList contacts = getDistributionList(10);
        DistributionList inner = getDistributionList(5);
        contacts.add(inner);

        contacts.accept(emailGatheringVisitor);
        for(String email: emailGatheringVisitor) {
            System.out.println("gathered email = " + email);
        }

        System.out.println();
        contacts.accept(countingVisitor);
        System.out.println("varianceChildrenPerComposite = " + countingVisitor.getVarianceChildrenPerComposite());
        System.out.println("averageChildrenPerComposite = " + countingVisitor.getAvgChildrenPerComposite());
        System.out.println("num of emails = " + countingVisitor.getNumOfEmails());
    }

    private static DistributionList getDistributionList(int numContacts) {
        DistributionList contacts = new DistributionList();
        for(int i=0; i < numContacts; i++) {
            contacts.add(new Person(FAKER.internet().safeEmailAddress()));
        }
        return contacts;
    }
}

