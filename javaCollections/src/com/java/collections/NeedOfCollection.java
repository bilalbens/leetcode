package com.java.collections;

public class NeedOfCollection {
	
	public static void  main(String[] arg) {
		
		int a = 1;
		int b = 11;
		int c = 121;
		int d = 42;
		int e = 41;
		int f = 421;

		
		int[] arrayOfInt = new int[10000];
		
		// Limitations of arrays
		//1. Arrays are fixed in size
		//2. Arrays can hold only homogeneous data elements
		
		
		Student[] students = new Student[100];
		students[0] = new Student();	
		students[1] = new Student();	

		
		Object[] objects = new Object[10];
		objects[0] = new Student();
		objects[1] = new Book();
		
		
		//3. ready made APIs support is not available in Arrays

		
	}
	

}



class Book {}

class Student{}