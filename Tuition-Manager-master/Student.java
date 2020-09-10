
public abstract class Student implements Comparable {
    protected int MAX_BILLED_CREDITS = 15;
    protected int FULL_TIME_CREDITS = 12;
    protected int PART_TIME_FEE = 846;
    protected int FULL_TIME_FEE = 1441;
	private String fname;
    private String lname;
    protected int credit;
    
    public Student(String fname, String lname, int credit) {
        this.fname = fname;
        this.lname = lname;
        this.credit = credit;
    }
    
    //must implement compareTo method because Student class implements the Comparable Interface
    //return 0 if fname and lname of the two students are equal,
    //return -1 if this fname and lname is < obj’s, return 1 if this fname and lname is > obj’s
    //Hint: use the .equals and compareToIgnoreCase methods of the String class to compare fname
    //and lname; names are not case-sensitive
    public int compareTo(Object obj) {
    	Student other = (Student)obj;
    	if(lname.compareToIgnoreCase(other.lname) < 0) {
    		return -1;
    	} else if(lname.compareToIgnoreCase(other.lname) > 0) {
    		return 1;
    	} else {
    		if(fname.compareToIgnoreCase(other.fname) < 0) {
    			return -1;
    		} else if(fname.compareToIgnoreCase(other.fname) > 0) {
    			return 1;
    		} else {
    			return 0;
    		}
    	}
    }
    
    //return a string with fname, lname and credit hours; subclasses will be using this method.    
    public String toString() {
    	return fname + " " + lname + " credits: " + credit + " ";
    }
    
    //compute the tuition due; concrete implementation is required in the subclasses.
    public abstract int tuitionDue();
}
