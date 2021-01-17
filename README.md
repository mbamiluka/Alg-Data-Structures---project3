# Alg-Data-Structures---project3
This project builds on project one and two, but with the use of ADT List. Note: ADT List was fully implemented during this project - Refer to List class.

## FileNumber Class - 121 lines
This  class gets a two digit number from the user through the console or the command line.
The number inputted will be used in naming input files.

Method overloading was used on the getFileNumber method. Based on the number of arguments, this 
method will either get input from the keyboard or from the command line.

## GradeItem Class - 271 lines
This class thoroughly validates arguments and then creates a grade for a student.
Each grade item has a; student ID, grade item ID, course ID, date, etc - All these are
relevant to a typical grade.

A constructor is used to initialize the variables listed above. The constructor has a series
of If-statements checking if any field is null or the length of any field is zero. If any fields are,
we throw an illegalArgumentException describing exactly what is missing.

On line 19 of the GradeItem class, you can see an array of grade types. I had to validate the user
input to be a valid grade type. So, I compared the input against the grade types by looping through
the items on line 19.

The date to is validated, and upon passing all validations I intiated the constructor (line 152 to 158)
Getter and Setter methods were created for each variable. Also, I created an equals method to check
if two grade items are the same or duplicate. 

The toString() method is used in outputting the details of a student object.
