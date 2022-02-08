

/**
  * 
  * CSCI 470/502        Assignment 2        Summer 2020
  *
  * Developer: Abel Vega Arteaga
  *
  * Section: 1
  *
  * Due Date/Time:  06/18/2021
  *
  * Purpose: a basic understaind of Java. A simple program
  *          that prints invoice of a hardware shop.
  */

public class InvoiceTest {
    
    
    public static void main(String[] args) {

        Invoice n1 = new Invoice("AB-23-4312","Cordless Drill",10,189.00);
        Invoice n2 = new Invoice("DC-42-1200","RTX 3090",1,699.99);
        Invoice n3 = new Invoice("RR-51-5024","2x4 Plank Wood",40,9.00);
        Invoice n4 = new Invoice("PZ-30-4200","Hammer",2,4.00);
        Invoice n5 = new Invoice("ZE-24-5371","Red Bolt",100,0.52);
        System.out.println("jeel\ro");
        n1.printInvoice(1);
        n2.printInvoice(2);
        n3.printInvoice(3);
        n4.printInvoice(4);
        n5.printInvoice(5);
    }
}
