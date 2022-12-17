/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controllers;

import helpers.mysqlconnect;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Mohamed Moslem
 */
public class AjouterMaterielController implements Initializable {
 @FXML
    private TextField nomtxt;

    @FXML
    private Button add;

    @FXML
    private Button closebtn;

    @FXML
    private DatePicker datetxt;

    @FXML
    private TextField statuttxt;

    @FXML
    private TextField prixtxt;

    @FXML
    private Button clean;

    String query = null;
    Connection conn= null;
  PreparedStatement preparedStatement;
     int gameId;
    
    
@FXML
   public void add () {    
        conn = mysqlconnect.ConnectDb();
        String nom = nomtxt.getText();
        String date_naiss = String.valueOf(datetxt.getValue());
        String prenom = statuttxt.getText();     
        String prixH = prixtxt.getText();
        

        if (nom.isEmpty() || date_naiss.isEmpty() || prenom.isEmpty() || prixH.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Veuillez remplir tous les champs svp!");
            alert.showAndWait();

        } else {
               getQuery();
               insert();     
               clean();
            
        }
  
    }
    @FXML
    public void close(ActionEvent event) {
        Stage stage = (Stage) closebtn.getScene().getWindow();
          stage.close();
    }

   public void clean() {
        nomtxt.setText(null);
        datetxt.setValue(null);
        
        prixtxt.setText(null);
       
        statuttxt.setText(null);
    }


     public void setUpdate(boolean b) {
        this.update = b;

}
      public void setTextField(int id,String name, String t,String l) {
        gameId=id;
        nomtxt.setText(name);
        statuttxt.setText(t);
   
        prixtxt.setText(l);
      
    } 
       private boolean update;
 

    private void getQuery() {

        if (update == false) {
            
            query = "INSERT INTO `materiel` (`nom`, `etat`, `date_achat`, `prix`) VALUES (?,?,?,?)";

        }else{
            query = "UPDATE `materiel` SET "
                    + "`nom`=?,"
                    + "`etat`=?,"
                    + "`date_achat`=?,"
                    + "`prix`=?"
                    + "WHERE idMateriel = '"+gameId+"'";
        }

    }
    
   private void insert() {
        try {
            
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, nomtxt.getText());
            preparedStatement.setString(2, statuttxt.getText());
            preparedStatement.setString(3, String.valueOf(datetxt.getValue()));
            preparedStatement.setString(4, prixtxt.getText());
            preparedStatement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(AjouterPersonnelController.class.getName()).log(Level.SEVERE, "probléme d'insertion", ex);
        }

    }
   
        @FXML
    void clean1(ActionEvent event) {
nomtxt.setText(null);
        datetxt.setValue(null);
        
        prixtxt.setText(null);
       
        statuttxt.setText(null);
    } 
   
   
     
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
   
      
    
}
