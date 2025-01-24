import java.util.Scanner;


public class Main {
	
	public static int n;
	public static int x,y;
	public static int[] xpos = new int[100];
	public static int[] ypos = new int[100];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		for(int i=0; i<n; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			xpos[i] = x;
			ypos[i] = y;
		}
		int min = Integer.MAX_VALUE;
		for(int i=1; i<n-1; i++) {
			int dist = 0;
			for(int j=1; j<n; j++) {
				if(i!=j) {
					dist+=Math.abs(xpos[j]-xpos[j-1])+Math.abs(ypos[j]-ypos[j-1]);
				}
				else {
					dist+=Math.abs(xpos[j-1]-xpos[j+1])+Math.abs(ypos[j-1]-ypos[j+1]);
					j++;
				}
			}
			min= Math.min(dist, min);
		}
		System.out.println(min);
		
		
		sc.close();
    }
}
