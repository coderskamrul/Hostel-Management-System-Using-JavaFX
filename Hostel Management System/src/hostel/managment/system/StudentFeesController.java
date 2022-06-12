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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Kamrul
 */

public class StudentFeesController implements Initializable {
  

    public void FeesTable() {
           String mobilenumber = MobileField.getText();
        try{
        Connection con = (Connection) ConnectionProvider.getCon();
        Statement st = con.createStatement();
        ResultSet rs = (ResultSet) st.executeQuery("Select*from fees where mobileNo='"+mobilenumber+"'");
        while(rs.next())
        {
            //dtm.addRow(new Object[] {rs.getString(2),rs.getString(3)});
             Paylist.add(new ModelTable(rs.getString("month"),rs.getString("amount")));
            
        }
        
        }
        catch(SQLException e){
        JOptionPane.showMessageDialog(null, e);
        }
        
        MonthCol.setCellValueFactory(new PropertyValueFactory<>("Monthdb"));
        AmountCol.setCellValueFactory(new PropertyValueFactory<>("AmountDb"));
        PayTable.setItems(Paylist);
    }
    @FXML
    private TextField MobileField;
    @FXML
    private TextField NameField;
    @FXML
    private TextField EmailField;
    @FXML
    private TextField RoomField;
    @FXML
    private TextField monthField;
    @FXML
    private TextField PayAmountField;
    @FXML
    private Button MobileSearchBtn;
    @FXML
    private Button FeeUpdateBtn;
    @FXML
    private Button ClearBtn;
    @FXML
    private TableView<ModelTable> PayTable;
    @FXML
    private TableColumn<ModelTable, String> MonthCol;
    @FXML
    private TableColumn<ModelTable, String> AmountCol;
    ObservableList<ModelTable> Paylist = FXCollections.observableArrayList();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO Table Show
      FeesTable();
    }    

    @FXML
    private void MobileSearchAction(ActionEvent event) {
         String mobilenumber = MobileField.getText();
        SimpleDateFormat dFormat = new SimpleDateFormat("MM-YYYY");
        Date date = new Date();
        String Month = dFormat.format(date);
        
        try{
        Connection con = (Connection) ConnectionProvider.getCon();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("Select*from student where mobileNo='"+mobilenumber+"' and status='living'");
        if(rs.next())
        {
            MobileField.setEditable(false);
            NameField.setText(rs.getString(2));
            EmailField.setText(rs.getString(5));
            RoomField.setText(rs.getString(9));
            monthField.setText(Month);
            PayAmountField.setText("7000");
        }
        else
        {
         JOptionPane.showMessageDialog(null, "Student does not Exist");
         //clear();
         MobileField.clear();
         NameField.clear();
         EmailField.clear();
         RoomField.clear();
         monthField.clear();
         PayAmountField.clear();
        }
        //tableDetails();
        FeesTable();
        
        ResultSet rs1 = st.executeQuery("select *from fees inner join student where student.status='living' and fees.month='"+Month+"' and student.mobileNo='"+mobilenumber+"' and fees.mobileNo='"+mobilenumber+"'");
        if(rs1.next())
        {
            FeeUpdateBtn.setVisible(false);
            JOptionPane.showMessageDialog(null, "Fees is already pay Student for this Month");
        }
        }
        catch(HeadlessException | SQLException e){
        JOptionPane.showMessageDialog(null, e);
        }
    }

    @FXML
    private void FeeUpdateAction(ActionEvent event) {
          String mobilenumber = MobileField.getText();
        String month = monthField.getText();
        String amount = PayAmountField.getText();
          try{
        Connection con = (Connection) ConnectionProvider.getCon();
        PreparedStatement ps = con.prepareStatement("insert into fees values(?,?,?)");
        ps.setString(1,mobilenumber);
        ps.setString(2,month);
        ps.setString(3,amount);
        ps.executeUpdate();
        JOptionPane.showMessageDialog(null,"Successfully Update");
        //tableDetails();
        FeesTable();
        //clear();
         MobileField.clear();
         NameField.clear();
         EmailField.clear();
         RoomField.clear();
         monthField.clear();
         PayAmountField.clear();
        }
        catch(HeadlessException | SQLException e){
        JOptionPane.showMessageDialog(null,e);
        }
    }

    @FXML
    private void ClearAction(ActionEvent event) {
         MobileField.clear();
         NameField.clear();
         EmailField.clear();
         RoomField.clear();
         monthField.clear();
         PayAmountField.clear();
    }
    
}
