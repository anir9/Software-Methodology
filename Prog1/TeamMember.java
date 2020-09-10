/**
 
 @author  
 */
public class TeamMember {
   private String name;
   private Date   startDate;
   
   public TeamMember(String nm, Date date) {
       name = nm;
       startDate = date;
   }
   
   public Date getStartDate() {
      return startDate;
   }
   
   public boolean equals(Object obj) {
	   //name and startDate must be the same
	   return ((TeamMember)obj).name.equals(this.name) && ((TeamMember)obj).startDate.equals(this.startDate);
   }  
   
   public String toString() {
       //name + " " + startDate;
	   return name + " " + startDate;
   }

   public static void main(String [] args) {
      //testbed main; you must include test cases that exercise 
      //the constructor and all methods in this class.
   }
}