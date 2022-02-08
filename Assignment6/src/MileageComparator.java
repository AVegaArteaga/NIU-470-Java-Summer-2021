import java.util.Comparator;
/**
  * 
  * CSCI 470/502        Assignment 4        Summer 2021
  *
  * Class: MileageComparator
  *
  * Developer: Abel Vega Arteaga
  *
  * Due Date/Time:  07/12/2021
  *
  * Purpose: Because the cities in the input text file will probably be out of order based on normal miles, the
  * readDestinations() method will need to sort them in descending normal miles order before any
  * redemptions can be done.
  */ 
public class MileageComparator implements Comparator<Destination>{
    /**
     * sorting using only the Destination's class NormalMiles variables
     */
    @Override
    public int compare(Destination d1, Destination d2){
        return (d2.getNormalMiles() - d1.getNormalMiles());
    }

}