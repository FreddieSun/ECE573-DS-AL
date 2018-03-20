

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Q2 {
    private static Random rand;

    public static void main(String[] args) {
        // generate an array (size 256) which contains random number from 1 - 256
        // generate an ordered array from 1 - 256
        int[] sortedInput = new int[256];
        int[] randInput = new int[256];
        for (int i = 0; i < 256; i++) {
            sortedInput[i] = i + 1;
            randInput[i] = i + 1;
        }
        shuffleArray(randInput);

        BST<Integer,Integer> randBST = new BST<>();
        BST<Integer,Integer> sortedBST = new BST<>();

        // insert the node into the corresponding BST
        for (int i = 0; i < 256; i++) {
            randBST.put(randInput[i],1);
            sortedBST.put(sortedInput[i], 1);
        }


        /*

        calculate the average path length
        1. find all the leave node
        2. calculate their depth
        3. calculate the average path length

         */
        
        System.out.println("The avg path length of BST with N-random insertions is: " + randBST.avgPathLength());
        System.out.println("The avg path length of BST with N-sorted insertions is: " + sortedBST.avgPathLength());



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
