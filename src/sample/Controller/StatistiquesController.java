package sample.Controller;

import javafx.event.ActionEvent;

public class StatistiquesController {
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

}
