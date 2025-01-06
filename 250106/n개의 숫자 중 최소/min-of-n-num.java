import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
       final int INT_MAX = Integer.MAX_VALUE;
       
       int minVal = INT_MAX;
       
       int n = sc.nextInt();
       int[] arr = new int[n];
       int cnt =0;
       
       for(int i=0; i<n; i++) {
    	   int num = sc.nextInt();
    	   arr[i] = num;
    	   if(num<minVal) {
    		   minVal = num;
    	   }
       }
       
       for(int i=0; i<n; i++) {
    	   if(arr[i] == minVal) {
    		   cnt++;
    	   }
       }
       System.out.print(minVal+" "+cnt);
       
        sc.close();
    }
}