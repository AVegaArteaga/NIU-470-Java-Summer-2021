import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
  * 
  * CSCI 470/502        Assignment 4        Summer 2021
  *
  * Developer: Abel Vega Arteaga
  *
  * Section: 1
  *
  * Due Date/Time:  07/12/2021
  *
  * Purpose: This assignment's objective is to write a console-based Java application with which a travel agent could
  * present options for travel destinations to a client who wants to redeem his or her accumulated frequent flyer
  * miles. For the sake of simplicity, we will assume all trips depart from O'Hare International Airport and that
  * the miles represented are required for a roundtrip ticket.
  * Depending on the distance, each destination requires a different number of frequent flyer miles to obtain a
  * roundtrip ticket. Note that, if the client travels during the "off season", he or she may be able to take
  * advantage of the "off season" mileage of a destination that requires fewer miles to obtain a roundtrip ticket
  * to that particular destination.
  */

public class MileRedemptionApp {
    
    /**
     * prints the title and the list of Destinations
     */
    public static void printTitle(MileRedeemer mileRedeemer){
        String[] cityNamesArry;
        printLongLine();
        System.out.println("       WELCOME TO THE JAVA AIRLINES MILES REDEMPTION AIR        ");
        printLongLine();
        System.out.println("List of destination cities your client can travel to:\n");
        
        cityNamesArry = mileRedeemer.getCityNames();
        for(int i = 0; i < cityNamesArry.length; i++){
            System.out.println(cityNamesArry[i]);
        }

        printLongLine();
    }
    /**
     * prints a single long lone for formatting
     */
    public static void printLongLine(){
        System.out.println("----------------------------------------------------------------");
    }
    public static void main(String[] args) throws IOException {

        
        MileRedeemer mileRedeemer = new MileRedeemer();
        String StrExitApp;
        Scanner exitApp = new Scanner(System.in); //exit the app
        Scanner enterScanner= new Scanner(System.in); //entered user's input
        int miles;
        int month;
        
        System.out.print("Please Enter the name of the file: ");
        Scanner readFile = new Scanner(System.in); //get the name of the file
        System.out.flush();

        //file selected
        String filename = readFile.nextLine();
        File file = new File(filename);
        Scanner fileScanner = new Scanner(file);
        
        mileRedeemer.readDestinations(fileScanner);

        printTitle(mileRedeemer);

        do{
            //gets the user's miles and month
            System.out.print("Please enter your clouent's accumulated Frequent Flyer Miles: ");
            miles = enterScanner.nextInt();
            System.out.println();
            System.out.print("Please enter your client's month of departure (1-12): ");
            month = enterScanner.nextInt();
            System.out.println();
            
            //gets the list of redeemed destinations and class
            String[] cityNamesArry;
            cityNamesArry = mileRedeemer.redeemMiles(miles,month);
            for(int i = 0; i < cityNamesArry.length; i++){
                System.out.println(cityNamesArry[i]);
            }

            System.out.println("\nYour client's remaining Frequent Flyer Miles: " + mileRedeemer.getRemainMiles() + "\n");
            
            //exiting?
            printLongLine();
            System.out.print("Do you want to continue (y/n)? ");
            StrExitApp = exitApp.next();
            printLongLine();
        } while (!StrExitApp.equalsIgnoreCase("n"));

        //close every scanner
        exitApp.close();
        enterScanner.close();
        fileScanner.close();
        readFile.close();

        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("         THANK YOU FOR USING THE JAVA AIRLINES MILRES REDEMPTION APP");
        System.out.println("-----------------------------------------------------------------------------");

    }
}
