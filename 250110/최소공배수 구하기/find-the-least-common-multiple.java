import java.util.Scanner;

public class Main {
	
	public static void printLcm(int n, int m) {
		int ans = 0;
		for(int i=n*m; i>=Math.max(n,m); i--) {
			if(i%n==0 && i%m ==0) {
				ans=i;
			}
		}
		System.out.println(ans);
	}
	
	
	
	
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int n = sc.nextInt();
    	int m = sc.nextInt();
    	printLcm(n,m);
    
        sc.close();
    }
}