import java.util.Scanner;

public class Main {
	
	public static final int MAX_N = 100;
	
	public static int a,b;
	public static int c,d;
	
	public static int[] region = new int[MAX_N];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int d = sc.nextInt();
		
		for(int i=a; i<b; i++) {
			region[i] = 1;
		}
		for(int i=c; i<d; i++) {
			region[i] = 1;
		}
		int cnt = 0; 
		for(int i=0; i<region.length; i++) {
			if(region[i] == 1) {
				cnt++;
			}
		}
		System.out.println(cnt);
		
		
		sc.close();
    }
}