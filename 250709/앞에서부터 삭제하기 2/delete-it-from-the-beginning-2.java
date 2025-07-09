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
       
       for(int k=1; k<=n-2; k++) {
    	   ArrayList<Integer> temp = new ArrayList<>();
    	   temp.addAll(arr);
    	   for(int i=0; i<k; i++)
    		   temp.remove(0);
    	   
    	   PriorityQueue<Integer> pq = new PriorityQueue<>();
    	   pq.addAll(temp);
    	   
    	   pq.poll();
    	   
    	   int sum = 0;
    	   int size = pq.size();
    	   
    	   while(!pq.isEmpty()) {
    		   sum+=pq.poll();
    	   }   
    	   ans = Math.max(ans, (double)sum/size);
       }
        
       System.out.printf("%.2f",ans);
        sc.close();
    }
}