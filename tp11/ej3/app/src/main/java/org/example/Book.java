package org.example;

/**
 * INVARIANT: both the ISBN and the title have at least one character
 */
public class Book{
  private String isbn;
  private String title;
  private boolean isBorrowed;

  /**
   * PRECONDITION: isbn != null && title != null && !isbn.isEmpty() && !title.isEmpty()
   * POSTCONDITION: creates a Book
   */
  public Book(String isbn, String title, boolean isBorrowed){
    if(isbn == null || title == null)
      throw new NullPointerException();

    if(isbn.isEmpty() || title.isEmpty())
      throw new IllegalArgumentException();

    this.isbn = isbn;
    this.title = title;
    this.isBorrowed = isBorrowed;

    assert this.isbn.equals(isbn);
    assert this.title.equals(title);
    assert this.isBorrowed == isBorrowed;

    assert repOk();
  }

  /**
   * PRECONDITION: isbn != null
   * POSTCONDITION: returns the isbn
   */
  public String getIsbn(){
    if(isbn == null)
      throw new IllegalStateException();

    assert repOk();
    return isbn;
  }

  /**
   * PRECONDITION: title != null
   * POSTCONDITION: returns the title
   */
  public String getTitle(){
    if(title == null)
      throw new IllegalStateException();

    assert repOk();
    return title;
  }

  /**
   * PRECONDITION: true
   * POSTCONDITION: returns true if the book is borrowed 
   */
  public boolean isBorrowed(){
    assert repOk();

    return isBorrowed;
  }

  /**
   * PRECONDITION: true 
   * POSTCONDITION: set is borrowed with the given value 
   */
  public void setIsBorrowed(boolean isBorrowed){
    this.isBorrowed = isBorrowed;

    assert repOk();
  }

  /**
   * PRECONDITION: true
   * POSTCONDITION: returns true if the invariant is true
   */
  public boolean repOk(){
    return isbn != null && title != null && !isbn.isEmpty() && !title.isEmpty();
  }

  /**
   * PRECONDITION: true 
   * POSTCONDITION: returns true if obj is equal to this
   */
  @Override
  public boolean equals(Object obj){
    if(obj == null) 
      return false;

    if(obj == this)
      return true;

    if(!(obj instanceof Book))
      return false;

    Book aux = (Book) obj;
    return getIsbn().equals(aux.getIsbn()) && getTitle().equals(aux.getTitle()) && isBorrowed() == aux.isBorrowed();
  }

  /**
   * PRECONDITION: true 
   * POSTCONDITION: returns the hash code 
   */
  @Override 
  public int hashCode(){
    int result = 17;
    result = 31 * result + isbn.hashCode();
    result = 31 * result + title.hashCode();
    result = 31 * result + Boolean.hashCode(isBorrowed);
    return result;
  }
}
