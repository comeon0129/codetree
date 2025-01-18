import java.util.Scanner;
import java.util.Arrays;


class Dot implements Comparable<Dot>{
	int distance, number;
	
	public Dot(int distance, int number) {
		this.distance = distance;
		this.number = number;
	}
	@Override
	public int compareTo(Dot o) {
		if(this.distance == o.distance) {
			return this.number - o.number;
		}
		return this.distance - o.distance;
	}
}

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Dot[] dots = new Dot[n];
		for(int i=0; i<n; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int distance = Math.abs(x-0) + Math.abs(y-0);
			dots[i] = new Dot(distance,i+1);
		}
		Arrays.sort(dots);
		for(int i=0; i<n; i++) {
			System.out.println(dots[i].number);
		}
		sc.close();
    }
}