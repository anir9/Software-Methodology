
public class Outstate extends Student{
	private int DISCOUNT = 200;
	private int COST_PER_CREDIT = 756;
    private boolean tristate;
    
    public Outstate(String fname, String lname, int credit, boolean tristate) {
    	super(fname, lname, credit);
    	this.tristate = tristate;
    }
    
    public String toString() {
    	return (tristate ? "tristate":"not-tristate") + " tuition due: $" + tuitionDue();
    }
    
    public int tuitionDue() {
    	int billedCredits = Math.min(credit, MAX_BILLED_CREDITS);
    	int fundsAvailable = tristate ? DISCOUNT*billedCredits:0;
    	int fee = credit >= FULL_TIME_CREDITS ? FULL_TIME_FEE:PART_TIME_FEE;
    	return COST_PER_CREDIT * billedCredits + fee - fundsAvailable;
    }
}
