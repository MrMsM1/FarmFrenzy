package AllClasses;

import javafx.animation.Transition;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Random;

public class CatAnimation extends Transition {
    private Cat cat;

    private ArrayList<Product> products;
    private double speed = 1;
    private int theta = 90;
    private AnchorPane anchorPane;
    private WareHouse wareHouse;
    Random random=new Random();
    public CatAnimation(Cat cat ,AnchorPane anchorPane,WareHouse wareHouse){
        this.cat=cat;
        setCycleDuration(Duration.millis(1000));
        setCycleCount(-1);
        this.anchorPane=anchorPane;
        this.wareHouse=wareHouse;
    }
    @Override
    protected void interpolate(double frac) {
        int frame=(int) Math.floor(frac*24);

            double dx = speed * Math.cos(Math.toRadians(cat.theta));
            double dy = speed * Math.sin(Math.toRadians(cat.theta)) * (-1);
            double[] xyP=new double[2];
            double[] xyM=new double[2];
            int[] find=new int[2];
            int randomTheta=random.nextInt(90);
            if (Math.abs(dx)<0.01){
                dx=0;
            }
            if (Math.abs(dy)<0.01){
                dy=0;
            }

            products=Product.products;
            xyP=cat.nearestGood(products,cat.getX(),cat.getY());
            if (xyP[0]+xyP[1]!=0) {
                xyM = cat.catMoveP(dx, dy, xyP[0], xyP[1]);
                find=cat.findProduct(products,cat.getX(),cat.getY());
                dx = xyM[0];
                dy = xyM[1];
                if(find[0]==1 && (30-wareHouse.getFullness())>=products.get(find[1]).getSize())
                {
                    products.get(find[1]).setRemoved(true);
                    Product.products.get(find[1]).setRemoved(true);
                    if (products.get(find[1]).getName().equals("egg")){
                        wareHouse.setEgg(1);
                    }
                    else if (products.get(find[1]).getName().equalsIgnoreCase("flour")){
                        wareHouse.setFlour(1);
                    }
                    else if (products.get(find[1]).getName().equalsIgnoreCase("milk")){
                        wareHouse.setMilk(1);
                    }
                    else if (products.get(find[1]).getName().equalsIgnoreCase("bread")){
                        wareHouse.setBread(1);
                    }
                    else if (products.get(find[1]).getName().equalsIgnoreCase("shirt")){
                        wareHouse.setShirt(1);
                    }
                    else if (products.get(find[1]).getName().equalsIgnoreCase("pocketMilk")){
                        wareHouse.setPocketMilk(1);
                    }
                    else if (products.get(find[1]).getName().equalsIgnoreCase("feather")){
                        wareHouse.setFeather(1);
                    }
                    else if (products.get(find[1]).getName().equalsIgnoreCase("iceCream")){
                        wareHouse.setIceCream(1);
                    }
                    else if (products.get(find[1]).getName().equalsIgnoreCase("cloth")){
                        wareHouse.setCloth(1);
                    }



                    anchorPane.getChildren().remove(products.get(find[1]));
                    products.remove(products.get(find[1]));

                    // cats.get(i).collect=true;
                }
//                else {
//                    dx = 0;
//                    dy = 0;
//                }
            }

            cat.catMove(dx,dy);
            try {
                if(dx<0 && dy==0)
                {
                    cat.setFill(new ImagePattern(new Image(getClass().getResource("../img/cat/catLeft/left_"+(frame+1)+".png").toExternalForm())));
                }
                else if(dx>0 && dy==0)
                {
                    cat.setFill(new ImagePattern(new Image(getClass().getResource("../img/cat/catRight/right_"+(24-frame+1)+".png").toExternalForm())));
                }
                else if (dx==0 && dy>0){
                    cat.setFill(new ImagePattern(new Image(getClass().getResource("../img/cat/catDown/down_"+(frame+1)+".png").toExternalForm())));
                }
                else if (dx==0 && dy<0){
                    cat.setFill(new ImagePattern(new Image(getClass().getResource("../img/cat/catUp/up_"+(frame+1)+".png").toExternalForm())));
                }
                else if (dx>0 && dy>0){
                    cat.setFill(new ImagePattern(new Image(getClass().getResource("../img/cat/catDownRight/down_right_"+(24-frame+1)+".png").toExternalForm())));
                }
                else if (dx>0 && dy<0 ){
                    //tu file eshtebas esme up right
                    cat.setFill(new ImagePattern(new Image(getClass().getResource("../img/cat/catUpRight/up_left_"+(24-frame+1)+".png").toExternalForm())));
                }
                else if (dx<0 && dy>0){
                    cat.setFill(new ImagePattern(new Image(getClass().getResource("../img/cat/catDownLeft/down_left_"+(frame+1)+".png").toExternalForm())));
                }
                else if (dx<0 && dy<0){
                    cat.setFill(new ImagePattern(new Image(getClass().getResource("../img/cat/catUpLeft/up_left_"+(frame+1)+".png").toExternalForm())));
                }

                if (cat.hitTop(cat.getY())){
                    cat.theta = -randomTheta-cat.theta;
                    cat.setY(cat.getY()+3);
                }
                else if (cat.hitRightWall(cat.getX())) {
                    cat.theta = 180 - cat.theta;
                    cat.setX(cat.getX()-3);
                }
                else if ( cat.hitLeftWall(cat.getX())) {
                    cat.theta = 180 - cat.theta;
                    cat.setX(cat.getX()+3);
                }
                else if (cat.hitFloor(cat.getY())) {
                    if( cat.theta==270 || cat.theta==-90){
                        cat.theta = randomTheta+360 - cat.theta;
                    }
                    else {

                        cat.theta = 360 - cat.theta;
                    }
                    cat.setY(cat.getY()-3);
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