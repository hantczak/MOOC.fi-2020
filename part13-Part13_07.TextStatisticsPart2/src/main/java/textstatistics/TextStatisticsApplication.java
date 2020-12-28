package textstatistics;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.Arrays;

public class TextStatisticsApplication extends Application {
    public void start(Stage window) {
        TextArea textArea = new TextArea();
        Label labelLetters = new Label("Letters: 0");
        Label labelWords = new Label("Words: 0");
        Label labelLongest = new Label("The longest word is:");

        textArea.textProperty().addListener((change, oldValue, newValue) -> {
            int characters = newValue.length();
            String[] parts = newValue.split(" ");
            int words = parts.length;
            String longest = Arrays.stream(parts)
                    .sorted((s1, s2) -> s2.length() - s1.length())
                    .findFirst()
                    .get();
            labelLetters.setText("Letters: " + characters);
            labelWords.setText("Words: " + words);
            labelLongest.setText("The longest word is: " + longest);
        });


        HBox hBox = new HBox();
        hBox.getChildren().add(labelLetters);
        hBox.getChildren().add(labelWords);
        hBox.getChildren().add(labelLongest);
        hBox.setSpacing(10);

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
