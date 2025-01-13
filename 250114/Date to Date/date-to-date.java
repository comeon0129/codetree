import java.util.Scanner;


public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m1= sc.nextInt();
		int d1= sc.nextInt();
		int m2= sc.nextInt();
		int d2= sc.nextInt();
		
		int month = m1, day = d1;
		int elapsedDays =1;
		
		int[] num_of_days = new int[] {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		while(true) {
			if(month  == m2 &&  day == d2) {
				break;
			}
			elapsedDays++;
			day++;
			
			if(day > num_of_days[month]) {
				month++;
				day = 1;
			}
		}
		System.out.println(elapsedDays);
		
		sc.close();
    }
}
