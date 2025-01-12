import java.util.Scanner;

class IntWrapper {
	int value;
	
	public IntWrapper(int  value) {
		this.value = value;
	}
}

public class Main {
	public static void swap(IntWrapper n, IntWrapper m) {
		int temp = n.value;
		n.value = m.value;
		m.value = temp;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		IntWrapper n = new IntWrapper(num1);
		IntWrapper m = new IntWrapper(num2);
		
		swap(n,m);
		
		System.out.println(n.value+" "+m.value);
		
    }
}