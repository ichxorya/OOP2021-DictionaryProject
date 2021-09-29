public class Character {

    private char character;                     //the character of the branch
    private String mean;                        //meaning of the word of that branch
    public Character[] afterChar = {};          //branches of this branch

    //----------------------------------------------------------------------------------------------------------------------------------//

    /**
     * geter and seter
     */

    void setCharacter(char c) {
        character = c;
    }

    void setMean(String m) {
        mean = m;
    }

    char getCharacter() {
        return character;
    }

    String getMean() {
        return mean;
    }

    //----------------------------------------------------------------------------------------------------------------------------------//

    /**
     * constructor
     */
    Character(char inputChar, String inMean) {
        setCharacter(inputChar);
        setMean(inMean);
    }

    //----------------------------------------------------------------------------------------------------------------------------------//

    /**
     * add a branch at right order
     */
    void addChar(Character newChar) {
        Character[] tmpArr = new Character[afterChar.length + 1];
        System.arraycopy(afterChar, 0, tmpArr, 0, afterChar.length);
        tmpArr[tmpArr.length - 1] = newChar;
        afterChar = tmpArr;
        for (int i = afterChar.length - 1; i > 0; i--) {
            if (afterChar[i].getCharacter() < afterChar[i - 1].getCharacter()) {
                Character tmp = afterChar[i];
                afterChar[i] = afterChar[i - 1];
                afterChar[i - 1] = tmp;
            }
        }
    }

    //----------------------------------------------------------------------------------------------------------------------------------//

    int findChar(char ch) {
        int loc = -1;
        if (this.afterChar.length > 0) {
            for (int i = 0; i < this.afterChar.length; i++) {
                if (this.afterChar[i].getCharacter() == ch) {
                    loc = i;
                }
            }
        }
        return loc;
    }

    //----------------------------------------------------------------------------------------------------------------------------------//

    /**
     * Recursive method to input a word and ít meaning into the tree
     */
    void addWord(String engWord, String vieWord) {
        char ch = engWord.charAt(0);

        int loc = findChar(ch);

        if (loc == -1) {
            if (engWord.length() == 1) {
                this.addChar(new Character(ch, vieWord));
            } else {
                this.addChar(new Character(ch, ""));
                loc = findChar(ch);
                this.afterChar[loc].addWord(engWord.substring(1, engWord.length()), vieWord);
            }
        } else {
            if (engWord.length() == 1) {
                this.afterChar[loc].setMean(vieWord);
            } else {
                this.afterChar[loc].addWord(engWord.substring(1, engWord.length()), vieWord);
            }
        }
    }

    //----------------------------------------------------------------------------------------------------------------------------------//

    /**
     * search a word and return ít meaning
     */
    String searchWord(String inputWord) {
        String noFound = "we can find it";
        char ch = inputWord.charAt(0);

        for (int i = 0; i < afterChar.length; i++) {
            if (afterChar[i].getCharacter() == ch) {
                if (inputWord.length() == 1) {
                    return afterChar[i].getMean();
                } else {
                    return searchWord(inputWord.substring(1, inputWord.length()));
                }
            }
        }
        return noFound;
    }

    //----------------------------------------------------------------------------------------------------------------------------------//

    /*
     * Print everything
     */
    void printAll(String wordForm) {
        wordForm += getCharacter();
        if (getMean() != "") {
            System.out.println(wordForm + " " + getMean());
        }
        if (afterChar.length != 0) {
            for (int i = 0; i < afterChar.length; i++) {
                afterChar[i].printAll(wordForm);
            }
        }
    }

    //----------------------------------------------------------------------------------------------------------------------------------//

    void printChar() {
        System.out.print(getCharacter() + " ");
        System.out.print("(");
        if (afterChar.length > 0) {
            for (int i = 0; i < afterChar.length; i++) {
                afterChar[i].printChar();

            }
        }
        System.out.print(")");
    }

    //----------------------------------------------------------------------------------------------------------------------------------//

    public static void main(String[] args) {
        Character test = new Character(' ', "");
        test.addWord("axe", "riu" );
        test.addWord("godgame", "tham tro choi" );
        test.addWord("god", "tham" );
        test.addWord("male", "nam" );
        test.addWord("female", "nu" );
        test.addWord("ass", "mong" );
        test.addWord("astroid", "thien thach" );
        test.addWord("as", "như là" );
        test.addWord("adudu", "adudu" );
        test.addWord("godfalse", "than sai cmnr" );
        test.addWord("godfall", "rot than" );
        test.addWord("goofy", "goofy" );
        test.printAll("");
        /*for (int i = 0; i < test.afterChar[0].afterChar.length; i++) {
            System.out.print(test.afterChar[0].afterChar[i].getCharacter() + " ");
        }*/
    }
}