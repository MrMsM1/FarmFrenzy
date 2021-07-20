package AllClasses;

import javafx.animation.Transition;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.util.Duration;

import java.util.Random;

public class TurkeyAnimation extends Transition {
    public Turkey turkey;
    private double speed = 1;
    private int theta = 90;
    AnchorPane anchorPane;
    Random random=new Random();
    boolean death=true;
    public TurkeyAnimation(Turkey turkey, AnchorPane anchorPane){
        this.turkey=turkey;
        this.anchorPane=anchorPane;
        setCycleDuration(Duration.millis(1000));
        setCycleCount(-1);
    }
    @Override
    protected void interpolate(double frac) {
        int frame=(int) Math.floor(frac*24);

            double dx = speed * Math.cos(Math.toRadians(turkey.theta));
            double dy = speed * Math.sin(Math.toRadians(turkey.theta)) * (-1);
            double[] xyP=new double[2];
            double[] xyG=new double[3];
            int randomTheta=random.nextInt(90);
            if (Math.abs(dx)<0.01){
                dx=0;
            }
            if (Math.abs(dy)<0.01){
                dy=0;
            }
        turkey.shomarande++;
        if(turkey.shomarande%250==0)
            turkey.setHealth(turkey.getHealth()-1);
        xyG=turkey.nearestGrass(Grass.grasses,turkey.getX(),turkey.getY());
        if (turkey.getHealth()<=5 && xyG[0]+xyG[1]>0 && turkey.getHealth()!=0) {
            xyP = turkey.turkeyMoveToEat(dx, dy, xyG[0], xyG[1]);
            dx = xyP[0];
            dy = xyP[1];

            if(Math.abs(turkey.getX()-xyG[0])<=2 && Math.abs(turkey.getY()-xyG[1])<=2)
            {
                turkey.eat=true;
                dx=0;dy=0;
                try {
                    turkey.eating++;
                    turkey.setFill(new ImagePattern(new Image(getClass().getResource("../img/turkey/turkeyEat/eat_"+(frame+1)+".png").toExternalForm())));
                }
                catch (Exception e){}
            }
        }
        if(turkey.eating%250==0 && turkey.eating!=0 && turkey.eat&&turkey.getHealth()!=0)
        {
            Grass.grasses.get((int) xyG[2]).setLevel(Grass.grasses.get((int)xyG[2]).getLevel()-1);
            if(Grass.grasses.get((int) xyG[2]).getLevel()==0)
                anchorPane.getChildren().remove(Grass.grasses.get((int) xyG[2]));
            turkey.setHealth(10);
            turkey.eat=false;
        }
        if(turkey.getHealth()==0)
        {
            dx=0;dy=0;
            try {
                turkey.death++;
                turkey.setFill(new ImagePattern(new Image(getClass().getResource("../img/turkey/turkeyDeath/death_"+(frame+1)+".png").toExternalForm())));
            }
            catch (Exception e){}
        }
        if(turkey.death%50==0 && turkey.death!=0 && death)
        {
            turkey.death=0;
            turkey.remove(turkey,turkey.index);
            death=false;
        }
            turkey.turkeyMove(dx,dy);
            try {
                if(dx<0 && dy==0)
                {
                    turkey.setFill(new ImagePattern(new Image(getClass().getResource("../img/turkey/turkeyLeft/left_"+(frame+1)+".png").toExternalForm())));
                }
                else if(dx>0 && dy==0)
                {
                    turkey.setFill(new ImagePattern(new Image(getClass().getResource("../img/turkey/turkeyRight/right_"+(24-frame+1)+".png").toExternalForm())));
                }
                else if (dx==0 && dy>0){
                    turkey.setFill(new ImagePattern(new Image(getClass().getResource("../img/turkey/turkeyDown/down_"+(frame+1)+".png").toExternalForm())));
                }
                else if (dx==0 && dy<0){
                    turkey.setFill(new ImagePattern(new Image(getClass().getResource("../img/turkey/turkeyUp/up_"+(frame+1)+".png").toExternalForm())));
                }
                else if (dx>0 && dy>0){
                    turkey.setFill(new ImagePattern(new Image(getClass().getResource("../img/turkey/turkeyDownRight/down_right_"+(24-frame+1)+".png").toExternalForm())));
                }
                else if (dx>0 && dy<0 ){
                    //tu file eshtebas esme up right
                    turkey.setFill(new ImagePattern(new Image(getClass().getResource("../img/turkey/turkeyUpRight/up_right_"+(24-frame+1)+".png").toExternalForm())));
                }
                else if (dx<0 && dy>0){
                    turkey.setFill(new ImagePattern(new Image(getClass().getResource("../img/turkey/turkeyDownLeft/down_left_"+(frame+1)+".png").toExternalForm())));
                }
                else if (dx<0 && dy<0){
                    turkey.setFill(new ImagePattern(new Image(getClass().getResource("../img/turkey/turkeyUpLeft/up_left_"+(frame+1)+".png").toExternalForm())));
                }

                if (turkey.hitTop(turkey.getY())){
                    turkey.theta = -randomTheta-turkey.theta;
                    turkey.setY(turkey.getY()+3);
                }
                else if (turkey.hitRightWall(turkey.getX()) ) {
                    turkey.theta = 180 - turkey.theta;
                    turkey.setX(turkey.getX()-3);
                }
                else if ( turkey.hitLeftWall(turkey.getX())) {
                    turkey.theta = 180 - turkey.theta;
                    turkey.setX(turkey.getX()+3);
                }
                else if (turkey.hitFloor(turkey.getY())) {
                    if( turkey.theta==270 || turkey.theta==-90){
                        turkey.theta = randomTheta+360 - turkey.theta;
                    }
                    else {
                        turkey.theta = 360 - turkey.theta;
                    }
                    turkey.setY(turkey.getY()-3);
                }
            }catch (NullPointerException e){

            }
            //cats.get(i).setTranslateX(50);
            //cats.get(i).setTranslateY(300);
            if (frac==1 && turkey.getCounter()!=0 && turkey.getCounter()%15==0){
                Product product = new Product((int)turkey.getX(),(int)turkey.getY(),4,"egg",1,anchorPane);
                anchorPane.getChildren().add(product);
                turkey.setCounter(turkey.getCounter()+1);
            }
            else if (frac==1){
                turkey.setCounter(turkey.getCounter()+1);
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