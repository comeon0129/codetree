import java.util.Scanner;

public class Main {
	
	public static void plus(int a, int b) {
		System.out.println(a+" + "+b+" = "+(a+b));
	}
	public static void minus(int a, int b) {
		System.out.println(a+" - "+b+" = "+(a-b));
	}
	public static void mult(int a, int b) {
		System.out.println(a+" * "+b+" = "+(a*b));
	}
	public static void divide(int a, int b) {
		System.out.println(a+" / "+b+" = "+(a/b));
	}
	
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int a = sc.nextInt();
    	char c= sc.next().charAt(0);
    	int b = sc.nextInt();
    	if(c == '+') {
    		plus(a,b);
    	}
    	else if(c == '-') {
    		minus(a,b);
    	}
    	else if(c == '*') {
    		mult(a,b);
    	}
    	else if(c == '/') {
    		divide(a,b);
    	}
    	else {
    		System.out.println("False");
    	}
        sc.close();
    }
}