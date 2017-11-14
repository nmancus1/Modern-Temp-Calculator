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
    @FXML
    private static final Stage POP_UP = new Stage(StageStyle.UNDECORATED);      //  New stage instance

    private char userTempType = 'C';                                            //  This character sets the temperature type to convert to - used in 

          
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
    
        
            
    
    public static void showPopup (Boolean start) throws IOException {           //  Popup window method
        
    //setup popup window and construct new FXMLloader object
        FXMLLoader loader = new FXMLLoader(WelcomeSceneController.class.getResource("PopupScene.fxml"));
        Parent root = loader.load();                                            //  Load FXML
        POP_UP.setScene(new Scene(root));                                       //  New scene object
        POP_UP.setTitle("tempCalc Results");                                    //  Set popup window title
        
    //  Popup window controls
        if (start == true) {                                
            POP_UP.showAndWait();
    }
        else {
            POP_UP.close();
        }
    
}
    
    @FXML
    public void calcButtonAction (ActionEvent event) throws IOException { //  Fire popup and calculations
        
        String userInput = userInputField.getText();                            //  Parse input into userInput String
        CalculateTemp.setResult(userInput,userTempType);                        //  Call CalculateTemp()
        WelcomeSceneController.showPopup(true);                                 //  Call popupWindow()
        
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
