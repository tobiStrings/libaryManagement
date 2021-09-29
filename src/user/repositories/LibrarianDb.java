package user.repositories;

import user.entities.Librarian;
import user.exceptions.LibraryManageMeantException;

import java.util.ArrayList;
import java.util.List;

public class LibrarianDb {
    private List<Librarian> librarianList = new ArrayList<>();
    private static LibrarianDb db;
    private LibrarianDb (){

    }

    public static LibrarianDb getInstance() {
        if (db == null){
            return db = new LibrarianDb();
        }
        return db;
    }

    public void addLibrarian(Librarian librarian){
        librarianList.add(librarian);
    }

    public Librarian searchLibrarian(String name) throws LibraryManageMeantException {
        for(Librarian librarian : librarianList){
            if(librarian.getName().equals(name)){
                return librarian;
            }
        }
        throw new LibraryManageMeantException("Librarian does not exist");
    }
}
