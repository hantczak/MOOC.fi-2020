package asteroids;

import javafx.scene.shape.Polygon;

public class Projectile extends Character{
    public Projectile(int x, int y){
        super(new Polygon(2, -2, 2, 2, -2, 2, -2, -2), x, y);
    }

    @Override
    public void move() {
        super.getCharacter().setTranslateX(super.getCharacter().getTranslateX() + super.getMovement().getX());
        super.getCharacter().setTranslateY(super.getCharacter().getTranslateY() + super.getMovement().getY());

        if(super.getCharacter().getTranslateX()>AsteroidsApplication.WIDTH){
            setAlive(false);
        }

        if(super.getCharacter().getTranslateX()<0){
            setAlive(false);
        }

        if(super.getCharacter().getTranslateY()>AsteroidsApplication.HEIGHT){
            setAlive(false);
        }

        if(super.getCharacter().getTranslateY()<0){
            setAlive(false);
        }
    }
}
