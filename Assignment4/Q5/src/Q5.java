import java.io.FileNotFoundException;

public class Q5 {
    public static void main(String[] args) throws FileNotFoundException {
        EdgeWeightedGraph nyc = new EdgeWeightedGraph("NYC.txt");
        int s = 1;

        //BreadthFirstSearch bfs = new BreadthFirstSearch(nyc, s);
        DepthFirstSearch dfs = new DepthFirstSearch(nyc, s);

    }
}
