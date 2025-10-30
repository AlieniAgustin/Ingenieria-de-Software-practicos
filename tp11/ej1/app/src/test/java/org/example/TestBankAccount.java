package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestBankAccount{

  @Test 
  public void depositAndWithdrawWithCorrectValues(){
    BankAccount account = new BankAccount("123",5.0);
    account.deposit(5.0);
    assertEquals(10.0, account.getBalance());
    account.withdraw(2.0);
    assertEquals(8.0, account.getBalance());
  }

  @Test 
  public void depositAndWithdrawWithIncorrectValues(){
    BankAccount account = new BankAccount("123",5.0);
    assertThrows(IllegalArgumentException.class, () -> account.deposit(-1.0));
    assertThrows(IllegalArgumentException.class, () -> account.withdraw(-1.0));
    assertThrows(IllegalArgumentException.class, () -> account.withdraw(6.0));
    assertEquals(5.0, account.getBalance());
  }

  @Test 
  public void closeBankAccount(){
    BankAccount account = new BankAccount("123",5.0);
    account.close();
    assertThrows(IllegalStateException.class, () -> account.deposit(2.0));
    assertThrows(IllegalStateException.class, () -> account.withdraw(2.0));
    assertThrows(IllegalStateException.class, () -> account.getBalance());
    assertThrows(IllegalStateException.class, () -> account.close());
  }
}
