package tri_simple;

import java.util.Scanner;

public class EssaiTri {

	static public void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		TriSimple tri = new TriSimple();

		while (true) {
			try {
				System.out.println("'a' pour insérer\n's' pour supprimer\n'q' pour quitter :");
				String commande = scanner.next();

				if (commande.equals("a")) {
					System.out.println("Entrez un entier à insérer :");
					int entier = scanner.nextInt();
					tri.inserer(entier);
					System.out.println(tri);
				} else if (commande.equals("s")) {
					System.out.println("Entrez un entier à supprimer :");
					int entier = scanner.nextInt();
					tri.supprimer(entier);
					System.out.println(tri);
				} else if (commande.equals("q")) {
					break;
				} else {
					System.out.println("Charactère non valide.");
				}
			} catch (Exception e) {
				System.out.println("error");
//				scanner.nextLine();
			}
		}

		scanner.close();
	}

}
