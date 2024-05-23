package DAA_Concepts;
import java.util.Scanner;
class PrimsMST {
    private int V = 0;
    // A utility method to find the vertex with the minimum key value which is not yet included in the MST
    public PrimsMST(int V){
        this.V=V;
    }
    private int minKey(int key[], Boolean mstSet[]) {
        int min = Integer.MAX_VALUE, min_index = -1;
        for (int v = 0; v < V; v++) {
            if (!mstSet[v] && key[v] < min) {
                min = key[v];
                min_index = v;
            }
        }
        return min_index;
    }
    // method to print the constructed MST
    private void printMST(int parent[], int graph[][]) {
        int totalMinimumCost=0;
        System.out.println("  Source\t :\tDestination = Weight");
        for (int i = 1; i < V; i++) {
            System.out.println("\t"+parent[i] + "\t    --- \t" + i + "\t\t    " + graph[i][parent[i]]);
            totalMinimumCost+=graph[i][parent[i]];
        }
        System.out.println("\nThe Minimum Cost of Spanning Tree is : "+totalMinimumCost);
    }
    // method to construct MST for a graph represented using adjacency matrix
    void primsMST(int graph[][]) {
        // Array to store constructed MST
        int parent[] = new int[V];
        // Key values used to pick the minimum weight edge in cut
        int key[] = new int[V];
        // To represent the set of vertices included in the MST
        Boolean mstSet[] = new Boolean[V];
        // Initialize all keys as INFINITE and mstSet[] as false
        for (int i = 0; i < V; i++) {
            key[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }
        // Always include the first vertex in MST.
        key[0] = 0; //Make key 0 so that this vertex is picked as the first vertex
        parent[0] = -1; // First node is always the root of MST
        for (int count = 0; count < V - 1; count++) {
            int u = minKey(key, mstSet);
            // Add the picked vertex to the MST Set
            mstSet[u] = true;
            // Consider only those vertices which are not yet included in the MST
            for (int v = 0; v < V; v++) {
                if (graph[u][v] != 0 && !mstSet[v] && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
            }
        }
        printMST(parent, graph);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of vertices in the graph:");
        int V = sc.nextInt();
        PrimsMST t = new PrimsMST(V);
        int[][] graph = new int[V][V];
        System.out.println("Enter the adjacency matrix for the graph:");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                graph[i][j] = sc.nextInt();
            }
        }
        t.primsMST(graph);
        sc.close();
    }
}
