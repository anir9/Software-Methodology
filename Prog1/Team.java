/**
  
 @author  
 */
public class Team {
   private final int NOT_FOUND = -1;
   private final int GROW_SIZE = 4; //initial and grow size
   private TeamMember [] team;
   private int numMembers;
   
   public Team() {
	   //this is the default constructor
	   team = new TeamMember[GROW_SIZE];
   }
   
   private int find(TeamMember m) {
       for(int i = 0; i < numMembers; i++) {
    	   if(team[i].equals(m)) {
    		   return i;
    	   }
       }
       return NOT_FOUND;
   }
   
   private void grow() {
	   TeamMember[] temp = new TeamMember[numMembers + GROW_SIZE];
	   for(int i = 0; i < numMembers; i++) {
		   temp[i] = team[i];
	   }
	   team = temp;
   }
   
   public boolean isEmpty() {
	   return numMembers == 0;
   }
   
   public void add(TeamMember m) {     
	   if(numMembers == team.length) {
		   grow();
	   }
	   team[numMembers++] = m;
   }
   
   public boolean remove(TeamMember m)	{
       int removeLocation = find(m);
       if(removeLocation == NOT_FOUND) {
    	   return false;
       }
       team[removeLocation] = team[numMembers-1];
       team[--numMembers] = null;
       return true;
   } 
   
   public boolean contains(TeamMember m) {
	   for(int i = 0; i < numMembers; i++) {
    	   if(team[i].equals(m)) {
    		   return true;
    	   }
       }
       return false;
   } 
   
   public void print() {
      //set up a for loop and call the toString() method
	  for(TeamMember tm: team) {
		  if(tm == null) {
			  return;
		  }
		  System.out.println(tm);
	  }
   } 
}
