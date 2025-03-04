package ex1;

import java.util.StringTokenizer;

public class Troncature {

	public static void main(String[] args) {
		for (int i = 0; i < args.length - 1; i += 2) {
			try {
				double x = Double.parseDouble(args[i]);
				int nbDecimales = Integer.parseInt(args[i + 1]);

				String resultat = tronque(x, nbDecimales);
				System.out.println(resultat);

			} catch (NumberFormatException e) {
				System.out.println("Erreur : Format invalide. Veuillez entrer un double et un entier.");
			} catch (NullPointerException e) {

			} catch (PositiveNumber e) {

			}
		}

	}

	public static String tronque(double x, int nbDecimales)
			throws NumberFormatException, NullPointerException, PositiveNumber {

		String str = Double.toString(x);

		if (nbDecimales < 0)
			throw new PositiveNumber("Erreur : Format invalide. Veuillez entrer un entier positive.");

		// Séparer la partie entière et la partie décimale avec un StringTokenizer
		StringTokenizer st = new StringTokenizer(str, ".");
		String partieEntiere = st.nextToken();
		String partieDecimale = (st.hasMoreTokens()) ? st.nextToken() : "";

		// Si on ne veut aucune décimale
		if (nbDecimales == 0) {
			return partieEntiere;
		}
		if(partieDecimale.length() < nbDecimales)
			for(int i=partieDecimale.length();i<=nbDecimales;i++)
				partieDecimale+="0";
		if (partieDecimale.length() > nbDecimales) {
			partieDecimale = partieDecimale.substring(0, nbDecimales);
		}

		return partieEntiere + (partieDecimale.isEmpty() ? "" : "." + partieDecimale);
	}

}

class PositiveNumber extends Exception {
	private String exception;

	PositiveNumber(String _exception) {
		exception = _exception;
	}

	PositiveNumber() {
		this("Positive number");
	}

	public String toString() {
		return exception;
	}
	
	public String getMessage()
	{
		return exception;
	}
}