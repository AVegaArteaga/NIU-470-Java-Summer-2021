// Fig. 10.4: Employee.java
// Employee abstract superclass.
/**
  * 
  * CSCI 470/502        Assignment 5        Summer 2021
  *
  * Class: Employee
  *
  * Developer: Abel Vega Arteaga
  *
  * Due Date/Time:  07/12/2021
  *    
  * Purpose: a class that encapsulates information for the super class Employee.
  *          uses Date class for the Employee's date
  */ 
public abstract class Employee 
{
   private final String firstName;
   private final String lastName;
   private final String socialSecurityNumber;
   private final Date birthDate;
   // constructor
   public Employee(String firstName, String lastName, 
      String socialSecurityNumber, String birthDate)
   {
      this.firstName = firstName;                                    
      this.lastName = lastName;                                    
      this.socialSecurityNumber = socialSecurityNumber;    
      //splits the birthday and sets it to the birtDate variable
      String[] dateArry = birthDate.split("/");
      this.birthDate = new Date(Integer.parseInt(dateArry[0]),Integer.parseInt(dateArry[1]),Integer.parseInt(dateArry[2]));    
   } 

   // return birthday
   public Date getBirthDate(){
      return birthDate;
   }

   // return first name
   public String getFirstName()
   {
      return firstName;
   } 

   // return last name
   public String getLastName()
   {
      return lastName;
   } 

   // return social security number
   public String getSocialSecurityNumber()
   {
      return socialSecurityNumber;
   } 

   // return String representation of Employee object
   @Override
   public String toString()
   {
      return String.format("%s %s%nsocial security number: %s %nbirth date: %s", 
         getFirstName(), getLastName(), getSocialSecurityNumber(),  getBirthDate());
   } 

   // abstract method must be overridden by concrete subclasses
   public abstract double earnings(); // no implementation here
} // end abstract class Employee


/**************************************************************************
 * (C) Copyright 1992-2014 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/
