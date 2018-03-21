import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Q4 {
    public static void main(String[] args) {
        int[] nList = new int[10000];
        for (int i = 0; i < 10000; i++)
            nList[i] = i + 1;



        for (int j = 0; j < 1000; j++) {
            for (int k = 0; k < nList.length; k++) {

                int N = nList[k];
                int[] input = new int[N];
                Scanner sc = new Scanner(System.in);
                for (int i = 0; i < N; i++) {
                    input[i] = sc.nextInt();
                }

                shuffleArray(input);

                RedBlackBST<Integer, Integer> rbBST = new RedBlackBST<>();

                // insert the node into the corresponding BST
                for (int i = 0; i < N; i++) {
                    rbBST.put(input[i], 1);

                }

            }
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
