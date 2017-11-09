/*
*@author Nick Mancuso
*CIS-120 Final Program
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


public class WelcomeSceneController implements Initializable {
    
    
    // Override fxml elements

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
    
    public static Stage popup = new Stage(StageStyle.UNDECORATED);              //  New stage object

          
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
    
        
    public static char userTempType = 'C';                                      //  This character sets the temperature type to convert to - used in 
            
    
    public static void popupWindow (String input) throws IOException {          //  Popup window method
        
        //setup popup window and construct new FXMLloader object
        FXMLLoader loader = new FXMLLoader(WelcomeSceneController.class.getResource("PopupScene.fxml"));
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
        
        String userInput = userInputField.getText();                            //  Parse input into userInput String
        CalculateTemp.setResult(userInput,userTempType);                        //  Call CalculateTemp()
        WelcomeSceneController.popupWindow("start");                            //  Call popupWindow()
        
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
