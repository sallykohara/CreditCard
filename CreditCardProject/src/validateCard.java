import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner; 

public class validateCard
	{
		static String playerAnswer; 
		static ArrayList<Object> cardNumbers; 
		static int sum;
		private static int count; 
		
		public static void main(String[]args)
		{
			helloUser(); 
			playerAnswer(playerAnswer);
			readTextFile(); 
		}
		public static void helloUser()
		{
			Scanner userInput = new Scanner(System.in);
			System.out.println("Input a 16 digit credit card number to test if it is a valid credit card number.");
			playerAnswer = userInput.nextLine();
		}
		public static void readTextFile()
		{
			try
		        {
		            Scanner myFile = new Scanner(new File("creditCardFile"));
		            while (myFile.hasNextLine())
		            {
		                String line = myFile.nextLine();
		                System.out.println("Checking from file: " + line);
		                playerAnswer(line);
		            }
		        }
		        catch (FileNotFoundException e)
		        {
		            System.out.println("File not found.");
		        }

		}
		public static void playerAnswer(String input)
		{
			cardNumbers = new ArrayList<>();
			for(int i=0; i<input.length(); i++)
				{
					int digit = input.charAt(i) - '0';
					cardNumbers.add(digit);
				}
			doubleAlternating();
			addTwoDigits();
			newValues();
			divideByTen();
		}
		
		public static void doubleAlternating()
		{
			for(int i = cardNumbers.size()-2; i>=0; i=2)
				{
					int doubledDigits = (int) cardNumbers.get(i)*2;
					cardNumbers.set(i,  doubledDigits);
				}
		}
		public static void addTwoDigits()
		{
			for(int i = 0; i< cardNumbers.size(); i++)
				{
					int value = (int) cardNumbers.get(i);
					if(value>9)
						{
							cardNumbers.set(i,  (value/10)+(value % 10));
						}
				}
		}
		public static void newValues()
		{
			sum = 0; 
			for (int i=0; i<cardNumbers.size(); i++)
				{
					sum+=(int) cardNumbers.get(i);
				}
		}
		public static void divideByTen()
		{
			if(sum % 10==0)
				{
					System.out.println("This number is valid!");
					count++;
				}
			else
				{
					System.out.println("This number is not valid....");
				}
		}

	}
