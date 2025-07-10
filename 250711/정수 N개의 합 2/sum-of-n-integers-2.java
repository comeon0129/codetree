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
        
        
        int ans = Integer.MIN_VALUE;
        for(int i=k; i<=n; i++) {
        	ans = Math.max(ans, prefixSum[i]-prefixSum[i-k]);
        }
        
        System.out.println(ans);
        
        sc.close();
    }
}