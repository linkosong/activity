package com.activity.thread;

public class Account {

	private String accountNo;
	private double balance;
	// 标识账户中是否已有存款的旗标
	private boolean flag = false;
	
	public  int   in = 0 ;

	public Account() {
	}

	public Account(String accountNo, double balance) {
		this.accountNo = accountNo;
		this.balance = balance;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getAccountNo() {
		return this.accountNo;
	}

	public double getBalance() {
		return this.balance;
	}

	// 执行取钱
//	public synchronized void draw(double drawAmount) {
//		try {
//			// 如果flag为假，表明账户中还没有人存钱进去，则取钱方法阻塞
//			if (!flag) {
//				wait();
//			} else {
//				// 执行取钱
//				System.out.println(Thread.currentThread().getName() + " 取钱:" + drawAmount);
//				balance -= drawAmount;
//				System.out.println("账户余额为：" + balance);
//				// 将标识账户是否已有存款的旗标设为false。
//				flag = false;
//				// 唤醒其他线程
//				notifyAll();
//			}
//		} catch (InterruptedException ex) {
//			ex.printStackTrace();
//		}
//	}
	
	
	
	
	public synchronized void draw(double drawAmount)
	 
	 {  
	System.out.println(" 进入 synchronized void draw");
	  
	  try
	  { //如果flag为假，表明账户中还没有人存钱进去，则取钱方法阻塞
	   if (!flag)
	   {//AtomicInteger
	       in++;
	    //将当前线程重命名
	     Thread.currentThread().setName("取钱者AAAAAAAAAAAAAAAAAAA"+" "+in);
	     System.out.println(Thread.currentThread().getName() + 
	      " 阻塞");
	     wait();
	   }
	   else
	   {   
	    //执行取钱
	    System.out.println(Thread.currentThread().getName() + 
	     " 取钱:" +  drawAmount);
	    balance -= drawAmount;
	    System.out.println("取钱成功--------------------取户余额为======================" + balance);
	    //将标识账户是否已有存款的旗标设为false。
	    flag = false;
	    //唤醒其他线程
	    System.out.println("                    ======取款唤醒其他线程                         ");
	    
	    notifyAll();
	   }
	  System.out.println("这人民共和国==========这人民共和国=====这人民共和国");
	  }
	  catch (InterruptedException ex)
	  {
	   ex.printStackTrace();
	  }
	 }
	
	
	
	// 执行存款
	public synchronized void deposit(double depositAmount) {
		try {
			System.out.println(" 进入 synchronized void deposit");
			// 如果flag为真，表明账户中已有人存钱进去，则存钱方法阻塞
			if (flag) {
				wait();
			} else {
				// 执行存款
				System.out.println(Thread.currentThread().getName() + " 存款:" + depositAmount);
				balance += depositAmount;
				System.out.println("账户余额为：" + balance);
				// 将表示账户是否已有存款的旗标设为true
				flag = true;
				// 唤醒其他线程
				notifyAll();
			}
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
	}

	public int hashCode() {
		return accountNo.hashCode();
	}

	public boolean equals(Object obj) {
		if (obj != null && obj.getClass() == Account.class) {
			Account target = (Account) obj;
			return target.getAccountNo().equals(accountNo);
		}
		return false;
	}


}
