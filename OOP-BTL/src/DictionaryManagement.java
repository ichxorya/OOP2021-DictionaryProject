import java.util.Arrays;
import java.util.Scanner;

public class DictionaryManagement {
    static Dictionary book;

    void insertFromCommandline() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String wordEn = sc.nextLine();
            String wordVie = sc.nextLine();

            Word[] newbook = Arrays.copyOf(book.dict, book.dict.length + 1);
            newbook[newbook.length - 1] = new Word(wordEn, wordVie);
            book.dict = newbook;
        }
    }
    public static void main(String[] args) {
        DictionaryManagement top = new DictionaryManagement();
        top.insertFromCommandline();
        for (int i = 0; i < top.book.dict.length; i++) {
            System.out.println((i + 1) + "   " + top.book.dict[i].getWord_target() + "   " + top.book.dict[i].getWord_explain());
        }
    }
}
