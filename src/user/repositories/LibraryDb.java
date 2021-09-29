package user.repositories;

import user.entities.Book;
import user.exceptions.BookDoesNotExistException;

import java.util.ArrayList;
import java.util.List;

public class LibraryDb {
    private List<Book> books = new ArrayList<>();
    private static LibraryDb db;

     public void add(Book book){
         books.add(book);
     }

     public void delete(Book book){
         books.remove(book);
     }

     public void update(String title){
         for (Book book:books){
             if (book.getTitle().equalsIgnoreCase(title)){
                 book.setTitle(title);
             }
         }
     }

     public String display(){
         for (Book book:books){
             return book.toString();
         }
         return null;
     }

     public String search(String title, String author) throws BookDoesNotExistException {
         for (Book book:books){
             if (book.getTitle().equalsIgnoreCase(title) || book.getAuthor().equalsIgnoreCase(author)){
                 return book.toString();
             }
         }
         throw new BookDoesNotExistException("Make sure the book exist");
     }

     public boolean bookReservation(String title, String author) throws BookDoesNotExistException {
         for (Book book:books){
             if (book.getTitle().equalsIgnoreCase(title) || book.getAuthor().equalsIgnoreCase(author)){
                 return book.getReservationStatus();
             }
         }
         throw new BookDoesNotExistException("Make sure the book exist");

     }

    public static LibraryDb getInstance(){
        if (db == null){
            db = new LibraryDb();
        }
        return db;
    }
    private LibraryDb(){

    }
    public List<Book> getBooks(){
         return books;
    }
}
