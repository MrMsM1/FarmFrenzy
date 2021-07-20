package AllClasses;

import javafx.animation.Transition;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.util.Duration;

import java.util.Random;

public class LionAnimation extends Transition {
    public Lion lion;
    private double speed = 1;
    private int theta = 90;
    AnchorPane anchorPane;
    Random random=new Random();
    boolean death=true;
    int level=1;
    boolean addcage=true;
    int clone;
    Cage cage;
    boolean add=true;
    boolean added=false;
    public LionAnimation(Lion lion, AnchorPane anchorPane){
        this.lion=lion;
        this.anchorPane=anchorPane;
        setCycleDuration(Duration.millis(1000));
        setCycleCount(-1);
    }
    @Override
    protected void interpolate(double frac) {
        int frame=(int) Math.floor(frac*24);
        double dx = speed * Math.cos(Math.toRadians(lion.theta));
        double dy = speed * Math.sin(Math.toRadians(lion.theta)) * (-1);
        double[] xyP=new double[2];
        double[] xyG=new double[3];
        int randomTheta=random.nextInt(90);
        if (Math.abs(dx)<0.01){
            dx=0;
        }
        if (Math.abs(dy)<0.01){
            dy=0;
        }
        if(added) {
            if (cage.level == 3 && add ) {
                dx = 0;
                dy = 0;
                add = false;
                cage.remove(cage);
                Cage cage = new Cage((int) lion.getX() - 50, (int) lion.getY() - 50, anchorPane, lion, lion.index);
                anchorPane.getChildren().add(cage);

            } else if (cage.level == 3 ) {
                dx = 0;
                dy = 0;
            } else if (cage.level >= 4 )
                cage.finish_remove(lion, lion.index);
        }
        lion.ostrichMove(dx,dy);
        lion.kill(lion);
        if(added)
        cage.move(dx,dy);

        try {
            if(dx<0 && dy==0)
            {
                lion.setFill(new ImagePattern(new Image(getClass().getResource("../img/lion/Left/left_"+(frame+1)+".png").toExternalForm())));

            }
            else if(dx>0 && dy==0)
            {
                lion.setFill(new ImagePattern(new Image(getClass().getResource("../img/lion/Right/right_"+(24-frame+1)+".png").toExternalForm())));
            }
            else if (dx==0 && dy>0){
                lion.setFill(new ImagePattern(new Image(getClass().getResource("../img/lion/Down/down_"+(frame+1)+".png").toExternalForm())));
            }
            else if (dx==0 && dy<0){
                lion.setFill(new ImagePattern(new Image(getClass().getResource("../img/lion/Up/up_"+(frame+1)+".png").toExternalForm())));
            }
            else if (dx>0 && dy>0){
                lion.setFill(new ImagePattern(new Image(getClass().getResource("../img/lion/DownRight/down_right_"+(frame+1)+".png").toExternalForm())));
            }
            else if (dx>0 && dy<0 ){
                //tu file eshtebas esme up right
                lion.setFill(new ImagePattern(new Image(getClass().getResource("../img/lion/UpRight/up_right_"+(24-frame+1)+".png").toExternalForm())));
            }
            else if (dx<0 && dy>0){
                lion.setFill(new ImagePattern(new Image(getClass().getResource("../img/lion/DownLeft/down_left_"+(frame+1)+".png").toExternalForm())));
            }
            else if (dx<0 && dy<0){
                lion.setFill(new ImagePattern(new Image(getClass().getResource("../img/lion/UpLeft/up_left_"+(frame+1)+".png").toExternalForm())));
            }

            if (lion.hitTop(lion.getY())){
                lion.theta = -randomTheta-lion.theta;
                lion.setY(lion.getY()+3);
            }
            else if (lion.hitRightWall(lion.getX()) ) {
                lion.theta = 180 - lion.theta;
                lion.setX(lion.getX()-3);
            }
            else if ( lion.hitLeftWall(lion.getX())) {
                lion.theta = 180 - lion.theta;
                lion.setX(lion.getX()+3);
            }
            else if (lion.hitFloor(lion.getY())) {
                if( lion.theta==270 || lion.theta==-90){
                    lion.theta = randomTheta+360 - lion.theta;
                }
                else {
                    lion.theta = 360 - lion.theta;
                }
                lion.setY(lion.getY()-3);
            }
        }catch (NullPointerException e){

        }


    }
    public boolean right(Cat cat)
    {
        return cat.getX()+82>=1100;
    }
    public boolean left(Cat cat)
    {
        return cat.getX()<=0;
    }

}