import Utilities.Code;

import java.util.HashMap;
import java.util.Objects;

public class Shelf {
    public final static int SHELF_NUMBER_ = 0;
    public final static int SUBJECT_ = 0;
    private HashMap<Book, Integer> books;
    private int shelfNumber;
    private String subject;

    public Shelf(int shelfNumber, String subject) {
        this.shelfNumber = shelfNumber;
        this.subject = subject;
    }

    public HashMap<Book, Integer> getBooks() {
        return books;
    }

    public void setBooks(HashMap<Book, Integer> books) {
        this.books = books;
    }

    public int getShelfNumber() {
        return shelfNumber;
    }

    public void setShelfNumber(int shelfNumber) {
        this.shelfNumber = shelfNumber;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shelf shelf = (Shelf) o;
        return shelfNumber == shelf.shelfNumber && Objects.equals(subject, shelf.subject);
    }

    public int hashCode() {
        return Objects.hash(shelfNumber, subject);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.shelfNumber + ": " + this.subject);
        return sb.toString();
    }

    public int getBookCount() {
        if (books == null) {
            return -1;
        } else {
            return books.size();
        }
    }

    public Code addBook(Book book) {
        if(!books.containsKey(book) && !books.containsValue(this.shelfNumber)) {
            return Code.SHELF_SUBJECT_MISMATCH_ERROR;
        } else if (books.containsKey(book)) {
            books.put(book, books.get(book) + 1);
            System.out.println(toString() + " added to shelf");
            return Code.SUCCESS;
        } else{
            books.put(book, 1);
            System.out.println(toString() + " added to shelf");
            return Code.SUCCESS;
        }
    }

    public Code removeBook(Book book) {
        if(!books.containsKey(book)) {
            System.out.println(book + " is not on shelf " + this.subject);
            return Code.BOOK_NOT_IN_INVENTORY_ERROR;
        } else if (books.containsKey(book) && books.containsValue(0)) {
            System.out.println("No copies of " + book + " remain on shelf " + this.subject);
            return Code.BOOK_NOT_IN_INVENTORY_ERROR;
        } else{
            System.out.println(book + " successfully removed from shelf  " + this.subject);
            return Code.SUCCESS;
        }
    }


}
