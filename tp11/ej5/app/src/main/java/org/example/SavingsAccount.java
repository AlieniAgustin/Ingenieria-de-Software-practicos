package org.example;

/**
 * INVARIANT: the account number has at least one digit, the balance isn't negative and the balance is greater than one, and when 
 * the bank account isn't open then the balance is zero. 
*/
public class SavingsAccount extends BankAccount{

  private final double minimumBalance = 1.0; //debo setear minimumBalance, ya que si lo pongo como parametro, estoy fortaleciendo la pre en vez de debilitarla

  /**
   * PRECONDITION: accountNumber != null && accountNumber.length() > 0 && initialDeposit >= 0
   * POSTCONDITION: create a bank account with the given account number and initial deposit, and where your minimum balance is $1
   */
  public SavingsAccount(String accountNumber, double initialDeposit){
    super(accountNumber,initialDeposit); //no puedo hacer los if() throw new ..., pq la primer sentencia debe ser super()

    assert this.isOpen;
    assert this.accountNumber.equals(accountNumber);
    assert this.balance == initialDeposit;
    assert this.minimumBalance == 1.0;

    assert repOk();
  }

  /**
   * PRECONDITION: isOpen && amount > 0 && amount <= balance && minimumBalance <= (balance - amount) 
   * POSTCONDITION: withdraw amount dollars from the bank account 
   */
  @Override
  public void withdraw(double amount){
    //EL PROBLEMA ES QUE ESTOY FORTALECIENDO LA PRECONDICION, EN LUGAR DE DEBILITARLA. PERO ESTO ES NECESARIO, SINO NO SE CUMPLE EL INVARIANTE
    if (!this.isOpen)
      throw new IllegalStateException("The bank account must be open!");

    if (amount <= 0)
      throw new IllegalArgumentException("The amount must be positive!");

    if (amount > this.balance)
      throw new IllegalArgumentException("The amount must not exceed the balance!");

    if (this.minimumBalance > (this.balance - amount))
      throw new IllegalArgumentException("The balance cannot be less than the minimum balance");

    double oldBalance = this.balance;
    this.balance -= amount;

    assert this.isOpen;
    assert this.balance == oldBalance - amount;

    assert repOk();
  }

  /**
   * PRECONDITION: true
   * POSTCONDITION: true, repOk represents the invariant
   */
  @Override
  public boolean repOk(){
    if(this.balance < 0 || this.accountNumber.length() == 0)
      return false;

    if(!this.isOpen && this.balance != 0)
      return false;

    if(this.minimumBalance != 1.0)
      return false;

    if(this.isOpen && this.balance < this.minimumBalance)
      return false;

    return true;
  }


}
