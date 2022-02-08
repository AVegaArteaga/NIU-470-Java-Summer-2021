import java.util.Scanner;

/**
  * 
  * CSCI 470/502        Assignment 5        Summer 2021
  *
  * Developer: Abel Vega Arteaga
  *
  * Section: 1
  *
  * Due Date/Time:  07/12/2021
  *
  * Purpose: This assignment's objective is to write a payrolled system that uses
  *          Polymophism and inheritence. There will be several employee classes that
  *          inherits from the Employee super class
  */
public class PayrollSystemTest 
{

   /**
    * addBonus returns a string that either prints a $100 bonus along the employee information
    * currentEmployee for class and month for what month will it land on
    */
   public static String addBonus( Employee currentEmployee, int month){
      

      if (currentEmployee.getBirthDate().getMonth() == month){
         return "plus $100.00 birthday bonus";
      }
      else{
         return "";
      }
   }
   public static void main(String[] args) 
   {
      Scanner enterMonth = new Scanner(System.in);
      int month = 0;
      // create subclass objects
      SalariedEmployee salariedEmployee = 
         new SalariedEmployee("John", "Smith", "111-11-1111", "6/15/1944" , 800.00);
      HourlyEmployee hourlyEmployee = 
         new HourlyEmployee("Karen", "Price", "222-22-2222", "12/29/1960" , 16.75, 40);
      CommissionEmployee commissionEmployee = 
         new CommissionEmployee("Sue", "Jones", "333-33-3333", "9/8/1954" ,10000, .06);
      BasePlusCommissionEmployee basePlusCommissionEmployee = 
         new BasePlusCommissionEmployee("Bob", "Lewis", "444-44-4444", "3/2/1965" ,5000, .04, 300);

      System.out.println("Employees processed individually:");
      
      System.out.printf("%n%s%n%s: $%,.2f%n%n", 
         salariedEmployee, "earned", salariedEmployee.earnings());
      System.out.printf("%s%n%s: $%,.2f%n%n",
         hourlyEmployee, "earned", hourlyEmployee.earnings());
      System.out.printf("%s%n%s: $%,.2f%n%n",
         commissionEmployee, "earned", commissionEmployee.earnings());
      System.out.printf("%s%n%s: $%,.2f%n%n", 
         basePlusCommissionEmployee, 
         "earned", basePlusCommissionEmployee.earnings());

      // create four-element Employee array
      Employee[] employees = new Employee[4]; 

      // initialize array with Employees
      employees[0] = salariedEmployee;
      employees[1] = hourlyEmployee;
      employees[2] = commissionEmployee; 
      employees[3] = basePlusCommissionEmployee;

      System.out.printf("Employees processed polymorphically:%n%n");

      System.out.printf("Enter the current month (1 - 12): ");
      month = enterMonth.nextInt();
      enterMonth.close();
      
      // generically process each element in array employees
      for (Employee currentEmployee : employees) 
      {
         System.out.println(currentEmployee); // invokes toString

         // determine whether element is a BasePlusCommissionEmployee
         if (currentEmployee instanceof BasePlusCommissionEmployee) 
         {
            // downcast Employee reference to 
            // BasePlusCommissionEmployee reference
            BasePlusCommissionEmployee employee = 
               (BasePlusCommissionEmployee) currentEmployee;

            employee.setBaseSalary(1.10 * employee.getBaseSalary());

            System.out.printf(
               "new base salary with 10%% increase is: $%,.2f%n",
               employee.getBaseSalary() );
         } 

         System.out.printf("earned $%,.2f %s%n%n", currentEmployee.earnings(), addBonus(currentEmployee, month));
      } 

      // get type name of each object in employees array
      for (int j = 0; j < employees.length; j++)
         System.out.printf("Employee %d is a %s%n", j, 
            employees[j].getClass().getName()); 
   } // end main
} // end class PayrollSystemTest

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
