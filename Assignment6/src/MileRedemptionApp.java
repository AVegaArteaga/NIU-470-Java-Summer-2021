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

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//
/**
 *
 * CSCI 470/502        Assignment 6        Summer 2021
 *
 * Developer: Abel Vega Arteaga
 *
 * Section: 1
 *
 * Due Date/Time:  08/30/2021
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

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.File;

import java.util.Scanner;

public class MileRedemptionApp extends Application {
    /**
     * start is the main logic of the class
     */
    @Override
    public void start(Stage stage) throws Exception {

        // start the MileRedeemer object
        MileRedeemer mileRedeemer = new MileRedeemer();
        //Create a file chooser
        FileChooser fileChooser = new FileChooser();

        //set the title
        fileChooser.setTitle("Opening the location...");
        //open the dialog box
        File file =  fileChooser.showOpenDialog(stage);

        //gets the input for the file from the path
        InputStream stream = new FileInputStream(file.getAbsolutePath());
        Scanner scanner = new Scanner(stream);

        HBox box = new HBox();
        box.setSpacing(20);
        //create scene
        Scene fileChooserScene = new Scene(box,350, 100);
        //set the scene
        stage.setScene(fileChooserScene);
        //set title
        stage.setTitle("Sample file chooser");
        //display the result
        stage.show();

        //System.out.println(file.getAbsolutePath());
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MileRedeemerApp.fxml"));
        Parent root = loader.load();

        //reads the destinations file for the class
        mileRedeemer.readDestinations(scanner);
        scanner.close();

        //passes the mileRedeemer obj to MileRedeemController class
        MileRedeemController objCon = loader.getController();
        objCon.initialize(mileRedeemer);


        //shows the GUI for the MileRedeemerApp
        Scene scene = new Scene(root);
        stage.setTitle("Mile Redemption App");
        stage.setScene(scene);
        stage.show();



    }

    public static void main(String[] args) {
        launch(args);
    }
}

