/**
  * 
  * CSCI 470/502        Assignment 3        Summer 2020
  *
  * Developer: Abel Vega Arteaga
  *
  * Section: 1
  *
  * Due Date/Time:  07/02/2021
  *
  * Purpose: consol app the lets the user to enter 
  *          bill/tip/partySize. Validates and 
  *          users could keep entering new data
  */


import java.util.InputMismatchException;
import java.util.Scanner;


public class TipApp {
    
    TipCalculator bill = new TipCalculator(); // object for tipCalculator 
    
    /**
     * main method
     */
    public static void main(String[] args) {
        
        
        TipApp tipApp = new TipApp();
        
        tipApp.calculateTips();
    
    }

    /**
     * calculateTips will contain the logic for interacting with the user at the keyboard
     * and displaying the output of the app
     */
    void calculateTips(){
        
        Scanner input = new Scanner(System.in);
        
        
        boolean continueApp = true; //continue the app
        boolean validInput = false; //checks if input is correct
        
        
        double billAmt;
        while(continueApp){
            
            System.out.print("\n*** Tip Calculator ***\n");
            
            //checks for valid bill amount > 0 and if is numeric 
            validInput = false;
            while(!validInput){
                System.out.print("\nEnter the bill amount: ");
                try{
                    billAmt = input.nextDouble();
                    if(billAmt > 0){
                        bill.setBillAmt(billAmt);
                        validInput = true;
                    }
                    else{
                        throw new IllegalArgumentException();
                    }
                } catch(InputMismatchException | IllegalArgumentException e){
                    System.out.print("Please enter a valid bill amount.\n");
                    input.nextLine();
                }
            }
            
            //checks for valid tip amount >= 0 and if is numeric 
            validInput = false;
            while(!validInput){
                System.out.print("Enter your desired tip percentage (20 equals 20%): ");
                try{
                    int pct = input.nextInt();
                    if(pct > -1){
                        bill.setPct(pct);
                        validInput = true;
                    }
                    else{
                        throw new IllegalArgumentException();
                    }

                } catch(InputMismatchException  | IllegalArgumentException e){
                    System.out.print("Please enter a valid tip percentage.\n\n");
                    input.nextLine();
                }
            }
            
            //checks for valid party size > 0 and if is numeric 
            validInput = false;
            while(!validInput){
                System.out.print("Enter the size of your party: ");
                try{
                    int partySize = input.nextInt();
                    if(partySize > 0){
                        bill.setPartySize(partySize);
                        validInput = true;
                    }
                    else{
                        throw new IllegalArgumentException();
                    }

                } catch(InputMismatchException | IllegalArgumentException e){
                    System.out.print("Please enter a valid party size.\n\n");
                    input.nextLine();
                }
            }

            System.out.print("\n*** Your Bill ****\n\n");
            System.out.printf("Bill Amount: $%.2f\n", bill.getBillAmt());
            System.out.printf("Tip Percentage: %d%%\n", bill.getPtc());
            System.out.printf("Party Size: %d\n\n", bill.getPartySize());
            System.out.printf("Total Bill (with Tip): $%.2f\n", bill.getTotalBill() );
            System.out.printf("Share for Each Individual: $%.2f\n\n", bill.getIndividualShare());
            
            // checks if the user wants to exit or not and if is either Y or N. 
            // Note to self - change this part using ingorecase and put the while loops into seperate methods for cleaner code
            validInput = false;
            while(!validInput){
                System.out.print("Another bill? (y/n): ");
                try{
                    String exitApp = input.next().toUpperCase();
                    if(exitApp.equals("Y")){
                        validInput = true;
                    }
                    else if(exitApp.equals("N")){
                        continueApp = false;
                        validInput = true;
                    }
                    else{
                        throw new IllegalArgumentException();
                    }
                } catch(InputMismatchException | IllegalArgumentException e){
                    System.out.print("Please enter (y/n).\n\n");
                    input.nextLine();
                }
            }
        }

        System.out.print("\nGoodbye!\n");
        input.close();
        bill = null;
    }
}


