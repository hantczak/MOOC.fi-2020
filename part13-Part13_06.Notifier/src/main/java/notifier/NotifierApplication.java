package notifier;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class NotifierApplication extends Application {
    public void start(Stage window){
        VBox vBox = new VBox();

        TextField textField = new TextField();
        Button button = new Button("Update");
        Label label = new Label();

        button.setOnAction(actionEvent -> label.setText(textField.getText()));

        vBox.getChildren().addAll(textField,button,label);

        Scene view = new Scene(vBox);
        window.setScene(view);
        window.show();
    }


    public static void main(String[] args) {
        launch(NotifierApplication.class);
    }

}
