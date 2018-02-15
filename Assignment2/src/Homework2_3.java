import java.util.Arrays;
import java.util.Collections;

public class Homework2_3 {

	public static void main(String[] args) {
		int[] nums=new int[8192];
		// generate the dataset
		for(int i=0;i<8192;i++) {
			if(i<1024)
				nums[i]=1;
			else if(i>=1024&&i<1024+2048) 
				nums[i]=11;
			else if(i>=1024+2048&&i<1024+2048+4096)
				nums[i]=111;
			else if(i>=1024+2048+4096&&i<1024+2048+4096+1024)
				nums[i]=1111;
		}
		
		countingSort(nums);
		
		for(int i=0;i<nums.length;i++)
			System.out.println(nums[i]);
	}

	private static int getMax(int[] arr) {  
	    int max = 0;  
	    for (int ele : arr) {  
	        if (ele > max) {  
	            max = ele;  
	        }  
	    }  
	    return max;  
	}  
	
	public static void countingSort(int[] nums) {
		int size=nums.length;
		int max=getMax(nums);
		
		int[] count=new int[max+1];
		int[] res=new int[size];
		
		for(int i=0;i<size;i++) {
			++count[nums[i]];
		}
		
		for(int i=1;i<max+1;i++)
			count[i]+=count[i-1];
		
		for(int i=0;i<size;i++) {
			res[count[nums[i]]-1]=nums[i];
			--count[nums[i]];
		}
		
		for(int i=0;i<size;i++)
			nums[i]=res[i];
	}
}
