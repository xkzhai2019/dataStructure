import java.util.HashSet;
import java.util.HashMap;

public class Main2 {
	
	public static void main(String[] args) {
		int a = 300;
		System.out.println(((Integer)a).hashCode()); // 300
		
		int b = -42;
		System.out.println(((Integer)b).hashCode()); // -42
		
		double c = 3.1415926;
		System.out.println(((Double)c).hashCode()); // 219937201
		
		String d = "xkzhai2020";
		System.out.println(d.hashCode()); // 625216965
		
		Student s1 = new Student(3,2,"xk","zhai");
		System.out.println(s1.hashCode()); // 865113938
		System.out.println(new Student(3,2,"xk","ZHAI").hashCode()); // 1442407170
		
		HashSet<Student> set = new HashSet<>();
		set.add(s1);
		
		HashMap<Student,Integer> scores = new HashMap<>();
		scores.put(s1, 100);
		
		Student s2 = new Student(3,2,"xk","zhai");
		System.out.println(s2.hashCode()); // 1028566121
	}
}
