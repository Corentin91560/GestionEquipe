package sample.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.stage.Window;
import sample.Class.Joueur;
import sample.Data.ApiCaller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Optional;

public class MainController {

    @FXML
    private TextField login_tf;
    @FXML private PasswordField password_tf;


    public void connect(ActionEvent actionEvent) {
        Joueur joueur = new Joueur();

        try {

            ApiCaller caller = ApiCaller.getInstance();
            System.out.println("login"+login_tf.getText());

            if (caller.signInUser(login_tf.getText(), password_tf.getText(), joueur) == 200) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                System.out.println(actionEvent);
                alert.setTitle("Confirmation Dialog");
                alert.setHeaderText("Welcome " + joueur.getNom());
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) {
                    try {
                        ChangeSceneController controller = new ChangeSceneController();
                        controller.changeScene("../ressources/home.fxml", actionEvent);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("nop");
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                System.out.println(actionEvent);
                alert.setTitle("Confirmation Dialog");
                alert.setHeaderText("password ou login invalide ");
                alert.showAndWait();
            }


        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            System.out.println(actionEvent);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText("serveur non disponible verifier la connection ");
            alert.showAndWait();
            System.out.println(e);
        }
    }

    public void confirmation(KeyEvent keyEvent) {

        if (keyEvent.getCode().equals(KeyCode.ENTER))
        {
            System.out.println("enter pressed");
        }

    }
}
