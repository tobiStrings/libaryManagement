package user.services;

import user.entities.Librarian;
import user.exceptions.BookDoesNotExistException;
import user.exceptions.LibraryManageMeantException;
import user.repositories.LibrarianDb;
import user.repositories.LibraryDb;

public class LibrarianServiceImpl implements  LibrarianService{

    LibrarianDb librarianDb = LibrarianDb.getInstance();
    @Override
    public boolean verifyLibrarian(String name) throws LibraryManageMeantException {
        if (librarianDb.searchLibrarian(name) != null){
            return true;
        }
        throw new LibraryManageMeantException("Librarian no dey");
    }

    @Override
    public void addLibrarian(Librarian librarian) {
        librarianDb.addLibrarian(librarian);
    }

    @Override
    public String search(String title, String author) throws BookDoesNotExistException {
        LibraryDb db = LibraryDb.getInstance();
        return  db.search(title,author);
    }
}
