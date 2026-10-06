//Member 04
import java.util.ArrayList;

public class GraphOperations {

    private ArrayList<String> vertices = new ArrayList<String>();
    private ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<ArrayList<Integer>>();
    private int stepCount = 0;

    public boolean isEmpty() {
        return vertices.isEmpty();
    }

    public String getVertexName(int index) {
        return vertices.get(index);
    }

    private int findVertex(String name) {
        for (int i = 0; i < vertices.size(); i++) {
            if (vertices.get(i).equalsIgnoreCase(name)) {
                return i;
            }
        }
        return -1;
    }

    public void addVertex(String name) {
        if (findVertex(name) != -1) {
            System.out.println("Vertex " + name + " already exists.");
            return;
        }
        vertices.add(name);
        adjacencyList.add(new ArrayList<Integer>());
        System.out.println("Vertex " + name + " added.");
    }

    public void addEdge(String first, String second) {
        int a = findVertex(first);
        int b = findVertex(second);
        if (a == -1 || b == -1) {
            System.out.println("Both vertices must exist before adding an edge.");
            return;
        }
        if (a == b) {
            System.out.println("A vertex cannot be connected to itself.");
            return;
        }
        if (adjacencyList.get(a).contains(b)) {
            System.out.println("Edge " + vertices.get(a) + " - " + vertices.get(b) + " already exists.");
            return;
        }
        adjacencyList.get(a).add(b);
        adjacencyList.get(b).add(a);
        System.out.println("Edge " + vertices.get(a) + " - " + vertices.get(b) + " added.");
    }

    public void display() {
        if (vertices.isEmpty()) {
            System.out.println("Graph is empty. Add some vertices first.");
            return;
        }
        System.out.println("Graph (Adjacency List):");
        for (int i = 0; i < vertices.size(); i++) {
            System.out.print(vertices.get(i) + " -> ");
            ArrayList<Integer> neighbours = adjacencyList.get(i);
            if (neighbours.isEmpty()) {
                System.out.print("(no connections)");
            }
            for (int j = 0; j < neighbours.size(); j++) {
                System.out.print(vertices.get(neighbours.get(j)) + " ");
            }
            System.out.println();
        }
    }

    public int bfs(String startName, boolean show) {
        int start = findVertex(startName);
        stepCount = 0;
        int n = vertices.size();
        boolean[] visited = new boolean[n];
        int[] queue = new int[n];
        int front = 0;
        int rear = 0;
        StringBuilder order = new StringBuilder();

        visited[start] = true;
        queue[rear] = start;
        rear++;

        while (front < rear) {
            int current = queue[front];
            front++;
            stepCount++;
            order.append(vertices.get(current)).append(" ");

            ArrayList<Integer> neighbours = adjacencyList.get(current);
            for (int i = 0; i < neighbours.size(); i++) {
                int next = neighbours.get(i);
                stepCount++;
                if (!visited[next]) {
                    visited[next] = true;
                    queue[rear] = next;
                    rear++;
                }
            }
        }

        if (show) {
            System.out.println("BFS traversal from " + vertices.get(start) + ": " + order.toString().trim());
            System.out.println("Steps taken: " + stepCount);
            ResultLog.add("BFS from " + vertices.get(start) + " -> " + order.toString().trim() + ", steps = " + stepCount);
        }
        return stepCount;
    }

    public int dfs(String startName, boolean show) {
        int start = findVertex(startName);
        stepCount = 0;
        boolean[] visited = new boolean[vertices.size()];
        StringBuilder order = new StringBuilder();

        dfsVisit(start, visited, order);

        if (show) {
            System.out.println("DFS traversal from " + vertices.get(start) + ": " + order.toString().trim());
            System.out.println("Steps taken: " + stepCount);
            ResultLog.add("DFS from " + vertices.get(start) + " -> " + order.toString().trim() + ", steps = " + stepCount);
        }
        return stepCount;
    }

    private void dfsVisit(int current, boolean[] visited, StringBuilder order) {
        visited[current] = true;
        stepCount++;
        order.append(vertices.get(current)).append(" ");

        ArrayList<Integer> neighbours = adjacencyList.get(current);
        for (int i = 0; i < neighbours.size(); i++) {
            int next = neighbours.get(i);
            stepCount++;
            if (!visited[next]) {
                dfsVisit(next, visited, order);
            }
        }
    }

    public void loadSampleGraph() {
        vertices.clear();
        adjacencyList.clear();
        String[] names = { "A", "B", "C", "D", "E", "F" };
        for (int i = 0; i < names.length; i++) {
            vertices.add(names[i]);
            adjacencyList.add(new ArrayList<Integer>());
        }
        String[][] edges = { { "A", "B" }, { "A", "C" }, { "B", "D" }, { "B", "E" }, { "C", "F" }, { "E", "F" } };
        for (int i = 0; i < edges.length; i++) {
            int a = findVertex(edges[i][0]);
            int b = findVertex(edges[i][1]);
            adjacencyList.get(a).add(b);
            adjacencyList.get(b).add(a);
        }
        System.out.println("Sample graph loaded (6 vertices, 6 edges).");
    }

    public void run() {
        boolean back = false;
        while (!back) {
            System.out.println();
            System.out.println("--------------- GRAPH OPERATIONS ---------------");
            System.out.println("1. Add Vertex");
            System.out.println("2. Add Edge");
            System.out.println("3. Display Graph");
            System.out.println("4. BFS Traversal");
            System.out.println("5. DFS Traversal");
            System.out.println("6. Load Sample Graph");
            System.out.println("7. Return to Main Menu");
            int choice = InputHelper.readInt("Enter your choice: ");

            switch (choice) {
                case 1:
                    String name = InputHelper.readText("Enter vertex name: ");
                    addVertex(name);
                    break;
                case 2:
                    if (vertices.size() < 2) {
                        System.out.println("Add at least two vertices first.");
                    } else {
                        String first = InputHelper.readText("Enter first vertex: ");
                        String second = InputHelper.readText("Enter second vertex: ");
                        addEdge(first, second);
                    }
                    break;
                case 3:
                    display();
                    break;
                case 4:
                    if (vertices.isEmpty()) {
                        System.out.println("Graph is empty. Add vertices or load the sample graph.");
                    } else {
                        String bfsStart = InputHelper.readText("Enter starting vertex: ");
                        if (findVertex(bfsStart) == -1) {
                            System.out.println("Vertex " + bfsStart + " does not exist.");
                        } else {
                            bfs(bfsStart, true);
                        }
                    }
                    break;
                case 5:
                    if (vertices.isEmpty()) {
                        System.out.println("Graph is empty. Add vertices or load the sample graph.");
                    } else {
                        String dfsStart = InputHelper.readText("Enter starting vertex: ");
                        if (findVertex(dfsStart) == -1) {
                            System.out.println("Vertex " + dfsStart + " does not exist.");
                        } else {
                            dfs(dfsStart, true);
                        }
                    }
                    break;
                case 6:
                    loadSampleGraph();
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
