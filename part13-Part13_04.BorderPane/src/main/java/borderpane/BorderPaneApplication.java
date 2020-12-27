package borderpane;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;



public class BorderPaneApplication extends Application {

    public void start(Stage window){


        Label labelNorth = new Label("NORTH");
        Label labelSouth = new Label("SOUTH");
        Label labelEast = new Label("EAST");
        Label labelWest = new Label("WEST");
        BorderPane bp = new BorderPane();
        bp.setTop(labelNorth);
        bp.setBottom(labelSouth);
        bp.setRight(labelEast);
        bp.setLeft(labelWest);

        Scene view = new Scene(bp);
        window.setScene(view);
        window.show();
    }


    public static void main(String[] args) {

        launch(BorderPaneApplication.class);
    }

}
