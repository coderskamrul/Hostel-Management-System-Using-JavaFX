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
public class AddStudentsController implements Initializable {

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
    private Button saveBtn;
    @FXML
    private Button clearBtn;
    @FXML
    private ComboBox RoomCombboField;

    /**
     * Initializes the controller class.
     */ public void clears()
     {
        MobileField.clear();
        NameField.clear();
        FnameField.clear();
        MnameField.clear();
        EmailField.clear();
        AddressField.clear();
        CollageField.clear();
        IdField.clear();
     }
    
          public void roomNumber()
        {
            int coun=0;
            try{
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select *from room where activate='Yes' and roomStatus='Not Bocked'");
            while(rs.next())
            {
                coun=1;
                //RoomCombboField.getItems(rs.getString(1));
                //RoomCombboField.setItems("hjkhg");
                ObservableList<String> list = FXCollections.observableArrayList(rs.getString("number"));
                RoomCombboField.setItems(list);
                
            }
            if(coun==0)
            {
                JOptionPane.showMessageDialog(null,"All Room are already Bocked");
                
                
            }
            }
            catch(HeadlessException | SQLException e){
            
            }
        }
          
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       roomNumber();
    }    

    @FXML
    private void saveAction(ActionEvent event) {
        
        String mobilenumber = MobileField.getText();
        String name = NameField.getText();
        String father = FnameField.getText();
        String mother = MnameField.getText();
        String email = EmailField.getText();
        String address = AddressField.getText();
        String collage = CollageField.getText();
        String idnumber = IdField.getText();
        String roomnumber = (String) RoomCombboField.getValue();
        String status = "living";
        try{
        Connection con = ConnectionProvider.getCon();
        PreparedStatement ps = con.prepareStatement("insert into student values(?,?,?,?,?,?,?,?,?,?)");
        ps.setString(1, mobilenumber);
        ps.setString(2, name);
        ps.setString(3, father);
        ps.setString(4, mother);
        ps.setString(5, email);
        ps.setString(6, address);
        ps.setString(7, collage);
        ps.setString(8, idnumber);
        ps.setString(9, roomnumber);
        ps.setString(10, status);
        ps.executeUpdate();
        
        PreparedStatement ps1 = con.prepareStatement("update room set roomStatus='Bocked' where number=?");
        ps1.setString(1, roomnumber);
        ps1.executeUpdate();
         JOptionPane.showMessageDialog(null,"Successfully Update");
         clears(); 
        }
        catch(HeadlessException | SQLException e){
         JOptionPane.showMessageDialog(null,e);
        }
    }

    @FXML
    private void clearAction(ActionEvent event) {
       clears();
        //RoomCombboField.clear();
    }
    
}
