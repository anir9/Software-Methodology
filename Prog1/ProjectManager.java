import java.util.Scanner;

/**
  
 @author  
 */
 
public class ProjectManager {
   Scanner stdin;
   Team cs213;
   public void run() {
	  stdin = new Scanner(System.in);
	  cs213 = new Team();
      boolean done = false;
      while (!done) {
         String command = stdin.next();
         switch (command.charAt(0)) {   
            case 'A': 
            	add();
            	break; 
            case 'R':
            	remove();
            	break;
            case 'P':
            	print();
            	break;
            case 'Q':
            	print();
            	System.out.println("The team is ready to go!");
            	done = true;
            	break;
            default: //deal with bad command here 
            	System.out.println("Command '" + command.charAt(0) +"' not supported!");
            	stdin.nextLine();
         }  
      }
      stdin.close();
      //write java code before you terminate the program
   } //run()
   
   private void add() {
      	//must check if the date is valid
	   //must call the contains() method to check if a given 
	   //team member is in the team already
	   String name = stdin.next();
	   Date date = new Date(stdin.next());
	   if(date.isValid()) {
		   TeamMember newMember = new TeamMember(name,date);
		   if(cs213.contains(newMember)) {
			   //print that it's a repeat
			   System.out.println(name + " " + date + " is already in the team.");
		   } else {
			   cs213.add(newMember);
			   System.out.println(name + " " + date + " has joined the team.");
		   }
	   } else {
		   System.out.println(date + " is not a valid date!");
	   }
   }
   
   private void remove() {
	   //must check if the date is valid
	   String name = stdin.next();
	   Date date = new Date(stdin.next());
	   if(date.isValid()) {
		   TeamMember newMember = new TeamMember(name,date);
		   if(cs213.contains(newMember)) {
			   //print that it's a repeat
			   cs213.remove(newMember);
			   System.out.println(name + " " + date + " has left the team.");
		   } else {
			   System.out.println(name + " " + date + " is not a team member.");
		   }
	   } else {
		   System.out.println(date + " is not a valid date!");
	   }
   }
   
   private void print() {
	   //must check if the team has 0 members. 
	   if(cs213.isEmpty()) {
		   System.out.println("We have 0 team members!");
	   } else {
		   System.out.println("We have the following team members:");
		   cs213.print();
		   System.out.println("-- end of list --");
	   }
   }   
} //ProjectManager
