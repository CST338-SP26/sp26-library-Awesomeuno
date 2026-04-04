import java.time.LocalDate;
import java.util.Objects;

public class Book {
    public static final int AUTHOR_ = 0;
    public static final int TITLE_ = 1;
    public static final int DUE_DATE_ = 2;
    public static final int PAGE_COUNT_ = 3;
    public static final int ISBN_ = 4;
    public static final int SUBJECT_ = 5;

    private String author;
    private String title;
    private LocalDate dueDate;
    private int pageCount;
    private String isbn;
    private String subject;

    public Book(String a, String t, String i, int pc, String s3, LocalDate of) {
        this.author = a;
        this.title = t;
        this.dueDate = of;
        this.pageCount = pc;
        this.isbn = i;
        this.subject = i;
    }


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(author, book.author) && Objects.equals(title, book.title) && Objects.equals(pageCount, book.pageCount) && Objects.equals(isbn, book.isbn) && Objects.equals(subject, book.subject);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, title, pageCount, isbn, subject);
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(title + " ");
        sb.append("by " + author + " ");
        sb.append("ISBN: " + isbn);
        return sb.toString();
    }

    public String getISBN() {
        return isbn;
    }

    public void setISBN(String isbn) {

    }
}
