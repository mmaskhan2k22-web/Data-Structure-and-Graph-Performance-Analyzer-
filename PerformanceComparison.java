// Member 01
public class PerformanceComparison {

    public static void run(GraphOperations graph) {
        System.out.println();
        System.out.println("=============================================");
        System.out.println("           PERFORMANCE COMPARISON");
        System.out.println("=============================================");

        int size = InputHelper.readIntInRange("Enter array size for the search test (10 - 1000000): ", 10, 1000000);
        int[] numbers = new int[size];
        for (int i = 0; i < size; i++) {
            numbers[i] = i * 2;
        }
        int target = numbers[size - 1];

        long start = System.nanoTime();
        int[] linear = SearchOperations.linearSearch(numbers, target);
        long linearTime = System.nanoTime() - start;

        start = System.nanoTime();
        int[] binary = SearchOperations.binarySearch(numbers, target);
        long binaryTime = System.nanoTime() - start;

        if (graph.isEmpty()) {
            System.out.println("Graph is empty, so the sample graph will be used.");
            graph.loadSampleGraph();
        }
        String startVertex = graph.getVertexName(0);

        start = System.nanoTime();
        int bfsSteps = graph.bfs(startVertex, false);
        long bfsTime = System.nanoTime() - start;

        start = System.nanoTime();
        int dfsSteps = graph.dfs(startVertex, false);
        long dfsTime = System.nanoTime() - start;

        System.out.println();
        System.out.println("Searching for " + target + " in " + size + " sorted numbers (worst case).");
        System.out.println("Graph traversal starts from vertex " + startVertex + ".");
        System.out.println();
        System.out.println("=============================================================");
        System.out.printf("%-18s %-16s %-10s %-12s%n", "Operation", "Algorithm", "Steps", "Time (ns)");
        System.out.println("-------------------------------------------------------------");
        System.out.printf("%-18s %-16s %-10d %-12d%n", "Search", "Linear Search", linear[1], linearTime);
        System.out.printf("%-18s %-16s %-10d %-12d%n", "Search", "Binary Search", binary[1], binaryTime);
        System.out.printf("%-18s %-16s %-10d %-12d%n", "Graph Traversal", "BFS", bfsSteps, bfsTime);
        System.out.printf("%-18s %-16s %-10d %-12d%n", "Graph Traversal", "DFS", dfsSteps, dfsTime);
        System.out.println("=============================================================");

        System.out.println();
        System.out.println("Why are the results different?");
        System.out.println("- Linear Search is O(n): in the worst case it checks all " + size + " elements.");
        System.out.println("- Binary Search is O(log n): it halves the array each step, so it needs very few steps.");
        System.out.println("- BFS and DFS are both O(V + E): each vertex and each edge is checked once,");
        System.out.println("  so their step counts are usually the same. They only differ in the visiting order.");
        System.out.println("- Execution time can change between runs because it depends on the computer.");

        ResultLog.add("Performance (" + size + " elements): Linear steps = " + linear[1] + ", Binary steps = " + binary[1]
                + ", BFS steps = " + bfsSteps + ", DFS steps = " + dfsSteps);
    }
}
