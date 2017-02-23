package com.activity.aspect;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.DynamicMethodMatcherPointcut;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
public class GreetingDynamicPointcut extends DynamicMethodMatcherPointcut {
    private static List<String> specialClientList = new ArrayList<String>();
    static {
        specialClientList.add("John");
        specialClientList.add("Tom");
    }
    public ClassFilter getClassFilter() {
        return new ClassFilter() {
            public boolean matches(Class<?> aClass) {
                System.out.println("调用getClassFilter()对" + aClass.getName() + "做静态检查。");
                return Waiter.class.isAssignableFrom(aClass);
//                return true;
            }
        };
    }
    public boolean matches(Method method, Class clazz) {
        System.out.println("调用matches(method,clazz)" + clazz.getName() + "." + method.getName() + "做静态检查。");
        return "greetTo".equals(method.getName());
    }
    
    
//    Spring动态检查机制：在创建代理时对目标类的每个连接点使用静态切点检查，如果仅通过静态切点检查就可以知道连接点是不匹配的，
//    	则在运行时就不再进行动态检查了；如果静态切点检查时匹配的，在运行时才进行动态切点检查。
    public boolean matches(Method method, Class<?> aClass, Object[] objects) {
        System.out.println("调用matches(method,aClass)" + aClass.getName() + "." + method.getName() + "做动态检查。");
        String clientName = (String)objects[0];
        return specialClientList.contains(clientName);
    }


}
