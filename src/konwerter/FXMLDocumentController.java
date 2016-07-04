/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package konwerter;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

/**
 *
 * @author Consek
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label output,error;
    @FXML
    private ToggleGroup left,right;
    @FXML
    private TextField input; 
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        
        final String c = "Celcius";
        final String f = "Fahrenheit";
        final String k = "Kelvin";
        
        
        RadioButton lSelected = (RadioButton)left.getSelectedToggle();
        String lText = lSelected.getText();
        RadioButton rSelected = (RadioButton)right.getSelectedToggle();
        String rText = rSelected.getText();
        double wejscie = 0;
        error.setText("");
        try{
            wejscie = Double.parseDouble(input.getText());
        }catch(NumberFormatException n){
            error.setText("Błędna dana");
            return;
        }
        double wyjscie = wejscie;
        
        
        
        switch(lText) {
        
            case c:
            {
                if(rText.equals(f))
                {
                    wyjscie = wejscie * 1.8 + 32;
                }else{
                    if(rText.equals(k)){
                        wyjscie = wejscie + 273.15;
                    }
                }
            }
            break;
            case f:
            {
                if(rText.equals(c))
                {
                    wyjscie = (wejscie + 32) / 1.8;
                }else{
                    if(rText.equals(k)){
                        wyjscie = (wejscie + 459.67) * 5/9;
                    }
                }
            }
            break;
            case k:
            {
                if(rText.equals(c))
                {
                    wyjscie = wejscie - 273.15;
                }else{
                    if(rText.equals(f)){
                        wyjscie = wejscie * 9/5 - 459.67;
                    }
                }
            }
            break;
        }
        
        output.setText( String.valueOf(wyjscie));
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
