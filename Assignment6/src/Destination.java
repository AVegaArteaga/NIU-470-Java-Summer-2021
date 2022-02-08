
/**
  * 
  * CSCI 470/502        Assignment 6        Summer 2021
  *
  * Class: Destination
  *
  * Developer: Abel Vega Arteaga
  *
  * Due Date/Time:  08/30/2021
  *    
  * Purpose: a class that encapsulates information such as the name of the destination city; normal miles required
  * for a ticket; "off season" miles required to for a ticket during the "off season" months; additional miles for
  * upgrading from economy to first class; start month of the "off season" and end month of the "off season".
  * Private instance variables and public accessor methods should be written for this information.
  */ 
  
public class Destination{
    
    private String cityName;
    
    private int normalMiles;
    private int offSeasonMiles;
    private int firstClass;

    private int startMonth;
    private int endMonth;


    /**
     * Constructor for the Destination Class
     * 
     */
    Destination(String cityName, int normalMiles, int offSeasonMiles, int firstClass, int startMonth, int endMonth ){
        this.cityName = cityName;
        this.normalMiles = normalMiles;
        this.offSeasonMiles = offSeasonMiles;
        this.firstClass = firstClass;
        this.startMonth = startMonth;
        this.endMonth = endMonth;
    }

    @Override
    public String toString()
    {
        return getCityName();
    }
    /**
     * setCityName sets the city name
     * 
     */
    public void setCityName(String cityName){
        this.cityName = cityName;
    }
    
    /**
     * returns the cityName
     * 
     */
    public String getCityName(){
        return this.cityName;
    }
    
    /**
     * setNormalMiles sets the normal Miles
     */
    public void setNormalMiles(int normalMiles){
        
        this.normalMiles = normalMiles;
    }
    
    /**
     * gets the normalMiles
     */
    public int getNormalMiles(){
        return this.normalMiles;
    }
    
    /**
     * offSeasonMiles sets the offSeasonmiless
     */
    public void setOffSeasonMiles(int offSeasonMiles){
        this.offSeasonMiles = offSeasonMiles;
    }
    /**
     *  gets the off Season Miles
     * 
     */
    public int getOffSeasonMiles(){
        return this.offSeasonMiles;
    }

    /**
     *  sets the First class points
     */
    public void setFirstClass(int firstClass){
        this.firstClass = firstClass;
    }
    
    /**
     * gets the first class points
     */
    public int getFirstClass(){
        return this.firstClass;
    }

    /**
     * sets the start of the month
     */
    public void setStartMonth(int startMonth){
        this.startMonth = startMonth;
    }
    
    /**
     *  gets the start of the month
     */
    public int getStartMonth(){
        return this.startMonth;
    }

    /**
     * Sets the End of the month
     */
    public void setEndMonth(int endMonth){
        this.endMonth = endMonth;
    }

    /**
     * gets the End of the month
     */
    public int getEndMonth(){
        return this.endMonth;
    }
}