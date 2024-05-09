import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Program that reads files and counts the vowels.
 *
 * @author Jessah
 * @version 1.0 @2024-05-03
 */
public final class NumVowels {

  /** Private constructor to prevent instantiation of this utility class. */
  private NumVowels() {
    // whitespace
  }

  /**
   * Counts the amount of vowels in string.
   *
   * @param i the info on the file.
   * @param n Is the the index for character count
   * @return Returns by calling recursive function and 1 or 0 for vowels.
   */
  public static int recNumVowels(final String i, final int n) {
    // base case for when the n reaches 0.
    if (n < 0) {
      return 0;
    }

  /*
   * Convert string to uppercase to check easier.
   * prevents the usage of checking lower and upper
   * case vowels.
   */
    String uppercase = i.toUpperCase();

    // Checks a single character at "n" index point.
    char ch = uppercase.charAt(n);

    // When the letter is a vowel
    if (ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
    /*
     * Calls the function and increments n by 1 for next letter
     * And adds a 1 to count the vowel.
     */
      return 1 + recNumVowels(i, n - 1);
    } else {
      // When the letter isn't a vowel.
      /*
       * Calls the function and increments n by 1 for next letter
       * And adds a 0 so if the word has no
       * vowels it will. Be seen as so with a 0 and
       * not blank Trying to differentiate non vowels
       * words and empty lines.
       */
      return 0 + recNumVowels(i, n - 1);
    }
  }

  /**
   * Main program.
   *
   * @param args Command-line arguments (not used in program).
   * @throws IOException
   */

  // Main program.
  public static void main(final String[] args) throws IOException {

    // Create file for input.
    final File inputFile =
     new File("Assign/Assign-03/Assign-03-Java-NumVowels/input.txt");
    // Create scanner to scan input.
    final Scanner input = new Scanner(inputFile);

    // Create file for output.
    final File outputFile =
     new File("Assign/Assign-03/Assign-03-Java-NumVowels/output.txt");
    // Allow to file write onto output file.
    final FileWriter output = new FileWriter(outputFile);
    // Checks if there is an existing file.
    try {
      // Checks if theres a string on next line.
      while (input.hasNext()) {
      /** Declare contents as string to pass to function.
       * And read current line.
      */
        final String line = input.nextLine();
        // Checks if line is empty.
        if (line.length() > 0) {
          /* Call recursive function.
           * line.length() - 1 because it becomes
           * out of range when it isn't used.
           */
          int vowels = recNumVowels(line, line.length() - 1);
          // write the values back to output file.
          output.write(vowels + "\n");
        } else {
          // Writes empty line to signify the empty line.
          output.write(line + "\n");
        }
      }
    } catch (IOException e) {
      // To check if there is no file
      System.out.println("No existing file.");
    }
    // Close input and output file.
    input.close();
    output.close();

    // Display when finished file reading.
    System.out.println("File reading is finished.");
  }
}
