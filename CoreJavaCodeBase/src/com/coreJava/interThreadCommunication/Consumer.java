package com.coreJava.interThreadCommunication;

public class Consumer extends Thread{
	Q obj;
	
	public Consumer(Q obj) {
		this.obj = obj;
		this.start();
	}
	
	public void run() {
	   while (true) {
		   try {
			   Thread.sleep(3000);
		   }catch(Exception e) {
			   System.out.println(e.toString());
		   }
		   obj.get();
	   }
	}	
}
