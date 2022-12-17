
package Controllers;

import Models.Personnel;
import helpers.mysqlconnect;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;

public class LoginController implements Initializable {

    @FXML
    private Button connexionbtn;

    @FXML
    private Button closeButton;
     @FXML
    private TextField username;

    @FXML
    private PasswordField mdp;
    
     @FXML
    private ComboBox role;
     
  
  
    Connection conn ;
    PreparedStatement preparedStatement = null ;
    ResultSet resultSet = null ;
   
            
    @FXML
    void Toconnexion(ActionEvent event) throws SQLException  {
         conn = mysqlconnect.ConnectDb();
        String usernom=username.getText();
        String pass=mdp.getText();
        String s = (String) role.getSelectionModel().getSelectedItem();

        if (usernom.equals("")&& pass.equals(""))
        {            JOptionPane.showMessageDialog(null, "Champs Username ou Mdp vide !");
        }else{
        try{
        preparedStatement = conn.prepareStatement("select * from user where username=? and mdp=? and type=?");
        preparedStatement.setString(1, usernom);
        preparedStatement.setString(2, pass);
        preparedStatement.setString(3, s);
        resultSet = preparedStatement.executeQuery();
        if (resultSet.next()){
            
            if("admin".equals(resultSet.getString("type"))){
                    JOptionPane.showMessageDialog(null, "Connexion réussie.Binevenue !");
                      try {
            Parent parent = FXMLLoader.load(getClass().getResource("/Views/Dashboard.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, "probléme de pages !", ex);
        }
                }
            else if ("client".equals(resultSet.getString("type"))){
                   JOptionPane.showMessageDialog(null, "Connexion réussie.Binevenue !");
            try {
            Parent parent = FXMLLoader.load(getClass().getResource("/Views/DashboardClt.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, "probléme de pages !", ex);
        }
            }
        }
        
        else{
                    username.setText("");
                    mdp.setText("");
                    username.requestFocus();
                    JOptionPane.showMessageDialog(null, "Connexion échouée.Veuillez vérifier vos données svp !");
                    
                }}catch (SQLException ex) {
                                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                            }

        
        }
       
    } 
  @FXML
    private void handleCancel()throws IOException {
          Stage stage = (Stage) closeButton.getScene().getWindow();
          stage.close();
    }
    
    @FXML
    void select(ActionEvent event) {
           String s = (String) role.getSelectionModel().getSelectedItem();
           
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
ObservableList<String> list = FXCollections.observableArrayList("Admin","Client");

    role.setItems(list);
    }    
    
}
