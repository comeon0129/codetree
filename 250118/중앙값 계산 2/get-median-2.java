import java.util.Scanner;
import java.util.Arrays;


public class Main {

	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		for(int i=0; i<n; i+=2) {
			Arrays.sort(arr,0,i+1);
			System.out.print(arr[i/2]+" ");
		}
		
		sc.close();
    }
}