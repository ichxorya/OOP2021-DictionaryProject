/**
 * Character class.
 * (Should be mentioned as *Character*).
 *
 * 1. Each Character object is a branch of a *tree*
 *    It can be the root, or the parent of other children branches.
 *
 * 2. Each branch contains a character and their meaning at that branch.
 *    For example: D: Chữ D
 *                 -> O: Làm
 *                    -> G: Con chó
 */

public class Character {
    
    //----------------------------------------------------------------------------------------------------------------------------------//

    private char character;                     // The character of the branch
    private String meaning;                     // Meaning of the word of that branch
    public Character[] afterChar = {};          // Sub-branches of this branch

    //----------------------------------------------------------------------------------------------------------------------------------//

    /**
     * Getters and Setters.
     */

    void setCharacter(char character) {
        this.character = character;
    }

    void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    char getCharacter() {
        return character;
    }

    String getMeaning() {
        return meaning;
    }

    //----------------------------------------------------------------------------------------------------------------------------------//

    /**
     * Constructor.
     */
    Character(char inputChar, String inputMeaning) {
        setCharacter(inputChar);
        setMeaning(inputMeaning);
    }

    //----------------------------------------------------------------------------------------------------------------------------------//

    /**
     * Add a *Character* to the present branch.
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

    /**
     * Find a *Character* in this branch, return -1 if not found.
     */
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
     * Recursive method to input a word and ít meaning into the tree.
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
                this.afterChar[loc].setMeaning(vieWord);
            } else {
                this.afterChar[loc].addWord(engWord.substring(1, engWord.length()), vieWord);
            }
        }
    }

    //----------------------------------------------------------------------------------------------------------------------------------//

    /**
     * Recursive method to search a word and return ít meaning.
     * return "We can't find it" if there's no word.
     */
    String searchWord(String inputWord) {
        String noFound = "We can't find it";
        char ch = inputWord.charAt(0);

        for (int i = 0; i < afterChar.length; i++) {
            if (afterChar[i].getCharacter() == ch) {
                if (inputWord.length() == 1) {
                    return afterChar[i].getMeaning();
                } else {
                    return afterChar[i].searchWord(inputWord.substring(1, inputWord.length()));
                }
            }
        }
        return noFound;
    }

    //----------------------------------------------------------------------------------------------------------------------------------//

    /**
     * Recursive method to search the branch of the last char of word
     */
    Character searchPart(String part) {
        char ch = part.charAt(0);

        for (int i = 0; i < afterChar.length; i++) {
            if (afterChar[i].getCharacter() == ch) {
                if (part.length() == 1) {
                    return afterChar[i];
                } else {
                    return afterChar[i].searchPart(part.substring(1, part.length()));
                }
            }
        }
        return new Character(' ', "");
    }

    //----------------------------------------------------------------------------------------------------------------------------------//

    /**
     * Recursive method to print all the word include number and meaning in dictionary in order.
     * flag 0 to print to cmd.
     * flag 1 to print to visual app. (not yet)
     * return number of word in that branch.
     */
    int printAll(String wordForm, int index, int flag) {
        wordForm += getCharacter();

        if (getMeaning() != "") {
            if (flag == 0) {
                index += 1;
                HelperMethod.formatStringAndPrint(index, wordForm, getMeaning());
            } else {
            }
        }
        if (afterChar.length != 0) {
            for (int i = 0; i < afterChar.length; i++) {
                index = afterChar[i].printAll(wordForm, index, flag);
            }
        }
        return index;
    }

    //----------------------------------------------------------------------------------------------------------------------------------//

    /**
     * Recursive method to print all branch in a tree-style look.
     * for test and debug only.
     */
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
}