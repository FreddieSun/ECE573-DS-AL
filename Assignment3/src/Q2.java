

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Q2 {
    private static Random rand;

    public static void main(String[] args) {

        int[] nList = {64,128,256,512,1024,2048,4096,8192};
        for (int k = 0; k < nList.length; k++) {
            // generate an array (size 256) which contains random number from 1 - 256
            // generate an ordered array from 1 - 256
            int N = nList[k];
            int[] sortedInput = new int[N];
            int[] randInput = new int[N];
            for (int i = 0; i < N; i++) {
                sortedInput[i] = i + 1;
                randInput[i] = i + 1;
            }

            shuffleArray(randInput);

            MyBST mRandBST = new MyBST();
            MyBST mSortedBST = new MyBST();

            // insert the node into the corresponding BST
            for (int i = 0; i < N; i++) {
                mRandBST.insert(randInput[i]);
                mSortedBST.insert(sortedInput[i]);
            }


        /*



        calculate the average path length
        1. find all the leave node
        2. calculate their depth
        3. calculate the average path length

         */

            System.out.println("The avg path length of BST with " + N + "-random insertions is: " + mRandBST.avgPathLength());
            System.out.println("The avg path length of BST with " + N + "-sorted insertions is: " + mSortedBST.avgPathLength());
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
