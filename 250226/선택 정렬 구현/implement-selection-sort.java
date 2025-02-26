import java.util.Scanner;

public class Main {
	public static int n;
		
	public static void selectionSort(int[] arr) {
		for(int i=0; i<n-1; i++) {
			int min = i;
			for(int j=i+1; j<n; j++) {
				if(arr[j] < arr[min])
					min = j;
			}
			int temp = arr[i];
			arr[i] = arr[min];
			arr[min] = temp;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n =sc.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		selectionSort(arr);
		for(int i=0; i<n; i++) {
			System.out.print(arr[i]+" ");
		}
		
		sc.close();
	}
}