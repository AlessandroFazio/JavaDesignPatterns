package github.alessandrofazio.design.patter.visitor.exercise1;

import com.github.javafaker.Faker;
import github.alessandrofazio.design.patter.visitor.exercise1.visitor.CountingVisitor;
import github.alessandrofazio.design.patter.visitor.exercise1.visitor.EmailGatheringVisitor;

public class VisitorTestClient {
    private static final Faker FAKER = new Faker();

    public static void main(String[] args) {
        EmailGatheringVisitor emailVisitor = new EmailGatheringVisitor();
        CountingVisitor countingVisitor = new CountingVisitor();
        DistributionList contacts = getDistributionList(10);
        DistributionList inner = getDistributionList(10);
        contacts.add(inner);

        contacts.accept(emailVisitor);
        for(String email: emailVisitor) {
            System.out.println("visited email: " + email);
        }
        System.out.println();

        contacts.accept(countingVisitor);
        System.out.println("Counted emails: " + countingVisitor.getNumOfEmails());

        System.out.println();
        System.out.println("Avg Num of children per composite: " + countingVisitor.getAverageChildrenPerComposite());
        System.out.println("Variance num of children per composite: " + countingVisitor.getVarianceNumChildrenPerComposite());
    }

    private static DistributionList getDistributionList(int num) {
        DistributionList contacts = new DistributionList();
        for(int i=0; i < num; i++) {
            contacts.add(new Person(FAKER.internet().safeEmailAddress()));
        }
        return contacts;
    }
}
