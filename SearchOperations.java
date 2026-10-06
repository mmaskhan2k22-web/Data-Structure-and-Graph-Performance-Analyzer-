//Member 01
import java.util.Arrays;
import java.util.Random;

public class SearchOperations {

    private int[] data = new int[0];

    public static int[] linearSearch(int[] array, int target) {
        int steps = 0;
        for (int i = 0; i < array.length; i++) {
            steps++;
            if (array[i] == target) {
                return new int[] { i, steps };
            }
        }
        return new int[] { -1, steps };
    }

    public static int[] binarySearch(int[] array, int target) {
        int low = 0;
        int high = array.length - 1;
        int steps = 0;
        while (low <= high) {
            steps++;
            int mid = low + (high - low) / 2;
            if (array[mid] == target) {
                return new int[] { mid, steps };
            } else if (array[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return new int[] { -1, steps };
    }

    private void enterManually() {
        int size = InputHelper.readIntInRange("How many numbers? (1 - 50): ", 1, 50);
        data = new int[size];
        for (int i = 0; i < size; i++) {
            data[i] = InputHelper.readInt("Enter number " + (i + 1) + ": ");
        }
        Arrays.sort(data);
        System.out.println("Array sorted automatically (needed for binary search).");
        displayArray();
    }

    private void generateRandom() {
        int size = InputHelper.readIntInRange("Array size? (1 - 100000): ", 1, 100000);
        Random random = new Random();
        data = new int[size];
        for (int i = 0; i < size; i++) {
            data[i] = random.nextInt(size * 10) + 1;
        }
        Arrays.sort(data);
        System.out.println("Sorted random array with " + size + " numbers created.");
        displayArray();
    }

    private void displayArray() {
        if (data.length == 0) {
            System.out.println("No array created yet. Choose option 1 or 2 first.");
            return;
        }
        if (data.length > 30) {
            System.out.println("Array has " + data.length + " elements (too big to print).");
            System.out.println("First element: " + data[0] + ", Last element: " + data[data.length - 1]);
            return;
        }
        System.out.print("Sorted array: ");
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    private void printSearchResult(String name, int target, int[] result, long time) {
        if (result[0] == -1) {
            System.out.println(name + ": " + target + " not found. Steps = " + result[1] + ", Time = " + time + " ns");
            ResultLog.add(name + " for " + target + " -> not found, steps = " + result[1] + ", time = " + time + " ns");
        } else {
            System.out.println(name + ": " + target + " found at position " + (result[0] + 1)
                    + ". Steps = " + result[1] + ", Time = " + time + " ns");
            ResultLog.add(name + " for " + target + " -> found at position " + (result[0] + 1)
                    + ", steps = " + result[1] + ", time = " + time + " ns");
        }
    }

    private void runLinear() {
        if (data.length == 0) {
            System.out.println("No array created yet. Choose option 1 or 2 first.");
            return;
        }
        int target = InputHelper.readInt("Enter number to search: ");
        long start = System.nanoTime();
        int[] result = linearSearch(data, target);
        long time = System.nanoTime() - start;
        printSearchResult("Linear Search", target, result, time);
    }

    private void runBinary() {
        if (data.length == 0) {
            System.out.println("No array created yet. Choose option 1 or 2 first.");
            return;
        }
        int target = InputHelper.readInt("Enter number to search: ");
        long start = System.nanoTime();
        int[] result = binarySearch(data, target);
        long time = System.nanoTime() - start;
        printSearchResult("Binary Search", target, result, time);
    }

    private void compareBoth() {
        if (data.length == 0) {
            System.out.println("No array created yet. Choose option 1 or 2 first.");
            return;
        }
        int target = InputHelper.readInt("Enter number to search: ");

        long start1 = System.nanoTime();
        int[] linear = linearSearch(data, target);
        long time1 = System.nanoTime() - start1;

        long start2 = System.nanoTime();
        int[] binary = binarySearch(data, target);
        long time2 = System.nanoTime() - start2;

        System.out.println();
        printSearchResult("Linear Search", target, linear, time1);
        printSearchResult("Binary Search", target, binary, time2);
        System.out.println();
        System.out.println("Linear Search is O(n) - it may check every element.");
        System.out.println("Binary Search is O(log n) - it halves the search area each step.");
    }

    public void run() {
        boolean back = false;
        while (!back) {
            System.out.println();
            System.out.println("-------------- SEARCHING OPERATIONS --------------");
            System.out.println("1. Enter Array Manually");
            System.out.println("2. Generate Random Sorted Array");
            System.out.println("3. Display Array");
            System.out.println("4. Linear Search");
            System.out.println("5. Binary Search");
            System.out.println("6. Compare Linear and Binary Search");
            System.out.println("7. Return to Main Menu");
            int choice = InputHelper.readInt("Enter your choice: ");

            switch (choice) {
                case 1:
                    enterManually();
                    break;
                case 2:
                    generateRandom();
                    break;
                case 3:
                    displayArray();
                    break;
                case 4:
                    runLinear();
                    break;
                case 5:
                    runBinary();
                    break;
                case 6:
                    compareBoth();
                    break;
                case 7:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid choice! Please enter 1 to 7.");
            }
        }
    }
}
