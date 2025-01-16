import java.util.Scanner;

public class Main {
	
	public static int x1,y1,x2,y2;
	public static int a1,b1,a2,b2;
	
	public static boolean overlapping(int x1, int y1, int x2, int y2, int a1, int b1, int a2, int b2) {
		if(x2 < a1 || a2 < x1 || y2 < b1 || b2 < y1)
			return false;
		return true;
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		x1 = sc.nextInt();
		y1 = sc.nextInt();
		x2 = sc.nextInt();
		y2 = sc.nextInt();
		a1 = sc.nextInt();
		b1 = sc.nextInt();
		a2 = sc.nextInt();
		b2 = sc.nextInt();
		
		if(overlapping(x1, y1, x2, y2, a1, b1, a2, b2)) {
			System.out.println("overlapping");
		}
		else
			System.out.println("nonoverlapping");
		
		sc.close();
    }
}
