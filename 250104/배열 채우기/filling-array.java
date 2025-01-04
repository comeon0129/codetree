import java.util.Scanner;


public class Main {
	
	
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[10];
		for(int i=0; i<10; i++) {
			int num = sc.nextInt();
			if(num == 0)
				break;
			arr[i] = num;
		}
		for(int i=0; i<10; i++) {
			if(arr[9-i] !=0)
				System.out.print(arr[9-i]+" ");
		}
		
		
		sc.close();
	}
		
}