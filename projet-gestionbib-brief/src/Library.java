import java.util.List;
import java.util.ArrayList;

public class Library {
    private List<Book> books;
    private List<Student> students;

    public Library() {
        books = new ArrayList<>();
        students = new ArrayList<>();
    }

    // Méthode pour ajouter un étudiant à la bibliothèque
    public void addStudent(Student student) {
        students.add(student);
    }

    // Méthode pour supprimer un étudiant de la bibliothèque
    public void removeStudent(Student student) {
        students.remove(student);
    }

    // Méthode pour rechercher un étudiant par nom
    public Student searchStudentByName(String name) {
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(name)) {
                return student;
            }
        }
        return null;
    }

    // Method to add a book to the library
    public void addBook(Book book) {
        books.add(book);
    }

    // Method to remove a book from the library
    public void removeBook(Book book) {
        books.remove(book);
    }

    // Method to search for a book by title
    public Book searchBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    // Method to search for a book by author
    public List<Book> searchBookByAuthor(String author) {
        List<Book> foundBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }

    // Method to check for overdue books and send reminders
    public void sendRemindersForOverdueBooks() {
        boolean reminderSent = false; // Variable pour suivre si au moins un rappel a été envoyé
        for (Book book : books) {
            if (book.isOverdue()) { // Vérifie si le livre est en retard
                if (!reminderSent) {
                    System.out.println("Rappels pour les livres en retard :");
                    reminderSent = true;
                }
                System.out.println("Reminder: The book \"" + book.getTitle() + "\" is overdue!");
                Student borrower = book.getBorrower();
                if (borrower != null) {
                    System.out.println("Borrower: " + borrower.getName() + " (" + borrower.getId() + ")");
                } else {
                    System.out.println("No borrower information available.");
                }
            }
        }
        if (!reminderSent) {
            System.out.println("Aucun livre en retard."); // Si aucun livre n'est en retard, affiche un message approprié
        }
    }
}



