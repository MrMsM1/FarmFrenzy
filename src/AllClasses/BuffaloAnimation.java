package AllClasses;

import javafx.animation.Transition;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.util.Duration;

import java.util.Random;

public class BuffaloAnimation extends Transition {

    public Buffalo buffalo;
    private double speed = 1;
    private int theta = 90;
    private boolean death=true;
    Random random=new Random();
    AnchorPane anchorPane;
    public BuffaloAnimation(Buffalo buffalo, AnchorPane anchorPane){
        this.buffalo=buffalo;
        this.anchorPane=anchorPane;
        setCycleDuration(Duration.millis(1000));
        setCycleCount(-1);

    }
    @Override
    protected void interpolate(double frac) {
        int frame=(int) Math.floor(frac*24);
            double dx = speed * Math.cos(Math.toRadians(buffalo.theta));
            double dy = speed * Math.sin(Math.toRadians(buffalo.theta)) * (-1);
            double[] xyP=new double[2];
            double[] xyG=new double[3];
            int randomTheta=random.nextInt(90);
            if (Math.abs(dx)<0.01){
                dx=0;
            }
            if (Math.abs(dy)<0.01){
                dy=0;
            }
            buffalo.shomarande++;
            if(buffalo.shomarande%250==0)
                buffalo.setHealth(buffalo.getHealth()-1);

        xyG=buffalo.nearestGrass(Grass.grasses,buffalo.getX(),buffalo.getY());

        if (buffalo.getHealth()<=5 && xyG[0]+xyG[1]>0 && buffalo.getHealth()!=0) {
                xyP = buffalo.buffaloMoveToEat(dx, dy, xyG[0], xyG[1]);
                dx = xyP[0];
                dy = xyP[1];

                if(Math.abs(buffalo.getX()-xyG[0])<=2 && Math.abs(buffalo.getY()-xyG[1])<=2)
                {
                    buffalo.eat=true;
                    dx=0;dy=0;
                    try {
                        buffalo.eating++;
                        buffalo.setFill(new ImagePattern(new Image(getClass().getResource("../img/buffalo/buffaloEat/eat_"+(frame+1)+".png").toExternalForm())));
                    }
                    catch (Exception e){}
                }
            }
            if(buffalo.eating%250==0 && buffalo.eating!=0 && buffalo.eat&&buffalo.getHealth()!=0)
            {
                Grass.grasses.get((int) xyG[2]).setLevel(Grass.grasses.get((int)xyG[2]).getLevel()-1);
                if(Grass.grasses.get((int) xyG[2]).getLevel()==0)
                anchorPane.getChildren().remove(Grass.grasses.get((int) xyG[2]));
                buffalo.setHealth(10);
                buffalo.eat=false;
            }
        if(buffalo.getHealth()==0)
        {
            dx=0;dy=0;
            try {
                buffalo.death++;
                buffalo.setFill(new ImagePattern(new Image(getClass().getResource("../img/buffalo/buffaloDeath/death_"+(frame+1+6)+".png").toExternalForm())));
            }
            catch (Exception e){}
        }
        if(buffalo.death%50==0 && buffalo.death!=0 && death)
        {
            buffalo.death=0;
            buffalo.remove(buffalo,buffalo.index);
            death=false;
        }
            buffalo.buffaloMove(dx,dy);
            try {
                if(dx<0 && dy==0)
                {
                    buffalo.setFill(new ImagePattern(new Image(getClass().getResource("../img/buffalo/buffaloLeft/left_"+(frame+1)+".png").toExternalForm())));
                }
                else if(dx>0 && dy==0)
                {
                    buffalo.setFill(new ImagePattern(new Image(getClass().getResource("../img/buffalo/buffaloRight/right_"+(24-frame+1)+".png").toExternalForm())));
                }
                else if (dx==0 && dy>0){
                    buffalo.setFill(new ImagePattern(new Image(getClass().getResource("../img/buffalo/buffaloDown/down_"+(frame+1)+".png").toExternalForm())));
                }
                else if (dx==0 && dy<0){
                    buffalo.setFill(new ImagePattern(new Image(getClass().getResource("../img/buffalo/buffaloUp/up_"+(frame+1)+".png").toExternalForm())));
                }
                else if (dx>0 && dy>0){
                    buffalo.setFill(new ImagePattern(new Image(getClass().getResource("../img/buffalo/buffaloDownRight/down_right_"+(frame+1)+".png").toExternalForm())));
                }
                else if (dx>0 && dy<0 ){
                    //tu file eshtebas esme up right
                    buffalo.setFill(new ImagePattern(new Image(getClass().getResource("../img/buffalo/buffaloUpRight/up_right_"+(24-frame+1)+".png").toExternalForm())));
                }
                else if (dx<0 && dy>0){
                    buffalo.setFill(new ImagePattern(new Image(getClass().getResource("../img/buffalo/buffaloDownLeft/down_left_"+(frame+1)+".png").toExternalForm())));
                }
                else if (dx<0 && dy<0){
                    buffalo.setFill(new ImagePattern(new Image(getClass().getResource("../img/buffalo/buffaloUpLeft/up_left_"+(frame+1)+".png").toExternalForm())));
                }

                if (buffalo.hitTop(buffalo.getY())){
                    buffalo.theta = -randomTheta-buffalo.theta;
                    buffalo.setY(buffalo.getY()+3);
                }
                else if (buffalo.hitRightWall(buffalo.getX())) {
                    buffalo.theta = 180 - buffalo.theta;
                    buffalo.setX(buffalo.getX()-3);
                }
                else if ( buffalo.hitLeftWall(buffalo.getX())) {
                    buffalo.theta = 180 - buffalo.theta;
                    buffalo.setX(buffalo.getX()+3);
                }
                else if (buffalo.hitFloor(buffalo.getY())) {
                    if( buffalo.theta==270 || buffalo.theta==-90){
                        buffalo.theta = randomTheta+360 - buffalo.theta;
                    }
                    else {
                        buffalo.theta = 360 - buffalo.theta;

                    }
                    buffalo.setY(buffalo.getY()-3);
                }
            }catch (NullPointerException e){

            }
            //cats.get(i).setTranslateX(50);
            //cats.get(i).setTranslateY(300);
            if (frac==1 && buffalo.getCounter()!=0 && buffalo.getCounter()%15==0){
                Product product = new Product((int)buffalo.getX(),(int)buffalo.getY(),4,"milk",1,anchorPane);
                anchorPane.getChildren().add(product);
                buffalo.setCounter(buffalo.getCounter()+1);
            }
            else if (frac==1){
                buffalo.setCounter(buffalo.getCounter()+1);
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