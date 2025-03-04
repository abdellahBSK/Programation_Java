package ex1;


public class test {

//	public test() {
//
//	}

	public static void main(String[] args) {
		String number =  "12.122212";

		int intNumber = 0;
		try 
		{
			intNumber = Integer.parseInt(number);
		}catch(NumberFormatException e)
		{
			System.out.println("Erreur");
		}
		System.out.println(intNumber);

	}

}
