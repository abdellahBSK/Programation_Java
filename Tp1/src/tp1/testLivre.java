package tp1;

import java.util.Enumeration;
import java.util.Scanner;

public class testLivre {

	public static void main(String[] args) {

		Biblio biblio = Biblio.lireBiblio();
		if (biblio == null)
			biblio = new Biblio(100);

		Scanner sc = new Scanner(System.in);
		int choix = 0;
		do {
			try {
				System.out.println("\nMenu:");
				System.out.println("1: Ajouter un livre");
				System.out.println("2: Sauvegarder la bibliothèque");
				System.out.println("3: Chercher un livre par auteur");
				System.out.println("4: Afficher tous les livres");
				System.out.println("0: Quitter");
				System.out.print("Votre choix : ");

				choix = sc.nextInt();
				sc.nextLine(); // Consommer le retoupr à la ligne

				switch (choix) {
				case 1:
					Livre livre = Livre.creeLivre();
					if (livre != null) {
						if (biblio.ajouteLivre(livre)) {
							System.out.println("Livre ajouté avec succès !");
						} else {
							System.out.println("Bibliothèque pleine, impossible d'ajouter le livre.");
						}
					} else {
						System.out.println("Erreur lors de la création du livre.");
					}
					break;

				case 2:
					if (biblio.sauvgarderBiblio()) {
						System.out.println("Bibliothèque sauvegardée !");
					} else {
						System.out.println("Échec de la sauvegarde.");
					}
					break;

				case 3:
					System.out.print("Entrez le nom de l'auteur : ");
					String auteur = sc.nextLine();
					Enumeration<Livre> livresTrouves = biblio.cherche(auteur);
					if (!livresTrouves.hasMoreElements()) {
						System.out.println("Aucun livre trouvé pour cet auteur.");
					} else {
						System.out.println("Livres trouvés :");
						while (livresTrouves.hasMoreElements()) {
							System.out.println(livresTrouves.nextElement());
						}
					}
					break;

				case 4:
					System.out.println("Contenu de la bibliothèque :");
					System.out.println(biblio);
					break;

				case 0:
					System.out.println("Au revoir !");
					break;

				default:
					System.out.println("Choix invalide, veuillez réessayer.");
				}

			} catch (Exception e) {
				continue;
			}
		} while (choix != 0);
		sc.close();
	}
}
