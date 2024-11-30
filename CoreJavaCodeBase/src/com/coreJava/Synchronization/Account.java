package com.coreJava.Synchronization;

public class Account implements Bank{
	private int accNo;
	private String Name;
	private double balance;
	
	public Account(int accNo, String name, double balance) {
		super();
		this.accNo = accNo;
		Name = name;
		this.balance = balance;
	}
	
	public Account() {
		super();
	}
	
	public int getAccNo() {
		return accNo;
	}
	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	@Override
	public String toString() {
		return "Account [accNo=" + accNo + ", Name=" + Name + ", balance=" + balance + "]";
	}
	
	@Override
	public synchronized void deposit(int amt) throws DepositLimitExceedsException{
		if (amt > DAILY_LIMIT) {
			throw new DepositLimitExceedsException("Daily limit exceeds...");
		}else {
			balance += amt;
			System.out.println("Amount Deposited..." + amt);
		}
	}
	
	/*
	 * non - synchronized method
	 * 
	 * @Override public void withdraw(int amt){
	 * 		balance = balance - amt;
	 * 		System.out.println("Balance: " + balance);
	 */

	@Override
	public void withdraw(int amt) throws InsufficientBalanceException {
		// TODO Auto-generated method stub
		if(balance - amt < MINBAL)
			throw new InsufficientBalanceException();
		else {
			balance = balance - amt;
			System.out.println("After withdrawing Rs." + amt + "\nCurrent Balance : Rs." + balance);
		}
	}
}
