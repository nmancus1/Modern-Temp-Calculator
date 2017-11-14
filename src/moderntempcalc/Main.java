/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moderntempcalc;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author nick
 */
public class Main extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
       
        //  Build WelcomeScene
        Parent root = FXMLLoader.load(getClass().getResource("WelcomeScene.fxml"));
        stage.setTitle("Material TempCalc");
        stage.getIcons().add(new Image(Main.class.getResourceAsStream("color_therm1.png")));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
       
        stage.show();
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
