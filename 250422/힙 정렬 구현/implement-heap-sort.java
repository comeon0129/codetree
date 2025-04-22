import java.util.Scanner;

public class Main {
	public static int n;
	
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		return;
		
	}
	
	public static void heapify(int[] arr, int n, int i) {
		int largest = i;
		int l = i* 2;
		int r = i*2+1;
		
		if(l<=n && arr[l] > arr[largest])
			largest = l;
		if(r<=n && arr[r] > arr[largest])
			largest = r;
		
		if(largest != i) {
			swap(arr,i,largest);
			heapify(arr,n,largest);
		}
	}
	
	public static void heapSort(int[] arr, int n) {
		for(int i = n/2; i>=1; i--) {
			heapify(arr,n,i);
		}
		
		for(int i=n; i>1; i--) {
			swap(arr,1,i);
			heapify(arr,i-1,1);
		}
	}
	
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n =sc.nextInt();
		int[] arr = new int[n+1];
		for(int i=1; i<=n; i++) {
			arr[i] = sc.nextInt();
		}
		heapSort(arr,n);
		for(int i=1; i<=n; i++) {
			System.out.print(arr[i]+" ");
		}
		sc.close();
	}
}