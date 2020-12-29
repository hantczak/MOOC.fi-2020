package application;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class JokeApplication extends Application {
    public void start(Stage window){
        BorderPane layout = new BorderPane();
        HBox buttons = new HBox();
        buttons.setSpacing(10);
        layout.setCenter(buttons);
        layout.setBottom(new Label("What do you call a bear with no teeth?"));
        Scene mainScene = new Scene(layout);

        Button showJokeQuestion = new Button("Joke");
        Button showJokeAnswer = new Button("Answer");
        Button showJokeExplanation = new Button("Explanation");

        buttons.getChildren().addAll(showJokeQuestion,showJokeAnswer,showJokeExplanation);

        StackPane jokeLayout = createView("What do you call a bear with no teeth?");
        StackPane answerLayout = createView("A gummy bear.");
        StackPane explanationLayout = createView("Becouse gummy bears don't have teeth.");

        showJokeQuestion.setOnAction(actionEvent -> layout.setBottom(jokeLayout));
        showJokeAnswer.setOnAction(actionEvent -> layout.setBottom(answerLayout));
        showJokeExplanation.setOnAction(actionEvent -> layout.setBottom(explanationLayout));

        window.setScene(mainScene);
        window.show();

    }

    private StackPane createView(String text){
        StackPane layout = new StackPane();
        layout.getChildren().add(new Label(text));
        layout.setAlignment(Pos.CENTER);
        return layout;
    }


    public static void main(String[] args) {

        launch(JokeApplication.class);
    }
}
