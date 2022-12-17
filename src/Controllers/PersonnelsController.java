
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
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;

public class PersonnelsController implements Initializable {
@FXML
    private Button dashboardbtn;
@FXML
    private Button jeuxbtn;
    @FXML
    private Button clientbtn;
    @FXML
    private Button Materielsbtn;
    @FXML
    private Button deconnexionbtn;
    @FXML
    private Button add;
    @FXML
    private TableView<Personnel> table;
@FXML
    private TableColumn<?, ?> idcol;

    @FXML
    private TableColumn<?, ?> nomcol;

    @FXML
    private TableColumn<?, ?> prenomcol;

    @FXML
    private TableColumn<?, ?> ncol;

    @FXML
    private TableColumn<?, ?> prixcol;

    @FXML
    private TableColumn<?, ?> datecol;

    @FXML
    private TableColumn<?, ?> postecol;
    @FXML
    private Button cancel;
    @FXML
    private Button personnel;
    ObservableList<Personnel> listJeux = FXCollections.observableArrayList();
    
    String query = null;
    Connection conn = null ;
    PreparedStatement preparedStatement = null ;
    ResultSet resultSet = null ;
    Personnel game;
   
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
    void Topersonnel(ActionEvent event) throws IOException {
        Stage dashboard = new Stage();
                personnel.getScene().getWindow().hide();
                Parent rootA;
                rootA = FXMLLoader.load(getClass().getResource("/Views/Personnels.fxml"));
                Scene scene = new Scene(rootA);
                dashboard.setScene(scene);
                dashboard.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadDate();
    }      

    
    
   public void add(ActionEvent event) throws IOException {
        
          try {
            Parent parent = FXMLLoader.load(getClass().getResource("/Views/ajouterPersonnel.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(PersonnelsController.class.getName()).log(Level.SEVERE, "probléme de pages !", ex);
        }
    
    }    
   
    @FXML
    private void refreshTable() {
       try {
             listJeux.clear();
            query = "SELECT * FROM `personnel`";
            preparedStatement = conn.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()){
                listJeux.add(new  Personnel(
                        resultSet.getInt("id"),
                        resultSet.getString("nom"),
                        resultSet.getString("prenom"),
                        resultSet.getString("date_naiss"),
                        resultSet.getString("poste"),
                        resultSet.getInt("nbrHeures"),
                        resultSet.getFloat("prixHeure")     
                        ));
                table.setItems(listJeux);
                
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(PersonnelsController.class.getName()).log(Level.SEVERE, "Probléme d'affichage des données", ex);
        }
    }
    
    
    
    
    private void loadDate() {
        
        conn = mysqlconnect.ConnectDb();
        refreshTable();
        
        
        
        idcol.setCellValueFactory(new PropertyValueFactory<>("id"));
        nomcol.setCellValueFactory(new PropertyValueFactory<>("nom"));
        prenomcol.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        ncol.setCellValueFactory(new PropertyValueFactory<>("nbrHeures"));
        prixcol.setCellValueFactory(new PropertyValueFactory<>("prixHeure"));
        datecol.setCellValueFactory(new PropertyValueFactory<>("date_naiss"));
        postecol.setCellValueFactory(new PropertyValueFactory<>("poste"));
        
        
        
       TableColumn<Personnel, Void> colBtn = new TableColumn("edit");
       Callback<TableColumn<Personnel, Void>, TableCell<Personnel, Void>> cellFactory = new Callback<TableColumn<Personnel, Void>, TableCell<Personnel, Void>>() {

           
            @Override
            public TableCell<Personnel, Void> call(final TableColumn<Personnel, Void> param) {
                final TableCell<Personnel, Void> cell = new TableCell<Personnel, Void>() {

                    private final Button btn = new Button("Modifier");

                    {
                        btn.setOnAction((ActionEvent event) -> {
                
                            game = table.getSelectionModel().getSelectedItem();
                            FXMLLoader loader = new FXMLLoader ();
                            loader.setLocation(getClass().getResource("/Views/ajouterPersonnel.fxml"));
                            try {
                                loader.load();
                            } catch (IOException ex) {
                                Logger.getLogger(JeuxController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            
                           AjouterPersonnelController AjouterPersonnelController = loader.getController();
                           AjouterPersonnelController.setUpdate(true);
                           AjouterPersonnelController.setTextField( game.getId(),game.getNom(), 
                                    game.getPrenom(), game.getPoste(), String.valueOf (game.getNbrHeures()),String.valueOf (game.getPrixHeure()));
                           

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
       
        TableColumn<Personnel, Void> colBtn1 = new TableColumn("Supprimer");
       Callback<TableColumn<Personnel, Void>, TableCell<Personnel, Void>> cellFactory1 = new Callback<TableColumn<Personnel, Void>, TableCell<Personnel, Void>>() {

           
            @Override
            public TableCell<Personnel, Void> call(final TableColumn<Personnel, Void> param) {
                final TableCell<Personnel, Void> cell = new TableCell<Personnel, Void>() {

                    private final Button btn = new Button("Supprimer");

                    {
                        btn.setOnAction((ActionEvent event) -> {
                            
                             try {
                                game = table.getSelectionModel().getSelectedItem();
                                query = "DELETE FROM `personnel` WHERE id  ="+game.getId();
                                conn = mysqlconnect.ConnectDb();
                                preparedStatement = conn.prepareStatement(query);
                                preparedStatement.execute();
                                refreshTable();
                                
                            } catch (SQLException ex) {
                                Logger.getLogger(JeuxController.class.getName()).log(Level.SEVERE, null, ex);
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
           
           
        table.setItems(listJeux);

        }
    
    @FXML
    void cancel(ActionEvent event) {
 Stage stage = (Stage) cancel.getScene().getWindow();
          stage.close();
    }
    
}
