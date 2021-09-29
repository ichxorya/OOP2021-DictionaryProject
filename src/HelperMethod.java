public class HelperMethod {
    static String formatString(int index, String firstWord, String secondWord) {
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
        return (indexStr + firstWord + secondWord);
    }
}
