import java.util.Scanner;

public class Main {
	public static int n;
		
	public static void mergeSort(int[] arr , int low, int high) {
		if(low>=high) {
			return;
		}
		int mid = (low+high)/2;
		
		mergeSort(arr,low,mid);
		mergeSort(arr,mid+1,high);
		
		
		merge(arr,low,mid,high);
			
	}
	
	public static void merge(int[] arr, int low, int mid, int high) {
		int[] temp = new int[high-low+1];
		int i = low;
		int j= mid+1;
		int idx = 0;
		
		while(i<=mid && j<=high) {
			if(arr[i] <= arr[j]) {
				temp[idx] = arr[i];
				idx++;
				i++;
			}
			else {
				temp[idx] = arr[j];
				idx++;
				j++;
			}
		}
		
		while(i<=mid) {
			temp[idx]= arr[i];
			idx++;
			i++;
		}
		
		while(j<=high) {
			temp[idx] = arr[j];
			idx++;
			j++;
		}
		
		for(int l = low; l<=high; l++) {
			arr[l] = temp[l-low];
		}
		
	}
	
		
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n =sc.nextInt();
		int[] arr = new int[n+1];
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		mergeSort(arr,0,n-1);
		for(int i=0; i<n; i++) {
			System.out.print(arr[i]+" ");
		}
		sc.close();
	}
}