public class DictionaryCommandline {
    DictionaryManagement top = new DictionaryManagement();

    void showAllWords() {
        System.out.println("NO   | English    | Vietnamese");
        for (int i = 0; i < top.book.dict.length; i++) {
            System.out.println((i + 1) + "   " + top.book.dict[i].getWord_target() + "   " + top.book.dict[i].getWord_explain());
        }
    }

    void dictionaryBasic() {
        top.insertFromCommandline();
        showAllWords();
    }

    public static void main(String[] args) {
        DictionaryCommandline test = new DictionaryCommandline();
        test.dictionaryBasic();
    }
}
