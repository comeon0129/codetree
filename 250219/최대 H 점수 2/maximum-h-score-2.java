import java.util.Scanner;

public class Main {
	
	public static int n,l;
	
	public static int[] arr = new int[100];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		l = sc.nextInt();
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		int maxH = 0;
		
		for(int i=n; i>=0; i--) {
			int cnt =0;
			int lcnt = 0;
			for(int j=0; j<n; j++) {
				if(arr[j] >=i)
					cnt++;
				else if(arr[j] +1 == i) {
					lcnt++;
				}
			}
			if(cnt >= i || (cnt+lcnt >=i && lcnt <=l))
				maxH = Math.max(maxH, i);
		}
		
		System.out.println(maxH);
		
		sc.close();
    }
}