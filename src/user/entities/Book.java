package user.entities;

import java.util.ArrayList;
import java.util.List;

public class Book {
    private List<String> feedBacks = new ArrayList<>();

    public String toStringForArray() {
        return "Book{" +
                "feedBacks=" + feedBacks +
                '}';
    }

    public String getFeedBacks() {
        return toStringForArray();
    }

    public void setFeedBacks(String feedBacks) {
       this.feedBacks.add(feedBacks);
    }

    private String title;
    private String author;
    private String ISBN;
    private boolean reservationStatus;

    public boolean getReservationStatus() {
        return reservationStatus;
    }

    public void setReservationStatus(boolean reservationStatus) {
        this.reservationStatus = reservationStatus;
    }

    public Book(String title, String author, String ISBN) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", ISBN='" + ISBN + '\'' +
                '}';
    }
}
