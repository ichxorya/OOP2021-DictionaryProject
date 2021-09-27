public class Word {
    /**
     * Word class - Contains an English word and its Vietnamese explanation.
     */

    /** Variables. */
    private String word_target;     // English
    private String word_explain;    // Vietnamese

    /** Methods. */
    /* Constructors */
    Word() {
        word_target = "";
        word_explain = "";
    }

    Word(String en, String vie) {
        word_target = en;
        word_explain = vie;
    }

    /* Getters */
    String getWord_target() {
        return word_target;
    }

    String getWord_explain() {
        return word_explain;
    }
}
