package hotel;

import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Chambre implements Serializable {
    private static final long serialVersionUID = 1L;

    private int numero;
    private int categorie;
    private double prix;
    private int capacity;
    private char etat; // 'O' pour Occupé et 'L' pour Libre

    public Chambre(int numero, int categorie, double prix, int capacity, char etat) {
        this.numero = numero;
        this.categorie = categorie;
        this.prix = prix;
        this.capacity = capacity;
        this.etat = etat;
    }

    public int getNumero() { return numero; }
    public void setNumero(int numero) { this.numero = numero; }

    public int getCategorie() { return categorie; }
    public void setCategorie(int categorie) { this.categorie = categorie; }

    public double getPrix() { return prix; }
    public void setPrix(double prix) { this.prix = prix; }

    public int getCapacity() { return capacity; }
    public void setCapacity(int capacity) { this.capacity = capacity; }

    public char getEtat() { return etat; }
    public void setEtat(char etat) { this.etat = etat; }


    public String toString() {
        return "Chambre [Numéro=" + numero + ", Catégorie=" + categorie + ", Prix=" + prix + 
               ", Capacité=" + capacity + ", État=" + etat + "]";
    }

    public static Chambre saisirChambre() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Numéro de la chambre : ");
        int numero = scanner.nextInt();

        System.out.print("Catégorie de la chambre : ");
        int categorie = scanner.nextInt();

        double prix;
        do {
            System.out.print("Prix de la chambre : ");
            prix = scanner.nextDouble();
            if (prix <= 0) System.out.println("Erreur : Le prix doit être supérieur à 0.");
        } while (prix <= 0);

        int capacite;
        do {
            System.out.print("Capacité de la chambre (entre 1 et 4) : ");
            capacite = scanner.nextInt();
            if (capacite < 1 || capacite > 4) System.out.println("Erreur : La capacité doit être entre 1 et 4.");
        } while (capacite < 1 || capacite > 4);

        return new Chambre(numero, categorie, prix, capacite, 'L'); // Par défaut, la chambre est libre
    }
}
