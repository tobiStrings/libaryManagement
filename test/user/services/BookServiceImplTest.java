package user.services;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import user.entities.Account;
import user.entities.Book;
import user.entities.User;
import user.exceptions.BookDoesNotExistException;
import user.exceptions.LibraryManageMeantException;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class BookServiceImplTest {
    BookServices bookServices;
    UserService userService;
    @BeforeEach
    void setUp() {
        bookServices = new BookServiceImpl();
        userService = new UserServiceImpl();
    }

    @AfterEach
    void tearDown() {
        bookServices = null;
        userService = null;
    }

    @Test
    void showDewDate(){
        try {
            Account account = new Account(1,2,3,4,0.0);
            Book book = new Book("Java","tobi","123ght");
            bookServices.addBook(book);
            assertEquals("2021-09-13 14:18",bookServices.showDewDate(account,"Java"));
        } catch (LibraryManageMeantException e) {
            e.printStackTrace();
        }
    }

    @Test
    void reservationStatus(){
        try { Book book = new Book("Java","tobi","123ght");
            bookServices.addBook(book);
            assertFalse(bookServices.reservationStatus("title",""));
        } catch (BookDoesNotExistException e) {
            e.printStackTrace();
        }
    }

    @Test
    void feedBack(){
        Book book = new Book("Java","tobi","123ght");
        bookServices.addBook(book);
        bookServices.feedBack(book,"wow");
        assertEquals("Book{feedBacks=[wow]}",bookServices.feedBacks(book));
    }

    @Test
    void bookRequest(){
        Book book = new Book("java","tobi","123ght");
        bookServices.addBook(book);
        try {
            assertEquals(book,bookServices.bookRequest("java","tobi"));
        } catch (BookDoesNotExistException e) {
            e.printStackTrace();
        }

    }

    @Test
    void renewInfo(){
        Book book = new Book("java","tobi","123ght");
        bookServices.addBook(book);
        bookServices.renewInfo(book,"python","that","isbn");
        try {
            assertEquals("Book{title='python', author='that', ISBN='isbn'}",userService.getBookInfo("python","that"));
        } catch (BookDoesNotExistException e) {
            e.printStackTrace();
        }
    }
}