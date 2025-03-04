package tp1;

import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Livre implements Serializable
{

	private String titre;
	private ArrayList<String> auteurs;
	private String isbn;
	private float prix;

	public Livre(String titre, ArrayList<String> auteurs, String isbn, float prix) {
		this.titre = titre;
		this.auteurs = auteurs;
		this.isbn = isbn;
		this.prix = prix;
	}

	public Livre() {
		titre = null;
		auteurs = null;
		isbn = null;
		prix = 0;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public ArrayList<String> getAuteurs() {
		return auteurs;
	}

	public void setAuteurs(ArrayList<String> auteurs) {
		this.auteurs = auteurs;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	public String toString() {
		return "Titre: " + titre + ", isbn: " + isbn + ", prix: " + prix + ", auteurs: "
				+ (auteurs == null ? "aucun" : auteurs);
	}

	public boolean containsAuthor(String auteur) {
		// Si l'auteur ou le début de l'auteur est trouvé dans les auteurs du livre
		for (String a : auteurs) {
			if (a.startsWith(auteur))
				return true;
		}
		return false;
	}

	
	public static Livre creeLivre() {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Titre : ");
            String titre = sc.nextLine();

            System.out.print("ISBN : ");
            String isbn = sc.nextLine();

            System.out.print("Prix : ");
            float prix = sc.nextFloat();
            sc.nextLine(); // Consommer le retour à la ligne

            ArrayList<String> auteurs = new ArrayList<>();
            System.out.print("Nombre d'auteurs : ");
            int nbAuteurs = sc.nextInt();
            sc.nextLine(); // Consommer le retour à la ligne

            for (int i = 0; i < nbAuteurs; i++) {
                System.out.print("Auteur " + (i + 1) + " : ");
                auteurs.add(sc.nextLine());
            }

            return new Livre(titre, auteurs, isbn, prix);
        } catch (Exception e) {
            System.out.println("Erreur lors de la saisie du livre.");
            return null;
        }
    }
	
}
