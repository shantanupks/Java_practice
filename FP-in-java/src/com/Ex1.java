package com;

import java.time.LocalDate;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;




public class Ex1 {
	public static void main(String[] args) {
		

	Function<String, Integer> function1 = s->{
		int i=s.length();
		return i;
	};
	
	
	
	Function<Function<String, Integer>, Function<String, Integer>> logWrapper = inpFunc->{
		return s->{
			System.out.println("Before LOG");
			int r = inpFunc.apply(s);
			System.out.println("After LOG");
			return r;
		};
	};
	
	Function<String, Integer> fun1WithLog = logWrapper.apply(function1);
	
	int result = fun1WithLog.apply("123");
	
	System.out.println(result);
	
	
	//function 2
	String str =null;
	Objects.requireNonNull(str, ()->"is null"+getTime() );
	//Objects.requireNonNull(str, "sdsd"+getTime());
	System.out.println("allwell");
	
	}
	
	
	

	private static String getTime() {
		// TODO Auto-generated method stub
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return LocalDate.now().toString();
	}

	

}
