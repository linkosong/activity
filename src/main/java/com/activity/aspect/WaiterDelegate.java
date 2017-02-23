package com.activity.aspect;
//WaiterDelegate类代理Waiter所有的方法
public class WaiterDelegate {
    private Waiter waiter;
    public void service(String clientName){
        waiter.greetTo(clientName);
        waiter.serveTo(clientName);
    }
    public void setWaiter(Waiter waiter){
        this.waiter = waiter;
    }
}
