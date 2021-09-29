package user.services;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import user.entities.Account;
import user.entities.Book;
import user.entities.Student;
import user.entities.User;
import user.exceptions.AccountNotFoundException;
import user.exceptions.BookDoesNotExistException;
import user.exceptions.UserNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceImplTest {
    User student;
    UserService userService;
    BookServices bookServices;

    @BeforeEach
    void setUp() {
        student = new Student("tobi");
        userService = new UserServiceImpl();
        bookServices = new BookServiceImpl();
    }

    @AfterEach
    void tearDown() {
        student = null;
        userService = null;
    }

    @Test
    void verifyUser(){
        try {
            assertFalse(userService.verify("tobi"));
            userService.addUser(student);
            assertTrue(userService.verify("tobi"));
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    void verifyNullUser(){
        try {
            boolean verify = userService.verify("tobi");
            assertFalse(verify);
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    void checkAccount(){
        Account account = new Account(1,2,3,4,0.0);
        userService.createAccount(account);
        try {
            assertEquals("Account{numberOfBorrowedBooks=1, numberOfReservedBooks=2, numberOfReturnedBooks=3, numberOfLostBooks=4, fineAmount=0.0}",userService.checkAccount(account));
        } catch (AccountNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    void checkAccountWithWrongAccount() {
        Account account = new Account(1, 2, 3, 4, 0.0);
//        userService.createAccount(account);
        assertThrows(AccountNotFoundException.class, () -> userService.checkAccount(account));
    }

    @Test
    void getBookInfo(){
        try {
            Book book = new Book("jav","tobi","1234gh");
            bookServices.addBook(book);
            assertEquals("Book{title='jav', author='tobi', ISBN='1234gh'}",userService.getBookInfo("jav","tobi"));
        } catch (BookDoesNotExistException e) {
            e.printStackTrace();
        }
    }
}