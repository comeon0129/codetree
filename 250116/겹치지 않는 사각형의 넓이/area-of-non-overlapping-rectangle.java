import java.util.Scanner;

public class Main {
	
	public static final int MAX_R = 2000;
	public static final int OFFSET = 1000;
	
	
	public static int[][] checked = new int[MAX_R+1][MAX_R+1];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a_x1= sc.nextInt();
		int a_y1= sc.nextInt();
		int a_x2= sc.nextInt();
		int a_y2= sc.nextInt();
		
		
		a_x1+=OFFSET;
		a_y1+=OFFSET;
		a_x2+=OFFSET;
		a_y2+=OFFSET;
		
		for(int x=a_x1; x<a_x2; x++) {
			for(int y =a_y1; y<a_y2; y++) {
				checked[x][y] = 1;
			}
		}
		
		int b_x1= sc.nextInt();
		int b_y1= sc.nextInt();
		int b_x2= sc.nextInt();
		int b_y2= sc.nextInt();
		
		b_x1+=OFFSET;
		b_y1+=OFFSET;
		b_x2+=OFFSET;
		b_y2+=OFFSET;
		
		for(int x=b_x1; x<b_x2; x++) {
			for(int y =b_y1; y<b_y2; y++) {
				checked[x][y] = 1;
			}
		}
		
		int m_x1= sc.nextInt();
		int m_y1= sc.nextInt();
		int m_x2= sc.nextInt();
		int m_y2= sc.nextInt();
		
		
		m_x1+=OFFSET;
		m_y1+=OFFSET;
		m_x2+=OFFSET;
		m_y2+=OFFSET;
		
		
		for(int x=m_x1; x<m_x2; x++) {
			for(int y =m_y1; y<m_y2; y++) {
				checked[x][y] = 0;
			}
		}

		
		int area =0;
		for(int i=0; i<=MAX_R; i++) {
			for(int j=0; j<=MAX_R; j++) {
				if(checked[i][j] == 1) {
					area++;
				}
			}
		}
		System.out.println(area);
				
		sc.close();
    }
}