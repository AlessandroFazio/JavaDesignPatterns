package github.alessandrofazio.desing.pattern.composite.exercise1;

import com.github.javafaker.Faker;

import java.util.Iterator;

public class ContactTest {
    private static final Faker FAKER = new Faker();
    private static final int numContacts = 10;

    public static void main(String[] args) {
        github.alessandrofazio.desing.pattern.composite.exercise1.Contact distributionList = new DistributionList();
        for(int i=0; i < numContacts; i++) {
            distributionList.add(new Person(FAKER.internet().safeEmailAddress()));
        }

        DistributionList innerList = new DistributionList();
        for(int i=0; i < numContacts; i++) {
            innerList.add(new Person(FAKER.internet().safeEmailAddress()));
        }
        distributionList.add(innerList);

        System.out.println("Starting spam");
        distributionList.sendEmail("TestSpam");
        System.out.println("Finished spam");

        System.out.println();
        Iterator<Contact> it = new ContactIterator(distributionList);
        while(it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
