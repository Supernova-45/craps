public class Die {

    //fields
    private int roll;

    //constructor
    public Die() {
        roll = (int) (Math.random() * 6);
    }

    public int getRoll() {
        return roll;
    }    
}