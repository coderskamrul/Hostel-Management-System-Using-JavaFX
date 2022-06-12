/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hostel.managment.system;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Kamrul
 */
public class HomeController implements Initializable {
    
   
    @FXML
    private Label userLabel;
    @FXML
    private Button LogoutBtn;
   
  public void setUsername(String ss)
    {
        userLabel.setText("Hi "+ss);
        
    }
    @FXML
    private HBox contentsShow;
    @FXML
    private Button AddStudent;
    @FXML
    private Button viewStudentLived;
    @FXML
    private Button rommManagement;
    @FXML
    private Button UpdateStudentBtn;
    @FXML
    private Button studenFeeBtn;
    @FXML
    private Button LivingStudentBtn;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
     
    }    

    @FXML
    private void AddStudentAction(ActionEvent event) {
        
            try {
            Parent pane = FXMLLoader.load(getClass().getResource("AddStudents.fxml"));
            contentsShow.getChildren().setAll(pane);
            
           // stage.setScene(scene);
           // stage.show();
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void viewStudentLivedAction(ActionEvent event) {
          try {
            Parent pane = FXMLLoader.load(getClass().getResource("ViewStudent.fxml"));
            contentsShow.getChildren().setAll(pane);
            
           // stage.setScene(scene);
           // stage.show();
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    private void rommManagementAction(ActionEvent event) {
          try {
            Parent pane = FXMLLoader.load(getClass().getResource("RoomManagment.fxml"));
            contentsShow.getChildren().setAll(pane);
            
           // stage.setScene(scene);
           // stage.show();
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void UpdateStudentAction(ActionEvent event) {
         try {
            Parent pane = FXMLLoader.load(getClass().getResource("UpdateStudent.fxml"));
            contentsShow.getChildren().setAll(pane);
            
           // stage.setScene(scene);
           // stage.show();
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void studenFeeAction(ActionEvent event) {
              try {
            Parent pane = FXMLLoader.load(getClass().getResource("StudentFees.fxml"));
            contentsShow.getChildren().setAll(pane);
            
           // stage.setScene(scene);
           // stage.show();
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void LivingStudentAction(ActionEvent event) {
         try {
            Parent pane = FXMLLoader.load(getClass().getResource("LivedStudentView.fxml"));
            contentsShow.getChildren().setAll(pane);
            
           // stage.setScene(scene);
           // stage.show();
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void LogoutAction(ActionEvent event) {
          Stage stage = null;
        Parent root = null;
         stage = (Stage) LogoutBtn.getScene().getWindow();
        try {
            FXMLLoader loder = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
            root = loder.load();
           //root = FXMLLoader.load(getClass().getResource("Home.fxml"));
           Scene scene = new Scene(root);
           stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
           JOptionPane.showMessageDialog(null,"No Screen");
        }
        
    }
    
}
