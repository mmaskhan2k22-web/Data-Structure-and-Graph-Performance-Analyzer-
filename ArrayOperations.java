public class ArrayOperations {

    private static final int MAX_SIZE = 20;
    private int[] data = new int[MAX_SIZE];
    private int size = 0;

    public void insertAtEnd(int value) {
        if (size == MAX_SIZE) {
            System.out.println("Array is full! Cannot insert " + value + ".");
            return;
        }
        data[size] = value;
        size++;
        System.out.println(value + " inserted at the end of the array.");
    }

    public void insertAtPosition(int position, int value) {
        if (size == MAX_SIZE) {
            System.out.println("Array is full! Cannot insert " + value + ".");
            return;
        }
        if (position < 1 || position > size + 1) {
            System.out.println("Invalid position! Choose a position between 1 and " + (size + 1) + ".");
            return;
        }
        int index = position - 1;
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = value;
        size++;
        System.out.println(value + " inserted at position " + position + ".");
    }

    public void deleteByValue(int value) {
        if (size == 0) {
            System.out.println("Array is empty! Nothing to delete.");
            return;
        }
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (data[i] == value) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            System.out.println(value + " was not found in the array.");
            return;
        }
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        System.out.println(value + " deleted from the array.");
    }

    public void search(int value) {
        if (size == 0) {
            System.out.println("Array is empty! Nothing to search.");
            return;
        }
        int steps = 0;
        int foundIndex = -1;
        for (int i = 0; i < size; i++) {
            steps++;
            if (data[i] == value) {
                foundIndex = i;
                break;
            }
        }
        if (foundIndex == -1) {
            System.out.println(value + " was not found. Steps taken: " + steps);
            ResultLog.add("Array search for " + value + " -> not found, steps = " + steps);
        } else {
            System.out.println(value + " found at position " + (foundIndex + 1) + ". Steps taken: " + steps);
            ResultLog.add("Array search for " + value + " -> found at position " + (foundIndex + 1) + ", steps = " + steps);
        }
    }

    public void display() {
        if (size == 0) {
            System.out.println("Array is empty.");
            return;
        }
        System.out.print("Array elements: ");
        for (int i = 0; i < size; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
        System.out.println("Number of elements: " + size + " / " + MAX_SIZE);
    }

    public void run() {
        boolean back = false;
        while (!back) {
            System.out.println();
            System.out.println("--------------- ARRAY OPERATIONS ---------------");
            System.out.println("1. Insert at End");
            System.out.println("2. Insert at Position");
            System.out.println("3. Delete by Value");
            System.out.println("4. Search (Linear)");
            System.out.println("5. Display Array");
            System.out.println("6. Return to Main Menu");
            int choice = InputHelper.readInt("Enter your choice: ");

            switch (choice) {
                case 1:
                    int value1 = InputHelper.readInt("Enter value to insert: ");
                    insertAtEnd(value1);
                    break;
                case 2:
                    int position = InputHelper.readInt("Enter position (1 to " + (size + 1) + "): ");
                    int value2 = InputHelper.readInt("Enter value to insert: ");
                    insertAtPosition(position, value2);
                    break;
                case 3:
                    int value3 = InputHelper.readInt("Enter value to delete: ");
                    deleteByValue(value3);
                    break;
                case 4:
                    int value4 = InputHelper.readInt("Enter value to search: ");
                    search(value4);
                    break;
                case 5:
                    display();
                    break;
                case 6:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid choice! Please enter 1 to 6.");
            }
        }
    }
}
