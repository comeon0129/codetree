import java.util.Scanner;

public class Main {
	
	public static void print(int n, int m) {
		int ans = 0;
		for(int i=1; i<=100; i++) {
			if(n%i==0 && m%i ==0) {
				ans=i;
			}
		}
		System.out.println(ans);
	}
	
	
	
	
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int n = sc.nextInt();
    	int m = sc.nextInt();
    	print(n,m);
    
        sc.close();
    }
}