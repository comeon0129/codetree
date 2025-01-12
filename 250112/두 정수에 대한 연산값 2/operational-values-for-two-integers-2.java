import java.util.Scanner;

class IntWrapper{
	int value;
	
	public IntWrapper(int value) {
		this.value =value;
		// TODO Auto-generated constructor stub
	}
}


public class Main {
	public static void modify(IntWrapper a, IntWrapper b) {
		if(a.value > b.value) {
			a.value *=2;
			b.value +=10;
		}
		else {
			a.value +=10;
			b.value *=2;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		IntWrapper aWrapper = new IntWrapper(a);
		IntWrapper bWrapper = new IntWrapper(b);
		modify(aWrapper, bWrapper);
		System.out.println(aWrapper.value+" "+bWrapper.value);
		sc.close();
    }
}
