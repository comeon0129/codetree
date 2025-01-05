import java.util.Scanner;


public class Main {
	
	
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int cnt = 0;
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			int num = sc.nextInt();
			if(num % 2 == 0) {
				arr[cnt] = num;
				cnt++;
			}
		}
		for(int i=cnt-1; i>=0; i--) {
			System.out.print(arr[i]+" ");
		}
		sc.close();
	}
		
}
