package com.springinaction.springidol;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IdolMain {

	public static void main(String[] args) {
//		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/springinaction/springidol/spring-idol.xml");
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-idol1.xml");
		String[] list = ctx.getBeanDefinitionNames();
		for (String string : list) {
			System.out.println(string);			
		}
		System.out.println("*******************************");
		Performer performer = (Performer) ctx.getBean("kenny");
		performer.perform();
		System.out.println("*******************************");
		Thinker thinker = (Thinker) ctx.getBean("volunteer");
		thinker.thinkOfSomething("asdfas");
	}

}
