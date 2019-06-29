package enigma;

import static enigma.EnigmaException.*;

/** Represents a permutation of a range of integers starting at 0 corresponding
 *  to the characters of an alphabet.
 *  @ Sandy Lee
 */
class Permutation {
    /**
     * Alphabet of this permutation.
     */
    //alphabet
    private Alphabet alphabet;
    /**
     * Cycle of this permutation.
     */
    // cycles is a string that represents the mappings, "(ABC)(DPQ)(XWY)..."
    private String cycles;

    //loop through the string and figure out how to populate the forwardArray
    //handle any special cases (multiple '' characters, missing letters map to themselves, etc.)
    //repeat above process for the backwardArray

    /**
     * Set this Permutation to that specified by CYCLES, a string in the
     * form "(cccc) (cc) ..." where the c's are characters in ALPHABET, which
     * is interpreted as a permutation in cycle notation.  Characters in the
     * alphabet that are not included in any cycle map to themselves.
     * Whitespace is ignored.
     */
    //underscores differentiate objects from instance variables
    Permutation(String cycles, Alphabet alphabet) {
        this.alphabet = alphabet;
        this.cycles = cycles;
    }

    /**
     * Return the value of P modulo the size of this permutation.
     */
    private final int wrap(int p) {
        int r = p % size();
        if (r < 0) {
            r += size();
        }
        return r;
    }

    /**
     * Returns the size of the alphabet I permute.
     */
    public int size() {

        return this.alphabet.size(); // FIXME - How do we ask the alphabet for its size?
    }

    /**
     * Return the index result of applying this permutation to the character
     * at index P in ALPHABET.
     */
    //return the index of the permutation that int p is mapped to
    //used the stored conversion array to translate it forward
    //example usage: integer of X
    //return forwardArray[23]
    public int permute(int p) {
        // NOTE: it might be beneficial to have one permute() method always call the other
        return this.alphabet.toChar(p);  // FIXME - How do we use our instance variables to get the index that P permutes to?


    /**
     * Return the index result of applying the inverse of this permutation
     * to the character at index C in ALPHABET.
     */
    //use thr tored conversion array to translate it backward (backward array)
    public int invert(int c) {
        // NOTE: it might be beneficial to have one invert() method always call the other
        return 0;  // FIXME - How do we use our instance variables to get the index that C inverts to?
    }

    /**
     * Return the character result of applying this permutation to the index
     * of character P in ALPHABET.
     */
    public char permute(char p) {
        // NOTE: it might be beneficial to have one permute() method always call the other
        return (this.cycles.charAt(this.cycles.indexOf(p) + 1));  // FIXME - How do we use our instance variables to get the character that P permutes to?
    }

    /**
     * Return the character result of applying the inverse of this permutation
     * to the index of character P in ALPHABET.
     */
    public char invert(char c) {
        // NOTE: it might be beneficial to have one invert() method always call the other
        return 0;  // FIXME - How do we use our instance variables to get the character that C inverts to?
    }

    /**
     * Return the alphabet used to initialize this Permutation.
     */
    public Alphabet alphabet() {

        return this.alphabet;
    }
}


 // FIXME - How do we store which letter permutes/inverts to which?
    /** Find out a way to see which letter maps to which one.
    */


    // Some starter code for unit tests. Feel free to change these up!
    // To run this through command line, from the proj0 directory, run the following:
    // javac enigma/Permutation.java enigma/Alphabet.java enigma/CharacterRange.java enigma/EnigmaException.java
    // java enigma/Permutation
    public static void main(String[] args) {
        Permutation perm = new Permutation("(ABCDEFGHIJKLMNOPQRSTUVWXYZ)", new CharacterRange('A', 'Z'));
        System.out.println(perm.size() == 26);
        System.out.println(perm.permute('A') == 'B');
        System.out.println(perm.invert('B') == 'A');
        System.out.println(perm.permute(0) == 1);
        System.out.println(perm.invert(1) == 0);
    }
}
