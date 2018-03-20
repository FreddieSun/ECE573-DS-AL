import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("3.txt"));
        String line;
        MyBST bst = new MyBST();

        while ((line = br.readLine()) != null) {
            bst.insert(Integer.parseInt(line));
        }



        System.out.println("the value of select(7) is: " + bst.select(7));
        System.out.println("the value of rank(7) is:  " + bst.rank(7));
    }
}
