import java.util.Scanner;
import java.util.Arrays;

class Number {
	int idx, value, ans;
	
	public Number(int idx, int value) {
		this.idx = idx;
		this.value = value;
		this.ans = 0;
	}
}

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Number[] numbers = new Number[n];
		for(int i=0; i<n; i++) {
			int value = sc.nextInt();
			numbers[i] = new Number(i+1,value);
		}
		Arrays.sort(numbers, (a,b)-> a.value - b.value);
		for(int i=0; i<n; i++) {
			numbers[i].ans = i+1;
		}
		Arrays.sort(numbers, (a,b)-> a.idx - b.idx);
		for(int i=0; i<n; i++) {
			System.out.print(numbers[i].ans+" ");
		}
		
		sc.close();
    }
}