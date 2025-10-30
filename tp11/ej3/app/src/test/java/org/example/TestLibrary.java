package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestLibrary{

  @Test 
  public void addNewBook(){
    Book book = new Book("1","papu",false);
    Library library = new Library();
    library.addBook(book);
    assertTrue(library.isTheBookThere(book));
  }

  @Test 
  public void errorInAddNewBook(){
    Library library = new Library();
    assertThrows(NullPointerException.class, () -> library.addBook(null));
    Book book1 = new Book("1","papu",false);
    library.addBook(book1);
    Book book2 = new Book("1","pepe",false);
    assertThrows(IllegalArgumentException.class, () -> library.addBook(book2));
  }

  @Test 
  public void borrowBook(){
    Library library = new Library();
    Book book1 = new Book("1","papu",false);
    library.addBook(book1);
    Book currentBook = library.borrowBook("1");
    assertEquals(book1,currentBook);
    assertTrue(currentBook.isBorrowed());
  }

  @Test 
  public void errorInBorrowBook(){
    Library library = new Library();
    assertThrows(NullPointerException.class, () -> library.borrowBook(null));
    Book book1 = new Book("1","papu",true);
    Book book2 = new Book("2","pepe",false);
    library.addBook(book1);
    library.addBook(book2);
    assertThrows(IllegalArgumentException.class, () -> library.borrowBook("3"));
    assertThrows(IllegalArgumentException.class, () -> library.borrowBook("1"));
  }
}
