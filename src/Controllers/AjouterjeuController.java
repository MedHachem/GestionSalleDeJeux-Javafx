package Controllers;



import Models.jeu;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javafx.stage.Stage;
import helpers.mysqlconnect;

import java.sql.SQLException;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;

public class AjouterjeuController implements Initializable {

  @FXML
    private TextField titretxt;

    @FXML
    private TextField typetxt;

    @FXML
    private TextField agetxt;

    @FXML
    private TextField desctxt;

    @FXML
    private DatePicker datetxt;

    @FXML
    private TextField prixtxt;

    @FXML
    private Button add;

    @FXML
    private Button closebtn;

    @FXML
    private Button clean; 
    
           @FXML
    void clean1(ActionEvent event) {
titretxt.setText(null);
        datetxt.setValue(null);
        typetxt.setText(null);
        prixtxt.setText(null);
        desctxt.setText(null);
        agetxt.setText(null);
    }  
    String query = null;
    Connection conn= null;

    PreparedStatement preparedStatement;
     int gameId;
        @FXML
   public void add () {    
        conn = mysqlconnect.ConnectDb();
        String Titre = titretxt.getText();
        String date_creation = String.valueOf(datetxt.getValue());
        String type = typetxt.getText();
        String ageLegal = agetxt.getText();
        String description = desctxt.getText();
        String prix = prixtxt.getText();
        

        if (Titre.isEmpty() || date_creation.isEmpty() || type.isEmpty() || ageLegal.isEmpty()) {
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

    
  
private boolean update;
    private void getQuery() {

        if (update == false) {
            
            query = "INSERT INTO `jeu` (`ageLegal`, `description`, `type`, `prix`, `date_creation`, `Titre`) VALUES (?,?,?,?,?,?)";

        }else{
            query = "UPDATE `jeu` SET "
                    + "`ageLegal`=?,"
                    + "`description`=?,"
                    + "`type`=?,"
                    + "`prix`=?,"
                    + " date_creation=?,"
                    + "Titre =?"
                    + "WHERE idJeu = '"+gameId+"'";
        }

    }
    
   private void insert() {
        try {
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, agetxt.getText());
            preparedStatement.setString(2, desctxt.getText());
            preparedStatement.setString(3, typetxt.getText());
            preparedStatement.setString(4, prixtxt.getText());
            preparedStatement.setString(5, String.valueOf(datetxt.getValue()));
            preparedStatement.setString(6, titretxt.getText());
            preparedStatement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(AjouterjeuController.class.getName()).log(Level.SEVERE, "problÃ©me d'insertion", ex);
        }

    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    

    @FXML
    private void close(ActionEvent event) {
        Stage stage = (Stage) closebtn.getScene().getWindow();
          stage.close();
    }

    private void clean() {
        titretxt.setText(null);
        datetxt.setValue(null);
        typetxt.setText(null);
        prixtxt.setText(null);
        desctxt.setText(null);
        agetxt.setText(null);
    }

   public void setUpdate(boolean b) {
        this.update = b;

    }
       public void setTextField(int id,String name, String t, String s, String p,String a) {
        gameId=id;
        titretxt.setText(name);
        typetxt.setText(t);
        prixtxt.setText(a);
        desctxt.setText(s);
        agetxt.setText(p);
          
    } 
   
}
