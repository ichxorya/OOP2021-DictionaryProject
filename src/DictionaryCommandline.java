import java.util.Dictionary;

public class DictionaryCommandline {

    /**
     * DictionaryCommandline class.
     * (Main class for CLI (Command Line Interface) users).
     */

    //----------------------------------------------------------------------------------------------------------------------------------//

    DictionaryManagement cliDictionary = new DictionaryManagement();   // Init a dictionary management to use.

    //----------------------------------------------------------------------------------------------------------------------------------//

    /**
     * Input from cmd, txt file and print all.
     * Obsolete method, use dictionaryAdvanced() instead.
     */
    @Deprecated
     void dictionaryBasic() {
        cliDictionary.insertFromCommandline();
        cliDictionary.insertFromFile();
        cliDictionary.showAllWords();
    }

    //----------------------------------------------------------------------------------------------------------------------------------//

    /**
     * Input from file and search.
     */
    void dictionaryAdvanced() {
        cliDictionary.insertFromFile();
        cliDictionary.searchFromCommandLine();
    }

    //----------------------------------------------------------------------------------------------------------------------------------//

    /**
     * Main method.
     */

    public static void main(String[] args) {
        DictionaryCommandline test = new DictionaryCommandline();
        test.dictionaryAdvanced();
    }

    //----------------------------------------------------------------------------------------------------------------------------------//
}
