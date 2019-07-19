package sample.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import sample.Class.Championnat;
import sample.Data.ApiCaller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ListeChampionnatController {


    @FXML
    private ListView<String> lvcategorie;
    @FXML
    private ListView<String> lvdepreg;
    @FXML
    private ListView<String> lvchmp;
    public int idchampionnat;

    public int getIdchampionnat() {
        return idchampionnat;
    }

    public void setIdchampionnat(int idchampionnat) {
        this.idchampionnat = idchampionnat;
    }

    private ObservableList<String> observableListcategorie = FXCollections.observableArrayList();
    private ObservableList<String> observableListdepreg = FXCollections.observableArrayList();
    private ObservableList<String> observableListchmp = FXCollections.observableArrayList();


    public void initialize(){
        List<Championnat> championnat = new ArrayList<Championnat>();
        championnat.add(new Championnat("national",""));
        championnat.add(new Championnat("regionnal",""));
        championnat.add(new Championnat("departemantal",""));
        int i=0;
        while(i<championnat.size()){
            observableListcategorie.add(championnat.get(i).getNiveau());
            i=i+1;
        }

        lvcategorie.setItems(observableListcategorie);

        lvcategorie.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                System.out.println("clicked on " + lvcategorie.getSelectionModel().getSelectedItem());
                switch (lvcategorie.getSelectionModel().getSelectedItem()){
                    case "national":
                        loadnat();
                        break;
                    case "regionnal":
                        loadreg();
                        break;
                    case "departemantal":
                        loaddep();
                        break;
                }
            }
        });


    }

    private void loadnat() {
        lvchmp.getItems().clear();
        lvdepreg.getItems().clear();

        ApiCaller caller = ApiCaller.getInstance();
        ArrayList<Championnat> championnat = new ArrayList<Championnat>();
        if (caller.depregsearch("national",championnat)==200){
            int i=0;
            while(i<championnat.size()){
                observableListdepreg.add(championnat.get(i).getNomdepreg());
                System.out.println(championnat.get(i).getNomdepreg());
                i=i+1;
            }
            lvdepreg.setItems(observableListdepreg);

            lvdepreg.setOnMouseClicked(new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent event) {
                    System.out.println("clicked on " + lvdepreg.getSelectionModel().getSelectedItem());
                    loadchmp(lvdepreg.getSelectionModel().getSelectedItem());
                }
            });
        }

    }

    public void loaddep(){
        lvchmp.getItems().clear();
        lvdepreg.getItems().clear();
        ApiCaller caller = ApiCaller.getInstance();
        ArrayList<Championnat> championnat = new ArrayList<Championnat>();
        if (caller.depregsearch("departemental",championnat)==200){
            int i=0;
            while(i<championnat.size()){
                observableListdepreg.add(championnat.get(i).getNomdepreg());
                System.out.println(championnat.get(i).getNomdepreg());
                i=i+1;
            }
            lvdepreg.setItems(observableListdepreg);

            lvdepreg.setOnMouseClicked(new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent event) {
                    System.out.println("clicked on " + lvdepreg.getSelectionModel().getSelectedItem());
                    loadchmp(lvdepreg.getSelectionModel().getSelectedItem());
                }
            });
        }

    }

    public void loadchmp(String selectedItem) {


        lvchmp.getItems().clear();
        ApiCaller caller = ApiCaller.getInstance();
        ArrayList<Championnat> championnat1 = new ArrayList<Championnat>();
        if (caller.championnatsearch(selectedItem,championnat1)==200){
            int i=0;
            while(i<championnat1.size()){
                observableListchmp.add(championnat1.get(i).getIdchampionnat()+" "+championnat1.get(i).getNomdepreg());
                System.out.println(championnat1.get(i).getDivision());
                i=i+1;
            }
            lvchmp.setItems(observableListchmp);


            lvchmp.setOnMouseClicked(new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent event) {
                    System.out.println("clicked on " + lvchmp.getSelectionModel().getSelectedItem().replaceAll("[^0-9]+",""));
                    setIdchampionnat(Integer.parseInt(lvchmp.getSelectionModel().getSelectedItem().replaceAll("[^0-9]+","")));

                    Parent root;
                    try {
                        root = FXMLLoader.load(getClass().getResource("../ressources/championnat.fxml"));
                        Stage stage = new Stage();
                        stage.setTitle("championnat");
                        stage.setScene(new Scene(root));
                        stage.show();
                    }
                    catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }


    }

    public void loadreg(){
        lvchmp.getItems().clear();
        lvdepreg.getItems().clear();

        ApiCaller caller = ApiCaller.getInstance();
        ArrayList<Championnat> championnat = new ArrayList<Championnat>();
        if (caller.depregsearch("regional",championnat)==200){
            int i=0;
            while(i<championnat.size()){
                observableListdepreg.add(championnat.get(i).getNomdepreg());
                System.out.println(championnat.get(i).getNomdepreg());
                i=i+1;
            }
            lvdepreg.setItems(observableListdepreg);

            lvdepreg.setOnMouseClicked(new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent event) {
                    System.out.println("clicked on " + lvdepreg.getSelectionModel().getSelectedItem());
                    loadchmp(lvdepreg.getSelectionModel().getSelectedItem());
                }
            });
        }
    }


    public void showChampionnat(ActionEvent actionEvent) {

        try {
            ChangeSceneController controller = new ChangeSceneController();
            controller.changeScene("../ressources/liste_championnat.fxml", actionEvent);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void showEquipes(ActionEvent actionEvent) {

        try {
            ChangeSceneController controller = new ChangeSceneController();
            controller.changeScene("../ressources/liste_equipe.fxml", actionEvent);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void showTournois(ActionEvent actionEvent) {

        try {
            ChangeSceneController controller = new ChangeSceneController();
            controller.changeScene("../ressources/liste_tournois.fxml", actionEvent);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void showStratistiques(ActionEvent actionEvent) {

        try {
            ChangeSceneController controller = new ChangeSceneController();
            controller.changeScene("../ressources/statistiques.fxml", actionEvent);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void Disconnect(ActionEvent actionEvent) {


        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText("Deconnection");
        alert.setContentText("Etes vous sur de vouloir vous deconnecté ?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            try {
                ChangeSceneController controller = new ChangeSceneController();
                controller.changeScene("../ressources/login.fxml", actionEvent);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            alert.close();
        }

    }
    public void showMatch(ActionEvent actionEvent) {

        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("../ressources/choixchampionnat.fxml"));
            Stage stage = new Stage();
            stage.setTitle("creation match");
            stage.setScene(new Scene(root));
            stage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
