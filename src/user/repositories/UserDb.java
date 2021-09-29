package user.repositories;

import user.entities.Account;
import user.exceptions.UserNotFoundException;
import user.entities.User;

import java.util.ArrayList;
import java.util.List;

public class UserDb {
    private static UserDb userDb;
    private List<User> userList = new ArrayList<>();
    private Account account;

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void addUser(User user){
        userList.add(user);
    }

    public void removeUser(User user){
        userList.remove(user);
    }

    public User findUserById(long id) throws UserNotFoundException {
        for(User user: userList){
            if(user.getUserId() == id){
                return user;
            }
        }
        throw new UserNotFoundException("User not found");
    }

    public User findUserByName(String name) throws UserNotFoundException {
        for(User user:userList){
            if(user.getName().equals(name)){
                return user;
            }
        }
        throw new UserNotFoundException("User not found");
    }

    public void addUserAccount(Account account) {
        setAccount(account);
    }

    private UserDb (){

    }

    public static UserDb getInstance(){
        if(userDb == null){
            userDb = new UserDb();
        }
        return userDb;
    }
}
