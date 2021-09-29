import java.util.Scanner;

public class DictionaryManagement {

    static Character book;
    Scanner sc = new Scanner(System.in);

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
        autoFlush = sc.nextLine();          // Flushed!             Bruh!:D

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
            ///////////////////////////////

            ++dictIndex;    // Increase the index of the Word array
            --numberOfWord; // Reduce the number of Word in the queue by 1
        }
    }
    public static void main(String[] args) {
        DictionaryManagement test = new DictionaryManagement();
    }
}
