package asteroids;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class AsteroidsApplication extends Application {
    public static int WIDTH = 800;
    public static int HEIGHT = 600;
    public Pane pane;

    public void start(Stage window) {
        this.pane = new Pane();
        pane.setPrefSize(WIDTH, HEIGHT);

        AtomicInteger points = new AtomicInteger();

        Text text = new Text(10, 20, "Points: 0");
        pane.getChildren().add(text);

        List<Character> asteroids = new ArrayList<>();
        for (int i = 0; i <= 5; i++) {
            Random rand = new Random();
            Asteroid asteroid = new Asteroid(rand.nextInt(WIDTH), rand.nextInt(HEIGHT));
            asteroids.add(asteroid);
            asteroid.setAlive(true);
        }

        Ship ship = new Ship(WIDTH / 2, HEIGHT / 2);
        asteroids.forEach(asteroid -> pane.getChildren().add(asteroid.getCharacter()));
        pane.getChildren().add(ship.getCharacter());
        Scene scene = new Scene(pane);

        List<Character> projectiles = new ArrayList<>();

        Map<KeyCode, Boolean> pressedKeys = new HashMap<>();

        scene.setOnKeyPressed(keyEvent -> {
            pressedKeys.put(keyEvent.getCode(), true);
        });

        scene.setOnKeyReleased(keyEvent -> {
            pressedKeys.put(keyEvent.getCode(), false);
        });

        new AnimationTimer() {
            public void handle(long now) {
                if (pressedKeys.getOrDefault(KeyCode.LEFT, false)) {
                    ship.turnLeft();
                }
                if (pressedKeys.getOrDefault(KeyCode.RIGHT, false)) {
                    ship.turnRight();
                }
                if (pressedKeys.getOrDefault(KeyCode.UP, false)) {
                    ship.accelerate();
                }



                if (pressedKeys.getOrDefault(KeyCode.SPACE, false) && projectiles.size() < 5) {
                    Projectile projectile = new Projectile((int) ship.getCharacter().getTranslateX(), (int) ship.getCharacter().getTranslateY());
                    projectile.getCharacter().setRotate(ship.getCharacter().getRotate());
                    projectile.setAlive(true);
                    projectiles.add(projectile);

                    projectile.accelerate();
                    projectile.setMovement(projectile.getMovement().normalize().multiply(3));

                    pane.getChildren().add(projectile.getCharacter());
                    pressedKeys.put(KeyCode.SPACE,false);
                }
                ship.move();
                asteroids.forEach(asteroid -> asteroid.move());
                projectiles.forEach(projectile -> projectile.move());

                asteroids.forEach(asteroid -> {
                    if (asteroid.collide(ship)) {
                        stop();
                    }
                });


                projectiles.forEach(projectile -> {
                    asteroids.forEach(asteroid -> {
                        if (projectile.collide(asteroid)) {
                            projectile.setAlive(false);
                            asteroid.setAlive(false);
                            text.setText("Points: " + points.addAndGet(1000));
                        }
                    });
                });
                deleteDeadCharacters(projectiles);
                deleteDeadCharacters(asteroids);

                if(Math.random() < 0.005) {
                    Random rand = new Random();
                    Asteroid asteroid = new Asteroid(rand.nextInt(WIDTH), rand.nextInt(HEIGHT));
                    if (!asteroid.collide(ship)) {
                        asteroids.add(asteroid);
                        asteroid.setAlive(true);
                        pane.getChildren().add(asteroid.getCharacter());
                    }
                }
            }
        }.start();


        window.setTitle("Asteroids!");
        window.setScene(scene);
        window.show();
    }


    public static void main(String[] args) {
        launch(AsteroidsApplication.class);
    }

    public void deleteDeadCharacters(List<Character> listOfCharacters) {
        listOfCharacters.stream()
                .filter(character -> !character.isAlive())
                .forEach(character -> {
                    pane.getChildren().remove(character.getCharacter());
                });
        listOfCharacters.removeAll(listOfCharacters.stream()
                .filter(character -> !character.isAlive())
                .collect(Collectors.toList()));
    }

    public static int partsCompleted() {
        // State how many parts you have completed using the return value of this method
        return 4;
    }
}
