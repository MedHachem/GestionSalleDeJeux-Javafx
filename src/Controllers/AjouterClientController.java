package Controllers;


import helpers.mysqlconnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AjouterClientController {

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
    private TextField rangtxt;

    @FXML
    private Button clean;

    @FXML
    private TextField bntxt;

    @FXML
    private TextField promotxt;

    @FXML
    private TextField ntxt;

    @FXML
    private TextField typetxt;

    @FXML
    private DatePicker datetxt1;

    @FXML
    private RadioButton aveugletxt;

    
    
     String query = null;
    Connection conn= null;
    boolean test;
    PreparedStatement preparedStatement;
     int gameId;
    @FXML
    void add(ActionEvent event) {
        conn = mysqlconnect.ConnectDb();
        String Titre = nomtxt.getText();
        String date_creation = String.valueOf(datetxt.getValue());
        String type = typetxt.getText();
        String ageLegal = prenomtxt.getText();
        

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
            
            query = "INSERT INTO `client`( `nom`, `prenom`, `typeAbo`, `date_abonn`, `date_naiss`, `aveugle`, `rang`, `nbrTournois`, `benefices`, `promo`) VALUES (?,?,?,?,?,?,?,?,?,?)";

        }else{
            query = "UPDATE `client` SET "
                    + "`nom`=?,"
                    + "`prenom`=?,"
                    + "`typeAbo`=?,"
                    + "`date_abonn`=?,"
                    + " date_naiss=?,"
                    + "aveugle =?,"
                    + " rang=?,"
                    + " nbrTournois=?,"
                    + " benefices=?,"
                    + " promo=?"
                    
                    + "WHERE idAbo = '"+gameId+"'";
        }

    }
    
   private void insert() {
      
      

        try {
            test=aveugletxt.isSelected();
            
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, nomtxt.getText());
            preparedStatement.setString(2, prenomtxt.getText());
            preparedStatement.setString(3, typetxt.getText());
            preparedStatement.setString(4, String.valueOf(datetxt1.getValue()));
            preparedStatement.setString(5, String.valueOf(datetxt.getValue()));
            preparedStatement.setBoolean(6, test);
            preparedStatement.setString(7, rangtxt.getText());
            preparedStatement.setString(8, ntxt.getText());
            preparedStatement.setString(9, bntxt.getText());
            preparedStatement.setString(10, promotxt.getText());
            preparedStatement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(AjouterClientController.class.getName()).log(Level.SEVERE, "probléme d'insertion", ex);
        }

    }

    @FXML
    private void close(ActionEvent event) {
        Stage stage = (Stage) closebtn.getScene().getWindow();
          stage.close();
    }

    private void clean() {
        nomtxt.setText(null);
        datetxt.setValue(null);
        typetxt.setText(null);
        prenomtxt.setText(null);
        bntxt.setText(null);
        ntxt.setText(null);
        datetxt1.setValue(null);
        promotxt.setText(null);
        aveugletxt.setText(null);
        rangtxt.setText(null);

    }

   public void setUpdate(boolean b) {
        this.update = b;

    }
       public void setTextField(int id,String name, String t, String s, String p,String a,String w,String x) {
        gameId=id;
        nomtxt.setText(name);
        typetxt.setText(s);
        prenomtxt.setText(t);
        bntxt.setText(p);
        rangtxt.setText(a);
        promotxt.setText(w);
        ntxt.setText(x);
    
    } 
       
       @FXML
    void clean1(ActionEvent event) {
nomtxt.setText(null);
        datetxt.setValue(null);
        typetxt.setText(null);
        prenomtxt.setText(null);
        bntxt.setText(null);
        ntxt.setText(null);
        datetxt1.setValue(null);
        promotxt.setText(null);
        aveugletxt.setText(null);
        rangtxt.setText(null);
    }


}
