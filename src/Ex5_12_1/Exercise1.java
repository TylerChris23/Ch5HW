package Ex5_12_1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * This program reads numbers from a CSV file, calculates stats like
 * sum, lowest number, highest number, and average,
 * and writes the results to a text file.
 */
public class Exercise1 {
    public static void main(String[] args) {
        // Allows variables of int values to store the sum,lowest,highest, and count
        int sum = 0;
        int lowest = Integer.MAX_VALUE;
        int highest = Integer.MIN_VALUE;
        int count = 0;

        try (BufferedReader br = new BufferedReader(new FileReader("Book1.csv"));
             FileWriter writer = new FileWriter("stats.txt")) {

            String line;
            // Read each line from the CSV file
            while ((line = br.readLine()) != null) {
                // Split the line by comma to extract numbers
                String[] numbers = line.split(",");
                for (String number : numbers) {
                    //converts each num from string to int
                    int num = Integer.parseInt(number.trim());
                    sum += num;
                    lowest = Math.min(lowest, num);
                    highest = Math.max(highest, num);
                    count++;
                }
            }
            // Calculate the average
            double average = sum / count;
            //Write statistics to the output
            writer.write("The sum of the numbers is: " + sum + "\n");
            writer.write("The lowest number is: " + lowest + "\n");
            writer.write("The highest number is: " + highest + "\n");
            writer.write("The average of the numbers is: " + average + "\n");

            System.out.println("Statistics have been written to " + sum);
        } catch (IOException e) {
            System.out.println("Error Happen: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
