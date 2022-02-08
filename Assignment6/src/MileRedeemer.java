import sun.security.krb5.internal.crypto.Des;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

/**
  * 
  * CSCI 470/502        Assignment 6        Summer 2021
  *
  * Class: MileRedeemer
  *
  * Developer: Abel Vega Arteaga
  *
  *
  * Due Date/Time:  08/30/2021
  *
  * Purpose: encapsulate the logic for redeeming mileage. This class should have private instance
  * variables for an array of Destination objects, and an integer to represent the remaining miles after the
  * user's Frequent Flyer Miles have been redeemed
  */

public class MileRedeemer{
 
    //list of Destination's records
    private ArrayList<Destination> destinationList = new ArrayList<Destination>();
    
    //sorted Destination's records
    Destination[] destinationArry;
    
    //remainng miles for client
    private int remainMiles = 0; 
    
    //just to inizilize the class object


    /**
     * Gets the destination Array
     *
     */
    public Destination[] getDestinationArry(){
        return this.destinationArry;
    }
    /**
     * 
     * set the Remaing mailes
     */
    public void setRemainMiles(int remainMiles ){
        this.remainMiles = remainMiles;
    }

    /**
     * 
     * get the Remaing mailes
     */
    public int getRemainMiles(){
        return this.remainMiles;
    }
    
    /**
     * 
     * reads the records from the file, it will put it into the desination arrayList
     */
    public void readDestinations(Scanner fileScanner) throws IOException {
        
        //spliting and entering the data to the Destination list
        while(fileScanner.hasNextLine()){
            String data = fileScanner.nextLine();
            String[] arrOfStr = data.split(";");
            String[] dateStr = arrOfStr[4].split("-");
            Destination obj = new Destination( arrOfStr[0],  Integer.parseInt(arrOfStr[1]),  
                                                Integer.parseInt(arrOfStr[2]),  Integer.parseInt(arrOfStr[3]),  
                                                Integer.parseInt(dateStr[0]),   Integer.parseInt(dateStr[1]));
            destinationList.add(obj);
        }
        
        //used to sort and use a fixed size array
        destinationArry = (Destination[]) destinationList.toArray(new Destination[destinationList.size()]);
        Arrays.sort(destinationArry, new MileageComparator());

    }

    /**
     * gets the list of Cities in Alpha Numerica in a String Array
     * 
     */
    public String[] getCityNames(){
        
        //string array of city names
        String[] cityNameArry = new String[destinationList.size()];
        
        
        //entering data
        int i = 0;
        for(Destination destin : destinationList){ 
            cityNameArry[i] = destin.getCityName();
            i++;
        }
        //sorting acsending order
        Arrays.sort(cityNameArry);
        return cityNameArry;
    }


    /**
     * passes Miles for getting off season values from the list and Miles the client has.
     * containing descriptions of redeemed tickets to be printed out by the main app.
     */
    public String[] redeemMiles(int miles, int month){

        
        remainMiles = miles;
        int redeemablePoints = 0;

        boolean redeemFound = false; //if we cant find a ticket

        String[] noTicketsFound = {"*** Your client's has not accumulated enough Frequent Flyer Miles ***"}; 
        
        //list of redeemed tickets to check to be upgraded
        ArrayList<Integer> upgradeClass;
        upgradeClass = new ArrayList<Integer>();
        
        //checking first redeemable tickets for either off Season and normal
        for(int i = 0; i < destinationArry.length; i++){
            
            if(destinationArry[i].getStartMonth() <= month && month <= destinationArry[i].getEndMonth()){
                redeemablePoints = destinationArry[i].getOffSeasonMiles();
            }
            else{
                redeemablePoints = destinationArry[i].getNormalMiles();
            }

            if(remainMiles >= redeemablePoints){
                remainMiles = remainMiles - redeemablePoints;
                redeemFound = true; //if we get one, then we skip the "not accumuated points"
                upgradeClass.add(i);
            }
        }
        //checking if we got atleast one
        if(!redeemFound){
            return noTicketsFound;
        }

        //list of city names to print in main
        String[] cityNameArry = new String[upgradeClass.size()];
        int index;


        //loop through redeemed tickets for a chance to upgrade to 
        for(int i = 0; i < upgradeClass.size();i++){

            index = upgradeClass.get(i);
            cityNameArry[i] = "* A trip to " + destinationArry[index].getCityName();
            
            //
            if(remainMiles >= destinationArry[index].getFirstClass()){
                remainMiles = remainMiles - destinationArry[index].getFirstClass();
                cityNameArry[i] += " in First Class";
            }
            else{
                cityNameArry[i] += " in Economy Class";
            }
        }
        //System.out.println("Your client's Frequent Flyer Miles can be used to redeem the following tickets:\n");
        return cityNameArry; //return with list of destinations either in Economy class or First class
    }



}