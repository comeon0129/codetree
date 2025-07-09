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
       
       pq.add(arr.get(n-1));
       
       int sum = arr.get(n-1);
       
       for(int k=n-2; k>0; k--) {
    	   
    	   pq.add(arr.get(k));
    	   sum+= arr.get(k);
    	   
    	   sum-=pq.peek();
    	   ans = Math.max(ans, (double)sum / (pq.size()-1));
    	   sum+=pq.peek();
       }
        
       System.out.printf("%.2f",ans);
        sc.close();
    }
}