import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] x = new int[4];
		int[] y = new int[4];
		for(int i=0; i<4; i++) {
			x[i] = sc.nextInt();
			y[i] = sc.nextInt();
		}
		int minX = 10;
		int maxX = 0;
		int minY = 10;
		int maxY = 0;
		for(int i=0; i<4; i++) {
			minX = Math.min(minX, x[i]);
			maxX = Math.max(maxX, x[i]);
			minY = Math.min(minY, y[i]);
			maxY = Math.max(maxY, y[i]);
			
		}
		
		int area = (maxX - minX) * (maxY - minY);
		System.out.println(area);
		
		sc.close();
    }
}
