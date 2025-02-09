import java.util.Scanner;

public class Main {
	
	public static final int MAX_N = 40000;
	public static int n;
	
	public static int[][] point = new int [100][100];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		for(int i=0; i<n; i++) {
			point[i][0] = sc.nextInt();
			point[i][1] = sc.nextInt();
		}
		int minArea = Integer.MAX_VALUE;
		for(int i=0; i<n; i++) {
			int minX = Integer.MAX_VALUE;
			int maxX = Integer.MIN_VALUE;
			int minY = Integer.MAX_VALUE;
			int maxY = Integer.MIN_VALUE;
			for(int j=0; j<n; j++) {
				if(j==i)
					continue;
				int x = point[j][0];
				int y = point[j][1];
				minX = Math.min(minX, x);
				maxX = Math.max(maxX, x);
				minY = Math.min(minY, y);
				maxY = Math.max(maxY, y);
			}
			int area = (maxX - minX) * (maxY - minY);
			minArea = Math.min(area, minArea);
		}
		System.out.println(minArea);
		
		
		sc.close();
    }
}
