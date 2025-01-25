import java.util.Scanner;


public class Main {
	public static int n;
	public static int[] arr = new int[100];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		int ans = 0;
		for(int i=0; i<n; i++) {
			for(int j=i; j<n; j++) {
				double average = 0;
				int sumVal = 0;
				int cnt =0;
				for(int k=i; k<=j; k++) {
					sumVal+=arr[k];
					cnt++;
				}
				average =(double)sumVal /cnt;
				for(int k=i; k<=j; k++) {
					if(arr[k] == average) {
						ans++;
						break;
					}
				}
			}
		}
		System.out.println(ans);
		sc.close();
    }
}
