import java.util.Scanner;


public class Main {
	public static int m1, d1;
	public static int m2, d2;
	
	public static String[] week = new String[] {"Mon","Tue","Wed","Thu","Fri","Sat","Sun"};
	public static int[] days = new int[] {0,31,28,31,30,31,30,31,31,30,31,30,31};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		m1= sc.nextInt();
		d1= sc.nextInt();
		
		m2= sc.nextInt();
		d2= sc.nextInt();
		
		
		int week_idx = 0;
		if(m1 < m2 || (m1 == m2 && d1<=d2)) {
			while(true) {
				if(m1==m2 && d1 == d2) {
					break;
				}
				d1++;
				week_idx = (week_idx+1) % 7;
				if(d1>days[m1]) {
					m1++;
					d1=1;
				}
			}
		}
		else {
			while(true) {
				if(m1==m2 && d1 == d2) {
					break;
				}
				d1--;
				week_idx = (week_idx-1+7) % 7;
				if(d1<=0) {
					m1--;
					d1=days[m1];
				}
			}
		}
		
		System.out.println(week[week_idx]);
		
		
		sc.close();
    }
}
