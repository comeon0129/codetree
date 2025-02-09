import java.util.Scanner;

public class Main {
	public static final int MAX_N = 100;
	
	public static int n;
	
	public static int[] x = new int[MAX_N];
	public static int[] y = new int[MAX_N];
	
	public static boolean isRightTriangle(int x1, int y1, int x2, int y2, int x3, int y3) {
		if((x1== x2) || (x1 == x3) || (x2 == x3)) {
			if((y1==y2) || (y1 == y3) || (y2== y3)) {
				return true;
			}
		}
		return false;
	}
	
	public static int calcArea(int x1, int y1, int x2, int y2, int x3, int y3) {
		if(x1 == x2) {
			return Math.abs((x3-x1)*(y2-y1));
		}
		else if(x1 == x3) {
			return Math.abs((x2-x1)*(y3-y1));
		}
		else {
			return Math.abs((x1-x2)*(y3-y2));
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		for(int i=0; i<n; i++) {
			x[i] = sc.nextInt();
			y[i] = sc.nextInt();
		}
		int maxArea = 0;
		for(int i=0; i<n; i++) {
			for(int j=i+1; j<n; j++) {
				for(int k=j+1; k<n; k++) {
					int x1 = x[i], y1= y[i];
					int x2 = x[j], y2 = y[j];
					int x3 = x[k], y3 = y[k];
					if(isRightTriangle(x1,y1,x2,y2,x3,y3)) {
						int area = calcArea(x1,y1,x2,y2,x3,y3);
						maxArea = Math.max(maxArea, area);
					}
				}
			}
		}
		System.out.println(maxArea);
		
		
		sc.close();
    }
}

