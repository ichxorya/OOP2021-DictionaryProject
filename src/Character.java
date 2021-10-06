import java.util.ArrayList;

public class Character {

    /**
     * Character Class
     * each Character is a branch of tree, has another or root as father and other branches as sons.
     * Each branch contain char and mean at that branch.
     */

    //----------------------------------------------------------------------------------------------------------------------------------//

    private char character;                                             //the character of the branch
    private String mean;                                                //meaning of the word of that branch
    ArrayList<Character> afterChar = new ArrayList<Character>();        //Muahahaha evolve to ArrayList. So much better.

    //----------------------------------------------------------------------------------------------------------------------------------//

    /**
     * getter and setter
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
     * Find a Character in this branch:
     * - Return -1 if not found.
     * - Return index if found.
     */
    int findChar(char ch) {
        if (afterChar.size() > 0) {
            for (int j = 0; j < afterChar.size(); j++) {
                if (afterChar.get(j).getCharacter() == ch) {
                    return j;
                }
            }
        }
        return -1;
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
                this.afterChar.add(new Character(ch, vieWord));
            } else {
                this.afterChar.add(new Character(ch, ""));
                this.afterChar.get(this.afterChar.size() - 1).addWord(engWord.substring(1, engWord.length()), vieWord);
            }
        } else {
            if (engWord.length() == 1) {
                this.afterChar.get(loc).setMean(vieWord);
            } else {
                this.afterChar.get(loc).addWord(engWord.substring(1, engWord.length()), vieWord);
            }
        }
        HelperMethod.ArrSort(this);
    }

    //----------------------------------------------------------------------------------------------------------------------------------//

    /**
     * Recursive method to delete a word and ít meaning from the tree.
     * Return "This word in not exist!" if not exist.
     */
    String deleteWord(String inputWord) {
        char ch = inputWord.charAt(0);

        for (int i = 0; i < afterChar.size(); i++) {
            if (afterChar.get(i).getCharacter() == ch) {
                if (inputWord.length() == 1) {
                    afterChar.remove(i);
                    return "Found and deleted!";
                } else {
                    String res =  afterChar.get(i).deleteWord(inputWord.substring(1, inputWord.length()));
                    if (res.equals("Found and deleted!") && afterChar.get(i).afterChar.size() == 0) {
                        afterChar.remove(i);
                    }
                    return res;
                }
            }
        }
        return "This word in not exist!";
    }

    //----------------------------------------------------------------------------------------------------------------------------------//

    /**
     * Recursive method to change meaning of a word in the tree.
     * return "we can't find it" if there's no word.
     */
    String changeMean(String inputWord, String newMean) {
        String noFound = "We can't find it!";
        char ch = inputWord.charAt(0);

        for (int i = 0; i < afterChar.size(); i++) {
            if (afterChar.get(i).getCharacter() == ch) {
                if (inputWord.length() == 1) {
                    afterChar.get(i).setMean(newMean);
                    return afterChar.get(i).getMean();
                } else {
                    return afterChar.get(i).changeMean(inputWord.substring(1, inputWord.length()), newMean);
                }
            }
        }
        return noFound;
    }

    //----------------------------------------------------------------------------------------------------------------------------------//

    /**
     * Recursive method to search a word and return ít meaning.
     * return "we can't find it" if there's no word.
     */
    String searchWord(String inputWord) {
        String noFound = "We can't find it!";
        char ch = inputWord.charAt(0);

        for (int i = 0; i < afterChar.size(); i++) {
            if (afterChar.get(i).getCharacter() == ch) {
                if (inputWord.length() == 1) {
                    return afterChar.get(i).getMean();
                } else {
                    return afterChar.get(i).searchWord(inputWord.substring(1, inputWord.length()));
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

        for (int i = 0; i < afterChar.size(); i++) {
            if (afterChar.get(i).getCharacter() == ch) {
                if (part.length() == 1) {
                    return afterChar.get(i);
                } else {
                    return afterChar.get(i).searchPart(part.substring(1, part.length()));
                }
            }
        }
        return new Character(' ', "");
    }

    //----------------------------------------------------------------------------------------------------------------------------------//

    /**
     * Recursive method to print all the word include number and mean in dictionary in order.
     * flag 0 to pritn to cmd.
     * flag 1 to print to visual app. (not yet)
     * return number of word in that branch.
     */
    int printAll(String wordForm, int index, int flag) {
        wordForm += getCharacter();

        if (getMean() != "") {
            if (flag == 0) {
                index += 1;
                HelperMethod.formatStringAndPrint(index, wordForm, getMean());
            } else {
            }
        }
        if (afterChar.size() != 0) {
            for (int i = 0; i < afterChar.size(); i++) {
                index = afterChar.get(i).printAll(wordForm, index, flag);
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
        if (afterChar.size() > 0) {
            for (int i = 0; i < afterChar.size(); i++) {
                afterChar.get(i).printChar();

            }
        }
        System.out.print(")");
    }

    //----------------------------------------------------------------------------------------------------------------------------------//
}