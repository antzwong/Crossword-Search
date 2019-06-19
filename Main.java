/*
 * given a 2d array of characters and a single string, write a method which checks if the string is in the 2d array.
 * the string may be horizontal, vertical, diagonal, or even backwards.
 * If there are any questions about the dimensions of the array consider the situation a crossword search is in
 */

package com.company.main;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        String[][] test1 = {
                {"abcde"},
                {"fghij"},
                {"klmno"},
                {"pqrst"},
                {"uvwxy"}
        };

        System.out.println(Search(test1, "abc"));

    }


    /* does the search horizontal, vertical, diagonal, etc
     * @Search the 2d array being searched
     * @word the word that is being looked for
     * @return is the word in the 2d array

     */


    public static boolean Search(String[][] Search, String word) {
        return horizontal(Search, word); //|| vertical(Search, word) || diagonal(Search, word);

    }


    /*
     * horizontal check. method checks if the word is horizontally located.
     * @param Search the 2d array of characters to be searched
     * @word that's being searched for
     * @return is the word in the 2d array or not
     * TODO account for the case where the word is NOT in the array
     * TODO make this more module. basically all the comparison stuff
     * TODO account for words that are backwards. this includes vertical, horizontal and diagonal
     *
     */
    public static boolean horizontal(String[][] Search, String word) {

        /* variable declaration */
        int wordLength = word.length(); //length of the word. use is to stop before reaching end of array
        int numRows = Search.length; //the number of rows in the array
        boolean in = false;

        //accounts for the case where word length > array length
        // in which case its impossible for the word to be in the array
        if (wordLength > numRows) {
            return false;
        }

        //iterates through start of each row
        int row = 0;
        while(!in && row < numRows) { //stops once it reaches end of row or finds the word
            System.out.println("Searching row: " + row);
            in = horizontalSearch(Search[row], word);
            row++;
        }

        return in;
    }

    /* Searches the isolated horizontal row
     * @param row the row that is being searched through
     * @word the word that is being searched for
     * @return is the word in the row
     */

    public static boolean horizontalSearch(String[] row, String word) {

        /* variable declaration */
        int match = 0; //how many chars match

        //iterates through the current row
        for (int index = 0; index < row.length; index++) { //iterates through row
            //filters words into the test char[]
            String test[] = new String[word.length()]; //array to holding chars to test

            //assigns chars to the test array
            for (int i = index; i < word.length(); i++) {
                test[i] = row[i];
            }
            System.out.println("Words in the test array:" + Arrays.toString(test));

            for (int i = 0; i < row.length; i++) { //compares the chars in the tes char vs the word
                if (row[i] == "" + (word.charAt(i))) { //checks how many characters are the same
                    match++; //increments the match
                }
            }

            //takes care of the case where the word is a perfect match
            if (match == word.length()) {
                return true;
            } else { //need to reset the values for the next char move on
                match = 0;
            }
        }
        return false;
    }

    public boolean vertical(String[] row, String word) {
        return false;
    }

    public boolean diagonal(String[] row, String word) {
        return false;
    }


}
