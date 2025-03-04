package tp1;
import static java.lang.System.*;
public class Somme {

	public static void main(String[] args) {
		int somme = 0;
		boolean child = false;
			for (String arg : args) {
				try {
				somme += Integer.parseInt(arg);
				}catch(NumberFormatException nfe) {
					child = true;
				}
			}

		out.println("This is the somme: " + somme );
		if(child) {
			out.println("Next time don't provide an non integer value");
		}

	}

}
