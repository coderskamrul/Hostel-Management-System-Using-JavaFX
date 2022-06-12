/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hostel.managment.system;

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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author Kamrul
 */
public class FXMLDocumentController implements Initializable {
  
    private Label label;
    @FXML
    private TextField userName;
    @FXML
    private TextField userPass;
    @FXML
    private Button loginbtn;
    
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    

    @FXML
    private void loginaction(ActionEvent event) {
         if(userName.getText().equals("hmd") && userPass.getText().equals("123") || userName.getText().equals("sabina") && userPass.getText().equals("12345"))
        {
            
        Stage stage = null;
        Parent root = null;
         stage = (Stage) loginbtn.getScene().getWindow();
        try {
            FXMLLoader loder = new FXMLLoader(getClass().getResource("Home.fxml"));
            root = loder.load();
            HomeController HomeController = loder.getController();
           //root = FXMLLoader.load(getClass().getResource("Home.fxml"));
           String pass = userName.getText();
           HomeController.setUsername(pass);
           Scene scene = new Scene(root);
           stage.setScene(scene);
           stage.setTitle("Home Page");
            stage.show();
        } catch (IOException ex) {
           JOptionPane.showMessageDialog(null,ex);
        }
           
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Incorrect User or Password");
        }
    }
    
}
