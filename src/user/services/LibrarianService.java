package user.services;

import user.entities.Librarian;
import user.exceptions.BookDoesNotExistException;
import user.exceptions.LibraryManageMeantException;

public interface LibrarianService {
    boolean verifyLibrarian(String name) throws LibraryManageMeantException;
    void addLibrarian(Librarian librarian);
    String search(String title, String author) throws BookDoesNotExistException;
}
