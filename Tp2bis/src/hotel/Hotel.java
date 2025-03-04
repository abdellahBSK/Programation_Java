package hotel;

import java.io.*;
import java.util.*;

public class Hotel {
    private List<Chambre> chambres;

    public Hotel() {
        chambres = new ArrayList<>();
    }

    public void ajouterChambre(Chambre chambre) {
        chambres.add(chambre);
    }

    public void afficherChambresCategorie(int categorie) {
        System.out.println("Chambres de la catégorie " + categorie + " :");
        for (Chambre c : chambres) {
            if (c.getCategorie() == categorie) System.out.println(c);
        }
    }

    public void trierChambresParCapacite() {
    	for (int i = 0; i < chambres.size() - 1; i++) {
    	    for (int j = 0; j < chambres.size() - i - 1; j++) {
    	        if (chambres.get(j).getCapacity() > chambres.get(j + 1).getCapacity()) {
    	            Chambre temp = chambres.get(j);
    	            chambres.set(j, chambres.get(j + 1));
    	            chambres.set(j + 1, temp);
    	        }
    	    }
    	}
    }

    public void afficherChambresLibres() {
        System.out.println("Chambres libres :");
        for (Chambre c : chambres) {
            if (c.getEtat() == 'L') System.out.println(c);
        }
    }

    public void supprimerChambre(int numero) {
//        chambres.removeIf(c -> c.getNumero() == numero);
    	for (int i = 0; i < chambres.size(); i++) {
    	    if (chambres.get(i).getNumero() == numero) {
    	        for (int j = i; j < chambres.size() - 1; j++) {
    	            chambres.set(j, chambres.get(j + 1));
    	        }
    	        chambres.remove(chambres.size() - 1); 
    	        break; 
    	    }
    	}
    }


    public void ecrireFichier() {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("chambres.dat"))) {
        	
            dos.writeInt(chambres.size()); // Écrire le nombre de chambres
            for (Chambre c : chambres) {
                dos.writeInt(c.getNumero());
                dos.writeInt(c.getCategorie());
                dos.writeDouble(c.getPrix());
                dos.writeInt(c.getCapacity());
                dos.writeChar(c.getEtat());
            }
            System.out.println("Données enregistrées avec succès !");
        } catch (IOException e) {
            System.out.println("Erreur d'écriture du fichier : " + e.getMessage());
        }
    }


    public List<Chambre> lireFichier() {
        chambres.clear();
        try (DataInputStream dis = new DataInputStream(new FileInputStream("chambres.dat"))) {
            int size = dis.readInt(); // Lire le nombre de chambres
            for (int i = 0; i < size; i++) {
                int numero = dis.readInt();
                int categorie = dis.readInt();
                double prix = dis.readDouble();
                int capacite = dis.readInt();
                char etat = dis.readChar();
                chambres.add(new Chambre(numero, categorie, prix, capacite, etat));
            }
            System.out.println("Données chargées avec succès !");
        } catch (IOException e) {
            System.out.println("Erreur de lecture du fichier ou fichier vide.");
        }
        return chambres;
    }


    public void copierChambresCategorie(int categorie, String nomFichier) {
        List<Chambre> chambresCategorie = new ArrayList<>();
        for (Chambre c : chambres) {
            if (c.getCategorie() == categorie) chambresCategorie.add(c);
        }

        if (chambresCategorie.isEmpty()) {
            System.out.println("Aucune chambre trouvée pour la catégorie " + categorie);
            return;
        }

        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(nomFichier))) {
            dos.writeInt(chambresCategorie.size()); // Écrire la taille
            for (Chambre c : chambresCategorie) {
                dos.writeInt(c.getNumero());
                dos.writeInt(c.getCategorie());
                dos.writeDouble(c.getPrix());
                dos.writeInt(c.getCapacity());
                dos.writeChar(c.getEtat());
            }
            System.out.println("Chambres de la catégorie " + categorie + " copiées dans " + nomFichier);
        } catch (IOException e) {
            System.out.println("Erreur lors de l'écriture du fichier : " + e.getMessage());
        }
        
        
    }

    public double calculerRecetteMaximale() {
        return chambres.stream().mapToDouble(Chambre::getPrix).sum();
    }

    public double calculerRecetteReelle() {
//        return chambres.stream()
//                .filter(c -> c.getEtat() == 'O')
//                .mapToDouble(Chambre::getPrix)
//                .sum();
    	double sum = 0;
    	for (int i = 0; i < chambres.size(); i++) {
    	    for (int j = i; j <= i; j++) { 
    	        if (chambres.get(j).getEtat() == 'O') {
    	            sum += chambres.get(j).getPrix();
    	        }
    	    }
    	}
    	return sum;
    }
    
    public String toString()
    {
    	String s="";
    	for(Chambre c: chambres)
    	{
    		s += c.toString() + '\n';
    	}
    	
    	return s;
    }
}
