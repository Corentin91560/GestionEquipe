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
    @FXML
    private ListView<String> lvjoueur;

    private ObservableList<String> observableListcategorie = FXCollections.observableArrayList();
    private ObservableList<String> observableListdepreg = FXCollections.observableArrayList();
    private ObservableList<String> observableListchmp = FXCollections.observableArrayList();
    private ObservableList<String> observableListjoueur = FXCollections.observableArrayList();


    public void initialize(){
        List<Championnat> championnat = new ArrayList<Championnat>();
        championnat.add(new Championnat("national",1));
        championnat.add(new Championnat("regionnal",2));
        championnat.add(new Championnat("departemantal",3));
        int i=0;
        while(i<championnat.size()){
            observableListcategorie.add(championnat.get(i).getDivision());
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

        loadchmp("national");


    }

    public void loaddep(){
        lvdepreg.getItems().clear();
        List<Championnat> championnat = new ArrayList<Championnat>();
        championnat.add(new Championnat("91",1));
        championnat.add(new Championnat("95",2));
        championnat.add(new Championnat("16",3));
        int i=0;
        while(i<championnat.size()){
            observableListdepreg.add(championnat.get(i).getDivision());
            i=i+1;
        }

        lvdepreg.setItems(observableListdepreg);

        lvdepreg.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                System.out.println("clicked on " + lvdepreg.getSelectionModel().getSelectedItem());
                loadchmp(lvcategorie.getSelectionModel().getSelectedItem());
            }
        });
    }

    private void loadchmp(String selectedItem) {

        //requete recup championnat
        //select namechampionnat where categorie = selecteditem;

    }

    public void loadreg(){
        lvdepreg.getItems().clear();
        List<Championnat> championnat = new ArrayList<Championnat>();
        championnat.add(new Championnat("idf",1));
        championnat.add(new Championnat("paca",2));
        championnat.add(new Championnat("nord",3));
        int i=0;
        while(i<championnat.size()){
            observableListdepreg.add(championnat.get(i).getDivision());
            i=i+1;
        }

        lvdepreg.setItems(observableListdepreg);

        lvdepreg.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                System.out.println("clicked on " + lvdepreg.getSelectionModel().getSelectedItem());
                switch (lvcategorie.getSelectionModel().getSelectedItem()){
                    case "idf":
                        loadnat();
                        break;
                    case "paca":
                        loadreg();
                        break;
                    case "nord":
                        loaddep();
                        break;
                }
            }
        });
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
