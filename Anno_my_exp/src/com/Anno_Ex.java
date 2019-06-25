package com;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


@Target(value = { ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@interface TestMapping{
	String service();
}




//container
class Container{
	@SuppressWarnings("deprecation")
	public void processRequest(String service) {
		try {
			Class<?> clazz = Class.forName("com.Services");
			Object instance1 = clazz.newInstance();
			
			
			Method[] methods = clazz.getMethods();
			
			for(Method method : methods) {
				TestMapping mapping = method.getAnnotation(TestMapping.class);
				if(mapping!=null) {
					String givenService = mapping.service();
					if(service.equals(givenService)) {
						method.invoke(instance1, new Object[] {});
					}
				}
				
			}
			
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
		}
		
	}
}

//developer

class Services{
	@TestMapping(service="show")
	public void showM() {
		System.out.println("showing marks");
	}
	
	@TestMapping(service = "update")
	public void updateM() {
		System.out.println("updating marks");
	}
	
}

public class Anno_Ex {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		// TODO Auto-generated method stub
		
		Container container = new Container();
		container.processRequest("show");
		
		container.processRequest("update");
		

	}


}
