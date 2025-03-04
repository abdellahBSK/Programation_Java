package tri_simple;

public class TriSimple {

    private int taille;
    private int[] numbers;
    private int increment;
    private int nbr_element;

    public TriSimple(int _taille, int _increment) {
        if (_increment > 0) {
            increment = _increment;
        } else {
            increment = 1; // valeur par défaut si l'incrément est invalide
        }
        taille = _taille;
        numbers = new int[taille];
        nbr_element = 0;
    }

    public TriSimple() {
        this(3, 5); // taille par défaut et incrément par défaut
    }

    void inserer(int entier) {
        if (nbr_element >= taille) {
            agrandirTableau();
        }
        int i;
        for (i = 0; i < nbr_element; i++) {
            if (entier < numbers[i]) {
                break;
            }
        }
        for (int j = nbr_element; j > i; j--) {
            numbers[j] = numbers[j - 1];
        }
        numbers[i] = entier;
        nbr_element++;
    }

    void supprimer(int entier) {
        for (int i = 0; i < nbr_element; i++) {
            if (numbers[i] == entier) {
                for (int j = i; j < nbr_element - 1; j++) {
                    numbers[j] = numbers[j + 1];
                }
                nbr_element--;
                if (taille - nbr_element >= 2 * increment) {
                    reduireTableau();
                }
                return;
            }
        }
    }

    private void agrandirTableau() {
        int nouvelleTaille = taille + increment; // la nouvelle taille
        int[] nouveauTableau = new int[nouvelleTaille]; 
        System.arraycopy(numbers, 0, nouveauTableau, 0, nbr_element);
        numbers = nouveauTableau;
        taille = nouvelleTaille;
    }

    private void reduireTableau() {
        int nouvelleTaille = taille - increment;
        int[] nouveauTableau = new int[nouvelleTaille];
        System.arraycopy(numbers, 0, nouveauTableau, 0, nbr_element);
        numbers = nouveauTableau;
        taille = nouvelleTaille;
    }

 
    public String toString() {
        if (nbr_element == 0) {
        	
            return "taille: 0 \n\t[]";
        }
        StringBuilder sb = new StringBuilder("taille: "+ taille +"\n\t[");
        for (int i = 0; i < nbr_element - 1; i++) {
            sb.append(numbers[i]).append(", ");
        }
        sb.append(numbers[nbr_element - 1]).append("]");
        return sb.toString();
    }
    
}