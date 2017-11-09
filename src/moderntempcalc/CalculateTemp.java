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
    

    
    public static void setResult (String userInput, char userTempType) {        //  Method to set result value, called from WelcomeScene
        
        Double userTemp;                                                        //  Variable to store parsed user input
        char resultTempType = 'C';                                              //  Variable to store the temp type of result
        double resultUserTemp = 0.0;                                            //  Variable to store resulting temperature
        
    
    //  Try - catch to grab incorrect user input
        try {
                userTemp = Double.parseDouble(userInput);                       //  Parses user input to a double
            }
         catch (java.lang.NumberFormatException e) {                            //  If the user enters something that is not an integer
               result = "Please enter numbers only.";
                return;
         }
    
        
    //  Conversion algorithm below
        switch (userTempType) {
            
            case 'C':   resultUserTemp = (userTemp-32)* 5/9;                    // Convert C to F
                        break;
                        
            case 'F':   resultUserTemp = userTemp * 9/5 +32;                    // Convert F to C
                        break;     
        }
        
    //  Round result and input to two decimal places, for cleaner output
        userTemp = (double) Math.round(userTemp * 100) / 100;
        resultUserTemp = (double) Math.round(resultUserTemp * 100) / 100;

        
    //  Logic to display proper temp type
        if (userTempType == 'C') {
               resultTempType = 'F'; 
            }
            else {
                resultTempType = 'C';
        }
        
    
    //  Convert back to string and assign to result variable
        result = (userTemp + "°" + resultTempType + " equals " + resultUserTemp + "°" + userTempType);
        }
    
    
    public static String getResult () {                                         //  Method to get result
        return result;
    }

   
}
