package Front.View;


import Front.Controller.LoginController;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginView extends Application {

    @FXML
    private Label title;

    @FXML
    private TextField user;

    @FXML
    private PasswordField password;

    @FXML
    private Button entrar;

    private LoginController loginController;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        loginController = new LoginController();
        try {
            primaryStage.setTitle("Sistema Leilao");
            Parent root = FXMLLoader.load(getClass().getResource("LoginView.fxml"));
            Scene appScene = new Scene(root);
            primaryStage.setResizable(true);
            primaryStage.setScene(appScene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    public void entrarAction(){
        if(loginController.login(user.getText(),password.getText())){
            System.out.println("Sucesso");
        }
    }
}
