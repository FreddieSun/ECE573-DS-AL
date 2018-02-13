import java.util.Arrays;
import java.io.*;

public class UnionFind {
	private int[] index;
	private int count;
	
	public UnionFind(int N) {
		// construct
		count=N;
		index=new int[N];
		for(int i=0;i<N;i++) {
			index[i]=i;
		}
	}
	
	public int count() {
		return count;
	}
	
	// return the result if the two node has been connected
	public boolean connected(int p,int q) {
		return find(p)==find(q);
	}
	
	// return the value of the node p
	public int find(int p) {
		return index[p];
	}
	
	// union two nodes
	public void union(int p,int q) {
		int pindex=find(p);
		int qindex=find(q);
		
		if(pindex==qindex)
			return;
		else {
			for(int i=0;i<index.length;i++) {
				if(index[i]==pindex)
					index[i]=qindex;
			}
			count--;
		}
	}
	
	public static void main(String[] args) {
		try {
			// write a loop to read each test data.
			int[] temp1= {8,32,128,512,1024,4096,8192};
			for(int k=0;k<7;k++) {
				int N=8192;
				// read the data from the file
				UnionFind unionFind=new UnionFind(N);
				File file=new File(String.valueOf(temp1[k])+"pair.txt");
				FileReader fileReader=new FileReader(file);
				BufferedReader bufferedReader = new BufferedReader(fileReader);
				String line;
			
				int num=temp1[k];
				int[] arr1=new int[num];
				int[] arr2=new int[num];
				int i=0;
				// to store the data in the file into a array
				while ((line = bufferedReader.readLine()) != null) {
					
					String[] temp=line.split("\\s+",2);
					arr1[i]=Integer.valueOf(temp[0]);
					arr2[i]=Integer.valueOf(temp[1]);
					i++;
				
				}
				
				// do the UF 
				long startTime=System.nanoTime();
				for(int j=0;j<num;j++) {
					if(unionFind.connected(arr1[j], arr2[j]))
						continue;
					unionFind.union(arr1[j], arr2[j]);
				}

				long endTime=System.nanoTime();
				// output the result and the running time.
				System.out.println(unionFind.count()+" Components");
				System.out.println("QuickUnion time cost is: "+(endTime-startTime)/100+"μs");
				bufferedReader.close();
			}
			
		}
		catch(IOException e) {
			e.printStackTrace();
		}

	}
}
