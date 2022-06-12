/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hostel.managment.system;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Kamrul
 */
public class ViewStudentController implements Initializable{ 


    @FXML
    private TableView<ModelTable> tableId;
    @FXML
    private TableColumn<ModelTable , String> mobileId;
    @FXML
    private TableColumn<ModelTable , String> nameId;
    @FXML
    private TableColumn<ModelTable , String> fatherId;
    @FXML
    private TableColumn<ModelTable , String> motherId;
    @FXML
    private TableColumn<ModelTable , String> emailId;
    @FXML
    private TableColumn<ModelTable , String> addressId;
    @FXML
    private TableColumn<ModelTable , String> collageId;
    @FXML
    private TableColumn<ModelTable , String> IdNoId;
    @FXML
    private TableColumn<ModelTable , String> statusId;
    @FXML
    private TableColumn<ModelTable , String> RoomId;
 
   ObservableList<ModelTable> oblist = FXCollections.observableArrayList();
   
    public void initialize(URL location, ResourceBundle resources) {
        
         try{
        Connection con = (Connection) ConnectionProvider.getCon();
        Statement st = con.createStatement();
        ResultSet rs = (ResultSet) st.executeQuery("Select*from student where status='leaved'");
        while(rs.next())
        {
           // model.addRow(new Object[] {rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(1),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9)});
            oblist.add(new ModelTable(rs.getString("mobileNo"),rs.getString("name"),rs.getString("father"),rs.getString("mother"),rs.getString("email"),rs.getString("address"),rs.getString("collage"),rs.getString("idNo"),rs.getString("roomNo"),rs.getString("status")));
            
        }
        
        }
        catch(Exception e){
        JOptionPane.showMessageDialog(null, e);
        }
      
         mobileId.setCellValueFactory(new PropertyValueFactory<>("mobilenumber"));
         nameId.setCellValueFactory(new PropertyValueFactory<>("name"));
         fatherId.setCellValueFactory(new PropertyValueFactory<>("father"));
         motherId.setCellValueFactory(new PropertyValueFactory<>("mother"));
         emailId.setCellValueFactory(new PropertyValueFactory<>("email"));
         addressId.setCellValueFactory(new PropertyValueFactory<>("address"));
         collageId.setCellValueFactory(new PropertyValueFactory<>("collage"));
         IdNoId.setCellValueFactory(new PropertyValueFactory<>("idnumber"));
         statusId.setCellValueFactory(new PropertyValueFactory<>("status"));
         RoomId.setCellValueFactory(new PropertyValueFactory<>("roomnumber"));
         tableId.setItems(oblist);
           }
      
    
}
