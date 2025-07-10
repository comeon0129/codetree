import java.util.Scanner;


public class Main {
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr =new int[n+1];
        
        for(int i=1; i<=n; i++){
        	arr[i] = sc.nextInt();
        }
        
        int[] prefixSum = new int[n+1];
        
        prefixSum[0] = 0;
        
        for(int i=1; i<=n; i++)
        	prefixSum[i] = prefixSum[i-1] + arr[i];
        
       int cnt = 0; 
       
       for(int i=1; i<=n; i++) { //i: 구간의 크기
    	   
    	   for(int j=i; j<=n; j++) {
    		   int temp = prefixSum[j] - prefixSum[j-i];
    		   if(temp == k)
    			   cnt++;
    	   }
       }
       System.out.println(cnt);
       
        
        sc.close();
    }
}