
public class StudentList {
	private final int NOT_FOUND = -1;
    private final int GROW_SIZE = 2;
    private final int INITIAL_SIZE = 10;
    private Student[] students;
    private int numMembers;
    
    public StudentList() {
    	students = new Student[INITIAL_SIZE];
    }
    
    private void grow() {
        Student[] temp = new Student[numMembers * GROW_SIZE];   // Creates a new Student array that is extended by GROW_SIZE positions. 
        for(int i = 0; i < numMembers; i++) {
            temp[i] = students[i];
        }
        students = temp;
    }
    
    private int find(Student s) {
        for(int i = 0; i < numMembers; i++) {
            if(students[i].compareTo(s) == 0) {
                return i;
            }
        }
        return NOT_FOUND;
    }
    
    public boolean add(Student s) {
    	if(find(s) != NOT_FOUND) {
    		return false;
    	} else if(numMembers == students.length) {
            grow();
        }
        students[numMembers++] = s;
        return true;
    }
    
    public boolean remove(Student s)	{
        int removeLocation = find(s);
        if(removeLocation == NOT_FOUND) {
            return false;
        }
        students[removeLocation] = students[numMembers - 1];   // Replaces to-be-removed student with the last student in the array.
        students[--numMembers] = null;   // Sets pointer of last student to null. Decrements numMembers.
        return true;
    } 
    
    public void print() {
        for(Student s: students) {
            if(s == null) {
                return;    //end of students
            }
            System.out.println(s);
        }
    }
}
