package enigma;

import static enigma.EnigmaException.*;

/** Class that represents a complete enigma machine.
 *  @author
 */
public class Machine {

    /** A new Enigma machine with alphabet ALPHA, 1 < NUMROTORS rotor slots,
     *  and 0 <= PAWLS < NUMROTORS pawls. ALLROTORS contains all the
     *  available rotors. */
    /** Common alphabet of my rotors. */
    private final Alphabet alphabet;
    private int numRotors;
    private int pawls;
    private Rotor[] myMachine;
    private Rotor[] allRotors;
    private Permutation plugboard;

    public Machine(Alphabet alpha, int numRotors, int pawls,
                   Rotor[] allRotors) {
        this.alphabet = alpha;
        this.numRotors = numRotors;
        this.pawls = pawls;
        this.allRotors = allRotors;
        this.myMachine = new Rotor[numRotors];
    }
        //store references to all the numbers/objects above
        //initialize enigma machine (array of rotors)
        //contains rotors that are relevant to us
        // FIXME - Assign any additional instance variables.


    /** Return the number of rotor slots I have. */
    public int numRotors() {

        return this.myMachine.length; // FIXME - How do we access the number of Rotor slots I have?
    }

    /** Return the number pawls (and thus rotating rotors) I have. */
    public int numPawls() {

        return this.pawls; // FIXME - How do we access the number of pawls I have?
    }

    /** Set my rotor slots to the rotors named ROTORS from my set of
     *  available rotors (ROTORS[0] names the reflector).
     *  Initially, all rotors are set at their 0 setting. */
    public void insertRotors(String[] rotors) {
        for (int rotorsIndex = 0; rotorsIndex < rotors.length; rotorsIndex++) {
            for (int allRotorsIndex = 0; allRotorsIndex < this.allRotors.length; allRotorsIndex++) {
                String rotorName = rotors[rotorsIndex];
                String allRotorsName = this.allRotors[allRotorsIndex].name();
                if ((rotorName.toUpperCase()).equals(allRotorsName.toUpperCase())) {
                    this.myMachine[rotorsIndex] = this.allRotors[allRotorsIndex];
                }
            }
        }
    }
        // we've saved allRotors somewhere, so we're going to use that to fill in our current setup
        // to match a  name (String 1).equals(string 2)
        // some names don't match capitalization, so you need to (string 1).toUppercase() and
        // (string 2).toUpperCase() before doing the above

        // go through a for loop and match strings in rotors to corresponding rotorws in allRotors
        // add it in your own machine if they match
        // FIXME - How do we fill this Machine with Rotors, based on names of available Rotors?



    /** Set my rotors according to SETTING, which must be a string of
     *  numRotors()-1 upper-case letters. The first letter refers to the
     *  leftmost rotor setting (not counting the reflector).  */
    public void setRotors(String setting) {
        // setting is a string describing positions
        // set each rotor, from 1 to numRotors() - 1, to the setting in the string above

        // my_rotors (or something equivalent) should exist, we are just changing each rotor's setting
        for (int i = 1; i < this.numRotors; i++){
            this.myMachine[i].set(setting.charAt(i-1));
            }
        }
        // FIXME - How do we set the positions of each Rotor in this Machine?


    /** Set the plugboard to PLUGBOARD. */
    public void setPlugboard(Permutation plugboard) {
        // need an instance variable to store plugboard
        this.plugboard = plugboard;
    }
    // FIXME - How do we assign our plugboard, based on a given Permutation?


    /** Returns the result of converting the input character C (as an
     *  index in the range 0..alphabet size - 1), after first advancing
     *  the machine. */
    public int convert(int c) {
        // move the rotors with advance()

        // loop through the rotors and convert forward/backward
        // tips: look at the rotor code we wrorte, figure out which direction
        // we are going in and use appropriate functions. Remember forward is <- and Backwards is ->

        // remember plugboard (for beginning and end)

    	// HINT: This one is tough! Consider using a helper method which advances
    	//			the appropriate Rotors. Then, send the signal into the
    	//			Plugboard, through the Rotors, bouncing off the Reflector,
    	//			back through the Rotors, then out of the Plugboard again.

        /* Step 7a: always advance() first */
        /* Step 7b: permute the character with the plugboard. */
        /* Step 7c: from myRotors[end] to myRotors[1] convertForward */
        /* Step 7d: convertForward on the reflector. Remember the reflector
                    is myRotors[0]. */
        /* Step 7e: from myRotors[1] to myRotors[end] convertBackward */
        /* Step 7f: invert character with the plugboard. */
        this.advance();
        int num = this.plugboard.permute(c);
        for (int i = myMachine.length-1; i >= 0; i--) {
            num = myMachine[i].convertForward(num);
        }
        for (int j = 1; j < myMachine.length; j++) {
            num = myMachine[j].convertBackward(num);
        }
        return this.plugboard.invert(num);

        // FIXME - How do we convert a single character index?
    }

    /** Optional helper method for convert() which rotates the necessary Rotors. */
    private void advance() {
        // figure out all rotors that are eligible to advance:
        // rightmost, any rotor with its notch exposed, any rotor N where N+1 notch is exposed

        //call advance() on all the rotors that can move (found above)

        /* Step 8a: make boolean array, one element per rotor. */
        /* Step 8b: iterate through every rotor, starting from myRotors[1]. */
        /* Step 8c: if rotor i is at a notch, mark rotor i and i-1 to true
                    in boolean array. */
        /* Step 8d: mark myRotors[end] as true. */
        /* Step 8d: rotate all rotors who are marked true in the boolean array. */

        //boolean[] setToRotate = new boolean[myMachine.length];
        for (int i = 1; i < myMachine.length-1; i++) {
            if ((myMachine[i].atNotch() && myMachine[i-1].reflecting()) || myMachine[i+1].atNotch()) {
                myMachine[i].advance();
            }
        } myMachine[myMachine.length-1].advance();
    }
    // FIXME - How do we make sure that only the correct Rotors are advanced?

    /** Returns the encoding/decoding of MSG, updating the state of
     *  the rotors accordingly. */
    public String convert(String msg) {
        // reminder: all you need to worry about here is using convert() properly and
        // creating a string
        //
        // make sure to uppsercase msg with msg = msg.toUppercase()
        // (Only convert if the msg characher is in teh alphabet)
        // goal is to loop through each character, use convert(char), append it onto
        // a string that you are constructing: ex. "XYZ" + "P" -> "XYZP"


    	// HINT: Strings are basically just a series of characters
        /* Step 9a: Capitalize msg and save it to a variable. */
        /* Step 9b: Create an empty string, called output. */
        /* Step 9c: For each character in the capitalized msg, convert the
                    character using convert(int c) and add it to output.
                    NOTE: convert(int c) takes in an INT, not a CHAR. Use
                          _alphabet methods to translate the character between
                          int's and char's as necessary.*/
        /* Step 9d: Return the output. */
        String holding = msg.toUpperCase();
        String output = "";
        for (int i = 0; i < holding.length() ; i++) {
            if (alphabet.contains(holding.charAt(i))) {
                output= output + alphabet.toChar(convert(alphabet.toInt(holding.charAt(i))));
            }
        }
        return output; // FIXME - How do we convert an entire String?
    }


    // FIXME - How do we keep track of my available Rotors/my Rotors/my pawls/my plugboard

    // FIXME: ADDITIONAL FIELDS HERE, IF NEEDED.

    // To run this through command line, from the proj0 directory, run the following:
    // javac enigma/Machine.java enigma/Rotor.java enigma/FixedRotor.java enigma/Reflector.java enigma/MovingRotor.java enigma/Permutation.java enigma/Alphabet.java enigma/CharacterRange.java enigma/EnigmaException.java
    // java enigma/Machine
    public static void main(String[] args) {

        CharacterRange upper = new CharacterRange('A', 'Z');
        MovingRotor rotorI = new MovingRotor("I",
                new Permutation("(AELTPHQXRU) (BKNW) (CMOY) (DFG) (IV) (JZ) (S)", upper),
                "Q");
        MovingRotor rotorII = new MovingRotor("II",
                new Permutation("(FIXVYOMW) (CDKLHUP) (ESZ) (BJ) (GR) (NT) (A) (Q)", upper),
                "E");
        MovingRotor rotorIII = new MovingRotor("III",
                new Permutation("(ABDHPEJT) (CFLVMZOYQIRWUKXSG) (N)", upper),
                "V");
        MovingRotor rotorIV = new MovingRotor("IV",
                new Permutation("(AEPLIYWCOXMRFZBSTGJQNH) (DV) (KU)", upper),
                "J");
        MovingRotor rotorV = new MovingRotor("V",
                new Permutation("(AVOLDRWFIUQ)(BZKSMNHYC) (EGTJPX)", upper),
                "Z");
        FixedRotor rotorBeta = new FixedRotor("Beta",
                new Permutation("(ALBEVFCYODJWUGNMQTZSKPR) (HIX)", upper));
        FixedRotor rotorGamma = new FixedRotor("Gamma",
                new Permutation("(AFNIRLBSQWVXGUZDKMTPCOYJHE)", upper));
        Reflector rotorB = new Reflector("B",
                new Permutation("(AE) (BN) (CK) (DQ) (FU) (GY) (HW) (IJ) (LO) (MP) (RX) (SZ) (TV)", upper));
        Reflector rotorC = new Reflector("C",
                new Permutation("(AR) (BD) (CO) (EJ) (FN) (GT) (HK) (IV) (LM) (PW) (QZ) (SX) (UY)", upper));

        Rotor[] allRotors = new Rotor[9];
        allRotors[0] = rotorI;
        allRotors[1] = rotorII;
        allRotors[2] = rotorIII;
        allRotors[3] = rotorIV;
        allRotors[4] = rotorV;
        allRotors[5] = rotorBeta;
        allRotors[6] = rotorGamma;
        allRotors[7] = rotorB;
        allRotors[8] = rotorC;

        Machine machine = new Machine(upper, 5, 3, allRotors);
        machine.insertRotors(new String[]{"B", "BETA", "III", "IV", "I"});
        machine.setRotors("AXLE");
        machine.setPlugboard(new Permutation("(HQ) (EX) (IP) (TR) (BY)", upper));

        System.out.println(machine.numRotors() == 5);
        System.out.println(machine.numPawls() == 3);
        System.out.println(machine.convert(5) == 16);
        System.out.println(machine.convert(17) == 21);
        System.out.println(machine.convert("OMHISSHOULDERHIAWATHA").equals("PQSOKOILPUBKJZPISFXDW"));
        System.out.println(machine.convert("TOOK THE CAMERA OF ROSEWOOD").equals("BHCNSCXNUOAATZXSRCFYDGU"));
        System.out.println(machine.convert("Made of sliding folding rosewood").equals("FLPNXGXIXTYJUJRCAUGEUNCFMKUF"));
    }
}
