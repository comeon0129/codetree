import java.util.Scanner;

public class Main {
	public static int n;
		
	public static void bubbleSort(int[] arr) {
		int len = arr.length;
		for(int i=0; i<len-1; i++) {
			for(int j=0; j<len-1-i; j++) {
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
				
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n =sc.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		bubbleSort(arr);
		for(int i=0; i<n; i++) {
			System.out.print(arr[i]+" ");
		}
		
		sc.close();
	}
}