package user.services;

import user.entities.Account;
import user.entities.Book;
import user.entities.User;
import user.exceptions.AccountNotFoundException;
import user.exceptions.BookDoesNotExistException;
import user.exceptions.UserNotFoundException;

public interface UserService {
    boolean verify(String name) throws UserNotFoundException;
    String checkAccount(Account account) throws AccountNotFoundException;
    void addUser(User user);

    void createAccount(Account account);

    String getBookInfo(String title, String author) throws BookDoesNotExistException;
}
