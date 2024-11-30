package com.coreJava.interThreadCommunication;

public class Producer extends Thread{
	Q obj;
	
	public Producer(Q obj) {
		this.obj = obj;
		this.start();
	}
	
	public void run() {
		int i = 0;
		while(true) {
			try {
				Thread.sleep(3000);
			}catch(Exception e) {
				System.out.println(e);
			}
			obj.put(i);
			i++;
		}
	}
}
