package asteroids;

import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;

import java.util.*;
import java.util.stream.Collectors;

public class GameMechanic {
    public Pane gameScreen;
    public Scene gameScene;
    public int screenWidth;
    public int screenHeight;

    public GameMechanic(int height, int width,Scene scene){
        this.gameScreen = new Pane();
        gameScreen.setPrefSize(screenWidth, screenHeight);
        screenWidth = width;
        screenHeight = height;
        this.gameScene = scene;
    }


    public void startGame(PointsCounter pointsCounter) {

        List<Character> asteroids = new ArrayList<>();
        for (int i = 0; i <= 5; i++) {
            Random rand = new Random();
            Asteroid asteroid = new Asteroid(rand.nextInt(screenWidth), rand.nextInt(screenHeight));
            asteroids.add(asteroid);
            asteroid.setAlive(true);
        }

        Ship ship = new Ship(screenWidth / 2, screenHeight / 2);
        asteroids.forEach(asteroid -> gameScreen.getChildren().add(asteroid.getCharacter()));
        gameScreen.getChildren().add(ship.getCharacter());

        List<Character> projectiles = new ArrayList<>();

        Map<KeyCode, Boolean> pressedKeys = new HashMap<>();

        gameScene.setOnKeyPressed(keyEvent -> {
            pressedKeys.put(keyEvent.getCode(), true);
        });

        gameScene.setOnKeyReleased(keyEvent -> {
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

                    gameScreen.getChildren().add(projectile.getCharacter());
                    pressedKeys.put(KeyCode.SPACE, false);
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
                            pointsCounter.increasePoints();
                        }
                    });
                });
                deleteDeadCharacters(projectiles);
                deleteDeadCharacters(asteroids);

                if (Math.random() < 0.005) {
                    Random rand = new Random();
                    Asteroid asteroid = new Asteroid(rand.nextInt(screenWidth), rand.nextInt(screenHeight));
                    if (!asteroid.collide(ship)) {
                        asteroids.add(asteroid);
                        asteroid.setAlive(true);
                        gameScreen.getChildren().add(asteroid.getCharacter());
                    }
                }
            }
        }.start();
    }

    public void deleteDeadCharacters(List<Character> listOfCharacters) {
        listOfCharacters.stream()
                .filter(character -> !character.isAlive())
                .forEach(character -> {
                    gameScreen.getChildren().remove(character.getCharacter());
                });
        listOfCharacters.removeAll(listOfCharacters.stream()
                .filter(character -> !character.isAlive())
                .collect(Collectors.toList()));
    }

    public Pane getGamePane(){
        return gameScreen;
    }
}
