package com.example.tree_dictionary_app;

import java.util.ArrayList;

/**
 * DictChar class.
 *
 * 1. Each DictChar object is a branch of a *tree*
 *    It can be the root, or the parent of other child-branches.
 *
 * 2. Each branch contains a character and their meaning at that branch.
 *    For example: D: Chữ D
 *                 -> O: Làm
 *                    -> G: Con chó
 */

public class DictChar {

    //----------------------------------------------------------------------------------------------------------------------------------//

    private char character;                                             // The character of the branch
    private String meaning;                                             // The meaning of the word of that branch
    ArrayList<DictChar> afterChar = new ArrayList<DictChar>();          // An ArrayList of DictChar

    //----------------------------------------------------------------------------------------------------------------------------------//

    /**
     * Getters and Setters.
     */
    void setCharacter(char c) {
        character = c;
    }

    void setMeaning(String m) {
        meaning = m;
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
    DictChar(char inputChar, String inputMeaning) {
        setCharacter(inputChar);
        setMeaning(inputMeaning);
    }

    //----------------------------------------------------------------------------------------------------------------------------------//

    /**
     * Find a DictChar in this branch:
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
     * Recursive method to put a word and its meaning into the tree.
     */
    void addWord(String word, String meaning) {
        char ch = word.charAt(0);

        int loc = findChar(ch);

        if (loc == -1) {
            if (word.length() == 1) {
                this.afterChar.add(new DictChar(ch, meaning));
            } else {
                this.afterChar.add(new DictChar(ch, ""));
                this.afterChar.get(this.afterChar.size() - 1).addWord(word.substring(1, word.length()), meaning);
            }
        } else {
            if (word.length() == 1) {
                this.afterChar.get(loc).setMeaning(meaning);
            } else {
                this.afterChar.get(loc).addWord(word.substring(1, word.length()), meaning);
            }
        }
        DictionaryUtilities.ArrSort(this);
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
        return "This word does not exist!";
    }

    //----------------------------------------------------------------------------------------------------------------------------------//

    /**
     * Recursive method to change meaning of a word in the tree.
     * return "we can't find it" if there's no word.
     */
    String changeMeaning(String inputWord, String newMeaning) {
        String noFound = "We can't find it!";
        char ch = inputWord.charAt(0);

        for (int i = 0; i < afterChar.size(); i++) {
            if (afterChar.get(i).getCharacter() == ch) {
                if (inputWord.length() == 1) {
                    afterChar.get(i).setMeaning(newMeaning);
                    return afterChar.get(i).getMeaning();
                } else {
                    return afterChar.get(i).changeMeaning(inputWord.substring(1, inputWord.length()), newMeaning);
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
                    return afterChar.get(i).getMeaning();
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
    DictChar searchPart(String part) {
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
        return new DictChar(' ', "");
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

        if (!getMeaning().equals("")) {
            if (flag == 0) {
                index += 1;
                DictionaryUtilities.formatStringAndPrint(index, wordForm, getMeaning());
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

    /**
     *  Modified printAll() to match the dict-to-file method.
     *  Goddamn I'm stoopid af, this is unoptimized but it works lol!
     */
    int dictToFileFiller(ArrayList<String> dictToFile, String wordForm, int index) {
        wordForm += getCharacter();

        if (!getMeaning().equals("")) {
            index += 1;
            dictToFile.add(DictionaryUtilities.formatStringAndReturn(index, wordForm, getMeaning()));
        }

        if (afterChar.size() != 0) {
            for (int i = 0; i < afterChar.size(); i++) {
                index = afterChar.get(i).dictToFileFiller(dictToFile, wordForm, index);
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