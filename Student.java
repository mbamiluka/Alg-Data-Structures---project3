import java.util.Objects;
/**
 * This class handles Metropolitan State University of Denver's
 * student data, which includes; first name, last name, student ID,
 * and email address. All variables are evaluated before finally
 * assigning them to an instance.
 * 
 * Student class for Computer SCience Two - Project 1
 * @author Mbami Luka
 * @version 
 */

public class Student 
{
	private String studentId;	// Student's Id
	private String firstName;	// Student's First Name
	private String lName;		// Student's Last Name
	private String email;		// Student's email
	
	public Student ( String studentId, String firstName, String lName, 
				   String email)
	{
		// Check if student ID is null/blank
		if ( studentId == null || studentId.length() == 0)
		{
			throw new IllegalArgumentException
			( "Student ID is empty or blank");
		}
		
		// End student ID null/blank check
		
		
		// Check if first name is null/blank
		if ( firstName == null || firstName.length() == 0)
		{
			throw new IllegalArgumentException
			("First name is empty or blank");
		}
		
		// End first name null/blank check
		
		
		// Check if last name is null/blank
		if ( lName == null || lName.length() == 0)
		{
			throw new IllegalArgumentException
			("Last name is empty or blank");
		} // End last name null/blank check
		
		
		// Check if email is null/blank
		if ( email == null || email.length() == 0)
		{
			throw new IllegalArgumentException
			("Email is empty or blank");
		} // End email null/blank check
		
		else if ( !email.contains("@"))
		{
			throw new IllegalArgumentException
			("Wrong email format: " + email + " must contain @");
				
		}
		
		// Assign instance variables after checks
		
		this.studentId = studentId;
		this.firstName = firstName;
		this.lName = lName;
		this.email = email;
		
		
	} // End Student constructor
	
	//*************************************************************
	//GETTER METHODS FOR EVERY INSTANCE VARIABLE 
	
	/**
	 * The method below obtains the student ID of a given student
	 * 
	 * @return	the student ID of a given student
	 */
	public String getStudentId () {
		return studentId;
	}
	
	//*************************************************************
	
	/**
	 * The method below returns the first name of given student
	 * 
	 * @return	the first name of this given student
	 */
	public String getFirstName () {
		return firstName;
	}
	
	//*************************************************************
	
	/**
	 * The method below returns the last name of a given student
	 * 
	 * @return	the last name of this given student
	 */
	public String getLastName () {
		return lName;
	}
	
	//*************************************************************
	
	/**
	 * The method below obtains and returns the email of a 
	 * given student
	 * 
	 * @return	the email of this given student
	 */
	public String getEmail () {
		return email;
	}
	//*************************************************************
	
	/**
	 * The method compares two students to find out if they possess
	 * the same student ID, first name, last name, and email
	 * 
	 * @param	other	- This is another student object, which will
	 * be compared to the current student
	 * 
	 * @return	True/False - students are the same or not
	 */
	public boolean equals ( Object obj)
	{
		//boolean isEqual = false;
        if (this == obj) {
            return true;
        }
        // Make sure the object is not null
        if (obj == null) {
            return false;
        }
        // Makes sure class types are equivalent
        if (this.getClass() != obj.getClass()) {
            return false;
        }

        // Cast the object to that of the same type as this object
        // Student would cast as Student, and GradeItem as GradeItem
        Student other = (Student) obj;
		
		if ( studentId.equals ( other.getStudentId())  &&
		   firstName.equals ( other.getFirstName())	   &&
		   lName.equals ( other.getLastName())		   &&
		   email.equals ( other.getEmail())
		   )
		{
			return true;
		}
		
		return false;
	} // End equals
	
	//**************************************************************
	
	/**
	 * The method below returns all the details on a particular
	 * student. These include; student ID, first name, last name,
	 * and email
	 * @return	the full details on a particular student
	 */
	public String toString() {
		 
		 return "Student id: " + studentId +
		 	    "\n" + "First Name: " + firstName + 
		 	    "\n" + "Last Name: "  + lName     +  
		 	    "\n" + "Email: "      + email     ;
				 
	 } //End toString
	 
	 //*************************************************************       
}


