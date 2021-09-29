package user.services;

import user.entities.Account;
import user.entities.Book;
import user.entities.User;
import user.exceptions.BookDoesNotExistException;
import user.exceptions.LibraryManageMeantException;

public interface BookServices {
    String showDewDate(Account account, String title) throws LibraryManageMeantException;
    boolean reservationStatus(String title,String author)throws BookDoesNotExistException;
    void feedBack(Book book, String feedBack);
    Book bookRequest(String title,String author) throws BookDoesNotExistException;
    void addBook(Book book);
    String feedBacks(Book book);
    void renewInfo(Book book ,String title, String author, String isbn);
}
