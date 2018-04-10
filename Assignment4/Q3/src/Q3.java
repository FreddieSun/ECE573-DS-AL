import java.io.FileNotFoundException;

public class Q3 {

    public static void main(String[] args) throws FileNotFoundException {

        EdgeWeightedDigraph ewd = new EdgeWeightedDigraph("Q3.txt");
        int s = 0;
        AcyclicSP sp = new AcyclicSP(ewd, s);
        AcyclicLP lp = new AcyclicLP(ewd, s);

        // find shortest path from s to each other vertex in DAG
        System.out.println("Shortest Path: ");
        for (int v = 0; v < ewd.V(); v++) {
            if (sp.hasPathTo(v)) {
                System.out.println(s + " to " + v + " " + sp.distTo(v));
                System.out.print("The shortest path is as follows: ");
                for (DirectedEdge e : sp.pathTo(v)) {
                    System.out.println(e + "   ");
                }
            } else {
                System.out.println(s + " to " + v + " no path");

            }
        }
        System.out.println();

        System.out.println("Longest Path");
        for (int v = 0; v < ewd.V(); v++) {
            if (lp.hasPathTo(v)) {
                System.out.println(s + " to " + v + " " + lp.distTo(v));
                System.out.print("The Longest path is as follows: ");
                for (DirectedEdge e : lp.pathTo(v)) {
                    System.out.println(e + "   ");
                }
            } else {
                System.out.println(s + " to " + v + " no path");

            }
        }
    }


}
