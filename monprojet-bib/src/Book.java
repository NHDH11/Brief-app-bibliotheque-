
public class Book {
        private String titre;
        private String auteur;
        private String isbn;
        private String publicationDate;
        private Student emprunteur;
        private LocalDate dueDate;

        // Constructeur
        public Book(String titre, String auteur, String isbn, String publicationDate) {
            this.titre = titre;
            this.auteur = auteur;
            this.isbn = isbn;
            this.publicationDate = publicationDate;
        }


        public String getTitre() {
            return titre;
        }

        public String getAuteur() {
            return auteur;
        }

        public String getIsbn() {
            return isbn;
        }

        public String getPublicationDate() {
            return publicationDate;
        }


        public void setEmprunteur(Student emprunteur) {
            this.emprunteur = emprunteur;
        }

        public void setDueDate(LocalDate dueDate) {
            this.dueDate = dueDate;
        }

        public void modifyBookDetails(String titre, String auteur, String isbn, String publicationDate) {
            this.titre = titre;
            this.auteur = auteur;
            this.isbn = isbn;
            this.publicationDate = publicationDate;
        }

        public boolean isOverdue() {
            return LocalDate.now().isAfter(dueDate);
        }
    }

}
