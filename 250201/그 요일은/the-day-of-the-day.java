import java.util.Scanner;


public class Main {
	public static int m1, d1;
	public static int m2, d2;
	
	public static String[] week = new String[] {"Mon","Tue","Wed","Thu","Fri","Sat","Sun"};
	public static int[] days = new int[] {0,31,29,31,30,31,30,31,31,30,31,30,31};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		m1= sc.nextInt();
		d1= sc.nextInt();
		
		m2= sc.nextInt();
		d2= sc.nextInt();
		String a = sc.next();
		
		int ans = 0;
		int week_idx = 0;
		while(true) {
			if(week[week_idx].equals(a)) {
				ans++;
			}
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
		
		System.out.println(ans);
		
		
		sc.close();
    }
}
