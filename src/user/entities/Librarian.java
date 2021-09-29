package user.entities;

public class Librarian {
    private String name;
    private long id;
    private String password;
    private String searchString;


    public Librarian(String name, String password) {
        this.name = name;
        idGenerator++;
        this.id =idGenerator;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSearchString() {
        return searchString;
    }

    public void setSearchString(String searchString) {
        this.searchString = searchString;
    }

    private static long idGenerator;



}
