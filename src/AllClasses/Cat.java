package AllClasses;

import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class Cat extends Rectangle {
    public static ArrayList<Cat> cats=new ArrayList<>();
    public static ArrayList<CatAnimation> catAnimation =new ArrayList<>();
    double theta;
    public boolean collect=false;
    public Cat(int x, int y, AnchorPane anchorPane,WareHouse wareHouse){
        super(x,y,82,68);
        theta=-90;
        cats.add(this);
        catAnimation.add(new CatAnimation(this,anchorPane,wareHouse));
        catAnimation.get(catAnimation.size()-1).play();
    }
    public void catMove(double dx,double dy){
        this.setX(this.getX()+dx);
        this.setY(this.getY()+dy);
    }
    public double[] catMoveP(double dx,double dy,double xp,double yp)
    {
        if(dx==0)
            dx=0.5;
        if(dy==0)
            dy=0.5;
        if(Math.abs(this.getX()-xp)<1.5) {
            dx = 0;
            dy = 1;
        }
        if(Math.abs(this.getY()-yp)<1.5) {
            dy = 0;
            dx = 1;
        }
        double[] xy=new double[2];
        double spy;
        double spx;
        if(Math.abs(xp-(this.getX()+dx))<=Math.abs(xp-(this.getX()-dx)))
            spx=dx;
        else
            spx=-dx;
        if(Math.abs(yp-(this.getY()+dy))<=Math.abs(yp-(this.getY()-dy)))
            spy=dy;
        else
            spy=-dy;


        xy[0]=spx;xy[1]=spy;

        return xy;
    }
    public double[] nearestGood(ArrayList<Product> products,double x,double y)
    {
        double[] xy=new double[2];
        double xn=0,yn=0;
        double min=100000;
        for (int i = 0; i < products.size(); i++) {
            if(!products.get(i).isRemoved())
            {
                if(Math.pow(x-products.get(i).getX(),2)+Math.pow(y-products.get(i).getY(),2)<min)
                {
                    xn=products.get(i).getX();
                    yn=products.get(i).getY();
                    min=Math.pow(x-products.get(i).getX(),2)+Math.pow(y-products.get(i).getY(),2);
                }
            }
        }
        xy[0]=xn;
        xy[1]=yn;
        return xy;
    }
    public int[] findProduct(ArrayList<Product> products,double x,double y)
    {
        int[] find=new int[3];
        for (int i = 0; i < products.size(); i++) {
            if(!products.get(i).isRemoved() && Math.abs(products.get(i).getX()-x)<2 && Math.abs(products.get(i).getY()-y)<2)
            {
                find[0]=1;
                find[1]=i;
                break;
            }
        }
        return find;
    }
    public boolean hitTop(double y) { return y<=210; }
    public boolean hitFloor(double y) {
        return y+80 >= 750;
    }
    public boolean hitLeftWall(double x) {
        return x <= 230;
    }
    public boolean hitRightWall(double x) { return x+85 >= 835;}
}