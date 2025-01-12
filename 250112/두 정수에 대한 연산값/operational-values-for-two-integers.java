import java.util.Scanner;

class IntWrapper{
	int value;
	
	public IntWrapper(int value) {
		this.value = value;
		// TODO Auto-generated constructor stub
	}
}


public class Main {
	public static void modify(IntWrapper n, IntWrapper m) {
		if(n.value > m.value) {
			n.value+=25;
			m.value*=2;
		}
		else {
			n.value*=2;
			m.value+=25;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a= sc.nextInt();
		int b= sc.nextInt();
		IntWrapper n = new IntWrapper(a);
		IntWrapper m = new IntWrapper(b);
		modify(n,m);
		System.out.println(n.value+" "+m.value);
		
		sc.close();
    }
}