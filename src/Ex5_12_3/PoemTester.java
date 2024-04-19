package Ex5_12_3;

import Ex5_12_2.Poem;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * This program reads data from a text file containing poems and poets,
 * creates Poem objects for each entry, and prints them.
 */
public class PoemTester {

    public static void main(String[] args) {
        // Try method to read from the file
        try {
            // Create a BufferedReader to read
            BufferedReader br  = new BufferedReader(new FileReader("poem2.txt"));
            String line;
            // Read each line from the file
            while ((line = br.readLine()) != null) {
                // Read the name of the poem
                String poemName = line;
                // Read the name of the poet
                String poet = br.readLine();
                // Create a Poem object and set its name and poet
                Poem poem = new Poem();
                poem.setName(poemName);
                poem.setPoet(poet);
                // prints poem object
                System.out.println(poem);
            }
        } catch (IOException e) {
            //print error message
            System.out.println("Error occurred.");
            e.printStackTrace();
        }
    }
}

