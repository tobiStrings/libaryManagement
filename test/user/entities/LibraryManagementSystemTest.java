package user.entities;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import user.enums.UserType;
import user.exceptions.LibraryManageMeantException;
import user.exceptions.UserNotFoundException;
import user.repositories.LibrarianDb;
import user.repositories.UserDb;

import static org.junit.jupiter.api.Assertions.*;

class LibraryManagementSystemTest {
    LibraryManagementSystem libraryManagementSystem;
    @BeforeEach
    void setUp() {
        libraryManagementSystem = new LibraryManagementSystem();
    }

    @AfterEach
    void tearDown() {
        libraryManagementSystem = null;
    }

    @Test
    void registerUserStudent(){
        libraryManagementSystem.register("tobi",null, UserType.STUDENT);
        UserDb userDb = UserDb.getInstance();
        try {
            assertEquals(libraryManagementSystem.getStudent(),userDb.findUserByName("tobi"));
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    void registerUserTeacher(){
        libraryManagementSystem.register("tobi",null, UserType.TEACHER);
        UserDb userDb = UserDb.getInstance();
        try {
            assertEquals(libraryManagementSystem.getTeacher(),userDb.findUserByName("tobi"));
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    void registerLibrarian(){
        libraryManagementSystem.register("tobi","12345",UserType.LIBRARIAN);
        LibrarianDb librarianDb = LibrarianDb.getInstance();
        try {
            assertEquals(libraryManagementSystem.getLibrarian(),librarianDb.searchLibrarian("tobi"));
        } catch (LibraryManageMeantException e) {
            e.printStackTrace();
        }
    }

    @Test
    void loginStudent(){
        libraryManagementSystem.register("tobi",null, UserType.STUDENT);
        UserDb userDb = UserDb.getInstance();
        try {
            assertEquals(libraryManagementSystem.getStudent(),userDb.findUserByName("tobi"));
            assertTrue(libraryManagementSystem.login("tobi", null,UserType.STUDENT));
        } catch (UserNotFoundException | LibraryManageMeantException e) {
            e.printStackTrace();
        }
    }

    @Test
    void loginTeacher(){
        libraryManagementSystem.register("tobi",null, UserType.TEACHER);
        UserDb userDb = UserDb.getInstance();
        try {
            assertEquals(libraryManagementSystem.getTeacher(),userDb.findUserByName("tobi"));
            assertTrue(libraryManagementSystem.login("tobi", null,UserType.TEACHER));
        } catch (UserNotFoundException | LibraryManageMeantException e) {
            e.printStackTrace();
        }
    }

    @Test
    void loginLibrarian(){
        libraryManagementSystem.register("tobi",null, UserType.LIBRARIAN);
        LibrarianDb librarianDb = LibrarianDb.getInstance();
        try {
            assertEquals(libraryManagementSystem.getLibrarian(),librarianDb.searchLibrarian("tobi"));
            assertTrue(libraryManagementSystem.login("tobi", null,UserType.LIBRARIAN));
        } catch (UserNotFoundException | LibraryManageMeantException e) {
            e.printStackTrace();
        }
    }


}