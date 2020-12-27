package textstatistics;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TextStatisticsApplication extends Application {
    public void start(Stage window){
        TextArea textArea = new TextArea();
        Label labelLetters = new Label("Letters: 0");
        Label labelWords = new Label("Words: 0");
        Label labelLongest = new Label("The longest word is:");

        HBox hBox = new HBox();
        hBox.getChildren().add(labelLetters);
        hBox.getChildren().add(labelWords);
        hBox.getChildren().add(labelLongest);

        BorderPane bp = new BorderPane();

        bp.setCenter(textArea);
        bp.setBottom(hBox);

        Scene view = new Scene(bp);
        window.setScene(view);
        window.show();
    }


    public static void main(String[] args) {
        launch(TextStatisticsApplication.class);
    }

}
