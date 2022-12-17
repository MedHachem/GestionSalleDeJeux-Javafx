

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
import javafx.scene.chart.LineChart;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class DashboardCltController implements Initializable{

    @FXML
    private Button deconnexion;

    @FXML
    private Button dashboardclt;

    @FXML
    private Button Events;

    @FXML
    private Button parties;

    @FXML
    private Button inbox;

    @FXML
    private LineChart<?, ?> moisChar;

    @FXML
    private LineChart<?, ?> recompensesChart;

    @FXML
    private HBox assitancebtn;

    @FXML
    void Events(ActionEvent event) throws IOException {
   Stage logout = new Stage();
	                deconnexion.getScene().getWindow().hide();
	                Parent rootA;
	                rootA = FXMLLoader.load(getClass().getResource("/Views/events.fxml"));
	                Scene scene = new Scene(rootA);
	                logout.setScene(scene);
	                logout.show();
    }

    @FXML
    void ToLogin(ActionEvent event) throws IOException {
Stage logout = new Stage();
	                deconnexion.getScene().getWindow().hide();
	                Parent rootA;
	                rootA = FXMLLoader.load(getClass().getResource("/Views/Login.fxml"));
	                Scene scene = new Scene(rootA);
	                logout.setScene(scene);
	                logout.show();
    }

    @FXML
    void toDashboard(ActionEvent event) throws IOException {
Stage dashboard = new Stage();
	                dashboardclt.getScene().getWindow().hide();
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
	                parties.getScene().getWindow().hide();
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






