package com.coreJava.Synchronization;

public abstract interface Bank {
	static final int MINBAL = 5000;
	static final int DAILY_LIMIT = 25000;
	void deposit(int amt) throws DepositLimitExceedsException;
	void withdraw(int amt) throws InsufficientBalanceException;
}
