
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


public class AjouterPersonnelController implements Initializable {
 @FXML
    private TextField nomtxt;

    @FXML
    private Button add;

    @FXML
    private Button closebtn;

    @FXML
    private DatePicker datetxt;

    @FXML
    private TextField prenomtxt;

    @FXML
    private TextField postetxt;

    @FXML
    private TextField ntxt;

    @FXML
    private TextField prixtxt;

    @FXML
    private Button clean;

    
    String query = null;
    Connection conn= null;
  PreparedStatement preparedStatement;
     int gameId;
    
        @FXML
    void clean1(ActionEvent event) {
   nomtxt.setText(null);
        datetxt.setValue(null);
        postetxt.setText(null);
        prixtxt.setText(null);
        ntxt.setText(null);
        prenomtxt.setText(null);
    }  
@FXML
   public void add () {    
        conn = mysqlconnect.ConnectDb();
        String nom = nomtxt.getText();
        String date_naiss = String.valueOf(datetxt.getValue());
        String prenom = prenomtxt.getText();
        String poste = postetxt.getText();
        String NbrH = ntxt.getText();
        String prixH = prixtxt.getText();
        

        if (nom.isEmpty() || date_naiss.isEmpty() || prenom.isEmpty() || poste.isEmpty()) {
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
        postetxt.setText(null);
        prixtxt.setText(null);
        ntxt.setText(null);
        prenomtxt.setText(null);
    }


     public void setUpdate(boolean b) {
        this.update = b;

}
      public void setTextField(int id,String name, String t,String l, String p,String a) {
        gameId=id;
        nomtxt.setText(name);
        prenomtxt.setText(t);
        postetxt.setText(l);
        prixtxt.setText(a);
        ntxt.setText(p);
        
        
          
    } 
       private boolean update;
 

    private void getQuery() {

        if (update == false) {
            
            query = "INSERT INTO `personnel` (`nom`, `prenom`, `poste`, `date_naiss`, `nbrHeures`, `prixHeure`) VALUES (?,?,?,?,?,?)";

        }else{
            query = "UPDATE `personnel` SET "
                    + "`nom`=?,"
                    + "`prenom`=?,"
                    + "`poste`=?,"
                    + "`date_naiss`=?,"
                    + " nbrHeures=?,"
                    + "prixHeure =?"
                    + "WHERE id = '"+gameId+"'";
        }

    }
    
   private void insert() {
        try {
            
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, nomtxt.getText());
            preparedStatement.setString(2, prenomtxt.getText());
            preparedStatement.setString(3, postetxt.getText());
             preparedStatement.setString(4, String.valueOf(datetxt.getValue()));
            preparedStatement.setString(5, ntxt.getText());
            preparedStatement.setString(6, prixtxt.getText());
            preparedStatement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(AjouterPersonnelController.class.getName()).log(Level.SEVERE, "probléme d'insertion", ex);
        }

    }
   
   
   
   
     
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
   
   
   
   
}
