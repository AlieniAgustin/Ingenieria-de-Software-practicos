package org.example;

import java.util.Map;
import java.util.HashMap;

/**
 * INVARIANT: A library that allows you to store well-defined books
*/
public class Library{
  private Map<String, Book> books;

  /**
   * PRECONDITION: true 
   * POSTCONDITION: create a library of books 
   */
  public Library(){
    books = new HashMap<>();

    assert repOk();
  }

  /**
   * PRECONDITION: book != null && book isn't in books
   * POSTCONDITION: add book in books
   */
  public void addBook(Book book){
    if(book == null)
      throw new NullPointerException();

    if(isTheBookThere(book))
      throw new IllegalArgumentException();

    String bookIsbn = book.getIsbn();

    int oldSize = books.size();
    books.put(bookIsbn,book);
    int newSize = books.size();

    assert newSize == oldSize + 1;
    assert books.containsKey(bookIsbn);
    assert books.containsValue(book);
    assert isTheBookThere(book);

    assert repOk();
  }

  /**
   * PRECONDITION: isbn != null && there is a book available with the given isbn 
   * POSTCONDITION: the book is now borrowed
   */
  public Book borrowBook(String isbn){
    if(isbn == null)
      throw new NullPointerException();

    if(!books.containsKey(isbn))
      throw new IllegalArgumentException();

    Book book = books.get(isbn);
    if(book.isBorrowed())
      throw new IllegalArgumentException();

    book.setIsBorrowed(true);

    assert isTheBookThere(book);
    assert book.isBorrowed();

    return book;
  }

  /**
   * PRECONDITION: book != null
   * POSTCONDITION: returns true if book is in books 
   */
  public boolean isTheBookThere(Book book){
    if(book == null)
      throw new NullPointerException();

    String bookIsbn = book.getIsbn();

    return books.containsKey(bookIsbn);
  }

  /**
   * PRECONDITION: true
   * POSTCONDITION: returns true if the invariant is true
   */
  public boolean repOk(){
    if(books == null)
      return false;

    for(String isbn : books.keySet()){
      Book book = books.get(isbn);
      if(!isbn.equals(book.getIsbn()))
        return false;
    }

    return true;
  }

}
