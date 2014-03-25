import java.io.*;
public class TestFileInputStream7 {

	public static void main(String[] args) {

		  try (FileInputStream myFile = new  FileInputStream("abc.dat")) {
		            
		            boolean eof = false;

		            while (!eof) {
		                int byteValue = myFile.read();
		                System.out.print(byteValue + " ");
		                if (byteValue  == -1)
		                    eof = true;
		           }
		       
		  } catch (IOException e) {
		           System.out.println("Could not read file: " + 
		                                           e.toString());
		  } 
			 
		 }
	}

