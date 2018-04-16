import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class EdgeWeightedDigraph {
    private static final String NEWLINE = System.getProperty("line.separator");

    private int V;                // number of vertices in this digraph
    private int E;                      // number of edges in this digraph
    private Bag<DirectedEdge>[] adj;    // adj[v] = adjacency list for vertex v
    private int[] indegree;             // indegree[v] = indegree of vertex v


    public EdgeWeightedDigraph(int V) {
        if (V < 0) throw new IllegalArgumentException("Number of vertices in a Digraph must be nonnegative");
        this.V = V;
        this.E = 0;
        this.indegree = new int[V];
        adj = (Bag<DirectedEdge>[]) new Bag[V];
        for (int v = 0; v < V; v++)
            adj[v] = new Bag<DirectedEdge>();
    }



    public EdgeWeightedDigraph(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        if (file.exists()) {
            Scanner sc = new Scanner(file);
            this.V = sc.nextInt();
            int N = sc.nextInt();
            this.indegree = new int[V];
            adj = (Bag<DirectedEdge>[]) new Bag[V];
            for (int v = 0; v < V; v++)
                adj[v] = new Bag<DirectedEdge>();

            if (N < 0) throw new IllegalArgumentException("Number of edges must be nonnegative");
            for (int i = 0; i < N; i++) {
                int v = sc.nextInt();
                int w = sc.nextInt();
                validateVertex(v);
                validateVertex(w);
                double weight = sc.nextDouble();
                addEdge(new DirectedEdge(v, w, weight));
            }
        } else {
            System.out.println("Error: File doesn't exist");
        }
    }


    public EdgeWeightedDigraph(EdgeWeightedDigraph G) {
        this(G.V());
        this.E = G.E();
        for (int v = 0; v < G.V(); v++)
            this.indegree[v] = G.indegree(v);
        for (int v = 0; v < G.V(); v++) {
            // reverse so that adjacency list is in same order as original
            Stack<DirectedEdge> reverse = new Stack<DirectedEdge>();
            for (DirectedEdge e : G.adj[v]) {
                reverse.push(e);
            }
            for (DirectedEdge e : reverse) {
                adj[v].add(e);
            }
        }
    }

    public int V() {
        return V;
    }


    public int E() {
        return E;
    }

    // throw an IllegalArgumentException unless {@code 0 <= v < V}
    private void validateVertex(int v) {
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V - 1));
    }


    public void addEdge(DirectedEdge e) {
        int v = e.from();
        int w = e.to();
        validateVertex(v);
        validateVertex(w);
        adj[v].add(e);
        indegree[w]++;
        E++;
    }



    public Iterable<DirectedEdge> adj(int v) {
        validateVertex(v);
        return adj[v];
    }


    public int outdegree(int v) {
        validateVertex(v);
        return adj[v].size();
    }


    public int indegree(int v) {
        validateVertex(v);
        return indegree[v];
    }


    public Iterable<DirectedEdge> edges() {
        Bag<DirectedEdge> list = new Bag<DirectedEdge>();
        for (int v = 0; v < V; v++) {
            for (DirectedEdge e : adj(v)) {
                list.add(e);
            }
        }
        return list;
    }


    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(V + " " + E + NEWLINE);
        for (int v = 0; v < V; v++) {
            s.append(v + ": ");
            for (DirectedEdge e : adj[v]) {
                s.append(e + "  ");
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }

}