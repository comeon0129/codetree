import java.util.Scanner;

public class Main {
	public static int n;
		
	public static void insertionSort(int[] arr) {
		for(int i=1; i<n; i++) {
			int j=i-1;
			int key = arr[i];
			while(j>= 0 && arr[j] > key) {
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = key;
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n =sc.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		insertionSort(arr);
		for(int i=0; i<n; i++) {
			System.out.print(arr[i]+" ");
		}
		
		sc.close();
	}
}