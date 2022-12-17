
package Controllers;
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
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javax.swing.JOptionPane;



public class DashboardController implements Initializable {
 private ObservableList data;    
 private   XYChart.Series series = new XYChart.Series();

 @FXML
    private CategoryAxis xx;

    @FXML
    private NumberAxis yy;
 @FXML
    private LineChart<String, Integer> lineChart;
   @FXML
    private CategoryAxis x;

    @FXML
    private NumberAxis y;
    @FXML
    private Button dashboardbtn;

    @FXML
    private AreaChart<String, Integer> areachart;
    @FXML
    private Button clientbtn;

    @FXML
    private Button Materielsbtn;

    @FXML
    private Button jeuxbtn;

    @FXML
    private Button deconnexionbtn;
    @FXML
    private Button printbtn;
    @FXML
    private Button btnSave;
    @FXML
    private Label tc;

    @FXML
    private Label tj;

    @FXML
    private Label tp;
     @FXML
    private Button personnel;
     @FXML
    private PieChart pieChart;

       @FXML
    void save(ActionEvent event) {       
 /*
        Stage stage = new Stage();
                btnSave.getScene().getWindow().hide();
                
     
      Menu file = new Menu("File");
      MenuItem item = new MenuItem("Save", (Node) data);
      file.getItems().addAll(item);
      //Creating a File chooser
      FileChooser fileChooser = new FileChooser();
      fileChooser.setTitle("Save");
      fileChooser.getExtensionFilters().addAll(new ExtensionFilter("All Files", "*.*"));
      //Adding action on the menu item
      item.setOnAction(new EventHandler<ActionEvent>() {
         public void handle(ActionEvent event) {
            //Opening a dialog box
            fileChooser.showSaveDialog(stage);
         }
      });
      //Creating a menu bar and adding menu to it.
      MenuBar menuBar = new MenuBar(file);
      Group root = new Group(menuBar);
      Scene scene = new Scene(root, 595, 355, Color.BEIGE);
      stage.setTitle("File Chooser Example");
      stage.setScene(scene);
      stage.show();       
  */             
    }

 @FXML
    void print(ActionEvent event) {
      Node node = new Circle(100, 200, 200);
 PrinterJob job = PrinterJob.createPrinterJob();
 if (job != null) {
    boolean success = job.printPage(node);
    if (success) {
        job.endJob();
    }
 }
    }
 @FXML
   public void Topersonnel(ActionEvent event) throws IOException {
        Stage dashboard = new Stage();
                personnel.getScene().getWindow().hide();
                Parent rootA;
                rootA = FXMLLoader.load(getClass().getResource("/Views/Personnels.fxml"));
                Scene scene = new Scene(rootA);
                dashboard.setScene(scene);
                dashboard.show();
    }
    @FXML
    void ToClients(ActionEvent event) throws IOException {
Stage Clients = new Stage();
                clientbtn.getScene().getWindow().hide();
                Parent rootA;
                rootA = FXMLLoader.load(getClass().getResource("/Views/Clients.fxml"));
                Scene scene = new Scene(rootA);
                Clients.setScene(scene);
                Clients.show();
    }

    @FXML
    void ToDashboard(ActionEvent event) throws IOException {
Stage dashboard = new Stage();
                dashboardbtn.getScene().getWindow().hide();
                Parent rootA;
                rootA = FXMLLoader.load(getClass().getResource("/Views/Dashboard.fxml"));
                Scene scene = new Scene(rootA);
                dashboard.setScene(scene);
                dashboard.show();
    }

    @FXML
    void ToJeux(ActionEvent event) throws IOException {
Stage jeux = new Stage();
                jeuxbtn.getScene().getWindow().hide();
                Parent rootA;
                rootA = FXMLLoader.load(getClass().getResource("/Views/Jeux.fxml"));
                Scene scene = new Scene(rootA);
                jeux.setScene(scene);
                jeux.show();
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
    void ToMateriels(ActionEvent event) throws IOException {
 Stage Materiels = new Stage();
                Materielsbtn.getScene().getWindow().hide();
                Parent rootA;
                rootA = FXMLLoader.load(getClass().getResource("/Views/Materiels.fxml"));
                Scene scene = new Scene(rootA);
                Materiels.setScene(scene);
                Materiels.show();
    }

    Connection conn ;
    PreparedStatement preparedStatement = null ;
    ResultSet resultSet = null ;

  public void buildDataPiechart(){
     data = FXCollections.observableArrayList();    
    try{  
        preparedStatement = conn.prepareStatement("select * from jeu group by Titre");
        resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){          
            data.add(new PieChart.Data(resultSet.getString("Titre"),resultSet.getDouble("ageLegal")));
        }      
       }
       catch (SQLException ex) {            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, "probléme de pages !", ex);
      }             
      }   
    
  public void buildData1(){  try{  
        preparedStatement = conn.prepareStatement("select count(idJeu) AS JeuCount  from jeu");
        resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
        tj.setText(String.valueOf(resultSet.getInt("JeuCount")));
        }      
       }
       catch (SQLException ex) {            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, "probléme de pages !", ex);
      }}  
  public void buildData2(){ try{  
        preparedStatement = conn.prepareStatement("select count(idAbo) AS JeuCount  from client");
        resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
        tc.setText(String.valueOf(resultSet.getInt("JeuCount")));
        }      
       }
       catch (SQLException ex) {            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, "probléme de pages !", ex);
      }}  
  public void buildData3(){  try{  
        preparedStatement = conn.prepareStatement("select count(id) AS JeuCount  from personnel");
        resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
        tp.setText(String.valueOf(resultSet.getInt("JeuCount")));
        }      
       }
       catch (SQLException ex) {            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, "probléme de pages !", ex);
      }}  
  
  public void buildDataLinechart(){  try{  
        preparedStatement = conn.prepareStatement("select *  from personnel group by nom");
        resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
       
       series.getData().add(new XYChart.Data(resultSet.getString("nom"),resultSet.getInt("nbrHeures")));
        }      
       }
       catch (SQLException ex) {            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, "probléme de pages !", ex);
      }} 
     

    public void buildDataAreachart(){  
         XYChart.Series series1 = new XYChart.Series();
        try{  
        
       
        preparedStatement = conn.prepareStatement("select *  from client group by nom");
        resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
       series1.getData().add(new XYChart.Data(resultSet.getString("nom"), resultSet.getInt("rang")));
       
        }      
        
       }
       catch (SQLException ex) {            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, "probléme de pages !", ex);
      }
    areachart.getData().addAll(series1);
    
    } 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                       
        JOptionPane.showMessageDialog(null, "Binevenue Mr Admin dans votre espace .!");
             
           conn = mysqlconnect.ConnectDb();
         buildData1();
         buildData2();
         buildData3();
        pieChart.setTitle("Jeux Disponible en stock :" );
        buildDataPiechart();
        pieChart.getData().addAll(data);
         buildDataLinechart(); 
       lineChart.getData().addAll(series);
       lineChart.setTitle("Personnels et nombre de travail:");
         x.setLabel("Nom du personnel:");
         y.setLabel("Nombre d'heures par semaine");
         xx.setLabel("Nom du client:");
         yy.setLabel("Rang du client");
        buildDataAreachart();
       areachart.setTitle("Classement des clients:");

}
}