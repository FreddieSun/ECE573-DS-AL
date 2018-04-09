import java.io.FileNotFoundException;

public class Q1 {
    public static void main(String[] args) throws FileNotFoundException {
        // 读入
        EdgeWeightedGraph ewg = new EdgeWeightedGraph("Q1.txt");

        boolean isAcyclic;
        Cycle cycle = new Cycle(ewg);

        isAcyclic = cycle.isAcyclic();

        if (isAcyclic)
            System.out.println("This graph is acyclic");
        else
            System.out.println("This graph is not acyclic");
    }
}
