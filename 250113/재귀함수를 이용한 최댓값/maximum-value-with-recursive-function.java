import java.util.Scanner;

public class Main {
	
	public static int calc(int[] arr, int n) {
		
		if(n==1){
			return arr[0];
		}
		if(arr[n-1] > calc(arr,n-1)) {
			return arr[n-1];
		}
		else
			return calc(arr,n-1);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		int max = calc(arr,n);
		System.out.println(max);
	
		sc.close();
    }
}
