import java.io.FileNotFoundException;

public class Q2 {
    public static void main(String[] args) throws FileNotFoundException {
        EdgeWeightedGraph ewg = new EdgeWeightedGraph("Q1.txt");

        long start1 = System.currentTimeMillis();

        KruskalMST kmst = new KruskalMST(ewg);

        long end1 = System.currentTimeMillis();

        long start2 = System.currentTimeMillis();
        PrimMST pmst = new PrimMST(ewg);
        long end2 = System.currentTimeMillis();

        System.out.println(end1 - start1);
        System.out.println(end2 - start2);

    }
}
