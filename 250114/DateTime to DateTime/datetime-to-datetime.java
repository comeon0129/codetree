import java.util.Scanner;


public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a= sc.nextInt();
		int b= sc.nextInt();
		int c= sc.nextInt();
		
		int t1 = 11 * 24 * 60  +11* 60 + 11;
		int t2 = a * 24 * 60 + b * 60  +c;
		if(t2 < t1) {
			System.out.println(-1);
		}
		else {
			System.out.println(t2-t1);
		}
		
		sc.close();
    }
}