import java.util.Arrays;
import java.util.Collections;
import java.util.function.IntPredicate;

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
		//easyCountingSort(nums);
		
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
	
	public static void easyCountingSort(int[] nums) {
		int[] count=new int[4];
		for(int i=0;i<nums.length;i++) {
			switch(nums[i]) {
			default:
				System.out.println("Error");
				break;
			case 1:
				count[0]++;
				break;
			case 11:
				count[1]++;
				break;
			case 111:
				count[2]++;
				break;
			case 1111:
				count[3]++;
				break;
			}
		}
		for(int i=0;i<count[0];i++)
			nums[i]=1;
		for(int i=count[0];i<count[0]+count[1];i++)
			nums[i]=11;
		for(int i=count[0]+count[1];i<count[0]+count[1]+count[2];i++)
			nums[i]=111;
		for(int i=count[0]+count[1]+count[2];i<nums.length;i++)
			nums[i]=1111;
	}
}
