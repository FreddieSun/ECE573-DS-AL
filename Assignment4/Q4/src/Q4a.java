import java.io.FileNotFoundException;
import java.text.DecimalFormat;

public class Q4a {
    private static final DecimalFormat DF = new DecimalFormat("0.00");

    public static void main(String[] args) throws FileNotFoundException {


        EdgeWeightedDigraph ewg = new EdgeWeightedDigraph("Q4.txt");
        int s = 0;
        BellmanFordSP bmsp = new BellmanFordSP(ewg, s);

        // print negative cycle
        if (bmsp.hasNegativeCycle()) {
            System.out.println("The negative cycle is: ");
            for (DirectedEdge e : bmsp.negativeCycle())
                System.out.println(e);
        } else {
            // print shortest paths
            for (int v = 0; v < ewg.V(); v++) {
                if (bmsp.hasPathTo(v)) {
                    System.out.print(s + " to " + v + " " + "(" + DF.format(bmsp.distTo(v)) + ") : ");
                    System.out.print("The shortest path is as follows: ");
                    for (DirectedEdge e : bmsp.pathTo(v)) {
                        System.out.print(e + "   ");
                    }
                    System.out.println();
                }
                else {
                    System.out.println(s + " to " + v + " no path");
                }
            }
        }

    }
}
