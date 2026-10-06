// member 01

import java.util.ArrayList;

public class ResultLog {

    private static ArrayList<String> results = new ArrayList<String>();

    public static void add(String result) {
        results.add(result);
    }

    public static void displayAll() {
        System.out.println();
        System.out.println("=============================================");
        System.out.println("             ALL SAVED RESULTS");
        System.out.println("=============================================");
        if (results.isEmpty()) {
            System.out.println("No results saved yet. Run some operations first.");
        } else {
            for (int i = 0; i < results.size(); i++) {
                System.out.println((i + 1) + ". " + results.get(i));
            }
        }
        System.out.println("=============================================");
    }
}
