public class LinkedListOperations {

    private class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head = null;
    private int size = 0;

    public void insertAtBeginning(int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
        size++;
        System.out.println(value + " inserted at the beginning.");
    }

    public void insertAtEnd(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
        System.out.println(value + " inserted at the end.");
    }

    public void delete(int value) {
        if (head == null) {
            System.out.println("Linked list is empty! Nothing to delete.");
            return;
        }
        if (head.data == value) {
            head = head.next;
            size--;
            System.out.println(value + " deleted from the list.");
            return;
        }
        Node current = head;
        while (current.next != null && current.next.data != value) {
            current = current.next;
        }
        if (current.next == null) {
            System.out.println(value + " was not found in the list.");
        } else {
            current.next = current.next.next;
            size--;
            System.out.println(value + " deleted from the list.");
        }
    }

    public void search(int value) {
        if (head == null) {
            System.out.println("Linked list is empty! Nothing to search.");
            return;
        }
        Node current = head;
        int position = 1;
        int steps = 0;
        while (current != null) {
            steps++;
            if (current.data == value) {
                System.out.println(value + " found at position " + position + ". Steps taken: " + steps);
                ResultLog.add("Linked list search for " + value + " -> found at position " + position + ", steps = " + steps);
                return;
            }
            current = current.next;
            position++;
        }
        System.out.println(value + " was not found. Steps taken: " + steps);
        ResultLog.add("Linked list search for " + value + " -> not found, steps = " + steps);
    }

    public void display() {
        if (head == null) {
            System.out.println("Linked list is empty.");
            return;
        }
        Node current = head;
        System.out.print("Linked List: ");
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
        System.out.println("Number of nodes: " + size);
    }

    public void run() {
        boolean back = false;
        while (!back) {
            System.out.println();
            System.out.println("------------- LINKED LIST OPERATIONS -------------");
            System.out.println("1. Insert at Beginning");
            System.out.println("2. Insert at End");
            System.out.println("3. Delete a Value");
            System.out.println("4. Search a Value");
            System.out.println("5. Display List");
            System.out.println("6. Return to Main Menu");
            int choice = InputHelper.readInt("Enter your choice: ");

            switch (choice) {
                case 1:
                    int value1 = InputHelper.readInt("Enter value to insert: ");
                    insertAtBeginning(value1);
                    break;
                case 2:
                    int value2 = InputHelper.readInt("Enter value to insert: ");
                    insertAtEnd(value2);
                    break;
                case 3:
                    int value3 = InputHelper.readInt("Enter value to delete: ");
                    delete(value3);
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
