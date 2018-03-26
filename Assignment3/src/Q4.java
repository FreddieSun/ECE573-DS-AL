import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Q4 {
    public static void main(String[] args) {
        int[] nList = new int[100];
        for (int i = 0; i < 100; i++)
            nList[i] = i + 1;

        double[][] res = new double[100][2];

        for (int j = 0; j < 1; j++) {
            for (int k = 0; k < nList.length; k++) {

                int N = nList[k];
                int[] input = new int[N];
                for (int i = 0; i < N; i++) {
                    input[i] = i + 1;
                }

                shuffleArray(input);

                RedBlackBST<Integer, Integer> rbBST = new RedBlackBST<>();

                // insert the node into the corresponding BST
                for (int i = 0; i < N; i++) {
                    rbBST.put(input[i], 1);
                }

                double[] tempRes = rbBST.countInternalPathLength();
                res[k][0] += tempRes[0];
                res[k][1] += tempRes[1];
            }
         }

         for (int i = 0; i < 100; i++) {
            System.out.println("Avg internal path length of " + nList[i] + " random keys is: " + res[i][0]);
            System.out.println("std deviation of avg path length of " + nList[i] + " random keys is: " + res[i][1] );
            System.out.println();

         }
    }


    // shuffle the array
    public static void shuffleArray(int[] ar)
    {
        // If running on Java 6 or older, use `new Random()` on RHS here
        Random rnd = ThreadLocalRandom.current();
        for (int i = ar.length - 1; i > 0; i--)
        {
            int index = rnd.nextInt(i + 1);
            // Simple swap
            int a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }
}
