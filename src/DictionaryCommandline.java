import java.util.Dictionary;

public class DictionaryCommandline {

    /**
     * DictionaryCommandline class - Main class for cmd user.
     */

    //----------------------------------------------------------------------------------------------------------------------------------//

    DictionaryManagement cliDictionary = new DictionaryManagement();   // init a dictionary management to use.

    //----------------------------------------------------------------------------------------------------------------------------------//

    /**
     * input from cmd, txt file and print all.
     */
    void dictionaryBasic() {
        cliDictionary.insertFromCommandline();
        cliDictionary.insertFromFile();
        cliDictionary.showAllWords();
    }

    //----------------------------------------------------------------------------------------------------------------------------------//

    /**
     * input from file and search.
     */
    void dictionaryAdvanced() {
        cliDictionary.insertFromFile();
        cliDictionary.optionFromCommandLine();
    }

    //----------------------------------------------------------------------------------------------------------------------------------//

    public static void main(String[] args) {
        DictionaryCommandline test = new DictionaryCommandline();
        test.dictionaryAdvanced();
    }

    //----------------------------------------------------------------------------------------------------------------------------------//
}
