import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		//이미 세사람이 연속인경우 
		if(Math.abs(b-a) == 1 && Math.abs(c-b) == 1) {
			System.out.println(0);
		}
		else if(Math.abs(b-a) !=1 && Math.abs(c-b) != 1) {
			System.out.println(2);
		}
		else {
			System.out.println(1);
		}
		
		
		sc.close();
    }
}

