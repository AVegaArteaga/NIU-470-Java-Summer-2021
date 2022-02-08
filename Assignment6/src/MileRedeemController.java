// CoverViewerController.java
// Controller for Cover Viewer application
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ListView;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;


import java.io.File;
import java.util.List;

/**
 *
 * CSCI 470/502        Assignment 6        Summer 2021
 *
 * Class: MileRedeemerApp
 *
 * Developer: Abel Vega Arteaga
 *
 * Due Date/Time:  08/30/2021
 *
 * Purpose: encapsulate the logic for the MileRedeemerApp.fxml. this class takes the copy of the MileRedeemer class
 *          for the logic of this class. this class shows the list of destinations and its class's variables and
 *          prints redeemed destinations
 */
public class MileRedeemController {

    // variables for the left side of the program
    @FXML private ListView<Destination> destinationListView;
    private final ObservableList<Destination> destinationObservableList = FXCollections.observableArrayList();
    @FXML private TextField normalMilesTextField;
    @FXML private TextField superSaverMilesTextField;
    @FXML private TextField UpgradeCostTextField;
    @FXML private TextField superSaverDatesTextField;

    //variables for the right side of the program
    @FXML private Spinner<String> monthSpinner;
    @FXML private ListView<String> redeemMilesListView;
    @FXML private TextField enterMilesTextField;
    @FXML private TextField remainingMilesTextField;

    //copy of the MileRedeemer for this program
    MileRedeemer redeemerControllerObj;

    //array of Months and setting it to the list
    private String[] monthArray = {
            "January", "February", "March" , "April" ,
            "May" , "June" , "July" , "August" ,
            "September" , "October" , "November" , "December"
    };
    private final ObservableList<String> months = FXCollections.observableArrayList(monthArray);


    /**
     * initialize member function to set a copy of the object MileRedeemer to this controller class
     */
    public void initialize(MileRedeemer mileRedeemer) throws Exception{

        //copy of the mileRedeemer
        redeemerControllerObj = mileRedeemer;

        //spinner of months
        SpinnerValueFactory<String> valueFactory = new SpinnerValueFactory.ListSpinnerValueFactory<String>(months);
        valueFactory.setValue("January");
        monthSpinner.setValueFactory(valueFactory);
        final Spinner<String> monthSpinner = new Spinner<>();




        //List view for Destiniation (the left side)
        destinationObservableList.addAll(redeemerControllerObj.getDestinationArry());
        destinationListView.setItems(destinationObservableList);
        destinationListView.getSelectionModel().selectedItemProperty().addListener(
                (observableValue, oldValue, newValue) -> {
                    normalMilesTextField.setText(new String(String.valueOf(newValue.getNormalMiles())));
                    superSaverMilesTextField.setText(new String(String.valueOf(newValue.getOffSeasonMiles())));
                    UpgradeCostTextField.setText(new String(String.valueOf(newValue.getFirstClass())));
                    superSaverDatesTextField.setText(new String(
                            monthArray[newValue.getStartMonth() - 1] // - 1 to match to the array
                                    + " - " +
                                    monthArray[ newValue.getEndMonth() - 1 ]
                            ));
                }
        );




    }

    /**
     * redeemMilesButtonPress is an button event when press outputs the redeem miles and month and prints the
     * redeemed destinations
     */
    @FXML public void redeemMilesButtonPress(ActionEvent event){

        try {
            //clears the list of outputs
            redeemMilesListView.getItems().clear();

            //gets the numbers for redeemMiles function
            int miles = Integer.parseInt(enterMilesTextField.getText());
            int month = getMonthNum(monthSpinner.getValue());


            //gets and sets the lists of strings
            String[] destinationArray = redeemerControllerObj.redeemMiles(miles, month);
            redeemMilesListView.getItems().addAll((destinationArray));

            //sets the remaining miles to text output
            remainingMilesTextField.setText(String.valueOf(redeemerControllerObj.getRemainMiles()));
        } catch (NumberFormatException e){
            remainingMilesTextField.setText("");
            enterMilesTextField.setText("Please Enter a number!");
        }
    }

    /**
     *
     * getMonthNum gets the number of the month
     */
    private int getMonthNum(String enterMonth){
        int month = 0;
        switch (enterMonth){
            case "January":
                month = 1;
                break;
            case "February":
                month = 2;
                break;
            case "March":
                month = 3;
                break;
            case "April":
                month = 4;
                break;
            case "May":
                month = 5;
                break;
            case "June":
                month = 6;
                break;
            case "July":
                month = 7;
                break;
            case "August":
                month = 8;
                break;
            case "September":
                month = 9;
                break;
            case "October":
                month = 10;
                break;
            case "November":
                month = 11;
                break;
            case "December":
                month = 12;
                break;
        }
        return month;
    }

}
