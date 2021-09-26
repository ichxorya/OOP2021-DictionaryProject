import java.util.Scanner;

public class DictionaryManagement {
    static Dictionary book;

    void insertFromCommandline() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String wordEn = sc.nextLine();
            String wordVie = sc.nextLine();
            Word[] newbook = new Word[book.dict.length + 1];
            System.arraycopy(book.dict, 0, book.dict, 0, book.dict.length);
            book.dict = newbook;
            book.dict[book.dict.length - 1] = new Word(wordEn, wordVie);
        }
    }
}
