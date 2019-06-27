package com.example.aspects;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TxnAspect {
	
	@Before("execution(boolean transfer(..))")
	public void before() {
		System.out.println("Txn - begin");
	}
	@AfterReturning(pointcut="execution(boolean transfer(..))",returning="r")
	public void afterReturining(Object r) {
		System.out.println("Txn - commit");
	}
	@AfterThrowing(pointcut="execution(boolean transfer(..))",throwing="e")
	public void afterThrowing(Throwable e) {
		System.out.println("Txn - rollback");
	}
	@After("execution(boolean transfer(..))")
	public void after() {
		System.out.println("Txn - release Txn resources i.e connection");
	}

}
