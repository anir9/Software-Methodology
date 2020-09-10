
public class Instate extends Student{
    private int COST_PER_CREDIT = 433;
	private int funds;
    
	public Instate(String fname, String lname, int credit, int funds) {
		super(fname, lname, credit);
		this.funds = funds;
	}
    
    public String toString() {
        return "funds: " + funds + " tuition due: $" + tuitionDue(); 	
    }
    
    public int tuitionDue() {
    	int billedCredits = Math.min(credit, MAX_BILLED_CREDITS);
    	int fundsAvailable = credit >= FULL_TIME_CREDITS ? funds:0;
    	int fee = credit >= FULL_TIME_CREDITS ? FULL_TIME_FEE:PART_TIME_FEE;
    	return COST_PER_CREDIT * billedCredits + fee - fundsAvailable;
    }
}
