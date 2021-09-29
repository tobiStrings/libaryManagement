package user.services;

import user.entities.Account;
import user.entities.Book;
import user.entities.User;
import user.exceptions.BookDoesNotExistException;
import user.exceptions.LibraryManageMeantException;
import user.repositories.LibraryDb;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class BookServiceImpl implements BookServices {
    LibraryDb db;
    LocalDateTime time;
    String DATE_FORMATTER= "yyyy-MM-dd HH:mm";
    LocalDateTime localDateTime = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMATTER);
    String formatDateTime = localDateTime.format(formatter);
    @Override
    public String showDewDate(Account account, String title) throws LibraryManageMeantException {
        LibraryDb libraryDb = LibraryDb.getInstance();
        for (Book book : libraryDb.getBooks()) {
            if (account.getNumberOfBorrowedBooks() > 0 && book.getTitle().equals(title)){
                localDateTime = localDateTime.plusDays(2);
                return formatDateTime = localDateTime.format(formatter);
            }
        }
         throw new LibraryManageMeantException();
    }

    @Override
    public boolean reservationStatus(String title,String author) throws BookDoesNotExistException {
        return db.bookReservation(title,author);
    }


    @Override
    public void feedBack(Book book, String feedBack) {
        LibraryDb libraryDb = LibraryDb.getInstance();
        if (libraryDb.getBooks().contains(book)){
            book.setFeedBacks(feedBack);
        }
    }

    @Override
    public Book bookRequest(String title,String author) throws BookDoesNotExistException {
            for(Book book :db.getBooks()){
                if (book.getTitle().equalsIgnoreCase(title)|| book.getAuthor().equalsIgnoreCase(author)){
                    return book;
                }
            }
        throw new BookDoesNotExistException("Book is not available");
    }

    public void addBook(Book book){
        db = LibraryDb.getInstance();
        db.add(book);
    }

    @Override
    public String feedBacks(Book book) {
        return book.getFeedBacks();
    }

    @Override
    public void renewInfo(Book book,String title, String author, String isbn) {
        for(Book books :db.getBooks()){
            if (books.equals(book)){
                books.setTitle(title);
                books.setAuthor(author);
                books.setISBN(isbn);
            }
        }
    }
}
