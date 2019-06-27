package com.example.aspects;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class CommonAspect {
	
	@Before("execution(transfer(..))")
	public void before(Joinpoint jp) {
		System.out.println("before"+jp.toString());
	}
	

}
