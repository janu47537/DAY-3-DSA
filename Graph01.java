import java.util.*;

class Graph01 {
    private Map<String, List<String>> adjacencyList;

    public Graph01() {
        adjacencyList = new HashMap<>();
    }

    public void addNode(String v) {
        adjacencyList.putIfAbsent(v, new ArrayList<>());

        for (String node : adjacencyList.keySet()) {
            if (!node.equals(v)) {
                addEdge(node, v);
            }
        }
    }

    public void addEdge(String u, String v) {
        if (!adjacencyList.containsKey(u)) addNode(u);
        if (!adjacencyList.containsKey(v)) addNode(v);

        if (!adjacencyList.get(u).contains(v))
            adjacencyList.get(u).add(v);

        if (!adjacencyList.get(v).contains(u))
            adjacencyList.get(v).add(u);
    }

    public void printGraph() {
        for (String v : adjacencyList.keySet()) {
            System.out.println(v + " -> " + adjacencyList.get(v));
        }
    }

    public boolean isConnected(String v, String u) {
        return adjacencyList.containsKey(v) && adjacencyList.get(v).contains(u);
    }

    public void removeEdge(String v, String u) {
        if (adjacencyList.containsKey(v)) {
            adjacencyList.get(v).remove(u);
        }
        if (adjacencyList.containsKey(u)) {
            adjacencyList.get(u).remove(v);
        }
    }

    public int countOfEdges() {
        int count = 0;
        for (String node : adjacencyList.keySet()) {
            count += adjacencyList.get(node).size();
        }
        return count / 2; // because undirected
    }

    public void countOfAdj() {
        for (String v : adjacencyList.keySet()) {
            int count = adjacencyList.get(v).size();
            System.out.println(v + ": " + count);
        }
    }
    public void addConnection(String v, String u) {
    addNode(v);
    addNode(u);

    if (!adjacencyList.get(v).contains(u))
        adjacencyList.get(v).add(u);

    if (!adjacencyList.get(u).contains(v))
        adjacencyList.get(u).add(v);
}

    public static void main(String[] args) {
    Graph01 a = new Graph01();

    a.addNode("Arjun");
    a.addNode("Nani");
    a.addNode("Ram");
    a.addNode("Prabhas");
    a.addNode("Arjun");
    a.addNode("Nani");


    System.out.println("Graph:");
    a.printGraph();

    // Check connection
    System.out.println("\nIs Arjun connected to Nani? " + a.isConnected("Arjun", "Nani"));

    // Remove edge
    a.removeEdge("Arjun", "Nani");

    System.out.println("\nIs Arjun connected to Nani after removal? " + a.isConnected("Arjun", "Nani"));

    System.out.println("\nAfter removing edge:");
    a.printGraph();

    System.out.println("\nNumber of edges: " + a.countOfEdges());

    System.out.println("\nNumber of adjacent nodes:");
    a.countOfAdj();
    // Using addConnection()
    a.addConnection("Arjun", "Nani");
    a.addConnection("Arjun", "Ram");
    a.addConnection("Nani", "Prabhas");

    // Printing statements
    System.out.println("Graph after adding connections:");
    a.printGraph();

    System.out.println("\nIs Arjun connected to Nani? " + a.isConnected("Arjun", "Nani"));
    System.out.println("Is Arjun connected to Prabhas? " + a.isConnected("Arjun", "Prabhas"));

    System.out.println("\nNumber of adjacent nodes (connections):");
    a.countOfAdj();

    System.out.println("\nTotal number of connections: " + a.countOfEdges());
}
}

