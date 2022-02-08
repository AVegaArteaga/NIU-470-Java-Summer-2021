import java.text.DecimalFormat;

/**
  * 
  * CSCI 470/502        Assignment 2        Summer 2020
  *
  * Class name: Invoice 
  *
  * Developer:  Abel Vega Arteaga
  *
  * Purpose: a basic understaind of Java. A simple program
  *          that prints invoice of a hardware shop.
  */

  
public class Invoice{
    private String partNumber;
    private String description;
    private int    quantity;
    private double price;

    /**
     * Invoice constructor to make a defualt class
     */
    public Invoice(){
        partNumber  = "NULL";
        description = "NONE";
        quantity    = 0;
        price = 0.00;
    }

    /**
     * Invoice 2nd construstor for the invoice class
     * 
     */
    public Invoice(String partNumber, String description, int quantity, double price){
        this.partNumber  = partNumber;
        this.description = description;
        this.quantity    = quantity;
        this.price       = price;
    }

    /**
     * 
     * getInvoiceAmount returns the InoiveAmount
     * 
     */
    public double getInvoiceAmount(){

        //Checks that the numbers are positive
        if(quantity < 0){
            quantity = 0;
        }
        if(price < 0.00){
            price = 0;
        }
        return quantity * price;
    }
    /**
     * printInvoice member to print the object's private members and invoice number.
     * 
     */
    public void printInvoice(int invNmb){

        //formating pattern
        String pattern = "$###,###,###.00";
        DecimalFormat moneyFormat = new DecimalFormat(pattern);

        //prints object's information
        System.out.printf("Invoice #%d\n\n", invNmb);
        System.out.printf("        Part No.: %s\n\n", getPartNumber());
        System.out.printf("      Item Desc.: %s\n\n", getDescription());
        System.out.printf("        Quantity: %d\n\n", getQuantity());
        System.out.printf("      Item Price: %s\n\n", moneyFormat.format(getPrice()));
        System.out.printf("Invoice Subtotal: %15s\n\n", moneyFormat.format(getInvoiceAmount()));
        System.out.printf("*********************************\n");
    }

    /**
     * setPartNumber sets the part number of the class
     * 
     */
    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }


    /**
     *  setDescription sets the description of the class
     * 
     */
    public void setDescription(String description){
        this.description = description;
    }

    /**
     * setQuantity sets the quantity of class
     * 
     */
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    /**
     * setPrice sets the price of the object
     */
    public void setPrice(double price){
        this.price = price;
    }

    /**
     * getPartNumber returns the partNumber of the object
     * 
     */
    public String getPartNumber(){
        return partNumber;
    }

    /*
     *  getDescription returns the object's description 
     */
    public String getDescription(){
        return description;
    }

    /*
     *  getQuantity returns the object's quantity 
     */
    public int getQuantity(){
        return quantity;
    }

    /*
     *  getPrice returns the object's price 
     */
    public double getPrice(){
        return price;
    }
}