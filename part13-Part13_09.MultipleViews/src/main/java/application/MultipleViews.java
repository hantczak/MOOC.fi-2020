package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MultipleViews extends Application {
    public void start(Stage windows){
        BorderPane bp = new BorderPane();
        Label labelFirst = new Label("First view!");
        Button buttonToSecond = new Button("To the second view!");
        bp.setCenter(buttonToSecond);
        bp.setTop(labelFirst);
        Scene scene1 = new Scene(bp);

        VBox vBox = new VBox();
        Button buttonToThird = new Button("To the third view!");
        Label labelSecond = new Label("Second view!");
        vBox.getChildren().addAll(buttonToThird,labelSecond);
        Scene scene2 = new Scene(vBox);

        GridPane gp = new GridPane();
        Label labelThird = new Label("Third view!");
        Button buttonToFirst = new Button("To the first view!");
        gp.add(labelThird,0,0);
        gp.add(buttonToFirst,1,1);
        Scene scene3 = new Scene(gp);

        buttonToSecond.setOnAction(actionEvent -> windows.setScene(scene2));
        buttonToThird.setOnAction(actionEvent -> windows.setScene(scene3));
        buttonToFirst.setOnAction(actionEvent -> windows.setScene(scene1));

        windows.setScene(scene1);
        windows.show();
    }

    public static void main(String[] args) {
        launch(MultipleViews.class);

    }
}
