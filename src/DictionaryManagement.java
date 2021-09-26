import java.util.Scanner;

public class DictionaryManagement {
    static Dictionary book;

    void insertFromCommandline() {
        Scanner sc = new Scanner(System.in);
        int numberOfWord = -1;
        int dictIndex = 0;

        while (numberOfWord <= 0) {
            System.out.println("How many words are there?");
            System.out.print("(Input a positive number): ");
            numberOfWord = sc.nextInt();
        }

        book.dict = new Word[numberOfWord];
        while (numberOfWord > 0) {
            System.out.println("Input the English word and its Vietnamese translation: ");
            String wordEn = sc.nextLine();
            String wordVie = sc.nextLine();

            System.out.println(wordEn + " va " + wordVie);


            book.dict[dictIndex] = new Word(wordEn, wordVie);

            ++dictIndex;
            --numberOfWord;
        }
    }
}
