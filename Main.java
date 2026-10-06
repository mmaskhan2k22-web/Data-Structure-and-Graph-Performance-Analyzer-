public class Main {

    public static void main(String[] args) {

        ArrayOperations arrayOps = new ArrayOperations();
        StackOperations stackOps = new StackOperations();
        QueueOperations queueOps = new QueueOperations();
        LinkedListOperations linkedListOps = new LinkedListOperations();
        SearchOperations searchOps = new SearchOperations();
        GraphOperations graphOps = new GraphOperations();

        boolean running = true;

        while (running) {
            System.out.println();
            System.out.println("=============================================");
            System.out.println("     DATA STRUCTURE & GRAPH ANALYZER");
            System.out.println("=============================================");
            System.out.println("1. Array Operations");
            System.out.println("2. Stack Operations");
            System.out.println("3. Queue Operations");
            System.out.println("4. Linked List Operations");
            System.out.println("5. Searching Operations");
            System.out.println("6. Graph Operations");
            System.out.println("7. Performance Comparison");
            System.out.println("8. Display All Results");
            System.out.println("9. Exit");
            int choice = InputHelper.readInt("Enter your choice: ");

            switch (choice) {
                case 1:
                    arrayOps.run();
                    break;
                case 2:
                    stackOps.run();
                    break;
                case 3:
                    queueOps.run();
                    break;
                case 4:
                    linkedListOps.run();
                    break;
                case 5:
                    searchOps.run();
                    break;
                case 6:
                    graphOps.run();
                    break;
                case 7:
                    PerformanceComparison.run(graphOps);
                    break;
                case 8:
                    ResultLog.displayAll();
                    break;
                case 9:
                    System.out.println("Thank you for using the program. Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice! Please enter a number from 1 to 9.");
            }
        }
    }
}
