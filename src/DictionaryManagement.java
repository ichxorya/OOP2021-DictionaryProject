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
}
