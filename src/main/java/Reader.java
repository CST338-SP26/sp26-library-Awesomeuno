import Utilities.Code;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Reader {
    public static final int CARD_NUMBER_ = 0;
    public static final int NAME_ = 0;
    public static final int PHONE_ = 0;
    public static final int BOOK_COUNT_ = 0;
    public static final int BOOK_START_ = 4;

    private int cardNumber;
    private String name;
    private String phone;
    private List<Book> books;

    public Reader(int cardNumber, String name, String phone) {
        this.cardNumber = cardNumber;
        this.name = name;
        this.phone = phone;
        this.books = new ArrayList<>();
    }

    public Code addBook(Book book) {
        if(this.books.contains(book)) {
            return Code.BOOK_ALREADY_CHECKED_OUT_ERROR;
        } else{
            books.add(book);
            return Code.SUCCESS;
        }
    }

    public Code removeBook(Book book) {
        if(!this.books.contains(book)) {
            return Code.READER_DOESNT_HAVE_BOOK_ERROR;
        } else{
            try{
                books.remove(book);
                return Code.SUCCESS;
            } catch(IndexOutOfBoundsException e){
                return Code.READER_COULD_NOT_REMOVE_BOOK_ERROR;
            }
        }
    }

    public boolean hasBook(Book book) {
        return this.books.contains(book);
    }

    public int getBookCount() {
        return this.books.size();
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public boolean equals(Object obj) {
        if(obj instanceof Reader) {
            Reader reader = (Reader) obj;
            return this.cardNumber == reader.cardNumber;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(this.cardNumber, this.name, this.phone);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(" (#").append(cardNumber).append(") ").append("has checked out {");
        for(int i = 0; i < books.size(); i++) {
            sb.append(books.get(i));
            if(i != books.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("}");
        return sb.toString();
    }
}
