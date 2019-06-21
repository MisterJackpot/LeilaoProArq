package Front.View;


import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginView extends Application {

    @FXML
    private Label title;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        try {
            primaryStage.setTitle("Sistema Leilao");
            Parent root = FXMLLoader.load(getClass().getResource("LoginView.fxml"));
            Scene appScene = new Scene(root);
            primaryStage.setScene(appScene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}