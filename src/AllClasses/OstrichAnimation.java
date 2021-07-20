package AllClasses;

import javafx.animation.Transition;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.util.Duration;

import java.util.Random;

public class OstrichAnimation extends Transition {
    public Ostrich ostrich;
    private double speed = 1;
    private int theta = 90;
    AnchorPane anchorPane;
    Random random=new Random();
    boolean death=true;
    public OstrichAnimation(Ostrich ostriches, AnchorPane anchorPane){
        this.ostrich=ostriches;
        this.anchorPane=anchorPane;
        setCycleDuration(Duration.millis(1000));
        setCycleCount(-1);
    }
    @Override
    protected void interpolate(double frac) {
        int frame=(int) Math.floor(frac*24);
            double dx = speed * Math.cos(Math.toRadians(ostrich.theta));
            double dy = speed * Math.sin(Math.toRadians(ostrich.theta)) * (-1);
            double[] xyP=new double[2];
        double[] xyG=new double[3];
            int randomTheta=random.nextInt(90);
            if (Math.abs(dx)<0.01){
                dx=0;
            }
            if (Math.abs(dy)<0.01){
                dy=0;
            }

        ostrich.shomarande++;
        if(ostrich.shomarande%250==0)
            ostrich.setHealth(ostrich.getHealth()-1);

        xyG=ostrich.nearestGrass(Grass.grasses,ostrich.getX(),ostrich.getY());

        if (ostrich.getHealth()<=5 && xyG[0]+xyG[1]>0 && ostrich.getHealth()!=0) {
            xyP = ostrich.ostrichMoveToEat(dx, dy, xyG[0], xyG[1]);
            dx = xyP[0];
            dy = xyP[1];

            if(Math.abs(ostrich.getX()-xyG[0])<=2 && Math.abs(ostrich.getY()-xyG[1])<=2)
            {
                ostrich.eat=true;
                dx=0;dy=0;
                try {
                    ostrich.eating++;
                    ostrich.setFill(new ImagePattern(new Image(getClass().getResource("../img/ostrich/ostrichEat/eat_"+(frame+1)+".png").toExternalForm())));
                }
                catch (Exception e){}
            }
        }
        if(ostrich.eating%250==0 && ostrich.eating!=0 && ostrich.eat&&ostrich.getHealth()!=0)
        {
            Grass.grasses.get((int) xyG[2]).setLevel(Grass.grasses.get((int)xyG[2]).getLevel()-1);
            if(Grass.grasses.get((int) xyG[2]).getLevel()==0)
                anchorPane.getChildren().remove(Grass.grasses.get((int) xyG[2]));
            ostrich.setHealth(10);
            ostrich.eat=false;
        }
        if(ostrich.getHealth()==0)
        {
            dx=0;dy=0;
            try {
                ostrich.death++;
                ostrich.setFill(new ImagePattern(new Image(getClass().getResource("../img/ostrich/ostrichDeath/death_"+(frame+1)+".png").toExternalForm())));
            }
            catch (Exception e){}
        }
        if(ostrich.death%50==0 && ostrich.death!=0 && death)
        {
            ostrich.death=0;
            ostrich.remove(ostrich,ostrich.index);
            death=false;
        }
            ostrich.ostrichMove(dx,dy);
            try {
                if(dx<0 && dy==0)
                {
                    ostrich.setFill(new ImagePattern(new Image(getClass().getResource("../img/ostrich/ostrichLeft/left_"+(frame+1)+".png").toExternalForm())));
                }
                else if(dx>0 && dy==0)
                {
                    ostrich.setFill(new ImagePattern(new Image(getClass().getResource("../img/ostrich/ostrichRight/right_"+(24-frame+1)+".png").toExternalForm())));
                }
                else if (dx==0 && dy>0){
                    ostrich.setFill(new ImagePattern(new Image(getClass().getResource("../img/ostrich/ostrichDown/down_"+(frame+1)+".png").toExternalForm())));
                }
                else if (dx==0 && dy<0){
                    ostrich.setFill(new ImagePattern(new Image(getClass().getResource("../img/ostrich/ostrichUp/up_"+(frame+1)+".png").toExternalForm())));
                }
                else if (dx>0 && dy>0){
                    ostrich.setFill(new ImagePattern(new Image(getClass().getResource("../img/ostrich/ostrichDownRight/down_right_"+(frame+1)+".png").toExternalForm())));
                }
                else if (dx>0 && dy<0 ){
                    //tu file eshtebas esme up right
                    ostrich.setFill(new ImagePattern(new Image(getClass().getResource("../img/ostrich/ostrichUpRight/up_right_"+(24-frame+1)+".png").toExternalForm())));
                }
                else if (dx<0 && dy>0){
                    ostrich.setFill(new ImagePattern(new Image(getClass().getResource("../img/ostrich/ostrichDownLeft/down_left_"+(frame+1)+".png").toExternalForm())));
                }
                else if (dx<0 && dy<0){
                    ostrich.setFill(new ImagePattern(new Image(getClass().getResource("../img/ostrich/ostrichUpLeft/up_left_"+(frame+1)+".png").toExternalForm())));
                }

                if (ostrich.hitTop(ostrich.getY())){
                    ostrich.theta = -randomTheta-ostrich.theta;
                    ostrich.setY(ostrich.getY()+3);
                }
                else if (ostrich.hitRightWall(ostrich.getX()) ) {
                    ostrich.theta = 180 - ostrich.theta;
                    ostrich.setX(ostrich.getX()-3);
                }
                else if ( ostrich.hitLeftWall(ostrich.getX())) {
                    ostrich.theta = 180 - ostrich.theta;
                    ostrich.setX(ostrich.getX()+3);
                }
                else if (ostrich.hitFloor(ostrich.getY())) {
                    if( ostrich.theta==270 || ostrich.theta==-90){
                        ostrich.theta = randomTheta+360 - ostrich.theta;
                    }
                    else {
                        ostrich.theta = 360 - ostrich.theta;
                    }
                    ostrich.setY(ostrich.getY()-3);
                }
            }catch (NullPointerException e){

            }

            if (frac==1 && ostrich.getCounter()!=0 && ostrich.getCounter()%15==0){
                Product product = new Product((int)ostrich.getX(),(int)ostrich.getY(),4,"feather",1,anchorPane);
                anchorPane.getChildren().add(product);
                ostrich.setCounter(ostrich.getCounter()+1);
            }
            else if (frac==1){
                ostrich.setCounter(ostrich.getCounter()+1);
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