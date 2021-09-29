package user.services;


import user.entities.Account;
import user.entities.Book;
import user.entities.User;
import user.exceptions.AccountNotFoundException;
import user.exceptions.BookDoesNotExistException;
import user.exceptions.UserNotFoundException;
import user.repositories.LibraryDb;
import user.repositories.UserDb;

public class UserServiceImpl implements UserService {
    private UserDb userDb ;

    public UserServiceImpl() {
        userDb = UserDb.getInstance();
    }


    @Override
    public String checkAccount(Account account) throws AccountNotFoundException {
        if (userDb.getAccount() == account){
            return account.toString();
        }
        else
        throw new AccountNotFoundException("You don't have account");
    }

    @Override
    public boolean verify(String name) throws UserNotFoundException {
        return userDb.findUserByName(name) != null;
    }
    @Override
    public void addUser(User user){
        userDb.addUser(user);
    }

    @Override
    public void createAccount(Account account) {
        userDb.addUserAccount(account);
    }

    @Override
    public String getBookInfo(String title, String author) throws BookDoesNotExistException {
        LibraryDb libraryDb = LibraryDb.getInstance();
        return libraryDb.search(title,author);
    }
}
