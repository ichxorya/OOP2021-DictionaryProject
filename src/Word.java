/**
 * Word class - Contains an English word and its Vietnamese explanation.
 * Obsolete class, use Character instead.
 */
@Deprecated
public class Word {

    //-----------------------------------------------------------------------------------------------------------------------------//

    private String word_target;     // English
    private String word_explain;    // Vietnamese

    //-----------------------------------------------------------------------------------------------------------------------------//

    /**
     * Constructors.
     */

    Word() {
        word_target = "";
        word_explain = "";
    }

    Word(String eng, String vie) {
        word_target = eng;
        word_explain = vie;
    }

    //-----------------------------------------------------------------------------------------------------------------------------//

    /**
     * Getters.
     */

    String getWord_target() {
        return word_target;
    }

    String getWord_explain() {
        return word_explain;
    }

    //----------------------------------------------------------------------------------------------------------------------------------//

}
