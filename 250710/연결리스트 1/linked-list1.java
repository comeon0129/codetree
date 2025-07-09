import java.util.Scanner;

class Node{
	String data;
	Node prev,next;
	
	public Node(String data) {
		this.data = data;
		this.prev = this.next = null;
	}
}

public class Main {
	public static void insertNext(Node cur, Node x) {
		x.prev = cur;
		x.next = cur.next;
		
		if(x.prev != null)
			x.prev.next = x;
		
		if(x.next != null)
			x.next.prev = x;
	}
	
	public static void insertPrev(Node cur, Node x) {
		x.prev = cur.prev;
		x.next = cur;
		
		if(x.prev != null)
			x.prev.next = x;
		
		if(x.next != null)
			x.next.prev = x;
	}
	
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String sInit = sc.next();
        int n = sc.nextInt();
        
        Node cur = new Node(sInit);
        
        while(n-->0) {
        	int command = sc.nextInt();
        	
        	if(command == 1) {
        		String sValue = sc.next();
        		Node x = new Node(sValue);
        		insertPrev(cur, x);
        	}
        	else if(command == 2) {
        		String sValue = sc.next();
        		Node x = new Node(sValue);
        		insertNext(cur, x);
        	}
        	else if(command == 3) {
        		if(cur.prev != null)
        			cur = cur.prev;
        	}
        	else if(command == 4) {
        		if(cur.next != null)
        			cur = cur.next;
        	}
        	
        	if(cur.prev == null)
        		System.out.print("(Null) ");
        	else
        		System.out.print(cur.prev.data+" ");
        	
        	System.out.print(cur.data+" ");
        	
        	if(cur.next == null)
        		System.out.print("(Null)");
        	else
        		System.out.println(cur.next.data);
        }
        
        sc.close();
    }
}
