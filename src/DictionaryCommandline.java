public class DictionaryCommandline {
    /**
     * DictionaryCommandline class - Main class.
     */

    DictionaryManagement cliDictionary = new DictionaryManagement();

    void showAllWords() {
        int lengthOfDictionary = Dictionary.dictionary.length;
        /* Message's length:012345678901234567890123456789*/
        System.out.println("NO   | English    | Vietnamese");
        for (int i = 0; i < lengthOfDictionary; i++) {
            String wordEn = Dictionary.dictionary[i].getWord_target();
            String wordVie = Dictionary.dictionary[i].getWord_explain();

            /* Print out the English word and its Vietnamese translation */
            String formattedWord = formatString(i + 1, wordEn, wordVie);
            System.out.println(formattedWord);
        }
    }

    void dictionaryBasic() {
        cliDictionary.insertFromCommandline();
        showAllWords();
    }

    String formatString(int index, String firstWord, String secondWord) {
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

    public static void main(String[] args) {
        DictionaryCommandline test = new DictionaryCommandline();
        test.dictionaryBasic();
    }
}
