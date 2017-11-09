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
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author nick
 */
public class PopupController implements Initializable {

    //  Overrides for FXML below
    @FXML
    private Text resultTextField;
    @FXML
    private Button thanksButton;

    
    //  Initialize result for popup window
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        resultTextField.setText(CalculateTemp.getResult());
    }    

    //  Override to close popup window
    @FXML
    public void closePopupScene(ActionEvent event) throws IOException {
        WelcomeSceneController.popupWindow("close");
        
    }
    
}
