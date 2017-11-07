/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moderntempcalc;

/**
 *
 * @author nick
 */
public class CalculateTemp {
    
    private static String result = "";
    static Double userTemp;
    static final char USER_TEMP_TYPE = WelcomeSceneController.userTempType;
    static char tempTypeResult;
    static double finalUserTemp;

    
    public static void setResult (String userInput) {
        
 
    try {
        userTemp = Double.parseDouble(userInput);
    } catch (java.lang.NumberFormatException e) { // if the user enters something that is not an integer
        result = "Please enter only numbers";
        return;
        
    }
    
        switch (USER_TEMP_TYPE) {
            
            case 'C':   finalUserTemp = (userTemp-32)* 5/9;
                        break;
                        
            case 'F':   finalUserTemp = userTemp * 9/5 +32;
                        break;     
                          
        }
        
        userTemp = (double) Math.round(userTemp * 100) / 100;
        finalUserTemp = (double) Math.round(finalUserTemp * 100) / 100;

        
        if (USER_TEMP_TYPE == 'C') {
            tempTypeResult = 'F'; 
        }
        else {
            tempTypeResult = 'C';
        }
        
        
        result = (userTemp + "°" + tempTypeResult + " equals " + finalUserTemp + "°" + USER_TEMP_TYPE);
        
    }
    
    public static String getResult () {
        return result;
    }

    public CalculateTemp() {
        this.userTemp = 0.0;
    }
    
}
