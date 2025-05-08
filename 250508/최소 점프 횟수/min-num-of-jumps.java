import java.util.Scanner;

public class Main {
	public static int n;
	
	public static int[] arr = new int[10];
	
	public static int ans = Integer.MAX_VALUE;
	
	public static boolean isPossible = false;
	
	public static void findMin(int index, int cnt) {
		if(index == n-1) {
			isPossible = true;
			ans = Math.min(ans, cnt);
			return;
		}
		
		for(int i=1; i<=arr[index]; i++) {
			if(index+i >=n)
				continue;
			findMin(index+i,cnt+1);
		}
		
	}
	
	
	public static void main (String args[]) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        
        for(int i=0; i<n; i++) {
        	arr[i] = sc.nextInt();
        }
        
        findMin(0,0);
        if(!isPossible) {
        	System.out.println(-1);
        }
        else {
        	System.out.println(ans);
        }
        
        sc.close();
    }
}