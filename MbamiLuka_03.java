import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class MbamiLuka_03 {
	private static List<Student> studentList = new List<Student> ( );
	private static List<GradeItem> gradeItemList = new List<GradeItem> ( );

	private static File inputFile = null;     // File to be read from
	private static File outputFile = null;    // File to be written to

	private static Scanner input = null;      // Scanner for reading file
	private static PrintWriter output = null; // This writes to files

	public static void main ( String[] args) 
	{
		outputFile = new File("Project_03_Output01");
		try {
			output = new PrintWriter (outputFile);
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println ( "Error opening file: "
							   + e.getMessage());
		}
		String separate = 
						  "**************************************"
					    + "**************************************";

		processInput ( );
		output.println ( separate);
		generateReport ( );
		
		output.flush();

	} // End main 

	//*************************************************************************
	public static void processInput ( ) {
		String data;
		String[] arrOfData;

		Student student = null;
		GradeItem gradeItem = null;

		// Verify if input file exists
		try 
		{
			String xx = "";
			xx = FileNumber.getFileNumber ( );
			String INPUT_FILENAME = "Project_03_Input" + xx + ".txt";

			inputFile = new File ( INPUT_FILENAME);
			input = new Scanner ( inputFile);

		} 
		catch  ( IOException e) 
		{

			System.err.println ( "Error opening file: " + e.getMessage ( ));

			output.println ( "Error opening file: " + e.getMessage ( ));
		} // End verifying existence of input file

		while ( input.hasNext())
		{
			data = input.nextLine ( );
			arrOfData = data.split ( ",");
	
			if  ( arrOfData[0].equals ( "STUDENT")) 
			{
				// Our student is processed with values of input line
				processStudentData ( arrOfData);
	
			} 
			else if  ( arrOfData[0].equals ( "GRADE ITEM")) 
			{
				processGradeItemData ( arrOfData);
			} 
			else 
			{
				System.err.println ( "Expected 1st value: STUDENT or GRADE ITEM");
	
				System.err.println ( "Detected 1st value: " + arrOfData[0]);
				
				output.println ( "Expected 1st value: STUDENT or GRADE ITEM");
				
				output.println ( "Detected 1st value: " + arrOfData[0]);
	
			} // End check for first word - STUDENT
		}
	}

	// *************************************************************************
	/**
	 * This method takes in array of data, which initially came from lines of input
	 * files. Then, it checks the 2nd value  ( index 1) in the array if it is STUDENT.
	 * If it is, the next four values in the array are used as parameters for a new
	 * Student object.
	 * 
	 * @param data which corresponds to lines from input files
	 * 
	 * @throws IllegalArgumentException if any student parameter is wrong
	 */
	public static void processStudentData ( String[] data) 
	{
		Student student = null;
		
		// Check the second item in data array if it's 'ADD'
		if  ( data[1].equals ( "ADD")) 
		{
			try {
				
				student = new Student ( data[2], data[3], data[4], data[5]);
				
				if  ( studentList.contains ( student)) {
					
					System.err.println ( "The student with ID: " + student.getStudentId ( )
										+ "is already in the student list and " + "cannot be added");
					output.println ( "Student not added " + student.getStudentId ( ));
					
				} 
				else 
				{
					studentList.add ( student);
					
					output.println 
					( "Added student with ID: " + student.getStudentId());

				}

			} 
			catch  ( IllegalArgumentException e) {
				System.err.println ( e.getMessage ( ));
				System.err.println("Student was not added to the students list\n");
				
				output.println ( e.getMessage ( ));
				output.println("Student was not added to the students list\n");

			}


		} // End check for second item 'ADD'
		
		// Check the second item in data array if it's 'DEL'
		else if  ( data[1].equals ( "DEL")) 
		{
			try 
			{		
				student = new Student ( data[2], data[3], data[4], data[5]);
				if(studentList.contains(student)) {
					studentList.remove ( student);
				}
				else {
					throw new IllegalArgumentException();
				}
			} 
			catch  ( IllegalArgumentException e) 
			{
				System.err.println ( e.getMessage ( ));
				output.println ( e.getMessage ( ));

			}
		} 
		else 
		{
			System.err.println 
			( "Expected: ADD or DEL from input file's 2nd value");

			System.err.println ( "Detected: " + data[1]);
			
			output.println 
			( "Expected: ADD or DEL from input file's 2nd value");

			output.println ( "Detected: " + data[1]);

		} // Check the second item in data array if it's 'ADD'



	}

	// *************************************************************************
	/**
	 * This method takes in array of data, which initially came from lines of input
	 * files. Then, it checks the 2nd value  ( index 1) in the array if it is ADD. If
	 * it is, the next seven values in the array are used as parameters for a new
	 * Grade Item.
	 * 
	 * @param data which corresponds to lines from input files
	 * 
	 * @throws IllegalArgumentException if any GradeItem parameter is wrong
	 */
	public static void processGradeItemData ( String[] data) {
		
		GradeItem gradeItem = null;

		// Check the second item in data array if it's 'ADD'
		if  ( data[1].equals ( "ADD")) {
			try {

				gradeItem = new GradeItem ( data[3], Integer.parseInt ( data[2]),

						data[4], data[5], data[6], Integer.parseInt ( data[7]),

						Integer.parseInt ( data[8]));

			} catch  ( Exception e) {

				System.err.println ( e.getMessage ( ));
				output.println ( e.getMessage ( ));

			} // end try/catch block

			if  ( gradeItemList.contains ( gradeItem)) {
				System.err.println ( "The grade item with ID: " + gradeItem.getStudentId ( )
						+ "is already in the student list and " + "cannot be added");
				output.println 
				( "The grade item with ID: " + gradeItem.getStudentId ( )
				+ "is already in the student list and " + "cannot be added");
			} 
			else 
			{
				gradeItemList.add ( gradeItem);
				
				output.println 
				( "Added Grade Item with ID: " + gradeItem.getGradeItemId());
			}
		}

		else if  ( data[1].equals ( "DEL")) {
			try {

				gradeItem = new GradeItem ( data[3], Integer.parseInt ( data[2]),
						
						                    data[4], data[5], data[6],
						                    
						                    Integer.parseInt ( data[7]),
						                    
						                    Integer.parseInt ( data[8])
						                   );
				
				if  ( gradeItemList.contains ( gradeItem)) {
					gradeItemList.remove ( gradeItem);
					output.println
					( "Removed Grade Item with ID: " + gradeItem.getGradeItemId());
					
				} 
				else 
				{
					System.err.println 
					( "The grade item with ID: " + 
					   gradeItem.getStudentId ( ) +
					  "is already in the student list " + 
					  "and cannot be 1added");
					
					output.println 
					( "The grade item with ID: " + 
					   gradeItem.getStudentId ( ) +
					  "is already in the student list " + 
					  "and cannot be 1added");
				}

			} catch  ( Exception e) {

				System.err.println ( e.getMessage ( ));
				output.println ( e.getMessage ( ));

			} // end try/catch block


		}
		
		else {

			System.err.println  (  "Expected: ADD or DEL from input file's 2nd value");

			System.err.println  (  "Detected: " + data[1]);
			
			output.println  (  "Expected: ADD or DEL from input file's 2nd value");

			output.println  (  "Detected: " + data[1]);

		} // end checking if 2nd item of data array is ADD

	} // end processGradeItemData

	// *************************************************************************

	public static void generateReport ( ) 
	{
		Object[] studList = studentList.toArray();
		Student student;
		
		Object[] grades = gradeItemList.toArray();
		GradeItem gradeItem;
		int actualSum;
		int maxSum;
		double percentEarned = 0.0;
		
		for(int i = 0; i < studList.length; i++) 
		{
			actualSum = 0;
			maxSum = 0;
            // Cast the generic object as a specific type
            student = (Student) studList[i];
            output.printf("%s %8s %8s %25s\n",
            				   student.getStudentId(),
            				   student.getFirstName(),
            				   student.getLastName(),
            				   student.getEmail() 
            				  );
            
            
            output.println("GRADE ITEMS");
            for (int j = 0; j < grades.length; j++)
            {
            	gradeItem = (GradeItem) grades[j];
            	if ( student.getStudentId().equals
            		(gradeItem.getStudentId() ) )
            	{
            		//output.println("");
		            output.printf ("%s %6s %11s %11s %9s %9s\n",
		            				   gradeItem.getGradeItemId(),
		            				   gradeItem.getCourseId(),
		            				   gradeItem.getItemType(),
		            				   gradeItem.getDate(),
		            				   gradeItem.getMaxScore(),
		            				   gradeItem.getActualScore()
		            				  );
		            actualSum += gradeItem.getActualScore();
		            maxSum += gradeItem.getMaxScore();
	            }
            }
            
	            percentEarned = ( (double) actualSum/ (double) maxSum ) * 100;
	            output.println
	    		("========================================================================");
	    		output.printf 
	    		( "%10s %31s %9s %9s%%\n\n", "Total", maxSum, 
	    		   actualSum, percentEarned);
            
            
        } // End for loop
		 
	}

}
