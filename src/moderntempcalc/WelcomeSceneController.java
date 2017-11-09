/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moderntempcalc;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


/**
 *
 * @author nick
 */
public class WelcomeSceneController implements Initializable {
    
    
    /*  Override fxml elements
    *   
    */
    @FXML
    private ToggleGroup toggleGroup1;           //  Enables only one radio button to be activated at one time
    @FXML
    private AnchorPane AnchorPane;              //  Pane with contains all other elements
    @FXML
    private Button convertButton;               //  Button launches the popup window and calculates the temperature    
    @FXML
    private TextField userInputField;           //  User input field
    @FXML
    private RadioButton convertToCbutton;       //  Button to designate Celsius conversion
    @FXML
    private RadioButton convertToFbutton;       //  Button to designate Fahrenheit conversion
          
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
    
    
    /*  Variables and program logic below
    
    */
    
    public static char userTempType = 'C';                                      //  This character sets the temperature type to convert to - used in 
    public static Stage popup = new Stage(StageStyle.UNDECORATED);              //  New stage object
            

                     
    public static void popupWindow (String input) throws IOException {          //  Popup window method
        
        FXMLLoader loader = new FXMLLoader(WelcomeSceneController.class.getResource("PopupScene.fxml"));    //  New FXML loader object
        Parent root = loader.load();                                            //  Load FXML
        popup.setScene(new Scene(root));                                        //  New scene object
        popup.setTitle("tempCalc Results");                                     //  Set popup window title
        
        
        //  Popup window controls
        if (input.equals("start")) {                                
            popup.showAndWait();
    }
        else {
            popup.close();
        }
    
}
    
    @FXML
    public void calculateAndStartPopup (ActionEvent event) throws IOException { //  Fire popup and calculations
        
        String userInput = userInputField.getText();
        CalculateTemp.setResult(userInput,userTempType);
        WelcomeSceneController.popupWindow("start");
        
    }
   
    //  Sets final temp type to Celsius
    @FXML
    private void setConvertToC(ActionEvent event) {
        userTempType = 'C';
    }

    //  Sets final temp type to Fahrenheit
    @FXML
    private void setConvertToF(ActionEvent event) {
        userTempType = 'F';
    }
    
}
