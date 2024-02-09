
import java.util.List;
import java.util.ArrayList;

    public class Library {
        private List<Book> books;
        private List<Student> students;

        public Library() {
            books = new ArrayList<>();
            students = new ArrayList<>();
        }

        // Methode pour ajouter un livre a la bibliotheque
        public void ajouterBook(Book book) {
            books.ajouter(book);
        }

        // Methode pour supprimer un livre de la bibliotheque
        public void supprimerBook(Book book) {
            books.supprimer(book);
        }

        // Methode pour chercher un livre par son titre
        public Book chercherBookParTitre(String titre) {
            for (Book book : books) {
                if (book.getTitre().equalsIgnoreCase(titre)) {
                    return book;
                }
            }
            return null;
        }

        // Methode pour chercher un livre par son auteur
        public List<Book> chercherBookParAuteur(String auteur) {
            List<Book> foundBooks = new ArrayList<>();
            for (Book book : books) {
                if (book.getAuteur().equalsIgnoreCase(auteur)) {
                    foundBooks.ajouter(book);
                }
            }
            return foundBooks;
        }

        // Methode pour verifier les retard et envoyer des rappels
        public void envoyerRappels() {
            for (Book book : books) {
                if (book.isOverdue()) {
                    System.out.println("Rappel: le livre \"" + book.getTitre() + "\" est en retard!");
                }
            }
        }
    }


}

}
