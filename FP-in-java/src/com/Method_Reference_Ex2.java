package com;

import java.util.function.BiFunction;
import java.util.function.Function;

class Employee{
	int id;
	String name;
	
	public Employee(int id) {
		super();
		this.id = id;
	}
	public Employee(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	
}

public class Method_Reference_Ex2 {
	public static void main(String[] args) {
		
		BiFunction<Integer, String, Employee> function3 = (i,s)->new Employee(i,s);
		
		
		Function<Integer, Employee> function = i->new Employee(i);
		
		Function<Integer, Employee> function2 = Employee::new;
		
		Employee e1=function2.apply(5);
		System.out.println(e1.id);
		
		
	}

}
