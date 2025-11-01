package org.example;


/**
 * INVARIANT: the account number has at least one digit, the balance isn't negative, and when 
 * the bank account isn't open then the balance is zero
*/
public class BankAccount{
  protected String accountNumber;
  protected double balance;
  protected boolean isOpen;

  /**
   * PRECONDITION: accountNumber != null && accountNumber.length() > 0 && initialDeposit >= 0
   * POSTCONDITION: create a bank account with the given account number and initial deposit
   */
  public BankAccount(String accountNumber, double initialDeposit){
    if (accountNumber == null)
      throw new NullPointerException();

    if (accountNumber.length() == 0)
      throw new IllegalArgumentException("The account number must have digits!");

    if (initialDeposit < 0)
      throw new IllegalArgumentException("The initial deposit cannot be negative!");

    this.isOpen = true;
    this.accountNumber = accountNumber;
    this.balance = initialDeposit;

    assert this.isOpen;
    assert this.accountNumber.equals(accountNumber);
    assert this.balance == initialDeposit;

    assert repOk();
  }

  /**
   * PRECONDITION: isOpen && amount > 0
   * POSTCONDITION: deposit amount dollars into the bank account
   */
  public void deposit(double amount){
    if (!this.isOpen)
      throw new IllegalStateException("The bank account must be open!");

    if (amount <= 0)
      throw new IllegalArgumentException("The amount must be positive!");

    double oldBalance = this.balance;
    this.balance += amount;

    assert this.isOpen;
    assert this.balance == oldBalance + amount;

    assert repOk();
  }

  /**
   * PRECONDITION: isOpen && amount > 0 && amount <= balance 
   * POSTCONDITION: withdraw amount dollars from the bank account 
   */
  public void withdraw(double amount){
    if (!this.isOpen)
      throw new IllegalStateException("The bank account must be open!");

    if (amount <= 0)
      throw new IllegalArgumentException("The amount must be positive!");

    if (amount > this.balance)
      throw new IllegalArgumentException("The amount must not exceed the balance!");

    double oldBalance = this.balance;
    this.balance -= amount;

    assert this.isOpen;
    assert this.balance == oldBalance - amount;

    assert repOk();
  }

  /**
   * PRECONDITION: isOpen
   * POSTCONDITION: returns the bank account balance 
   */
  public double getBalance(){
    if (!this.isOpen)
      throw new IllegalStateException("The bank account must be open!");

    assert this.isOpen;

    assert repOk();

    return this.balance;
  }

  /**
   * PRECONDITION: isOpen
   * POSTCONDITION: close the bank account 
   */
  public void close(){
    if(!this.isOpen)
      throw new IllegalStateException("The bank account must be open!");

    this.isOpen = false;
    this.balance = 0;

    assert !this.isOpen;
    assert this.balance == 0;

    assert repOk();
  }

  /**
   * PRECONDITION: true
   * POSTCONDITION: true, repOk represents the invariant
   */
  public boolean repOk(){
    if(this.balance < 0 || this.accountNumber.length() == 0)
      return false;

    if(!this.isOpen && this.balance != 0)
      return false;

    return true;
  }

}

