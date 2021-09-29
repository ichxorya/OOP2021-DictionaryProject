import java.util.Dictionary;

public class DictionaryCommandline {

    /**
     * DictionaryCommandline class - Main class for cmd user.
     */

    //----------------------------------------------------------------------------------------------------------------------------------//

    DictionaryManagement cliDictionary = new DictionaryManagement();   // init a dictionary management to use.

    //----------------------------------------------------------------------------------------------------------------------------------//

    void dictionaryBasic() {
        cliDictionary.insertFromCommandline();
        cliDictionary.insertFromFile();
        cliDictionary.showAllWords();
    }

    //----------------------------------------------------------------------------------------------------------------------------------//

    public static void main(String[] args) {
        DictionaryCommandline test = new DictionaryCommandline();
        test.dictionaryBasic();
    }

    //----------------------------------------------------------------------------------------------------------------------------------//
}
