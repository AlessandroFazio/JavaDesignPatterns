package github.alessandrofazio.design.patter.nullobject.playground.nullpointerexception;

public class NullPointerMystery {
    public static String getValue() {
        return null;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Exception previous = null;
        while (true) {
            try {
                getValue().toUpperCase().toLowerCase();
            } catch (Exception e) {
                e.printStackTrace();
                if(e == previous) {
                    System.out.println("We've seen that before!");
                    return;
                }
                previous = e;
            } finally {
                long end = System.currentTimeMillis();
                System.out.println("It took about: " + (end - start));
            }
        }
    }
}
