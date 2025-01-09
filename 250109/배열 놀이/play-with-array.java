import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int n = sc.nextInt();
    	int q = sc.nextInt();
    	int[] arr = new int[n];
     	for(int i=0; i<n; i++) {
    		arr[i] = sc.nextInt();
    	}
     	for(int i=0; i<q; i++) {
     		int num = sc.nextInt();
     		
     		if(num == 1) {
     			int a =sc.nextInt();
     			System.out.println(arr[a-1]);
     		}
     		else if(num == 2) {
     			int b=sc.nextInt();
     			boolean flag = true;
     			for(int j=0; j<n; j++) {
     				if(arr[j] == b) {
     					System.out.println(j+1);
     					flag = false;
     					break;
     				}
     			}
     			if(flag) {
     				System.out.println(0);
     			}
     			
     		}
     		else if(num == 3) {
     			int s =sc.nextInt();
     			int e = sc.nextInt();
     			for(int j=s-1; j<e; j++) {
     				System.out.print(arr[j]+" ");
     			}
     			System.out.println();
     			
     		}
     	}
    	

        sc.close();
    }
}