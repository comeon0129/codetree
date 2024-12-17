import java.util.Scanner;

public class Main {
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		double score = sc.nextDouble();
		if(score >= 1.0)
			System.out.println("High");
		else if(score >=0.5)
			System.out.println("Middle");
		else{
			System.out.println("Low");
		}
		sc.close();
	}
}

