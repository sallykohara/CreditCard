import java.io.IOException;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner; 

public class textFile
	{
		
		public static void main(String[] args) throws IOException
			{
				ArrayList<textFile> Student = new ArrayList<>();
				getTextFile();
			}
			
		public static void getTextFile() throws IOException
		{
			Scanner file = new Scanner(new File("newTextFile.txt"));
			while(file.hasNext())
				{
					String firstName = file.next();
					Student.add(new Student(String f, String l))
				    System.out.println(firstName);
				}
		}

	}//meow!!!!
