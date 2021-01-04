package smiley;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class SmileyApplication extends Application {
    public void start(Stage window) {
        BorderPane layout = new BorderPane();

        Canvas paintingCanvas = new Canvas(640, 480);
        GraphicsContext painter = paintingCanvas.getGraphicsContext2D();

        painter.setFill(Color.BLACK);
        painter.fillRect(100,0,100,100);
        painter.fillRect(400,0,100,100);
        painter.fillRect(0,250,100,100);
        painter.fillRect(500,250,100,100);
        painter.fillRect(100,350,400,100);

        layout.setCenter(paintingCanvas);
        Scene view = new Scene(layout);
        window.setScene(view);
        window.show();
    }


    public static void main(String[] args) {
        launch(SmileyApplication.class);
    }

}
