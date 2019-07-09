/*******************************************************************************

List

Purpose: 
The purpose of this class is to implement the MyCollection interface and to
provide the methods necessary for the main class of Project 03.

Ryan Lejeal, Mbami Luka

Project #03

Windows 10 Home Edition, Surface Laptop 2, jGrasp

   sequacious
      adjective - lacking independence or originality of thought

   "The man who has confidence in himself gains the confidence of others."
                                                           - Hasisdic Proverb

*******************************************************************************/

public class List <T> implements MyCollectionInterface <T> {

   private int capacity = 10;
       
       private T[] data;
       private int size;
       
       public List() {

           data = (T[]) new Object[capacity];
           size = 0;
       }
           
/******************************************************************************/

   /**
    * Adds a new entry to this collection
    * 
    * @param newItem The object to be added to the collection
    * @return True if the addition is successful, or false if not.
    */

   public boolean add (T newItem) {
   
      if (size == capacity) {

         T[] tempArray = data.clone();
                     
         capacity += 10;
         data = (T[]) new Object[capacity];
                     
         for (int i = 0; i < tempArray.length; i++) {
            data[i] = tempArray[i];
         }
         
      }
      
      data[size] = newItem;
      
      size++;
      
      return true;
        
   } // End add method

/******************************************************************************/

   /**
    * Removes one unspecified entry from the collection, if possible.
    *
    * @return Either the removed entry, if the removal was successful, or null.
    */
    
   public T remove () {
   
      if (size == 0) {
            // throw exception
            return null;
        }
        
        T temp = data[size-1];
        data[size-1] = null;
        size--;

        return temp;
        
   } // End remove method

/******************************************************************************/

   /**
    * Removes one occurrence of a given entry from this collection.
    *
    * @param anEntry The entry to be removed.
    * @return true if the removal was successful, false if not.
    */
       
   public boolean remove (T anEntry) {
   
        for (int i = 0; i < size; i++) {
        
            if (data[i].equals(anEntry)) {
            
                for (int j = i; j < size; j++ ) {
                    data[j] = data[j+1];
                }
                
                size--;
                return true;
            }
         
        }
        
        return false;
        
   } // End remove method

/******************************************************************************/
   
   /**
    * Removes all entries from this collection.
    */

   public void clear () {
   
      for (int i = 0; i < size; i++) {
      
         data[i] = null;
         
      }
      
   size = 0;
   
   } // End clear Method

/******************************************************************************/

   /**
    * Gets the current number of entries in this collection.
    *
    * @return The integer number of entries currently in the collection.
    */
   
   public int getCurrentSize () {
   
      return size;
      
   } // End getCurrentSize method

/******************************************************************************/
   
   /**
    * Check to see if the collection is empty.
    *
    * @return True if the collection is empty, or false if not.
    */
   
   public boolean isEmpty () {
   
      if (size == 0) {
      
         return true;
         
      }
        
   return false;

   } // End isEmpty method

/******************************************************************************/

   /**
    * Counts the number of times a given entry appears in this collection.
    *
    * @param anEntry The entry to be counted.
    * @return The number of times anEntry appears in the collection.
    */   

   public int getFrequencyOf (T anEntry) {
   
   int counter = 0;
   
      for (int i = 0; i < size; i++) {
        
         if (data[i].equals(anEntry)) {
            counter++;
         }
         
      }
   
   return counter;
   
   } // End getFrequencyOf method

/******************************************************************************/

   /**
    * Tests whether this collection contains a given entry.
    *
    * @param anEntry The entry to locate.
    * @return True if the collection contains anEntry, or false if not.
    */
       
   public boolean contains (T anEntry) {
      for (int i = 0; i < size; i++) {
            if (data[i].equals(anEntry)) {
               return true;
            }
      }
      
   return false;
      
   } // End contains method

/******************************************************************************/

   /**
    * Retrieves all entries that are in this collection.
    *
    * @return A newly allocated array of all the entries in the collection. 
    * Note: If the collection is empty, the returned array is empty.
    */
       
   public Object[] toArray () {
      
      Object[] listOfStudents = new Object[size];
        
      for (int i = 0; i < size; i++) {
      
         listOfStudents[i] = (Object) data[i];
         
      }
        
   return listOfStudents;
      
   } // End toArray method

} // end List class