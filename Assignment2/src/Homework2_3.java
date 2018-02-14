
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
		
		
	}

}
