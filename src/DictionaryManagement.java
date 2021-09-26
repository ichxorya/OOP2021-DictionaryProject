import java.util.Scanner;

public class DictionaryManagement {
    /**
     * Variables.
     */
    static Dictionary book;
    Scanner sc = new Scanner(System.in);

    /**
     * Methods.
     */

    /* Return a non-empty String */
    String nonEmptyString() {
        String aWord = sc.nextLine();
        return  aWord;
    }

    void insertFromCommandline() {
        /* Variables */
        int numberOfWord = -1;
        int dictIndex = 0;
        String wordEn = "";
        String wordVie = "";
        String autoFlush = "";     // Important variable meow~~

        /* Input */
        while (numberOfWord <= 0) {
            System.out.println("How many words are there?");
            System.out.print("(Input a positive number): ");
            numberOfWord = sc.nextInt();    // After using sc.nextInt(), we have to flush (?) the input stream
        }
        autoFlush = sc.nextLine();          // Flushed!

        book.dict = new Word[numberOfWord];
        while (numberOfWord > 0) {
            System.out.println("Input the English word and its Vietnamese translation: ");
            wordEn = sc.nextLine();
            wordVie = sc.nextLine();

            /* Non-empty check */
            while (wordEn.equals("")) {
                System.out.println("<!> Re-input the English word <!>");
                wordEn = sc.nextLine();
            }
            while (wordVie.equals("")) {
                System.out.println("<!> Re-input the Vietnamese translation <!>");
                wordVie = sc.nextLine();
            }

            /* Added to the dictionary */
            book.dict[dictIndex] = new Word(wordEn, wordVie);

            ++dictIndex;
            --numberOfWord;
        }
    }
}
