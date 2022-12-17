package Controllers;
import Models.jeu;
import helpers.mysqlconnect;
import java.awt.Image;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
import javafx.scene.image.ImageView;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;



public class JeuxController implements Initializable {

    @FXML
    private Button dashboardbtn;
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
    private TableView<jeu> table;
     @FXML
    private TableColumn<?, ?> idcol;
    @FXML
    private TableColumn<?, ?> agecol;
    @FXML
    private TableColumn<?, ?> desccol;
    @FXML
    private TableColumn<?, ?> typecol;
    @FXML
    private TableColumn<?, ?> prixcol;
    @FXML
    private TableColumn<?, ?> datecol;
    @FXML
    private TableColumn<?, ?> titrecol;
      @FXML
    private Button personnels;
           @FXML
    private Button cancel;
     
    ObservableList<jeu> listJeux = FXCollections.observableArrayList();
    
    String query = null;
    Connection conn = null ;
    PreparedStatement preparedStatement = null ;
    ResultSet resultSet = null ;
    jeu game;
    
   
    @FXML
    void add(ActionEvent event) throws IOException {
        
          try {
            Parent parent = FXMLLoader.load(getClass().getResource("/Views/ajouterjeu.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(JeuxController.class.getName()).log(Level.SEVERE, null, ex);
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
   public void ToClients(ActionEvent event) throws IOException {
           Stage Clients = new Stage();
                clientbtn.getScene().getWindow().hide();
                Parent rootA;
                rootA = FXMLLoader.load(getClass().getResource("/Views/Clients.fxml"));
                Scene scene = new Scene(rootA);
                Clients.setScene(scene);
                Clients.show();
    }

   

    @FXML
   public void ToLogin(ActionEvent event)throws IOException {
          Stage logout = new Stage();
                deconnexionbtn.getScene().getWindow().hide();
                Parent rootA;
                rootA = FXMLLoader.load(getClass().getResource("/Views/Login.fxml"));
                Scene scene = new Scene(rootA);
                logout.setScene(scene);
                logout.show();
    }

    @FXML
  public  void ToMateriels(ActionEvent event) throws IOException{
        Stage Materiels = new Stage();
                Materielsbtn.getScene().getWindow().hide();
                Parent rootA;
                rootA = FXMLLoader.load(getClass().getResource("/Views/Materiels.fxml"));
                Scene scene = new Scene(rootA);
                Materiels.setScene(scene);
                Materiels.show();
    }

    @FXML
   public void Tojeux(ActionEvent event)throws IOException {
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
                personnels.getScene().getWindow().hide();
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
  @FXML
    void cancel(ActionEvent event) {
     Stage stage = (Stage) cancel.getScene().getWindow();
          stage.close();
    }
    @FXML
    private void refreshTable() {
try {
             listJeux.clear();
            query = "SELECT * FROM `jeu`";
            preparedStatement = conn.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()){
                listJeux.add(new  jeu(
                        resultSet.getInt("idJeu"),
                        resultSet.getString("Titre"),
                        resultSet.getInt("ageLegal"),
                        resultSet.getString("description"),
                        resultSet.getString("type"),
                        resultSet.getFloat("prix"),
                        resultSet.getString("date_creation")     
                        ));
                table.setItems(listJeux);
                
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(JeuxController.class.getName()).log(Level.SEVERE, "ProblÃ©me d'affichage des donnÃ©es", ex);
        }
    }
   
      
 private void loadDate() {
        
        conn = mysqlconnect.ConnectDb();
        refreshTable();
        idcol.setCellValueFactory(new PropertyValueFactory<>("idJeu"));
        titrecol.setCellValueFactory(new PropertyValueFactory<>("Titre"));
        agecol.setCellValueFactory(new PropertyValueFactory<>("ageLegal"));
        desccol.setCellValueFactory(new PropertyValueFactory<>("description"));
        typecol.setCellValueFactory(new PropertyValueFactory<>("type"));
        prixcol.setCellValueFactory(new PropertyValueFactory<>("prix"));
        datecol.setCellValueFactory(new PropertyValueFactory<>("date_creation")
        
        );
       TableColumn<jeu, Void> colBtn = new TableColumn("edit");
       Callback<TableColumn<jeu, Void>, TableCell<jeu, Void>> cellFactory = new Callback<TableColumn<jeu, Void>, TableCell<jeu, Void>>() {

           
            @Override
            public TableCell<jeu, Void> call(final TableColumn<jeu, Void> param) {
                final TableCell<jeu, Void> cell = new TableCell<jeu, Void>() {

                    private final Button btn = new Button("Modifier");

                    {  

                            
                        btn.setOnAction((ActionEvent event) -> {
                
                             game = table.getSelectionModel().getSelectedItem();
                            FXMLLoader loader = new FXMLLoader ();
                            loader.setLocation(getClass().getResource("/Views/ajouterjeu.fxml"));
                            try {
                                loader.load();
                            } catch (IOException ex) {
                                Logger.getLogger(JeuxController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            
                           AjouterjeuController AjouterjeuController = loader.getController();
                           AjouterjeuController.setUpdate(true);
                           AjouterjeuController.setTextField( game.getIdJeu(),game.getTitre(), 
                                    game.getType(),game.getDescription(),String.valueOf (game.getAgeLegal()),String.valueOf (game.getPrix()));
                           

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
       
        TableColumn<jeu, Void> colBtn1 = new TableColumn("Supprimer");
       Callback<TableColumn<jeu, Void>, TableCell<jeu, Void>> cellFactory1 = new Callback<TableColumn<jeu, Void>, TableCell<jeu, Void>>() {

           
            @Override
            public TableCell<jeu, Void> call(final TableColumn<jeu, Void> param) {
                final TableCell<jeu, Void> cell = new TableCell<jeu, Void>() {

                    private final Button btn = new Button("Supprimer");

                    {
                        btn.setOnAction((ActionEvent event) -> {
                            
                             try {
                                game = table.getSelectionModel().getSelectedItem();
                                query = "DELETE FROM `jeu` WHERE idJeu  ="+game.getIdJeu();
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
}
