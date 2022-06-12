/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hostel.managment.system;

import java.awt.Color;
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
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Background;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Kamrul
 */
public class RoomManagmentController implements Initializable {
      public void RoomTable() {
           try{
        Connection con = (Connection) ConnectionProvider.getCon();
        Statement st = con.createStatement();
        ResultSet rs = (ResultSet) st.executeQuery("Select*from room");
        while(rs.next())
        {
            //dtm.addRow(new Object[] {rs.getString(1),rs.getString(2),rs.getString(3)});
              //roomlist.add(new RoomTable(rs.getString("number")));
            roomlist.add(new ModelTable(rs.getString("number"),rs.getString("activate"),rs.getString("roomstatus")));
         
        }
        }
        catch(SQLException e){
        }
   
             room_col.setCellValueFactory(new PropertyValueFactory<>("numberdb"));
             activa_col.setCellValueFactory(new PropertyValueFactory<>("activatedb"));
             status_col.setCellValueFactory(new PropertyValueFactory<>("statussdb"));
             TableViews.setItems(roomlist);
      }

    @FXML
    private TextField roomField;
    @FXML
    private CheckBox cheackbpx;
    @FXML
    private TableView<ModelTable> TableViews;
    @FXML
    private TableColumn<ModelTable, String> room_col;
    @FXML
    private TableColumn<ModelTable, String> activa_col;
    @FXML
    private TableColumn<ModelTable, String> status_col;
    ObservableList<ModelTable> roomlist = FXCollections.observableArrayList();
    @FXML
    private TextField roomsearchField;
    @FXML
    private CheckBox cheackbpxUpdate;
    @FXML
    private Button roomsearchBtn;
    @FXML
    private Button roomUpdateBtn;
    @FXML
    private Button RoomDeleteBtn;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        RoomTable();      
    }    

    @FXML
    private void saveRoomInfo(ActionEvent event) {
        
        String RoomNumber = roomField.getText();
        String activate;
        String RoomStatus ="Not Bocked";
        if(cheackbpx.isSelected())
        {
            activate="Yes";
        }
        else
        {
            activate="No";
        }
        try{
        Connection con = (Connection) ConnectionProvider.getCon();
        PreparedStatement ps = con.prepareStatement("insert into room values(?,?,?)");
        ps.setString(1,RoomNumber);
        ps.setString(2,activate);
        ps.setString(3,RoomStatus);
        ps.executeUpdate();
        JOptionPane.showMessageDialog(null,"Successfully Update");
        //tableDetails();
       // RoomTable();
       
        //clear();
        
        }
        catch(HeadlessException | SQLException e){
        JOptionPane.showMessageDialog(null,e);
        }
    }

    @FXML
    private void roomsearchAction(ActionEvent event) {
        String roomnumber = roomsearchField.getText();
        int coun=0;
        try{
        Connection con = ConnectionProvider.getCon();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select *from room where number = '"+roomnumber+"'");
        
        while(rs.next())
        {
            coun=1;
            if(rs.getString(3).equals("Bocked"))
            {
            JOptionPane.showMessageDialog(null, "This room is Bocked");
            //clear();
            roomsearchField.clear();
            }
            else{
            roomsearchField.setEditable(false);
            //roomsearchField.setForeground(Color.red);
           
            if(rs.getString(2).equals("Yes"))
            {
            cheackbpxUpdate.setSelected(true);
            }
            else{
            cheackbpxUpdate.setSelected(false);

            }
            }
            if(coun==0)
            {
            JOptionPane.showMessageDialog(null, "This room Number does not Exist");
            //clear();
             roomsearchField.clear();
            }
        }
              
        }
        catch(HeadlessException | SQLException e)
        {
         JOptionPane.showMessageDialog(null, e);
        }
    }

    @FXML
    private void roomUpdateAction(ActionEvent event) {
        
             String roomnumber = roomsearchField.getText();
             if(roomnumber.equals(""))
             {
                 JOptionPane.showMessageDialog(null, "Please Enter the Room Number");
             }
             else
             {
                 String activate;
        if(cheackbpxUpdate.isSelected())
        {
            activate="Yes";
        }
        else{
        activate="No";
        }
        try{
          Connection con = ConnectionProvider.getCon();
        Statement st = con.createStatement();
        st.executeUpdate("update room set activate='"+activate+"' where number='"+roomnumber+"'");
        JOptionPane.showMessageDialog(null, "Successfully Update");
        //tableDetails();
        //RoomTable();
       // clear();
        roomsearchField.clear();
        }
        catch(HeadlessException | SQLException e){
        JOptionPane.showMessageDialog(null, e);

        }
        //RoomTable();
             }
        
    }

    @FXML
    private void RoomDeleteAction(ActionEvent event) {
              String roomnumber = roomsearchField.getText();
        try{
          Connection con = ConnectionProvider.getCon();
        Statement st = con.createStatement();
        st.executeUpdate("delete from room where number='"+roomnumber+"'");
        JOptionPane.showMessageDialog(null, "Successfully Delete");
        //tableDetails();
        //RoomTable();
        //clear();
        roomsearchField.clear();

        }
        catch(HeadlessException | SQLException e){
        JOptionPane.showMessageDialog(null, e);

        }
    }
    
}
