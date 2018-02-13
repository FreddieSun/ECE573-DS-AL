import java.util.Arrays;
import java.io.*;



public class ThreeSum {
	// the brute search of three sum
	public static int BruteCount(int[] a) {
		int N=a.length;
		int cnt=0;
		for(int i=0;i<N;i++)
			for(int j=i+1;j<N;j++)
				for(int k=j+1;k<N;k++)
					if(a[i]+a[j]+a[k]==0)
						cnt++;
		return cnt;
	}
	

	// using the binarysearch to search for 3 sum pair
	public static int sophisticatedCount(int[] a) {
		Arrays.sort(a);
		int N=a.length;
		int cnt=0;
		for(int i=0;i<N;i++)
			for(int j=i+1;j<N;j++)
				if(Arrays.binarySearch(a, -a[i]-a[j])>j)
					cnt++;
		return cnt;
		
	}
	
	public static void main(String[] args) {
		try {
			// write a loop to read each test data.
			int[] fileName= {8,32,128,512,1024,4096,4192,8192};
			for(int k=0;k<8;k++) {
				// read the data from the file
				File file=new File(String.valueOf(fileName[k])+"int.txt");
				FileReader fileReader = new FileReader(file);
				int[] array=new int[fileName[k]];
				BufferedReader bufferedReader = new BufferedReader(fileReader);
				String line;
				int i=0;
				// to store the data in the file into a array
				while ((line = bufferedReader.readLine()) != null) {
					array[i]=Integer.valueOf(line);
					i++;
				}
				fileReader.close();
				long startTime=System.currentTimeMillis();
				// two ways to calculate
				//int cnt=ThreeSum.sophisticatedCount(array);
				int cnt=ThreeSum.BruteCount(array);
				long endTime=System.currentTimeMillis();
				// output the result and the running time.
				System.out.println("The result is: "+cnt+"triples");
				System.out.println("ThreeSum time cost is: "+(endTime-startTime)+"ms");
			}
			
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		

		
	}
}
