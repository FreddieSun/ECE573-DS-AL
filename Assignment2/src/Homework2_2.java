import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.naming.ldap.SortControl;

public class Homework2_2 {
	
	private static int[] aux;
	public static int countKTD(int[] nums) {
		int res=0;
		aux=new int[nums.length];
		res=sort(nums, 0, nums.length-1);
		return res;
	}
	
	// This method sort the aux array and returns the number of inversions
	public static int sort(int[] nums,int lo,int hi) {
		int res=0;
		if(hi>lo) {
			
			// the mid index
			int mid=lo+(hi-lo)/2;
			// sort the left part
			res+=sort(nums, lo, mid);
			// sort the right part
			res+=sort(nums, mid+1,hi);
			// merge the two subarray and return the number of the inversions
			res+=merge(nums, lo, mid, hi);
		}
		
		return res;
	}
	
	// This method sort the sorted array and returns the number of inversions
	public static int merge(int[] nums,int lo,int mid,int hi) {
		int res=0;
		int i=lo,j=mid+1;
		
		for(int k=lo;k<=hi;k++) {
			aux[k]=nums[k];
		}
		for(int k=lo;k<=hi;k++) {
			if(i>mid)
				nums[k]=aux[j++];
			else if(j>hi)
				nums[k]=aux[i++];
			else if(aux[i]<aux[j]) {
				nums[k]=aux[i++];
			} else {
				nums[k]=aux[j++];
				res+=mid-i+1;
			}
		}
		
		return res;	
	}
	

	public static void main(String[] args) {
		try {
			int[] result=new int[12];
			int[] invNum=new int[12];
			String[] fileName= {"data0.1024","data0.2048","data0.4096","data0.8192","data0.16384","data0.32768",
					"data1.1024","data1.2048","data1.4096","data1.8192","data1.16384","data1.32768"};
			for(int i=0;i<5;i++) {
				for(int k=0;k<fileName.length;k++) {
					// read the data from the file
					File file=new File(fileName[k]);
					FileReader fileReader = new FileReader(file);
					
					int size=Integer.valueOf(fileName[k].substring(6,fileName[k].length()));
					int[] array=new int[size];
					BufferedReader bufferedReader = new BufferedReader(fileReader);
					String line;
					int index=0;
					// to store the data in the file into a array
					while ((line = bufferedReader.readLine()) != null) {
						array[index]=Integer.valueOf(line);
						index++;
					}
					
					fileReader.close();

					long startTime=System.nanoTime();
					int num=countKTD(array);
					long endTime=System.nanoTime();
					
					result[k]+=(endTime-startTime);
					invNum[k]+=num;
					// output the result and the running time
//					System.out.println(num+" inversions in the dataset: "+fileName[k]);
//					System.out.println("Running time is: "+String.valueOf((endTime-startTime)/100)+" μs");
//					System.out.println();
				}

			}
			for(int i=0;i<12;i++) {
				System.out.println(String.valueOf(invNum[i]/5) +" inversions in the dataset: ");
				System.out.println("Running time is: "+String.valueOf(result[i]/1000)+" μs");
				System.out.println();
			}

		}catch(IOException e) {
			e.printStackTrace();
		}
//		 int arr[] = new int[]{1, 5, 4, 8, 10,2,6,9,3,7};
//	     System.out.println("Number of inversions are " + countKTD(arr));

	}

}
