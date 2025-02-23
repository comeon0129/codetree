import java.util.Scanner;
import java.util.LinkedList;

public class Main {
	
	public static int n;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		LinkedList<Integer> l = new LinkedList<>();
		for(int i=0; i<n; i++) {
			String s = sc.next();
			if(s.equals("push_front")) {
				int e = sc.nextInt();
				l.addFirst(e);
			}
			else if(s.equals("push_back")) {
				int e = sc.nextInt();
				l.addLast(e);
			}
			else if(s.equals("pop_front")) {
				System.out.println(l.pollFirst());
			}
			else if(s.equals("pop_back")) {
				System.out.println(l.pollLast());
			}
			else if(s.equals("size")) {
				System.out.println(l.size());
			}
			else if(s.equals("empty")) {
				if(l.isEmpty())
					System.out.println(1);
				else
					System.out.println(0);
			}
			else if(s.equals("front")) {
				System.out.println(l.peekFirst());
			}
			else if(s.equals("back")) {
				System.out.println(l.peekLast());
			}
		}
		
		sc.close();
    }
}