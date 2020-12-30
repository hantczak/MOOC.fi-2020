package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class SavingsCalculatorApplication extends Application {
    public void start(Stage window) {
        ProgramLayout layout = new ProgramLayout();

        BorderPane generalLayout = new BorderPane();

        generalLayout.setCenter(layout.createGraph());
        generalLayout.setTop(layout.createSliders());

        Scene view = new Scene(generalLayout);
        window.setScene(view);
        window.show();
    }

    public static void main(String[] args) {
        launch(SavingsCalculatorApplication.class);
    }
}
