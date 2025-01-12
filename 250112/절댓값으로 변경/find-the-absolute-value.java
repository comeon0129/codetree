import java.util.Scanner;

//class IntWrapper{
//	int value;
//	
//	public IntWrapper(int value) {
//		this.value = value;
//		// TODO Auto-generated constructor stub
//	}
//}


public class Main {
	public static void absolute(int[] arr) {
		for(int i=0; i<arr.length; i++) {
			arr[i] =Math.abs(arr[i]);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n= sc.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		absolute(arr);
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		
		sc.close();
    }
}