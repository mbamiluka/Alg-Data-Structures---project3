/**
 * This class handles Metropolitan State University of Denver's
 * students' grades data, which includes; student ID, grade Item Id,
 * courseId, item types of grades, date of grading, maximum score,
 * and actual score. All variables are evaluated before finally
 * assigning them to an instance.
 * GradeItem class for Computer SCience Two - Project 1
 * 
 * @author Mbami
 *
 */

public class GradeItem 
{
	private String studentId;			// Student's Id
	private Integer gradeItemId;		// Unique grade item ID
	private String courseId;			// Unique course ID
	public static String [] itemTypes = // Grade item type/category
	{"HW", "Quiz", "Class Work", "Test", "Final"};
	private String itemType;			// Type of grade
	private String date;				// Date of grade
	private Integer maxScore;			// Maximum score
	private Integer actualScore;		// Score obtained
	String error;						// Specific error detected
	boolean validItem = false;			// See if an item is present
	
	public GradeItem (String studentId, Integer gradeItemId,
			
			          String courseId, String itemType,
			          
			          String date, Integer maxScore,
			          
			          Integer actualScore
			          )
	{
		// Check if student ID is null/blank
		if (studentId == null || studentId.length() == 0)
		{
			error = "Student ID is empty or blank";
			throw new IllegalArgumentException(error);
		} // End student ID null/blank check
		
		
		// Check if grade ID is null/blank
		if ( gradeItemId == null)
		{
			throw new IllegalArgumentException
			("Grade item ID is empty or blank");
			
		} // End grade ID null/blank check
		
		
		
		// Check if grade course ID is null/blank
		if (courseId == null || courseId.length() == 0)
		{
			error = "Course ID is empty or blank";
			throw new IllegalArgumentException(error);
		} // End course ID null/blank check
		
		
		// Check if item type is null/blank
		if (itemType == null || itemType.length() == 0)
		{
			error = "Item type is empty or blank";
			throw new IllegalArgumentException(error);
		} // End item type null/blank check
		
		else
		{
			// Check if itemType is an allowed grade type
			for (int i = 0; i < itemTypes.length && !validItem; i++)
			{
				if (itemType.equals(this.itemTypes[i]))
				{
					validItem = true;
				}
				
			}
			
			if (!validItem) 
			{			
				throw new IllegalArgumentException
				(itemType + " is not a valid item type.");
			} 
		} // End checking if item type an allowed grade type
				
		
		// Check if date is null/blank
		if (date == null || date.length() == 0)
		{
			
			throw new IllegalArgumentException
			("Date is empty or blank");
			
		} // End date ID null/blank check
		
		else if (date.length() != 8)
		{
			throw new IllegalArgumentException
			("Date format must be yyyymmdd");
		}
		
		
		// Check if maxScore is blank
		if ( maxScore == null) 
		{
			throw new IllegalArgumentException
			("Maximum score is empty or blank");
			
		}
		
		// Check if maxScore is zero 
		else if ( maxScore == 0)
		{
			throw new IllegalArgumentException
			( maxScore + " ( maximum) is 0");
		}
		
		// Check if maxScore is negative
		else if ( maxScore < 0) 
		{
			throw new IllegalArgumentException
			( maxScore + " ( maximum) is less than 0");
			
		} // End evaluating max score
		
		
		// Find out if  actual score is null or in range
		if (actualScore == null)
		{	
			throw new IllegalArgumentException
			("Actual score is null");
		}
		
		else if ( actualScore < 0 )
		{
			
			throw new IllegalArgumentException
			( actualScore + " is less than 0");
		}
		else if ( actualScore > maxScore){
			
			throw new IllegalArgumentException
			( actualScore + " exceeds " + maxScore + " ( max.)" );
			
		} // End evaluating actual score
		
		
		// Assign instance variables
		
		this.studentId = studentId;
		this.courseId = courseId;
		this.gradeItemId = gradeItemId;
		this.itemType = itemType;
		this.date = date;
		this.maxScore = maxScore;
		this.actualScore = actualScore;
		
		
	} // End GradeItem constructor
	
	//*************************************************************
	//GETTER METHODS FOR EVERY INSTANCE VARIABLE 
	
	/**
	 * The method below returns the student ID of a given student
	 * @return	the student ID of this grade item
	 */
	public String getStudentId() {
		return studentId;
	}
	
	//*************************************************************
	
	/**
	 * The method below returns the grade Item ID of a given student
	 * @return	the grade item ID of this grade item
	 */
	public int getGradeItemId() {
		return gradeItemId;
	}
	//*************************************************************
	
	/**
	 * The method below returns the course ID of a given student
	 * @return	the course ID of this grade item
	 */
	public String getCourseId() {
		return courseId;
	}
	
	/**
	 * The method below returns the type of grade item; HW, Quiz,
	 * classwork, test and final.
	 * 
	 * @return	the type of grade Item
	 */
	
	//*************************************************************
	
	public String getItemType() {
		return itemType;
	}
	
	//*************************************************************
		
	public String getDate() {
		return date;
	}
	
	//*************************************************************
		
	public int getMaxScore() {
		return maxScore;
	}
	
	//*************************************************************
		
	public Integer getActualScore() {
		return actualScore;
	}
	
	//*************************************************************
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
        GradeItem other = (GradeItem) obj;
		if ( studentId.equals(other.studentId) 	&&
		    courseId.equals(other.courseId)	 	&&
		    itemType.equals(other.itemType)	 	&&
		    date.equals(other.date) 			&&
		    maxScore.equals(other.maxScore)
		   )
		{
			return true;
		}
		return false;
	} // End equals
	
	//*************************************************************
	
	public String toString() 
	{
		 
		 return " Student id: "      + studentId     +  
		 	    "\n Grade Item Id: " + gradeItemId   +  
		 	    "\n Course Id: "     + courseId      +  
		 	    "\n Item Type: "     + itemType      +  
		 	    "\n Date: "          + date          +  
		 	    "\n Maximum score: " + maxScore      +  
		 	    "\n Actual score: "  + actualScore   ;
		 	    			
	 } // End toString
	 
	 //*************************************************************
 } // End GradeItem

