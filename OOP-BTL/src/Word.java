public class Word {
    private String word_target;
    private String word_explain;

    String getWord_target() {
        return word_target;
    }

    String getWord_explain() {
        return word_explain;
    }

    Word() {
        word_target = "";
        word_explain = "";
    }

    Word(String en, String vie) {
        word_target = en;
        word_explain = vie;
    }
}
