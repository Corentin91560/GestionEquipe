package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.util.Optional;

public class Controller {
    @FXML private TextField login_tf;
    public void connect(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText("Welcome "+login_tf.getText());
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            try {

                System.out.println(getClass().getResource("home.fxml"));
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("home.fxml"));
                Parent root = (Parent) fxmlLoader.load();
                //<editor-fold desc="change scene from stage">
                Node source = (Node) actionEvent.getSource();
                Window theStage = source.getScene().getWindow();
                Stage currentStage = (Stage)theStage.getScene().getWindow();
                currentStage.setScene(new Scene(root));
                currentStage.show();
                //</editor-fold>
            } catch(Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("nop");
        }

    }
}
