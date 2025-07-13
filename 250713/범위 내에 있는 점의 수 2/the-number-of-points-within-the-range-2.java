import java.util.Scanner;


public class Main {
	public static int n,q;
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); //점의 개수
        q = sc.nextInt(); //주어지는 범위의 개수
        
        int[] points = new int[n];
        
        for(int i=0; i<n; i++)
        	points[i] = sc.nextInt();
        
        while(q-->0) {
        	int a = sc.nextInt();
        	int b = sc.nextInt();
        	
        	int ans = 0;
        	
        	for(int i=0; i<n; i++) {
        		if(points[i] >= a && points[i]<=b)
        			ans++;
        	}
        	
        	System.out.println(ans);
        	
        }
        
        
        sc.close();
    }
}
