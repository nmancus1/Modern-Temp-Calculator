/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moderntempcalc;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.AnchorPane;


/**
 *
 * @author nick
 */
public class tempCalcController implements Initializable {
    
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

    public tempCalcController() {
        this.tempType = 'C';
    }
          
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    //temperature logic here
    private char tempType;
    
    
    @FXML
    private void convertTemp(ActionEvent event) {
        
        String userInput = userInputField.getText();
        double userTemp = Double.parseDouble(userInput); 
        
        
        switch (tempType) {
            
            case 'C':   userTemp = (userTemp-32)* 5/9;
                        break;
                        
            case 'F':   userTemp = userTemp * 9/5 +32;
                        break;     
                          
        }
        
        userTemp = (double) Math.round(userTemp * 100) / 100;
        
        String tempResult = Double.toString(userTemp);
        userInputField.setText(tempResult);

        
       
            
    }

    @FXML
    private void setConvertToC(ActionEvent event) {
        tempType = 'C';
    }

    @FXML
    private void setConvertToF(ActionEvent event) {
        tempType = 'F';
    }
    
}
