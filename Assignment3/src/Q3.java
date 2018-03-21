import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Q3 {
    public static void main(String[] args) {
        int[] nList = {10000, 100000, 1000000};
        double[] res = new double[3];
        for (int j = 0; j < 50; j++) {
            for (int k = 0; k < nList.length; k++) {
                // generate an array (size 256) which contains random number from 1 - 256
                // generate an ordered array from 1 - 256
                int N = nList[k];
                int[] input = new int[N];
                for (int i = 0; i < N; i++) {
                    input[i] = i + 1;
                }

                //shuffleArray(input);

                RedBlackBST<Integer, Integer> rbBST = new RedBlackBST<>();

                // insert the node into the corresponding BST
                for (int i = 0; i < N; i++) {
                    rbBST.put(input[i], 1);

                }

                res[k] += rbBST.countRedPercentage() * 100;
            }
        }
        for (int i = 0; i < 3; i++) {
            System.out.println("The percentage of red nodes after " + nList[i] + "-increasing insertions is: " + res[i] / 50 +"%");
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
