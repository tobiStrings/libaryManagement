package user.entities;

public class Account {
    private int numberOfBorrowedBooks;
    private int numberOfReservedBooks;
    private int numberOfReturnedBooks;
    private int numberOfLostBooks;
    private double fineAmount;

    public Account(int numberOfBorrowedBooks, int numberOfReservedBooks, int numberOfReturnedBooks, int numberOfLostBooks,double fineAmount) {
        this.numberOfBorrowedBooks = numberOfBorrowedBooks;
        this.numberOfReservedBooks = numberOfReservedBooks;
        this.numberOfReturnedBooks = numberOfReturnedBooks;
        this.numberOfLostBooks = numberOfLostBooks;
        this.fineAmount = fineAmount;
    }

    public int getNumberOfBorrowedBooks() {
        return numberOfBorrowedBooks;
    }

    public void setNumberOfBorrowedBooks(int numberOfBorrowedBooks) {
        this.numberOfBorrowedBooks = numberOfBorrowedBooks;
    }

    public int getNumberOfReservedBooks() {
        return numberOfReservedBooks;
    }

    public void setNumberOfReservedBooks(int numberOfReservedBooks) {
        this.numberOfReservedBooks = numberOfReservedBooks;
    }

    public int getNumberOfReturnedBooks() {
        return numberOfReturnedBooks;
    }

    public void setNumberOfReturnedBooks(int numberOfReturnedBooks) {
        this.numberOfReturnedBooks = numberOfReturnedBooks;
    }

    public int getNumberOfLostBooks() {
        return numberOfLostBooks;
    }

    public void setNumberOfLostBooks(int numberOfLostBooks) {
        this.numberOfLostBooks = numberOfLostBooks;
    }

    @Override
    public String toString() {
        return "Account{" +
                "numberOfBorrowedBooks=" + numberOfBorrowedBooks +
                ", numberOfReservedBooks=" + numberOfReservedBooks +
                ", numberOfReturnedBooks=" + numberOfReturnedBooks +
                ", numberOfLostBooks=" + numberOfLostBooks +
                ", fineAmount=" + fineAmount +
                '}';
    }

    public void setFineAmount(double fineAmount) {
        this.fineAmount += fineAmount;
    }

    public double getFineAmount(){
        return fineAmount;
    }
}
