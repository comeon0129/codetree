import java.util.Scanner;

public class Main {
	
	public static void print(int a, int b) {
		int mult =1;
		for(int i=0; i<b; i++) {
			mult*=a;
		}
		System.out.println(mult);
	}
	
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int a = sc.nextInt();
    	int b = sc.nextInt();
    	print(a,b);
        sc.close();
    }
}