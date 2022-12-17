package Controllers;

import Models.Client;
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
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;

public class ClientsController implements Initializable {

    @FXML
    private Button dashboardbtn;

    @FXML
    private Button clientbtn;

    @FXML
    private Button Materielsbtn;

    @FXML
    private Button personnels;

    @FXML
    private Button deconnexionbtn;
    @FXML
    private PieChart piechart;

    @FXML
    private Button add;

    @FXML
    private TableView<Client> table;

    @FXML
    private TableColumn<?, ?> idc;

    @FXML
    private TableColumn<?, ?> nomcol;

    @FXML
    private TableColumn<?, ?> prenomcol;

    @FXML
    private TableColumn<?, ?> TypeCol;

    @FXML
    private TableColumn<?, ?> rangcol;

    @FXML
    private TableColumn<?, ?> datecol;

    @FXML
    private Button jeuxbtn;
    @FXML
    private Button cancel;
        ObservableList<Client> listJeux = FXCollections.observableArrayList();


    String query = null;
    Connection conn = null ;
    PreparedStatement preparedStatement = null ;
    ResultSet resultSet = null ;
    Client game;
    private ObservableList data; 
   public void buildDataPiechart(){
     data = FXCollections.observableArrayList();    
    try{  
        preparedStatement = conn.prepareStatement("select * from client group by typeAbo");
        resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){          
            data.add(new PieChart.Data(resultSet.getString("typeAbo"),resultSet.getDouble("idAbo")));
        }      
       }
       catch (SQLException ex) {            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, "probléme de pages !", ex);
      }             
      } 
@FXML
    public void ToDashboard(ActionEvent event) throws IOException {
          Stage dashboard = new Stage();
                dashboardbtn.getScene().getWindow().hide();
                Parent rootA;
                rootA = FXMLLoader.load(getClass().getResource("/Views/Dashboard.fxml"));
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
    void ToLogin(ActionEvent event)throws IOException {
          Stage logout = new Stage();
                deconnexionbtn.getScene().getWindow().hide();
                Parent rootA;
                rootA = FXMLLoader.load(getClass().getResource("/Views/Login.fxml"));
                Scene scene = new Scene(rootA);
                logout.setScene(scene);
                logout.show();
    }

    @FXML
    void ToMateriels(ActionEvent event) throws IOException{
        Stage Materiels = new Stage();
                Materielsbtn.getScene().getWindow().hide();
                Parent rootA;
                rootA = FXMLLoader.load(getClass().getResource("/Views/Materiels.fxml"));
                Scene scene = new Scene(rootA);
                Materiels.setScene(scene);
                Materiels.show();
    }

   @FXML
    void Tojeux(ActionEvent event)throws IOException {
  Stage jeux = new Stage();
                jeuxbtn.getScene().getWindow().hide();
                Parent rootA;
                rootA = FXMLLoader.load(getClass().getResource("/Views/Jeux.fxml"));
                Scene scene = new Scene(rootA);
                jeux.setScene(scene);
                jeux.show();
    }
    
    @FXML
    void Topersonnels(ActionEvent event) throws IOException {
        Stage dashboard = new Stage();
                dashboardbtn.getScene().getWindow().hide();
                Parent rootA;
                rootA = FXMLLoader.load(getClass().getResource("/Views/Personnels.fxml"));
                Scene scene = new Scene(rootA);
                dashboard.setScene(scene);
                dashboard.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadDate();
        piechart.setTitle("Type d'abonnement par client:" );
        buildDataPiechart();
        piechart.getData().addAll(data);
    }      
    
    
    
    public void add(ActionEvent event) throws IOException {
        
          try {
            Parent parent = FXMLLoader.load(getClass().getResource("/Views/ajouterClient.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ClientsController.class.getName()).log(Level.SEVERE, "probléme de pages !", ex);
        }
    
    }   
    
    
     @FXML
    private void refreshTable() {
       try {
             listJeux.clear();
            query = "SELECT * FROM `client`";
            preparedStatement = conn.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()){
                listJeux.add(new  Client(
                        resultSet.getInt("idAbo"),
                        resultSet.getString("nom"),
                        resultSet.getString("prenom"),
                        resultSet.getString("date_naiss"),
                        resultSet.getBoolean("aveugle"),
                        resultSet.getInt("rang"),
                        resultSet.getInt("nbrTournois"),
                        resultSet.getInt("benefices"),
                        resultSet.getInt("promo"),
                        resultSet.getString("typeAbo"),
                        resultSet.getString("date_abonn")
                          
                        ));
                table.setItems(listJeux);
                
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ClientsController.class.getName()).log(Level.SEVERE, "Probléme d'affichage des données", ex);
        }
    }
    
    
    private void loadDate() {
        
        conn = mysqlconnect.ConnectDb();
        refreshTable();
        idc.setCellValueFactory(new PropertyValueFactory<>("idAbo"));
        nomcol.setCellValueFactory(new PropertyValueFactory<>("nom"));
        prenomcol.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        TypeCol.setCellValueFactory(new PropertyValueFactory<>("typeAbo"));
        rangcol.setCellValueFactory(new PropertyValueFactory<>("rang"));
        datecol.setCellValueFactory(new PropertyValueFactory<>("date_abonn"));
        table.setItems(listJeux);
        
       
        
        
       
       TableColumn<Client, Void> colBtn = new TableColumn("edit");
       Callback<TableColumn<Client, Void>, TableCell<Client, Void>> cellFactory = new Callback<TableColumn<Client, Void>, TableCell<Client, Void>>() {

           
            @Override
            public TableCell<Client, Void> call(final TableColumn<Client, Void> param) {
                final TableCell<Client, Void> cell = new TableCell<Client, Void>() {

                    private final Button btn = new Button("Modifier");

                    {
                        btn.setOnAction((ActionEvent event) -> {
                
                            game = table.getSelectionModel().getSelectedItem();
                            FXMLLoader loader = new FXMLLoader ();
                            loader.setLocation(getClass().getResource("/Views/ajouterClient.fxml"));
                            try {
                                loader.load();
                            } catch (IOException ex) {
                                Logger.getLogger(ClientsController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            
                           AjouterClientController AjouterClientController = loader.getController();
                           AjouterClientController.setUpdate(true);
                           AjouterClientController.setTextField( game.getIdAbo(),game.getNom(), 
                                    game.getPrenom(), game.getTypeAbo(), String.valueOf (game.getBenefices()),String.valueOf (game.getRang()),String.valueOf (game.getPromo()),String.valueOf (game.getNbrTournois()));
                           

                             Parent parent = loader.getRoot();
                            Stage stage = new Stage();
                            stage.setScene(new Scene(parent));
                            stage.initStyle(StageStyle.UTILITY);
                            stage.show();
                       
                            
                         
                            
                            
                        });
            
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btn);
                        }
                    }
                };
                return cell;
            }
            
        };
       
        TableColumn<Client, Void> colBtn1 = new TableColumn("Supprimer");
       Callback<TableColumn<Client, Void>, TableCell<Client, Void>> cellFactory1 = new Callback<TableColumn<Client, Void>, TableCell<Client, Void>>() {

           
            @Override
            public TableCell<Client, Void> call(final TableColumn<Client, Void> param) {
                final TableCell<Client, Void> cell = new TableCell<Client, Void>() {

                    private final Button btn = new Button("Supprimer");

                    {
                        btn.setOnAction((ActionEvent event) -> {
                            
                             try {
                                game = table.getSelectionModel().getSelectedItem();
                                query = "DELETE FROM `Client` WHERE idAbo  ="+game.getIdAbo();
                                conn = mysqlconnect.ConnectDb();
                                preparedStatement = conn.prepareStatement(query);
                                preparedStatement.execute();
                                
                                
                            } catch (SQLException ex) {
                                Logger.getLogger(ClientsController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            
                        });
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btn);
                        }
                    }
                };
                return cell;
            }
            
        };
       
           
        colBtn.setCellFactory(cellFactory);

        table.getColumns().add(colBtn);
           
           
           colBtn1.setCellFactory(cellFactory1);

         table.getColumns().add(colBtn1);
           
           

        }
    
    


    @FXML
    void cancel(ActionEvent event) {
 Stage stage = (Stage) cancel.getScene().getWindow();
          stage.close();
    }

  

}
