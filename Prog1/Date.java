import java.util.StringTokenizer;

/**
  
 @author  
 */
public class Date {
   private int day;
   private int month;
   private int year;
   
   public Date(String d) {
	   //use StringTokenizer to parse the String and create a Date object
	   try {
		   StringTokenizer x = new StringTokenizer(d, "/", false);
		   month = Integer.parseInt(x.nextToken());
		   day = Integer.parseInt(x.nextToken());
		   year = Integer.parseInt(x.nextToken());
	   } catch(Exception ex) {
		   day = 0;
		   month = 0;
		   year = 0;
	   }
   }
   
   public Date(Date d) {
      //this is a constructor
	  this.day = d.day;
	  this.month = d.month;
	  this.year = d.year;
   }      
   
   public boolean isValid() {
       if(day <= 0 || year <= 0) {
    	   return false;
       }
       switch(month) {
	       case 1: case 3: case 5: case 7: case 8: case 10: case 12:
	    	   return day <= 31;
	       case 4: case 6: case 9: case 11:
	    	   return day <= 30;
	       case 2:
	    	   return day <= (isLeapYear() ? 29:28);
	       default:
	    	   return false;
       }
   }
   
   private boolean isLeapYear() {
	   if(year % 4 == 0) {
		   if(year % 100 == 0 && year % 400 != 0) {
			   return false;
		   } else {
			   return true;
		   }
	   } else {
		   return false;
	   }
   }
   
   @Override
   public String toString() {
       //use the format "month/day/year"
	   return month + "/" + day + "/" + year;
   }
   
   @Override
   public boolean equals(Object obj) {
       Date other = (Date)obj;
       return this.day == other.day && this.month == other.month && this.year== other.year;
   }  
}


