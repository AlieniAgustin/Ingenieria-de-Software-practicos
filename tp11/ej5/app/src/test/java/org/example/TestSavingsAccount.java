package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestSavingsAccount{

  @Test 
  public void depositAndWithdrawWithCorrectValues(){
    BankAccount account = new SavingsAccount("123",5.0);
    account.deposit(5.0);
    assertEquals(10.0, account.getBalance());
    account.withdraw(2.0);
    assertEquals(8.0, account.getBalance());
  }

  @Test 
  public void depositAndWithdrawWithIncorrectValues(){
    BankAccount account = new SavingsAccount("123",5.0);
    assertThrows(IllegalArgumentException.class, () -> account.deposit(-1.0));
    assertThrows(IllegalArgumentException.class, () -> account.withdraw(-1.0));
    assertThrows(IllegalArgumentException.class, () -> account.withdraw(4.1));
    assertEquals(5.0, account.getBalance());
  }

  @Test 
  public void closeBankAccount(){
    BankAccount account = new SavingsAccount("123",5.0);
    account.close();
    assertThrows(IllegalStateException.class, () -> account.deposit(2.0));
    assertThrows(IllegalStateException.class, () -> account.withdraw(2.0));
    assertThrows(IllegalStateException.class, () -> account.getBalance());
    assertThrows(IllegalStateException.class, () -> account.close());
  }

  //@Test  si se descomenta esto, se tomara el metodo como un test, que claramente fallara, pues se debe lanzar una excepcion
  public void strengthenThePreconditionInTheSubclass(){
    BankAccount account = new SavingsAccount("123",5.0);
    account.withdraw(4.5);
    /**
     * El cliente solo sabe la precondicion de BankAccount, que exige que la cuenta este activa,
     * amount > 0, amount <= balance, pero no sabe que en SavingsAccount ademas se exige que
     * minimumBalance (1.0) <= balance (5.0) - amount (4.5), entonces se lanzara una excepcion 
     */
  }
}

