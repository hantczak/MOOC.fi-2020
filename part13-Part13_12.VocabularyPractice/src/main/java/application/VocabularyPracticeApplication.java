package application;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


// END SOLUTION
public class VocabularyPracticeApplication extends Application {
    private Dictionary dictionary;

    public void init() {
        this.dictionary = new Dictionary();
    }

    public void start(Stage window) {
        InputView inputView = new InputView(dictionary);
        PracticeView practiceView = new PracticeView(dictionary);

        BorderPane bp = new BorderPane();
        HBox hbox = new HBox();
        Button inputViewButton = new Button("Enter new words");
        Button practiceViewButton = new Button("Practice");
        hbox.getChildren().addAll(inputViewButton, practiceViewButton);

        inputViewButton.setOnAction(actionEvent -> {
            bp.setCenter(inputView.getView());
        });
        practiceViewButton.setOnAction(actionEvent -> {
            bp.setCenter(practiceView.getView());
        });

        bp.setTop(hbox);
        bp.setCenter(inputView.getView());
        Scene mainScene = new Scene(bp);

        window.setScene(mainScene);
        window.show();
    }


    public static void main(String[] args) {
        launch(VocabularyPracticeApplication.class);
    }
}
