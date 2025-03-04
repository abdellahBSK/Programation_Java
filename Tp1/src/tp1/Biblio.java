package tp1;

import java.io.*;
import java.util.Enumeration;
import java.util.Vector;

public class Biblio implements Serializable {

    private int size;
    private int capacite;
    private Livre[] livres;

    public Biblio(int capacite) {
        this.capacite = capacite;
        this.livres = new Livre[capacite];
        this.size = 0;
    }

    public int capacite() {
        return capacite;
    }

    public boolean ajouteLivre(Livre l) {
        if (size >= capacite) return false;
        livres[size] = l;
        size++;
        return true;
    }

    public int size() {
        return size;
    }

    public String toString() {
        StringBuilder affiche = new StringBuilder();
        for (int i = 0; i < size; i++) {
            affiche.append("\nLivre ").append(i + 1).append("\n\t").append(livres[i]);
        }
        return affiche.toString();
    }

    public boolean sauvgarderBiblio() {
        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("biblio.dat"))) {
            os.writeObject(this);
            return true;
        } catch (IOException e) {
        	System.out.println(e.getMessage());
            return false;
        }
    }

    public static Biblio lireBiblio() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("biblio.dat"))) {
            return (Biblio) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return null;
        }
    }

    public Enumeration<Livre> cherche(String auteur) {
        Vector<Livre> v = new Vector<>();
        for (int i = 0; i < size; i++) {
            if (livres[i].containsAuthor(auteur)) {
                v.addElement(livres[i]);
            }
        }
        return v.elements();
    }
}
