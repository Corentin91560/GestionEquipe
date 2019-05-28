package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    String user = "JavaFX2";
    String pw = "password";
    String checkUser, checkPw;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 350, 220));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
