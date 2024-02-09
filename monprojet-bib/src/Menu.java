import java.util.Scanner;

public class Menu {
        private Library library;
        private Scanner scanner;

        public Menu() {
            library = new Library();
            scanner = new Scanner(System.in);
        }

        public void afficherMenu() {
            System.out.println("Bibliotheque Management Systeme Menu:");
            System.out.println("1. Ajouter un livre");
            System.out.println("2. Supprimer un livre");
            System.out.println("3. Chercher un livre par titre");
            System.out.println("4. Chercher un livre par auteur");
            System.out.println("5. Envoyer des rappels pour les livres qui sont en retard");
            System.out.println("6. Quitter");
            System.out.print("Entrez votre choix: ");
        }

        public void commencer() {
            int choix;
            do {
                afficherMenu();
                choix = scanner.nextInt();
                scanner.nextLine();
                switch (choix) {
                    case 1:
                        ajouterBook();
                        break;
                    case 2:
                        supprimerBook();
                        break;
                    case 3:
                        chercherBookParTitre();
                        break;
                    case 4:
                        chercherBookParAuteur();
                        break;
                    case 5:
                        library.nvoyerRappels();
                        break;
                    case 6:
                        System.out.println("Sortie de l'application...");
                        break;
                    default:
                        System.out.println("choix invalide, Veuillez reessayer.");
                }
            } while (choix != 6);


        }

        private void ajouterBook() {
            System.out.println("Entrez les details de livre:");
            System.out.print("Titre: ");
            String titre = scanner.nextLine();
            System.out.print("Auteur: ");
            String auteur = scanner.nextLine();
            System.out.print("ISBN: ");
            String isbn = scanner.nextLine();
            System.out.print("date de publication: ");
            String publicationDate = scanner.nextLine();

            Book newBook = new Book(titre, auteur, isbn, publicationDate);
            library.ajouterBook(newBook);
            System.out.println("Livre ajouté avec succès !");
        }

        private void supprimerBook() {
            System.out.print("Entez le titre du livre que vous voulez supprimer : ");
            String titre = scanner.nextLine();
            Book bookToRemove = library.chercherBookParTitre(titre);
            if (bookToRemove != null) {
                library.removeBook(bookToRemove);
                System.out.println("Livre supprime avec succes !");
            } else {
                System.out.println("Livre introuvable .");
            }
        }

        private void chercherBookParTitre() {
            System.out.print("Saisissez le titre du livre que vous souhaitez rechercher : ");
            String titre = scanner.nextLine();
            Book foundBook = library.chercherBookParTitre(titre);
            if (foundBook != null) {
                System.out.println("Livre trouvé.");
                // Print book details
            } else {
                System.out.println("Livre introuvable.");
            }
        }

        private void chercherBookParAuteur() {
            System.out.print("Saisissez l'auteur du livre que vous souhaitez rechercher: ");
            String auteur = scanner.nextLine();
            List<Book> foundBooks = library.chercherBookParAuteur(auteur);
            if (!foundBooks.isEmpty()) {
                System.out.println("Livres trouvés par auteur '" + auteur + "':");
                for (Book book : foundBooks) {
                    // Print book details
                }
            } else {
                System.out.println("Aucun livre trouvé par auteur '" + auteur + "'.");
            }
        }
    }
}

}
