package com.activity.aspect;

import org.springframework.aop.MethodBeforeAdvice;
import java.lang.reflect.Method;
public class GreetingBeforeAdvice implements MethodBeforeAdvice {
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println(o.getClass().getName() + "." + method.getName());
        String clientName = (String) objects[0];
        System.out.println("Hi! Mr." + clientName + ".");
    }
}
