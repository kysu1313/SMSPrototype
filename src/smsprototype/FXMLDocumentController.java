/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package smsprototype;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author kms
 */
public class FXMLDocumentController implements Initializable {
    
    protected Scene scene;
    @FXML protected TextField usernamePhone;
    @FXML protected PasswordField txtPassword;
    @FXML protected Label lblStatus;
    
    public void login (ActionEvent event) {
        boolean num = isPhoneNum(usernamePhone.getText());
        if (num) {
            
            System.out.println("checking phone number");
            // Check a database of registered phone numbers
            
        } else {
            
            System.out.println("checking username");
            // Check a database of registered usernames
            
        }
        
        // If statement for testing purposes
        // TODO: add database
        if (usernamePhone.getText().equals("user") && txtPassword.getText().equals("pass")) {
            lblStatus.setText("Login Success");
            
            // After login is successful, you are taken to the main page
            Parent root;
            try {
                Stage stage = new Stage();
                root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } else {
            lblStatus.setText("Login Failed");
        }
        
    }
    
    public boolean isPhoneNum (String txt) {
        Pattern p = Pattern.compile("(0/91)?[7-9][0-9]{9}"); 
        boolean isNum = false;
        Matcher m = p.matcher(txt); 
        if (m.find() && m.group().equals(txt)) {
            isNum = true;
        }
        return isNum;
    }
    
    @Override
    public void initialize (URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
