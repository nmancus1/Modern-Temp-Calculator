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
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;


public class PopupController implements Initializable {

    //  Overrides for FXML below
    @FXML
    private Text resultTextField;
    @FXML
    private Button thanksButton;

    
    //  Initialize result for popup window
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        resultTextField.setText(CalculateTemp.getResult());
    }    

    //  Override to close popup window
    @FXML
    public void closePopupScene(ActionEvent event) throws IOException {
        WelcomeSceneController.showPopup(false);
        
    }
    
}
