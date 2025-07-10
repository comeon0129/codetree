import java.util.HashMap;
import java.util.Scanner;

class Node{
	int number;
	Node prev,next;
	
	public Node(int number) {
		this.number = number;
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
	
	public static void pop(Node cur) {
		if(cur.prev != null)
			cur.prev.next = cur.next;
		if(cur.next != null)
			cur.next.prev = cur.prev;
		
		cur.prev = cur.next = null;
	}
	
	public static void printNodes(Node cur) {
		if(cur.prev == null)
			System.out.print(0+" ");
		else
			System.out.print(cur.prev.number+" ");
		
		if(cur.next == null)
			System.out.println(0);
		else
			System.out.println(cur.next.number);
	}
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        HashMap<Integer, Node> nodes = new HashMap<>();
        for(int i=1; i<=n; i++) {
        	nodes.put(i,new Node(i));
        }
        
        int q = sc.nextInt();
       
        while(q-->0) {
        	int option = sc.nextInt();
        	
        	int i = sc.nextInt();
        	
        	if(option == 1)
        		pop(nodes.get(i));
        	else if(option == 2) {
        		int j = sc.nextInt();
        		insertPrev(nodes.get(i), nodes.get(j));
        	}
        	else if(option == 3) {
        		int j = sc.nextInt();
        		insertNext(nodes.get(i), nodes.get(j));
        	}
        	else if(option ==4) {
        		printNodes(nodes.get(i));
        	}
        }
        
        for(int i=1; i<=n; i++) {
        	Node cur = nodes.get(i);
        	
        	if(cur.next == null)
        		System.out.print(0+" ");
        	else
        		System.out.print(cur.next.number+" ");
        }
        
        
        sc.close();
    }
}