package com.huzaifa;

import com.huzaifa.demo.GreetingService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
       ApplicationContext context = new ClassPathXmlApplicationContext("applicationBeanContext.xml");
       GreetingService greetingService = (GreetingService) context.getBean("myBean");
       greetingService.sayHello();
    }
}
