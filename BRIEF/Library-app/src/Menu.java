import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private Library library;
    private Scanner scanner;

    public Menu() {
        library = new Library();
        scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("**********************************************");
        System.out.println("******  Library Management System Menu: ******");
        System.out.println("**********************************************");
        System.out.println("****** 1. Add a book                    ******");
        System.out.println("****** 2. Remove a book                 ******");
        System.out.println("****** 3. Search for a book by title    ******");
        System.out.println("****** 4. Search for a book by author   ******");
        System.out.println("****** 5. Send reminders/overdue books  ******");
        System.out.println("****** 6. Modify the details of a book  ******");
        System.out.println("****** 7. Borrow a book                 ******");
        System.out.println("****** 8. Exit the application          ******");
        System.out.println("**********************************************");
        System.out.print("Enter your choice: ");
    }

    public void start() {
        int choice;
        do {
            displayMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (choice) {
                case 1:
                    // Add a book
                    addBook();
                    break;
                case 2:
                    // Remove a book
                    removeBook();
                    break;
                case 3:
                    // Search for a book by title
                    searchBookByTitle();
                    break;
                case 4:
                    // Search for a book by author
                    searchBookByAuthor();
                    break;
                case 5:
                    // Send reminders for overdue books
                    library.sendRemindersForOverdueBooks();
                    break;
                case 6:
                    modifyBookDetails();
                    break;
                case 7:
                    borrowBook();
                case 8:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 8);


    }

    private void addBook() {
        System.out.println("Enter book details:");
        System.out.print("Title: ");
        String title = scanner.nextLine();
        System.out.print("Author: ");
        String author = scanner.nextLine();
        System.out.print("ISBN: ");
        String isbn = scanner.nextLine();
        System.out.print("Publication Date: ");
        String publicationDate = scanner.nextLine();

        Book newBook = new Book(title, author, isbn, publicationDate);
        library.addBook(newBook);
        System.out.println("Book added successfully!");
    }

    private void removeBook() {
        System.out.print("Enter the title of the book you want to remove: ");
        String title = scanner.nextLine();
        Book bookToRemove = library.searchBookByTitle(title);
        if (bookToRemove != null) {
            System.out.println("Book found:");
            System.out.println("Title: " + bookToRemove.getTitle());
            System.out.println("Author: " + bookToRemove.getAuthor());
            System.out.println("ISBN: " + bookToRemove.getIsbn());
            System.out.println("Publication Date: " + bookToRemove.getPublicationDate());
            System.out.print("Are you sure you want to remove this book? (yes/no): ");
            String confirmation = scanner.nextLine();
            if (confirmation.equalsIgnoreCase("yes")) {
                library.removeBook(bookToRemove);
                System.out.println("Book removed successfully!");
            } else {
                System.out.println("Operation canceled.");
            }
        } else {
            System.out.println("Book not found.");
        }
    }

    private void searchBookByTitle() {
        System.out.print("Enter the title of the book you want to search for: ");
        String title = scanner.nextLine();
        Book foundBook = library.searchBookByTitle(title);
        if (foundBook != null) {
            System.out.println("Book found:");
            System.out.println("Title: " + foundBook.getTitle());
            System.out.println("Author: " + foundBook.getAuthor());
            System.out.println("ISBN: " + foundBook.getIsbn());
            System.out.println("Publication Date: " + foundBook.getPublicationDate());
        } else {
            System.out.println("Book not found.");
        }
    }

    private void searchBookByAuthor() {
        System.out.print("Enter the author of the book you want to search for: ");
        String author = scanner.nextLine();
        List<Book> foundBooks = library.searchBookByAuthor(author);
        if (!foundBooks.isEmpty()) {
            System.out.println("Books found by author '" + author + "':");
            for (Book book : foundBooks) {
                System.out.println("Title: " + book.getTitle());
                System.out.println("Author: " + book.getAuthor());
                System.out.println("ISBN: " + book.getIsbn());
                System.out.println("Publication Date: " + book.getPublicationDate());
                System.out.println();
            }
        } else {
            System.out.println("No books found by author '" + author + "'.");
        }
    }

    private void borrowBook() {
        // Demandez à l'utilisateur les informations sur le livre et l'étudiant
        System.out.print("Enter student name: ");
        String studentName = scanner.nextLine();
        System.out.print("Enter student address: ");
        String studentAddress = scanner.nextLine();
        System.out.print("Enter student ID: ");
        String studentId = scanner.nextLine();

        Student student = new Student(studentName, studentAddress, studentId);

        System.out.print("Enter the title of the book you want to borrow: ");
        String title = scanner.nextLine();
        Book bookToBorrow = library.searchBookByTitle(title);

        if (bookToBorrow != null) {
            if (bookToBorrow.getBorrower() == null) {
                // Le livre est disponible pour emprunt
                bookToBorrow.setBorrower(student);
                // Définissez la date d'échéance à aujourd'hui plus la période de prêt (par exemple, 14 jours)
                LocalDate dueDate = LocalDate.now().plusDays(14); // Période de prêt de 14 jours
                bookToBorrow.setDueDate(dueDate);
                System.out.println("Book borrowed successfully!");
            } else {
                System.out.println("The book is already borrowed by another student.");
            }
        } else {
            System.out.println("Book not found.");
        }
    }

    private void modifyBookDetails() {
        System.out.print("Enter the title of the book you want to modify: ");
        String title = scanner.nextLine();
        Book bookToModify = library.searchBookByTitle(title);
        if (bookToModify != null) {
            System.out.println("Enter the new details for the book:");
            System.out.print("New title: ");
            String newTitle = scanner.nextLine();
            System.out.print("New author: ");
            String newAuthor = scanner.nextLine();
            System.out.print("New ISBN: ");
            String newIsbn = scanner.nextLine();
            System.out.print("New publication date: ");
            String newPublicationDate = scanner.nextLine();

            bookToModify.modifyBookDetails(newTitle, newAuthor, newIsbn, newPublicationDate);
            System.out.println("Book details modified successfully!");
        } else {
            System.out.println("Book not found.");
        }
    }


}

