import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.io.*;

public class Faster3sum {
	public static int findFaster3sum(int[] nums) {
		int res=0;
		// if the array is null or size is under 3. Directly return.
		if(nums==null||nums.length<3)
			return res;
		for(int i=0;i<nums.length-2;i++) {
			// to skip the duplicate 
			if(i>0&&nums[i]==nums[i-1]) {
				continue;
			}
			// set the pointers
			int left=i+1,right=nums.length-1;
			int val=-nums[i];
			// loop through the array
			while(left<right) {
				if(nums[left]+nums[right]==val) {
					res++;
					// to skip the duplicate
					while(left<right&&nums[left]==nums[left+1])
						left++;
					while(left<right&&nums[right-1]==nums[right])
						right--;
					left++;
					right--;
				}else if(nums[left]+nums[right]<val) {
					// to skip the duplicate
					while(left<right&&nums[left]==nums[left+1])
						left++;
					left++;
				}else {
					// to skip the duplicate
					while(left<right&&nums[right]==nums[right-1])
						right--;
					right--;
				}
			}
		}
		return res;
	}
	
	public static int hashFaster3Sum(int[] nums) {
		int res=0;
		// declare the hashmap
		Map<Integer,Integer> map=new HashMap<Integer,Integer>();
		for(int i=0;i<nums.length;i++) {
			map.clear();
			// to skip the duplicate. If I comment this row. 
			// It will go to the worst case and performe as a quadratic algorithm
			if(i==0||nums[i-1]<nums[i]) {
				for(int j=i+1;j<nums.length;j++) {
					if(map.containsKey(nums[j]+nums[i])) {
						res++;
						// to skip the duplicate
						while(j<nums.length-1&&nums[i]==nums[i+1])
							j++;
					}else {
						map.put(-nums[i]-nums[j],nums[i]+nums[j] );
					}
				}
			}
			
		}
		return res;
	}
	
	public static void main(String[] args) {
		try {
			// write a loop to read each test data.
			int[] fileName= {8,32,128,512,1024,4096,4192,8192};
			for(int j=0;j<8;j++) 
			{
				File file=new File(String.valueOf(fileName[j])+"int.txt");
				FileReader fileReader = new FileReader(file);
				int[] array=new int[fileName[j]];
				BufferedReader bufferedReader = new BufferedReader(fileReader);
				String line;
				int i=0;
				// read the data from the file
				while ((line = bufferedReader.readLine()) != null) {
					array[i]=Integer.valueOf(line);
					i++;
				}
				int[] array= {-1,-1,0,0,1,1,1};
				Arrays.sort(array);
				//fileReader.close();
				long startTime=System.currentTimeMillis();
				// do the 3 sum algorithm.
				int result=Faster3sum.hashFaster3Sum(array);
				long endTime=System.currentTimeMillis();
				// output the running time and the result.
				System.out.println("Time cost is"+String.valueOf((endTime-startTime)));
				System.out.println(result);
			}
			
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
	}
}
