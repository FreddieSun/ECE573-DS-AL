import java.io.BufferedReader;
import java.io.*;


public class FarthestPair {
	
	public static double[] getFarthestPair(double[] array) {
		// declare the array to store the result
		double[] res=new double[2];
		int size=array.length;
		double min=array[0];
		double max=array[0];
		// loop through the array and find the minimum and the maximum
		for(int i=0;i<size;i++) {
			if(array[i]<min)
				min=array[i];
			if(array[i]>max)
				max=array[i];
		}
		res[0]=min;
		res[1]=max;
		return res;
	}
	public static void main(String[] args) {
		try {
			// write a loop to read each test data.
			int[] fileName= {8,32,128,512,1024,4096,4192,8192};
			for(int k=0;k<8;k++) {
				// read the data from the file
				File file=new File(String.valueOf(fileName[k])+"int.txt");
				FileReader fileReader = new FileReader(file);
				double[] array=new double[fileName[k]];
				BufferedReader bufferedReader = new BufferedReader(fileReader);
				String line;
				int i=0;
				// to store the data in the file into a array
				while ((line = bufferedReader.readLine()) != null) {
					array[i]=Double.valueOf(line);
					i++;
				}
				fileReader.close();
				long startTime=System.nanoTime();
				// try to find the farthest pair and calculate the running time.
				double[] result=FarthestPair.getFarthestPair(array);
				long endTime=System.nanoTime();
				// output the running time and the result.
				System.out.println("Time cost is"+String.valueOf((endTime-startTime)/100));
				for(int j=0;j<2;j++)
					System.out.println(result[j]);
			}
			
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		
	}
}
