import java.util.Scanner;

public class Main {
	
	public static int calcMin(int a, int b, int c) {
		int min = 0;
		if(a<b) {
			if(a<c) {
				min = a;
			}
			else {
				min = c;
			}
		}
		else {
			if(b<c) {
				min = b;
			}
			else {
				min = c;
			}
		}
		return min;
	}
	
	
	
	
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int a = sc.nextInt();
    	int b = sc.nextInt();
    	int c = sc.nextInt();
    	int min =calcMin(a,b,c);
    	System.out.println(min);
    
        sc.close();
    }
}
