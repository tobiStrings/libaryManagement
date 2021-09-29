package user.entities;

import user.enums.UserType;
import user.exceptions.LibraryManageMeantException;
import user.exceptions.UserNotFoundException;
import user.repositories.LibrarianDb;
import user.repositories.UserDb;

public class LibraryManagementSystem {
    private String username;
    private UserType type;
    private String password;
    private UserDb userDb;
    private User student;
    private Librarian librarian;
    private LibrarianDb librarianDb;
    private User teacher;
    private boolean isRegistered;
    private boolean isLogin;

    public boolean isLogin() {
        return isLogin;
    }

    public void setLogin(boolean login) {
        isLogin = login;
    }

    public boolean isRegistered() {
        return isRegistered;
    }

    public void setRegistered(boolean registered) {
        isRegistered = registered;
    }

    public Librarian getLibrarian() {
        return librarian;
    }

    public User getStudent() {
        return student;
    }

    public User getTeacher() {
        return teacher;
    }

    public void register(String name,String password,UserType userType) {
        userDb = UserDb.getInstance();
        if (userType == UserType.STUDENT){
            student= new Student(name);
            userDb.addUser(student);
            setRegistered(true);
        }else if (userType == UserType.TEACHER){
            teacher = new Teacher(name);
            userDb.addUser(teacher);
            setRegistered(true);
        }else if(userType == UserType.LIBRARIAN){
            librarian = new Librarian(name,password);
            librarianDb = LibrarianDb.getInstance();
            librarianDb.addLibrarian(librarian);
            setRegistered(true);
        }
    }

    public boolean login(String name,String password,UserType userType) throws UserNotFoundException, LibraryManageMeantException {
        userDb = UserDb.getInstance();
        if (isRegistered()){
            if(userDb.findUserByName(name) != null && userType == UserType.STUDENT||userType == UserType.TEACHER){
                setLogin(true);
            } if(librarianDb.searchLibrarian(name) != null){
                setLogin(true);
            }
        }
        return  isLogin();
    }
}
