import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Q4 {

    final static int NUM_OF_TRIAL = 1000;
    final static int RANGE_OF_N = 10000;

    public static void main(String[] args) {
        int[] nList = new int[RANGE_OF_N];
        for (int i = 0; i < RANGE_OF_N; i++)
            nList[i] = i + 1;

        double[] avg = new double[RANGE_OF_N];
        double[] dev = new double[RANGE_OF_N];

        for (int k = 0; k < nList.length; k++) {
            double[] tempAvg = new double[NUM_OF_TRIAL];

            // for every N, test 1000 times. save to the array.
            for (int j = 0; j < NUM_OF_TRIAL; j++) {
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

                double tempRes = rbBST.countInternalPathLength();
                tempAvg[j] = tempRes;
            }

            // 求 N个插入时，平均的AVG
            double sum = 0.0;
            for (int j = 0; j < NUM_OF_TRIAL; j++) {
                sum += tempAvg[j];
            }
            avg[k] = sum / NUM_OF_TRIAL;

            // 求 N个插入时，std dev
            double devSum = 0.0;
            for (int j = 0; j < NUM_OF_TRIAL; j++) {
                double diff = tempAvg[j] - avg[k];
                devSum += Math.pow(diff, 2);
            }
            dev[k] = Math.sqrt(devSum / NUM_OF_TRIAL);

            System.out.println("Avg internal path length of " + nList[k] + " random keys is: " + avg[k]);
            System.out.println("std deviation of avg path length of " + nList[k] + " random keys is: " + dev[k] );
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
