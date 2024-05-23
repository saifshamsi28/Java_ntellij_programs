package DAA_Concepts;
import java.util.*;
class DijkstraShortestPath {
    private static final int INFINITY = Integer.MAX_VALUE;
    private int V;
    private List<List<Node>> adjacencyList;
    static class Node {
        int destination;
        int weight;
        Node(int destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }
    DijkstraShortestPath(int v) {
        V = v;
        adjacencyList = new ArrayList<>(V);
        for (int i = 0; i < V; ++i)
            adjacencyList.add(new ArrayList<>());
    }
    void addEdge(int source, int destination, int weight) {
        Node node = new Node(destination, weight);
        adjacencyList.get(source).add(node);
    }
    void dijkstra(int source) {
        int[] dist = new int[V];
        Arrays.fill(dist, INFINITY);
        List<Integer> path = new ArrayList<>(Collections.nCopies(V, null));
        // Priority queue to store vertices with their minimum distance
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(V, Comparator.comparingInt(o -> o.weight));
        dist[source] = 0;
        priorityQueue.add(new Node(source, 0));
        while (!priorityQueue.isEmpty()) {
            int u = priorityQueue.poll().destination;
            for (Node neighbor : adjacencyList.get(u)) {
                int v = neighbor.destination;
                int weight = neighbor.weight;
                if (dist[u] != INFINITY && dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    priorityQueue.add(new Node(v, dist[v]));
                    path.set(v, u);
                }
            }
        }
        printShortestPaths(dist, source, path);
    }
    private void printShortestPaths(int[] dist, int source, List<Integer> path) {
        System.out.println("Shortest paths from vertex " + source + ":");
        for (int i = 0; i < V; ++i) {
            if (dist[i] != INFINITY) {
                System.out.print("Vertex " + i + ": Distance - " + dist[i] + ", Path - ");
                printPath(source, i, path);
                System.out.println();
            }
        }
    }
    private void printPath(int source, int destination, List<Integer> path) {
        if (destination == source) {
            System.out.print(source);
        } else if (path.get(destination) == null) {
            System.out.println("No path from " + source + " to " + destination);
        } else {
            printPath(source, path.get(destination), path);
            System.out.print(" -> " + destination);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of vertices: ");
        int V = scanner.nextInt();
        DijkstraShortestPath graph = new DijkstraShortestPath(V);
        System.out.print("Enter the number of edges: ");
        int E = scanner.nextInt();
        System.out.println("Enter the details of each edge (source destination weight):");
        for (int i = 0; i < E; i++) {
            int source = scanner.nextInt();
            int destination = scanner.nextInt();
            int weight = scanner.nextInt();
            graph.addEdge(source, destination, weight);
        }
        System.out.print("Enter the source vertex: ");
        int sourceVertex = scanner.nextInt();
        graph.dijkstra(sourceVertex);
    }
}
