import java.time.LocalDate;

public class Book {
    private String title;
    private String author;
    private String isbn;
    private String publicationDate;
    private Student borrower;
    private LocalDate dueDate;

    // Constructeur
    public Book(String title, String author, String isbn, String publicationDate) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publicationDate = publicationDate;
    }


    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getPublicationDate() {
        return publicationDate;
    }


    public void setBorrower(Student borrower) {
        this.borrower = borrower;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

     public void modifyBookDetails(String title, String author, String isbn, String publicationDate) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publicationDate = publicationDate;
    }

    public Student getBorrower() {
        return borrower;
    }


    public boolean isOverdue() {
        if (dueDate == null) {
            return false; // No due date set, not overdue
        }
        return LocalDate.now().isAfter(dueDate);
    }

}
