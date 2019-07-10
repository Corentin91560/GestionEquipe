package sample.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class ListeEquipeController {
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
