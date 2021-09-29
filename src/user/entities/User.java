package user.entities;

public class User {
    private String name;
    private long userId;
    private static long idGenerator;
    private Account account;

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public User(String name) {
        this.name = name;

        idGenerator++;
        this.userId = idGenerator;
    }

    public User() {
        this.userId = idGenerator;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getUserId() {
        return userId;
    }
}
