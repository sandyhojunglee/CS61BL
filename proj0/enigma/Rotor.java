package enigma;

import static enigma.EnigmaException.*;

/** Superclass that represents a rotor in the enigma machine.
 *  @SandyLee
 */
public class Rotor {
    /** My name. */
    private final String name;

    /** The permutation implemented by this rotor in its 0 position. */
    private Permutation permutation;
    //^used for transformation

    private int setting;

    /** A rotor named NAME whose permutation is given by PERM. */
    public Rotor(String name, Permutation perm) {
        this.name = name;
        this.permutation = perm;
        this.setting = 0;
        //initialize current setting to 0
    }

    /** Return my name. */
    public String name() {
        return name;
    }

    /** Return my alphabet. */
    public Alphabet alphabet() {
        return permutation.alphabet();
    }

    /** Return my permutation. */
    public Permutation permutation() {
        return permutation;
    }

    /** Return the size of my alphabet. */
    public int size() {
        return permutation.size();
    }

    /** Return true if and only if I have a ratchet and can move. */
    public boolean rotates() {
        return false;
    }

    /** Return true if and only if I reflect. */
    public boolean reflecting() {
        return false;
    }

    /** Return my current setting. */
    public int setting() {
        return this.setting; // FIXME - How do we keep track of my current position?
    }

    /** Set setting() to POSN.  */
    public void set(int posn) {
        this.setting = posn;// FIXME - How do we update our current position, based on an alphabet index?
    }

    /** Set setting() to character CPOSN. */
    public void set(char cposn) {
        this.setting = alphabet().toInt(cposn); // FIXME - How do we update our current position, based on an alphabet character?
    }

    /** Return the conversion of P (an integer in the range 0..size()-1)
     *  according to my permutation. */
    public int convertForward(int p) {
        //add current setting
        //mod to keep within alphabet space
        //use the this.permutation to go forward
        //subtract current setting
        //mod to keep within alphabet space
        int contactInF = this.permutation.wrap(this.setting +p);
        int contactOutF = this.permutation.permute(contactInF);
        return this.permutation.wrap(contactOutF - this.setting);
        // FIXME - How do we permute the index P, taking into account my current position?
    }

    /** Return the conversion of C (an integer in the range 0..size()-1)
     *  according to the inverse of my permutation. */
    public int convertBackward(int c) {
        //difference between ^ is that we are now going backwards
        //using invert
        int contactInB = this.permutation.wrap(this.setting + c);
        int contactOutB = this.permutation.invert(contactInB);
        return this.permutation.wrap(contactOutB - this.setting);  // FIXME - How do we invert the index E, taking into account my current position?
    }

    /** Returns true if and only if I am positioned to allow the rotor
     * to my left to advance. */
    public boolean atNotch() {
        return false;
    }

    /** Advance me one position, if possible. By default, does nothing. */
    public void advance() {
        if (this.rotates()) {
            if (this.setting() == this.alphabet().size() - 1) {
                this.set(0);
            } else {
                this.set(this.setting() + 1);
            }
        } //this.permutation.wrap(this.setting);
    }


    @Override
    public String toString() {
        return "Rotor " + name;
    }
}


    //keep track of last setting



