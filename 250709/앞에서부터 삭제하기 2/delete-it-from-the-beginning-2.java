import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static int n;
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
  
        ArrayList<Integer> arr = new ArrayList<>();
        
        for(int i=0; i<n; i++){
    	   int x = sc.nextInt();
    	   arr.add(x);
       }
       double ans = -1;
       
       PriorityQueue<Integer> pq = new PriorityQueue<>();
 
       for(int k=1; k<=n-2; k++) {
    	   int sum = 0;
    	   for(int j=k; j<arr.size(); j++) {
    		   pq.add(arr.get(j));
    		   sum+= arr.get(j);
    	   }
    	   
    	   sum -= pq.poll();
    	   int size = pq.size();
    	   
    	   ans = Math.max(ans, (double)sum/size);
    	   pq.clear();
       }
        
       System.out.printf("%.2f",ans);
        sc.close();
    }
}