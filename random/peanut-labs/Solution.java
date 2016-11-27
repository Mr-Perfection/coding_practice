import java.lang.*;
import java.util.*;
import java.io.*;

public class Solution
{
	public static void main(String[] args) {
		// The name of the file to open.
        String fileName = "input.txt";

        try {
            // Use this for reading the data.
            byte[] buffer = new byte[1000];

            FileInputStream inputStream = 
                new FileInputStream(fileName);

            // read fills buffer with data and returns
            // the number of bytes read (which of course
            // may be less than the buffer size, but
            // it will never be more).
            int total = 0;
            int nRead = 0;
            int cols = 0;
            int rows = 0;
            while((nRead = inputStream.read(buffer)) != -1) {
                // Convert to String so we can display it.
                // Of course you wouldn't want to do this with
                // a 'real' binary file.
                String buf = new String(buffer);
                System.out.println(new String(buffer));
                rows = buf.length();
                System.out.println("rows: " + rows);
                total += nRead;
            	cols += 1;
            }   

            // Always close files.
            inputStream.close();        

            // System.out.println("Read " + total + " bytes");
            System.out.println("cols: " + cols);
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                  
            // Or we could just do this: 
            // ex.printStackTrace();
        }

	}
}