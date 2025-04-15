import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner; 

public class validateCard
	{
		static String playerAnswer; 
		static ArrayList<Integer> cardNumbers; 
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
		            Scanner myFile = new Scanner(new File("src/CreditCardNumbers.txt"));
		            while (myFile.hasNextLine())
		            {
		                String line = myFile.nextLine().trim();
		                System.out.println("Checking from file: " + line);
		                boolean isValid = playerAnswer(line);
		                if(isValid)
		                	{
		                		count++;
		                	}
		            }
		        }
		        catch (FileNotFoundException e)
		        {
		            System.out.println("File not found.");
		        }

		}
		public static boolean playerAnswer(String input)
		{
			cardNumbers = new ArrayList<>();
			if(input.length() !=16 || !input.matches("\\d+"))
				{
					System.out.println("Invalid input format: + input");
					return false;
				}
			for(int i=0; i<input.length(); i++)
				{
					int digit = input.charAt(i) - '0';
					cardNumbers.add(digit);
				}
			doubleAlternating();
			addTwoDigits();
			findSumOfValid();

			boolean isValid = (sum%10==0);
			if(isValid)
				{
					System.out.println("This number is valid! Go crazy!");
				}
			else
				{
					System.out.println("This number is not valid....");
				}
			return isValid;
		}
		
		public static void doubleAlternating()
		{
			for(int i = cardNumbers.size()-2; i>=0; i-=2)
				{
					int doubledDigits = ((int) cardNumbers.get(i)*2);
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
		public static void findSumOfValid()
		{
			sum = 0; 
			for(int num: cardNumbers)
				{
					sum += num;
				}
		}

	}
