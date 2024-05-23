package DAA_Concepts;
import java.util.Scanner;
class KruskalMST {
    class Edge implements Comparable<Edge> {
        int src, dest, weight;
        public int compareTo(Edge compareEdge) {
            return this.weight - compareEdge.weight;
        }
    }
    class Subset {
        int parent, rank;
    }
    int V, E;
    Edge[] edges;
    KruskalMST(int v, int e) {
        V = v;
        E = e;
        edges = new Edge[E];
        for (int i = 0; i < e; ++i)
            edges[i] = new Edge();
    }
    int find(Subset subsets[], int i) {
        if (subsets[i].parent != i)
            subsets[i].parent = find(subsets, subsets[i].parent);
        return subsets[i].parent;
    }
    void union(Subset subsets[], int x, int y) {
        int xroot = find(subsets, x);
        int yroot = find(subsets, y);
        if (subsets[xroot].rank < subsets[yroot].rank)
            subsets[xroot].parent = yroot;
        else if (subsets[xroot].rank > subsets[yroot].rank)
            subsets[yroot].parent = xroot;
        else {
            subsets[yroot].parent = xroot;
            subsets[xroot].rank++;
        }
    }
    void kruskalMST() {
        Subset subsets[] = new Subset[V];
        for (int i = 0; i < V; ++i) {
            subsets[i] = new Subset();
            subsets[i].parent = i;
            subsets[i].rank = 0;
        }
        // Sort edges in non-decreasing order of their weight
        for (int i = 0; i < E - 1; i++) {
            for (int j = 0; j < E - i - 1; j++) {
                if (edges[j].weight > edges[j + 1].weight) {
                    Edge temp = edges[j];
                    edges[j] = edges[j + 1];
                    edges[j + 1] = temp;
                }
            }
        }
        System.out.println("\nTable in increasing order of weights:- ");
        System.out.println("S - D : W ");
        for (int i = 0; i < edges.length; ++i)
            System.out.println(edges[i].src + " - " + edges[i].dest + " : " + edges[i].weight);
        Edge result[] = new Edge[V - 1];
        int e = 0;
        int i = 0;
        while (e < V - 1) {
            Edge nextEdge = edges[i++];
            int x = find(subsets, nextEdge.src);
            int y = find(subsets, nextEdge.dest);
            if (x != y) {
                result[e++] = nextEdge;
                union(subsets, x, y);
            }
        }
        System.out.println("Edges in the Minimum Spanning Tree:");
        System.out.println("S - D : W ");
        int totalMinimumCost=0;
        for (i = 0; i < e; ++i) {
            System.out.println(result[i].src + " - " + result[i].dest + " : " + result[i].weight);
            totalMinimumCost += result[i].weight;
        }
        System.out.println("The Minimum Cost of Spanning Tree is : "+totalMinimumCost);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of vertices: ");
        int V = scanner.nextInt();
        System.out.print("Enter the number of edges: ");
        int E = scanner.nextInt();
        KruskalMST graph = new KruskalMST(V, E);
        System.out.println("Enter the details of each edge (source destination weight):");
        for (int i = 0; i < E; i++) {
            graph.edges[i].src = scanner.nextInt();
            graph.edges[i].dest = scanner.nextInt();
            graph.edges[i].weight = scanner.nextInt();
        }
        graph.kruskalMST();
    }
}

