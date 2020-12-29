package ticTacToe;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;

public class TicTacToeApplication extends Application {
    private String turn = "X";
    private ArrayList<Button> gameBoardButtonsList = new ArrayList<>();
    private Label turnInfo = new Label("Turn: X");

    public void start(Stage window) {
        GridPane gameBoard = new GridPane();
        BorderPane layout = new BorderPane();
        turnInfo.setFont(Font.font("Monospaced", 20));
        layout.setTop(turnInfo);
        layout.setCenter(gameBoard);
        createGameBoard(gameBoard);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.show();
    }

    public void createGameBoard(GridPane gameBoard) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Button button = new Button(" ");
                button.setFont(Font.font("Monospaced", 40));
                gameBoard.add(button, i, j);
                button.setOnAction(actionEvent -> {
                    changeEmptyButton(button);
                    turnInfo.setText("Turn: " + turn);
                    checkIfWon();
                });
                gameBoardButtonsList.add(button);
            }
        }
    }

    public void changeEmptyButton(Button button) {
        if (button.getText().equals(" ")) {
            button.setText(turn);
            turnChange();
            System.out.println(turn);
        }
    }

    public void turnChange() {
        if (turn.equals("X")) {
            turn = "O";
        } else if (turn.equals("O")) {
            turn = "X";
        }
    }

    public void checkIfWon() {
        if (verticalWin()) {
            endGame();
        }
        if (horizontalWin()) {
            endGame();
        }
        if (diagonalWin()) {
            endGame();
        }
    }

    private boolean verticalWin() {
        Button[] columnArray;

        columnArray = createButtonArray(0, 1, 2);
        if (checkIfAllButtonsAreTheSame(columnArray)) {
            return true;
        }
        columnArray = createButtonArray(3, 4, 5);
        if (checkIfAllButtonsAreTheSame(columnArray)) {
            return true;
        }
        columnArray = createButtonArray(6, 7, 8);
        if (checkIfAllButtonsAreTheSame(columnArray)) {
            return true;
        }
        return false;
    }


    private boolean horizontalWin() {
        Button[] rowArray;

        rowArray = createButtonArray(0, 3, 6);
        if (checkIfAllButtonsAreTheSame(rowArray)) {
            return true;
        }
        rowArray = createButtonArray(1, 4, 7);
        if (checkIfAllButtonsAreTheSame(rowArray)) {
            return true;
        }
        rowArray = createButtonArray(2, 5, 8);
        if (checkIfAllButtonsAreTheSame(rowArray)) {
            return true;
        }
        return false;
    }

    private boolean diagonalWin() {
        Button[] diagonalArray;

        diagonalArray = createButtonArray(6, 4, 2);
        if (checkIfAllButtonsAreTheSame(diagonalArray)) {
            return true;
        }

        diagonalArray = createButtonArray(0, 4, 8);
        if (checkIfAllButtonsAreTheSame(diagonalArray)) {
            return true;
        }
        return false;
    }

    private Button[] createButtonArray(int firstButton, int secondButton, int thirdButton) {
        return new Button[]{gameBoardButtonsList.get(firstButton), gameBoardButtonsList.get(secondButton), gameBoardButtonsList.get(thirdButton)};
    }

    private boolean checkIfAllButtonsAreTheSame(Button[] buttons) {
        if (buttons[0].getText().equals(buttons[1].getText()) && buttons[0].getText().equals(buttons[2].getText())) {
            if (!buttons[0].getText().equals(" ")) {
                return true;
            }
        }
        return false;
    }

    public void endGame() {
        turnInfo.setText("The end!");
        this.turn = " ";
    }

    public static void main(String[] args) {
        launch(TicTacToeApplication.class);
    }
}
