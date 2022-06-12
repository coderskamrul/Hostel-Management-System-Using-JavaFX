/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hostel.managment.system;

import java.awt.HeadlessException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Kamrul
 */


public class UpdateStudentController implements Initializable {

    @FXML
    private TextField MobileField;
    @FXML
    private TextField NameField;
    @FXML
    private TextField FnameField;
    @FXML
    private TextField MnameField;
    @FXML
    private TextField EmailField;
    @FXML
    private TextField AddressField;
    @FXML
    private TextField CollageField;
    @FXML
    private TextField IdField;
    @FXML
    private TextField roomNumber;
    @FXML
    private Button searchBtn;
    @FXML
    private Button updateStudent;
    @FXML
    private ComboBox StatusCombboField;
    @FXML
    private Button DeleteStudent1;
    @FXML
    private Button ClearStudent11;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void searchBtns(ActionEvent event) {
         String mobilenumber = MobileField.getText();
        try{
         Connection con = ConnectionProvider.getCon();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select *from student where mobileNo='"+mobilenumber+"'");
       //ResultSet rs = st.executeQuery("select *from student where mobileNo='"+mobilenumber+"'");
        
        if(rs.next())
        {
            //jTextField1.setEditable(false);
            NameField.setText(rs.getString(2));
            FnameField.setText(rs.getString(3));
            MnameField.setText(rs.getString(4));
            EmailField.setText(rs.getString(5));
            AddressField.setText(rs.getString(6));
            CollageField.setText(rs.getString(7));
            IdField.setText(rs.getString(8));
            roomNumber.setText(rs.getString(9));
            
            if(rs.getString(10).equals("living"))
            {
            ObservableList<String> data = FXCollections.observableArrayList("living", "leaved");
            StatusCombboField.setItems(data);
            StatusCombboField.setValue("living");
            //StatusCombboField.setValue("leaved");
            }
            else
            {   
            ObservableList<String> data = FXCollections.observableArrayList("leaved", "living");
            StatusCombboField.setItems(data);
            StatusCombboField.setValue("leaved");
           // StatusCombboField.setValue("living");
            } 
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Student does not Exist");
            //clear();
        }
        }        
        catch(HeadlessException | SQLException e){
         JOptionPane.showMessageDialog(null,e);
        }
    }

    @FXML
    private void updateStudentAction(ActionEvent event) {
        String mobilenumber = MobileField.getText();
        String name = NameField.getText();
        String father = FnameField.getText();
        String mother = MnameField.getText();
        String email = EmailField.getText();
        String address = AddressField.getText();
        String collage = CollageField.getText();
        String idnumber = IdField.getText();
        String roomnumber = roomNumber.getText();
        String status = (String) StatusCombboField.getValue();
        try{
        Connection con = ConnectionProvider.getCon();
        Statement st = con.createStatement();
        if(status.equals("living"))
        {
            st.executeUpdate("update room set roomstatus='Bocked' where number='"+roomnumber+"'");
        }
        else
        {
             st.executeUpdate("update room set roomstatus='Not Bocked' where number='"+roomnumber+"'");
        }
        
         PreparedStatement pss = con.prepareStatement("update student set name=?,father=?,mother=?,email=?,address=?,collage=?,idNo=?,status=? where mobileNo=?");
         pss.setString(1, name);
         pss.setString(2, father);
         pss.setString(3, mother);
         pss.setString(4, email);
         pss.setString(5, address);
         pss.setString(6, collage);
         pss.setString(7, idnumber);
         pss.setString(8, status);
         pss.setString(9, mobilenumber);
         pss.executeUpdate();
         JOptionPane.showMessageDialog(null, "Successfully Updated");
         //clear();
          MobileField.clear();
            NameField.clear();
             FnameField.clear();
            MnameField.clear();
             EmailField.clear();
             AddressField.clear();
              CollageField.clear();
             IdField.clear();
             roomNumber.clear();
        }
        catch(HeadlessException | SQLException e){
        JOptionPane.showMessageDialog(null, e);
        }
    }

    @FXML
    private void DeleteStudentAction(ActionEvent event) {
        
         String mobilenumber = MobileField.getText();
         String roomnumber = roomNumber.getText();
         try{
         Connection con = ConnectionProvider.getCon();
         Statement st = con.createStatement();
         st.executeUpdate("delete from student where mobileNo='"+mobilenumber+"'");
         st.executeUpdate("update room set roomstatus='Not Bocked' where number='"+roomnumber+"'");
         JOptionPane.showMessageDialog(null, "Successfully Deleted");
          //clear();
           MobileField.clear();
            NameField.clear();
             FnameField.clear();
            MnameField.clear();
             EmailField.clear();
             AddressField.clear();
              CollageField.clear();
             IdField.clear();
             roomNumber.clear();
        //String status = (String) StatusCombboField.getValue();
         }
         catch(Exception e){
         JOptionPane.showMessageDialog(null, e);
         }
    }

    @FXML
    private void ClearStudentAction(ActionEvent event) {
           MobileField.clear();
            NameField.clear();
             FnameField.clear();
            MnameField.clear();
             EmailField.clear();
             AddressField.clear();
              CollageField.clear();
             IdField.clear();
             roomNumber.clear();
    }
    
}
