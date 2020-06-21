package com.xkzhai.genericArray;

public class Student {
	private String stuName;
	private int score;
	
	public Student(String stuName,int score) {
		this.stuName = stuName;
		this.score = score;
	}
	
	@Override
	public String toString() {
		return String.format("Student(Name: %s , Score: %d )", stuName,score);
	}
	
	public static void main(String[] args) {
		GenericArray<Student> students = new GenericArray<Student>();
		students.addLast(new Student("Alice", 100));
		students.addLast(new Student("Bob", 69));
		students.addLast(new Student("Tom", 80));
		System.out.println(students);
		// Array: size = 3, capacity = 10 
		// [Student(Name: Alice , Score: 100 ),Student(Name: Bob , Score: 69 ),Student(Name: Tom , Score: 80 )]
		
	}
}
