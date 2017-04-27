package com.springinaction.springidol;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Audience {

	@Pointcut("execution(* com.springinaction.springidol.Performer.perform(..))")//("execution(* com.springinaction.springidol.Performer.perform(..))")
	public void performance1(){}
/*	
	@Before("performance1()")
	public void takeSeats() { // Перед выступлением
		System.out.println(">>>>>The audience is taking their seats.");
	}

	@Before("performance1()")
	public void turnOffCellPhones() { // Перед выступлением
		System.out.println(">>>>>The audience is turning off their cellphones");
	}

	@AfterReturning("performance1()")
	public void applaud() { // После выступления
		System.out.println(">>>>>CLAP CLAP CLAP CLAP CLAP");
	}

	@AfterThrowing("performance1()")
	public void demandRefund() { // После неудачного выступления
		System.out.println(">>>>>Boo! We want our money back!");
	}
*/	@Around("performance1()")
	public void watchPerformance(ProceedingJoinPoint joinpoint) {
		try {
			System.out.println("The audience is taking their seats.");
			System.out.println("The audience is turning off their cellphones");
			long start = System.currentTimeMillis(); // Перед выступлением
			joinpoint.proceed(); // Вызов целевого метода
			long end = System.currentTimeMillis(); // После выступления
			System.out.println("CLAP CLAP CLAP CLAP CLAP");
			System.out.println("The performance took " + (end - start) + " milliseconds.");
		} catch (Throwable t) {
			System.out.println("Boo! We want our money back!");
		}
	}
}
