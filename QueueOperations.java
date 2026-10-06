public class QueueOperations {

    private static final int MAX_SIZE = 10;
    private int[] queue = new int[MAX_SIZE];
    private int front = 0;
    private int rear = -1;
    private int count = 0;

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == MAX_SIZE;
    }

    public void enqueue(int value) {
        if (isFull()) {
            System.out.println("Queue is full! Cannot enqueue " + value + ".");
            return;
        }
        rear = (rear + 1) % MAX_SIZE;
        queue[rear] = value;
        count++;
        System.out.println(value + " added to the queue.");
    }

    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty! Cannot dequeue.");
            return;
        }
        int removed = queue[front];
        front = (front + 1) % MAX_SIZE;
        count--;
        System.out.println(removed + " removed from the queue.");
    }

    public void peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Nothing at the front.");
            return;
        }
        System.out.println("Front element is: " + queue[front]);
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("The queue is empty.");
            return;
        }
        System.out.print("Queue (front to rear): ");
        for (int i = 0; i < count; i++) {
            int index = (front + i) % MAX_SIZE;
            System.out.print(queue[index] + " ");
        }
        System.out.println();
    }

    public void run() {
        boolean back = false;
        while (!back) {
            System.out.println();
            System.out.println("--------------- QUEUE OPERATIONS ---------------");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek / Front");
            System.out.println("4. Display Queue");
            System.out.println("5. Return to Main Menu");
            int choice = InputHelper.readInt("Enter your choice: ");

            switch (choice) {
                case 1:
                    int value = InputHelper.readInt("Enter value to enqueue: ");
                    enqueue(value);
                    break;
                case 2:
                    dequeue();
                    break;
                case 3:
                    peek();
                    break;
                case 4:
                    display();
                    break;
                case 5:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid choice! Please enter 1 to 5.");
            }
        }
    }
}
