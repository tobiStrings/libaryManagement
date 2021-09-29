package user.services;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import user.entities.Book;
import user.entities.Librarian;
import user.exceptions.BookDoesNotExistException;
import user.exceptions.LibraryManageMeantException;

import static org.junit.jupiter.api.Assertions.*;

class LibrarianServiceImplTest {
    LibrarianService librarianService;
    BookServices bookServices;
    @BeforeEach
    void setUp() {
        librarianService = new LibrarianServiceImpl();
        bookServices = new BookServiceImpl();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void verifyLibrarian(){
        try {
            Librarian tobi = new Librarian("tobi","1234");
            librarianService.addLibrarian(tobi);
            assertTrue(librarianService.verifyLibrarian("tobi"));
        } catch (LibraryManageMeantException e) {
            e.printStackTrace();
        }
    }

    @Test
    void search(){
        Book book = new Book("java","tobi","1234gh");
        bookServices.addBook(book);
        try {
            assertEquals("Book{title='java', author='tobi', ISBN='1234gh'}",librarianService.search("java","tobi"));
        } catch (BookDoesNotExistException e) {
            e.printStackTrace();
        }
    }
}