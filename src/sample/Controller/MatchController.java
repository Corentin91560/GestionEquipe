package sample.Controller;

import javafx.event.ActionEvent;

public class MatchController {
ListeChampionnatController controller = new ListeChampionnatController();

    public void validerchampionnat(ActionEvent actionEvent) {
        try {
            ChangeSceneController controller = new ChangeSceneController();
            controller.changeScene("../ressources/choixequipe.fxml", actionEvent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void validerequipe(ActionEvent actionEvent) {
        try {
            ChangeSceneController controller = new ChangeSceneController();
            controller.changeScene("../ressources/choixjoueur.fxml", actionEvent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void validerjoueur(ActionEvent actionEvent) {

        try {
            ChangeSceneController controller = new ChangeSceneController();
            controller.changeScene("../ressources/feuilledematch.fxml", actionEvent);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
