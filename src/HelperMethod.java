import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

/**
 * A class contain method that not classified (but we need it).
 */

public class HelperMethod {

    //----------------------------------------------------------------------------------------------------------------------------------//

    /**
     * a method to make output look better like this:
     * no     |  engWord       |  vieWord
     * amd then print output.
     */
    static void formatStringAndPrint(int index, String firstWord, String secondWord) {
        /* Space-padding */
        String indexStr = index + "";
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
     * I dont know wtf is this but we need it.
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
