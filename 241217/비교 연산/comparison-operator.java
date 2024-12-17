import java.util.Scanner;

public class Main {
	
	public static void trueCase() {
		System.out.println(1);
	}
	public static void falseCase() {
		System.out.println(0);
	}
	
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		if(a>=b) {
			Main.trueCase();
		}
		else {
			Main.falseCase();
		}
		if(a>b) {
			Main.trueCase();
		}
		else {
			Main.falseCase();
		}
		if(a<=b) {
			Main.trueCase();
		}
		else {
			Main.falseCase();
		}
		if(a<b) {
			Main.trueCase();
		}
		else {
			Main.falseCase();
		}
		if(a==b) {
			Main.trueCase();
		}
		else {
			Main.falseCase();
		}
		if(a!=b) {
			Main.trueCase();
		}
		else {
			Main.falseCase();
		}
	}
}