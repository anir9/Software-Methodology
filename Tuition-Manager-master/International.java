
public class International extends Student{
	public static int MIN_CREDIT_HOURS = 9;
	private int COST_PER_CREDIT = 945;
	private int INTERNATIONAL_STUDENT_FEE = 350;
    private boolean exchange;
    
    public International(String fname, String lname, int credit, boolean exchange) {
    	super(fname, lname, credit);
    	this.exchange = exchange;
    }
    
    public String toString() {
    	return (exchange ? "exchange":"not-exchange") + " tuition due: $" + tuitionDue();
    }
    
    public int tuitionDue() {
    	int billedCredits = Math.min(credit, MAX_BILLED_CREDITS);
    	int fee = credit >= FULL_TIME_CREDITS ? FULL_TIME_FEE:PART_TIME_FEE;
    	return fee + INTERNATIONAL_STUDENT_FEE + (exchange ? 0:COST_PER_CREDIT * billedCredits);
    }
}
