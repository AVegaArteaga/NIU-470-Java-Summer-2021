/**
  * 
  * CSCI 470/502        Assignment 3        Summer 2020
  *
  * Class name: TipCalculator 
  *
  * Developer:  Abel Vega Arteaga
  *
  * Purpose: calculations for tip logic. this may be resued with a different user unterfasce in a future assignment.
  */

public class TipCalculator {
    
    private double billAmt;
    private int    pct;
    private int    partySize;

    /**
     * TipCalculator constructor.
     */
    public TipCalculator(){
        billAmt = 0;
        pct = 20;
        partySize = 1;
    }

    /**
     * 2nd TipCalculator constructor for varibles 
     */
    public TipCalculator(double billAmt, int pct, int partySize){
        this.billAmt = billAmt;
        this.pct = pct;
        this.partySize = partySize;
    }

    /**
     * getIndividualShare used to get individals share of the bill + tip
     */ 
    public double getIndividualShare(){
        
        return getTotalBill() / partySize;

    }

    /**
     * getTotalBill gets the Total bill including the tip
     */     
    public double getTotalBill(){
        
        return (billAmt * ((double)getPtc() / 100)) + billAmt; 
    }

    /**
     * setBillAmt sets the bill amount
     */  
    public void setBillAmt(double billAmt){
        this.billAmt = billAmt;
    }

    /**
     * setPct sets to the tip Percentage to leave for the server 
     */ 
    public void setPct(int pct){
        this.pct = pct;
    }

    /**
     * setPartySize sets how many people
     */ 
    public void setPartySize(int partySize){
        this.partySize = partySize;
    }

    /**
     * getBillAmt gets the bill amount
     */ 
    public double getBillAmt(){
        return billAmt;
    }

    /**
     * getPtc gets the percentage
     */ 
    public int getPtc(){
        return pct;
    }

    /**
    * getPartySize gets the party size
    */
    public int getPartySize(){
        return partySize;
    }

}