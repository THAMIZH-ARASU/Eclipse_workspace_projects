package com.coreJava.Synchronization;

public class AccountThread extends Thread{
	
	private Account acc;
	private int amt;
	
	public AccountThread(Account acc, int amt) {
		super();
		this.acc = acc;
		this.amt = amt;
	}
	
	@Override public void run() {
		/*
		 * Using Synchronized Block - withdraw( is non synchronized
		 * synchronized(acc)
		 * {
		 * 		acc.wihtdraw(amt);
		 * } 
		*/
		try {
			acc.withdraw(amt);
		}catch(InsufficientBalanceException e) {
			System.out.println(e.getMessage());
		}
	}
}
