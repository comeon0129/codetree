import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	public static int n;
		
	public static ArrayList<Integer> radixSort(ArrayList<Integer> arr, int k) {
		for(int pos = k-1; pos>=0; pos--) {
			ArrayList<Integer>[] arr_new = new ArrayList[10];
			for(int i=0; i<10; i++) {
				arr_new[i] = new ArrayList<Integer>();
			}
			
			for(int i=0; i<arr.size(); i++) {
				int a = 1000000;
				for(int j = 0; j<pos; j++) {
					a/=10;
				}
				int b = a/10;
				int digit = (arr.get(i) % a) / b;
				arr_new[digit].add(arr.get(i));
			}
			
			ArrayList<Integer> storeArr = new ArrayList<Integer>();
			for(int i=0; i<10; i++) {
				for(int j=0; j<arr_new[i].size(); j++) {
					storeArr.add(arr_new[i].get(j));
				}
			}
			arr = storeArr;
		}
		return arr;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n =sc.nextInt();
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for(int i=0; i<n; i++) {
			int num = sc.nextInt();
			arr.add(num);
		}
		arr =radixSort(arr,6);
		for(int i=0; i<n; i++) {
			System.out.print(arr.get(i)+" ");
		}
		
		sc.close();
	}
}