import java.util.Scanner;

public class TuitionManager {
    Scanner stdin;
    StudentList students;
    
    public void run() {
        stdin = new Scanner(System.in);
        students = new StudentList();
        boolean done = false;
        while(!done) {
            String command = stdin.next();
            switch(command.charAt(0)) {   
                case 'I': case 'O': case 'N':
                    add(command.charAt(0));  
                    break; 
                case 'R': 
                    remove();  
                    break;
                case 'P': 
                    print();
                    break;
                case 'Q': 
                    System.out.println("Program terminated");
                    done = true;
                    break;
                default:    // Warns user of invalid command.   
                    System.out.println("Command '" + command.charAt(0) + "' not supported!");
                    stdin.nextLine();
            }  
        }
        stdin.close();
    }
    
    private void add(char studentType) {
    	String fname = stdin.next();
    	String lname = stdin.next();
    	int credit = stdin.nextInt();
    	boolean valid = false;
    	
    	if(credit <= 0) {
    		System.out.println("Invalid number of credits.");
    		return;
    	}
		switch(studentType) {
		    case 'I':
		    	int funds = stdin.nextInt();
		    	valid = students.add(new Instate(fname,lname,credit,funds));
		    	break;
		    case 'O':
		    	boolean tristate = stdin.next() == "T" ? true:false;
		    	valid = students.add(new Outstate(fname,lname,credit,tristate));
		    	break;
		    case 'N':
		    	if(credit < 9) {
		    		System.out.println("Invalid number of credits.");
		    		return;
		    	}
		    	boolean exchange = stdin.next() == "T" ? true:false;
		    	valid = students.add(new International(fname,lname,credit,exchange));
		    	break;
		}
		if(!valid) {
			System.out.println("Student already on the list.");
		}
	}  

	private void remove() {
		String fname = stdin.next();
    	String lname = stdin.next();
    	if(!students.remove(new Instate(fname,lname,0,0))) {
    		System.out.println("Student not on the list.");
    	}
	}

	private void print() {
		students.print();
	}
}