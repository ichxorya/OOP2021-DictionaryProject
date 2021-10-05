import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

/**
 * A class contain method that not classified (but we need it).
 * (Renamed from HelperMethod to DictionaryUtilities)
 */

public class DictionaryUtilities {

    //----------------------------------------------------------------------------------------------------------------------------------//

    /**
     * Make the output look like this:
     *
     * Example:
     * NO   | English    | Vietnamese
     * 1    | FLower     | Hoa
     * 2    | Chicken    | Con gà
     */
    static void formatStringAndPrint(int index, String firstWord, String secondWord) {
        /* Space-padding */
        String indexStr = index + "";   // Convert the index (int) to String
        firstWord = "| " + firstWord;
        secondWord = "| " + secondWord;

        while (indexStr.length() < 5) {
            indexStr += ' ';
        }

        while ((indexStr + firstWord).length() < 18) {
            firstWord += ' ';
        }

        System.out.println(indexStr + firstWord + secondWord);
    }

    //----------------------------------------------------------------------------------------------------------------------------------//

    /**
     * Count the number of lines (of a file).
     */
    static int numberOfLines(File file) throws IOException {
        FileReader readFile = new FileReader(file);
        LineNumberReader lineNumberReader = new LineNumberReader(readFile);

        int lineNumber = 0;
        while (lineNumberReader.readLine() != null) {
            lineNumber++;
        }
        return lineNumber;
    }

    //----------------------------------------------------------------------------------------------------------------------------------//
}
