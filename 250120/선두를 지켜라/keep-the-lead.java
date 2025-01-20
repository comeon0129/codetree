import java.util.Scanner;

public class Main {
	
	static final int MAX_N = 1000000;
	
	static int[] timeA = new int[MAX_N+1];
	static int[] timeB = new int[MAX_N+1];
	
	
	public static void main (String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int totalTimeA = 0;
        int totalTimeB = 0;
        for(int i=1; i<=n; i++) {
        	int v =sc.nextInt();
        	int t = sc.nextInt();
        	for(int j=1+totalTimeA; j<=totalTimeA+t; j++) {
        		timeA[j] = timeA[j-1]+v;
        	}
        	totalTimeA +=t;
        }
        for(int i=1; i<=m; i++) {
        	int v =sc.nextInt();
        	int t = sc.nextInt();
        	for(int j=1+totalTimeB; j<=t+totalTimeB; j++) {
        		timeB[j] = timeB[j-1]+v;
        	}
        	totalTimeB +=t;
        }
        int[] arr = new int[totalTimeA+1];
        for(int i=1; i<=totalTimeA; i++) {
        	if(timeA[i] > timeB[i]) {
        		arr[i] = 1;
        	}
        	else if(timeA[i] < timeB[i]) {
        		arr[i] = -1;
        	}
        	else {
        		arr[i] = arr[i-1];
        	}
        }
        int ans = 0;
        for(int i=1; i<totalTimeA; i++) {
        	if(arr[i] != 0 && arr[i] != arr[i+1]) {
        		ans++;
        	}
        }
        System.out.println(ans);
       
        sc.close();
    }
}
