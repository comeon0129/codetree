import java.util.Scanner;

public class Main {
	public static int n;
	
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		return;
		
	}
	
	public static int partition(int[] arr, int low, int high) {
		int pivot = arr[high];
		int i = low-1; // 파란색 화살표의 위치
		
		for(int j= low; j<=high-1; j++) { //빨간색 화살표의 움직임
			if(arr[j] < pivot) {
				i+=1;
				swap(arr,i,j);
			}
		}
		swap(arr,i+1,high);
		return i+1;
	}
	
	public static void quickSort(int[] arr , int low, int high) {
		if(low >= high) 
			return;
		int pos = partition(arr, low, high);
	
		quickSort(arr, low, pos-1);
		quickSort(arr, pos+1, high);
	}
		
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n =sc.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		quickSort(arr,0,n-1);
		for(int i=0; i<n; i++) {
			System.out.print(arr[i]+" ");
		}
		sc.close();
	}
}
