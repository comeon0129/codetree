import java.util.Scanner;


public class Main {
	public static int n;
	public static int a1,b1,c1;
	public static int a2,b2,c2;
	
	public static boolean isOpen1(int i, int j, int k) {
		if(Math.abs(i-a1)<= 2 || Math.abs(i-a1)>=n-2) {
			if(Math.abs(j-b1)<= 2 || Math.abs(j-b1)>=n-2) {
				if(Math.abs(k-c1)<= 2 || Math.abs(k-c1)>=n-2) {
					return true;
				}
			}
		}
		return false;
	}
	public static boolean isOpen2(int i, int j, int k) {
		if(Math.abs(i-a2)<= 2 || Math.abs(i-a2)>=n-2) {
			if(Math.abs(j-b2)<= 2 || Math.abs(j-b2)>=n-2) {
				if(Math.abs(k-c2)<= 2 || Math.abs(k-c2)>=n-2) {
					return true;
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		a1 = sc.nextInt();
		b1 = sc.nextInt();
		c1 = sc.nextInt();
		a2 = sc.nextInt();
		b2 = sc.nextInt();
		c2 = sc.nextInt();
		int maxSum = 0;
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				for(int k=1; k<=n; k++) {
					if(isOpen1(i,j,k)){
						maxSum++;
					}
					if(isOpen2(i,j,k)) {
						maxSum++;
					}
					if(isOpen1(i,j,k) && isOpen2(i,j,k)) {
						maxSum--;
					}
				}
			}
		}
		System.out.println(maxSum);
		
		sc.close();
    }
}