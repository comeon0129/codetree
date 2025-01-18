import java.util.Scanner;
import java.util.Arrays;

class Student implements Comparable<Student> {
	int h, w, n;
	
	public Student(int h, int w, int n) {
		this.h = h;
		this.w = w;
		this.n = n;
	}
	
	@Override
	public int compareTo(Student o) {
		if(this.h == o.h) {
			return o.w - this.w;
		}
		return this.h - o.h;
	}
	
}


public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Student[] students = new Student[n];
		for(int i=0; i<n; i++) {
			int height = sc.nextInt();
			int weight = sc.nextInt();
			students[i] = new Student(height,weight,i+1);
		}
		Arrays.sort(students);
		for(int i=0; i<n; i++) {
			System.out.print(students[i].h+" ");
			System.out.print(students[i].w+" ");
			System.out.println(students[i].n+" ");
		}
	
		sc.close();
    }
}