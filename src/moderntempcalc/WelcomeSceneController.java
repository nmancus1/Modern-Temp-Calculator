/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moderntempcalc;

import static com.sun.javafx.scene.control.skin.Utils.getResource;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


/**
 *
 * @author nick
 */
public class WelcomeSceneController implements Initializable {
    
    private Label label;
    @FXML
    private ToggleGroup toggleGroup1;
    @FXML
    private AnchorPane AnchorPane;
    @FXML
    private Button convertButton;
    @FXML
    private TextField userInputField;
    @FXML
    private RadioButton convertToCbutton;
    @FXML
    private RadioButton convertToFbutton;
          
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    //temperature logic here
    public static char userTempType = 'C';
    
    public static Stage popup = new Stage(StageStyle.UNDECORATED);
            

                     
    public static void popupWindow (String input) throws IOException {
        
        FXMLLoader loader = new FXMLLoader(WelcomeSceneController.class.getResource("PopupScene.fxml"));
        Parent root = loader.load();
        popup.setScene(new Scene(root));
        popup.setTitle("tempCalc Results");
        
        
        
        if (input.equals("start")) {

        popup.showAndWait();
    }
        else {
            popup.close();
        }
    
}
    
    @FXML
    public void calculateAndStartPopup (ActionEvent event) throws IOException {
        
        String userInput = userInputField.getText();
        
        CalculateTemp.setResult(userInput);
        
        WelcomeSceneController.popupWindow("start");
        
    }
   
    @FXML
    private void setConvertToC(ActionEvent event) {
        userTempType = 'C';
    }

    @FXML
    private void setConvertToF(ActionEvent event) {
        userTempType = 'F';
    }
    
}
