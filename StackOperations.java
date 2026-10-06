// Member 2
public class StackOperations {

    private static final int MAX_SIZE = 10;
    private int[] stack = new int[MAX_SIZE];
    private int top = -1;

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == MAX_SIZE - 1;
    }

    public void push(int value) {
        if (isFull()) {
            System.out.println("Stack Overflow! The stack is full. Cannot push " + value + ".");
            return;
        }
        top++;
        stack[top] = value;
        System.out.println(value + " pushed onto the stack.");
    }

    public void pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow! The stack is empty. Cannot pop.");
            return;
        }
        int removed = stack[top];
        top--;
        System.out.println(removed + " popped from the stack.");
    }

    public void peek() {
        if (isEmpty()) {
            System.out.println("The stack is empty. Nothing to peek.");
            return;
        }
        System.out.println("Top element is: " + stack[top]);
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("The stack is empty.");
            return;
        }
        System.out.println("Stack (top to bottom):");
        for (int i = top; i >= 0; i--) {
            System.out.println("| " + stack[i] + " |");
        }
        System.out.println("-----");
    }

    public void run() {
        boolean back = false;
        while (!back) {
            System.out.println();
            System.out.println("--------------- STACK OPERATIONS ---------------");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Display Stack");
            System.out.println("5. Return to Main Menu");
            int choice = InputHelper.readInt("Enter your choice: ");

            switch (choice) {
                case 1:
                    int value = InputHelper.readInt("Enter value to push: ");
                    push(value);
                    break;
                case 2:
                    pop();
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
