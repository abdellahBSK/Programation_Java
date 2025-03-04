package tp1;

public class Morse {

	public static void main(String[] args) {
		String concat="";
		for(String arg : args) {
			concat +=arg + " stop. ";
		}
		System.out.println(concat);

	}

}
