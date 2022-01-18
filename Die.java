/**
 * Simulates rolling a 6 sided die
 * @author Alexandra Kim
 * @version 1-18-2022
 */

public class Die {

    //fields
    private int roll;

    //constructor
    public Die() {
        roll = (int) (Math.random() * 6);
    }

    /**
     * @return a random number from 1-6 inclusive
     */
    public int getRoll() {
        return roll;
    }    
}