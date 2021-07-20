package AllClasses;

import javafx.animation.Transition;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.util.Duration;

import java.util.Random;

public class DogAnimation extends Transition {
    private Cat cat;
    private Dog dog;
    private double speed = 1;
    private int theta = 90;
    Random random=new Random();
    public DogAnimation(Dog dogs){
        this.dog=dogs;
        setCycleDuration(Duration.millis(1000));
        setCycleCount(-1);
    }
    @Override
    protected void interpolate(double frac) {
        int frame=(int) Math.floor(frac*24);

            double dx = speed * Math.cos(Math.toRadians(dog.theta));
            double dy = speed * Math.sin(Math.toRadians(dog.theta)) * (-1);
            double[] xyP=new double[2];
            int randomTheta=random.nextInt(90);
            if (Math.abs(dx)<0.01){
                dx=0;
            }
            if (Math.abs(dy)<0.01){
                dy=0;
            }
             if(!Lion.lions.isEmpty()) {
                 xyP = dog.goToFight(dx, dy, Lion.lions.get(0).getX(), Lion.lions.get(0).getY());
                 dx = xyP[0];
                 dy = xyP[1];
                 if (Math.abs(dog.getX() - Lion.lions.get(0).getX()) < 5 && Math.abs(dog.getY() - Lion.lions.get(0).getY()) < 5) {
                     dog.fighting(dog.getX(), dog.getY(), dog, dog.index);
                 }
             }
            dog.dogMove(dx,dy);
            try {
                if(dx<0 && dy==0)
                {
                    dog.setFill(new ImagePattern(new Image(getClass().getResource("../img/dog/dogLeft/left_"+(frame+1)+".png").toExternalForm())));
                }
                else if(dx>0 && dy==0)
                {
                    dog.setFill(new ImagePattern(new Image(getClass().getResource("../img/dog/dogRight/right_"+(24-frame+1)+".png").toExternalForm())));
                }
                else if (dx==0 && dy>0){
                    dog.setFill(new ImagePattern(new Image(getClass().getResource("../img/dog/dogDown/down_"+(frame+1)+".png").toExternalForm())));
                }
                else if (dx==0 && dy<0){
                    dog.setFill(new ImagePattern(new Image(getClass().getResource("../img/dog/dogUp/up_"+(frame+1)+".png").toExternalForm())));
                }
                else if (dx>0 && dy>0){
                    dog.setFill(new ImagePattern(new Image(getClass().getResource("../img/dog/dogDownRight/down_right_"+(frame+1)+".png").toExternalForm())));
                }
                else if (dx>0 && dy<0 ){
                    //tu file eshtebas esme up right
                    dog.setFill(new ImagePattern(new Image(getClass().getResource("../img/dog/dogUpRight/up_right_"+(24-frame+1)+".png").toExternalForm())));
                }
                else if (dx<0 && dy>0){
                    dog.setFill(new ImagePattern(new Image(getClass().getResource("../img/dog/dogDownLeft/down_left_"+(frame+1)+".png").toExternalForm())));
                }
                else if (dx<0 && dy<0){
                    dog.setFill(new ImagePattern(new Image(getClass().getResource("../img/dog/dogUpLeft/up_left_"+(frame+1)+".png").toExternalForm())));
                }

                if (dog.hitTop(dog.getY())){
                    dog.theta = -randomTheta-dog.theta;
                    dog.setY(dog.getY()+3);
                }
                else if (dog.hitRightWall(dog.getX())) {
                    dog.theta = 180 - dog.theta;
                    dog.setX(dog.getX()-3);
                }
                else if ( dog.hitLeftWall(dog.getX())) {
                    dog.theta = 180 - dog.theta;
                    dog.setX(dog.getX()+3);
                }
                else if (dog.hitFloor(dog.getY())) {
                    if( dog.theta==270 || dog.theta==-90){
                        dog.theta = randomTheta+360 - dog.theta;
                    }
                    else {

                        dog.theta = 360 - dog.theta;
                    }
                    dog.setY(dog.getY()-3);
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