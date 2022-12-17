/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Mohamed Moslem
 */
public class eventsController implements Initializable {
   @FXML
    private Button deconnexionbtn;
    @FXML
    private HBox dashboardCltbtn;
    @FXML
    private Button dashboardbtn;
    @FXML
    private HBox eventsbtn;
    @FXML
    private Button eventbtn;
    @FXML
    private Button partiesbtn;
    @FXML
    private Button inboxBtn;
    @FXML
    private HBox assitancebtn;
    @FXML
    private Button assistanceBtn;

  @FXML
    void Events(ActionEvent event) throws IOException {
   Stage logout = new Stage();
	                eventsbtn.getScene().getWindow().hide();
	                Parent rootA;
	                rootA = FXMLLoader.load(getClass().getResource("/Views/events.fxml"));
	                Scene scene = new Scene(rootA);
	                logout.setScene(scene);
	                logout.show();
    }

    @FXML
    void ToLogin(ActionEvent event) throws IOException {
Stage logout = new Stage();
	                deconnexionbtn.getScene().getWindow().hide();
	                Parent rootA;
	                rootA = FXMLLoader.load(getClass().getResource("/Views/Login.fxml"));
	                Scene scene = new Scene(rootA);
	                logout.setScene(scene);
	                logout.show();
    }

    @FXML
    void toDashboard(ActionEvent event) throws IOException {
Stage dashboard = new Stage();
	                dashboardbtn.getScene().getWindow().hide();
	                Parent rootA;
	                rootA = FXMLLoader.load(getClass().getResource("/Views/DashboardClt.fxml"));
	                Scene scene = new Scene(rootA);
	                dashboard.setScene(scene);
	                dashboard.show();
    }

    @FXML
    void toInbox(ActionEvent event) throws IOException {/*
  Stage Clients = new Stage();
	                inbox.getScene().getWindow().hide();
	                Parent rootA;
	                rootA = FXMLLoader.load(getClass().getResource("/Views/Events.fxml"));
	                Scene scene = new Scene(rootA);
	                Clients.setScene(scene);
	                Clients.show();*/
    }

    @FXML
    void toParties(ActionEvent event) throws IOException {
 Stage dashboard = new Stage();
	                partiesbtn.getScene().getWindow().hide();
	                Parent rootA;
	                rootA = FXMLLoader.load(getClass().getResource("/Views/Parties.fxml"));
	                Scene scene = new Scene(rootA);
	                dashboard.setScene(scene);
	                dashboard.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    } 
    
}
