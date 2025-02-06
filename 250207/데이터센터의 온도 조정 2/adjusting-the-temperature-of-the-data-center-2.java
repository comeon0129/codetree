import java.util.Scanner;

public class Main {
	public static final int MAX_N = 1000;
	
	public static int n,c,g,h;
	
	public static int[] ta = new int[MAX_N];
	public static int[] tb = new int[MAX_N];
	
	
	public static int getWorkLoad(int ta, int tb, int temp) {
		if(temp < ta) {
			return c;
		}
		else if(temp >=ta && temp <=tb) {
			return g;
		}
		else {
			return h;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();   // 장비의 개수
		c = sc.nextInt();   // 장비들의 작업량1
		g = sc.nextInt();   // 장비들의 작업량2
		h = sc.nextInt();   // 장비들의 작업량3
		
		for(int i=0; i<n; i++) {
			ta[i] = sc.nextInt();
			tb[i] = sc.nextInt();	 
		}
		int ans = Integer.MIN_VALUE;
		for(int i=0; i<=1000; i++) {
			int temp = i;
			int workLoad = 0;
			for(int j=0; j<n; j++) {
				workLoad+=getWorkLoad(ta[j],tb[j],temp);
			}
			ans = Math.max(ans, workLoad);
		}
		System.out.println(ans);
		
		sc.close();
    }
}