package hotel;

import java.io.*;
import java.util.*;

public class BisTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hotel hotel = new Hotel();
        List<Chambre> chambres = hotel.lireFichier();

        int choix;
        do {
            try {
                System.out.println("\n\tGESTION DE L'HÔTEL");
                System.out.println("1. Ajouter une chambre");
                System.out.println("2. Afficher toutes les chambres");
                System.out.println("3. Afficher les chambres d'une catégorie");
                System.out.println("4. Trier les chambres par capacité");
                System.out.println("5. Afficher les chambres libres");
                System.out.println("6. Supprimer une chambre");
                System.out.println("7. Enregistrer les chambres dans un fichier");
                System.out.println("8. Charger les chambres depuis un fichier");
                System.out.println("9. Calculer la recette maximale et réelle");
                System.out.println("10. Copier les chambres d'une catégorie dans un fichier");
                System.out.println("0. Quitter");
                System.out.print("Choisissez une option : ");
                choix = scanner.nextInt();

                switch (choix) {
                    case 1:
                        Chambre chambre = Chambre.saisirChambre();
                        hotel.ajouterChambre(chambre);
                        break;
                    case 2:
                        System.out.println(hotel);;
                        break;
                    case 3:
                        System.out.print("Entrez la catégorie : ");
                        hotel.afficherChambresCategorie(scanner.nextInt());
                        break;
                    case 4:
                        hotel.trierChambresParCapacite();
                        System.out.println("Chambres triées.");
                        break;
                    case 5:
                        hotel.afficherChambresLibres();
                        break;
                    case 6:
                        System.out.print("Numéro de la chambre à supprimer : ");
                        hotel.supprimerChambre(scanner.nextInt());
                        break;
                    case 7:
                        hotel.ecrireFichier();
                        break;
                    case 8:
                        hotel.lireFichier();
                        break;
                    case 9:
                        System.out.println("Recette max : " + hotel.calculerRecetteMaximale());
                        System.out.println("Recette réelle : " + hotel.calculerRecetteReelle());
                        break;
                    case 10:
                        System.out.print("Catégorie à copier : ");
                        hotel.copierChambresCategorie(scanner.nextInt(), "chambres_categorie.dat");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrée invalide. Veuillez entrer un nombre valide.");
                scanner.nextLine();
                choix = -1;
            }
        } while (choix != 0);

        scanner.close();
    }
}
