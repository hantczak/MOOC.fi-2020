package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GreeterApplication extends Application {
    public void start(Stage windows) {
        GridPane gp = new GridPane();
        Label welcomeLabel = new Label("Enter your name and start.");
        TextField textField = new TextField();
        Button startButton = new Button("Start");
        gp.add(welcomeLabel, 0, 1);
        gp.add(textField, 0, 2);
        gp.add(startButton, 0, 3);
        Scene welcomeScene = new Scene(gp);

        BorderPane bp1 = new BorderPane();
        Label secondLabel = new Label();
        bp1.setCenter(secondLabel);
        Scene secondScene = new Scene(bp1);

        startButton.setOnAction(actionEvent ->{
            secondLabel.setText("Welcome " + textField.getText() + "!");
            windows.setScene(secondScene);
                });
        windows.setScene(welcomeScene);
        windows.show();
    }


    public static void main(String[] args) {
        launch(GreeterApplication.class);
    }
}
