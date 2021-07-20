package AllClasses;

import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class Ostrich extends Rectangle {
    public static ArrayList<Ostrich> ostriches=new ArrayList<>();
    public static ArrayList<OstrichAnimation> ostrichAnimations =new ArrayList<>();
    double theta;
    public boolean eat=false;
    private int counter;
    AnchorPane anchorPane;
    private int health;
    public int eating=0;
    public int shomarande=0;
    public int index;
    public int death=0;

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public Ostrich(int x, int y, AnchorPane anchorPane){
        super(x,y,130,100);
        this.anchorPane=anchorPane;
        theta=-90;
        this.counter=0;
        this.health=10;
        ostriches.add(this);
        this.index=ostriches.size()-1;
        ostrichAnimations.add(new OstrichAnimation(this,anchorPane));
        ostrichAnimations.get(ostrichAnimations.size()-1).play();
    }
    public double[] nearestGrass(ArrayList<Grass> grasses,double x,double y)
    {
        double[] xy=new double[3];
        double xn=0,yn=0;
        double min=100000;
        for (int i = 0; i < grasses.size(); i++) {
            if(grasses.get(i).getLevel()!=0)
            {
                if(Math.pow(x-grasses.get(i).getX(),2)+Math.pow(y-grasses.get(i).getY(),2)<min)
                {
                    xn=grasses.get(i).getX();
                    yn=grasses.get(i).getY();
                    xy[2]=i;
                    min=Math.pow(x-grasses.get(i).getX(),2)+Math.pow(y-grasses.get(i).getY(),2);
                }
            }
        }
        xy[0]=xn-10;
        xy[1]=yn-50;
        return xy;
    }
    public void remove(Ostrich o,int index)
    {
        ostriches.remove(o);
        ostrichAnimations.get(index).stop();
        ostrichAnimations.remove(index);
        anchorPane.getChildren().remove(o);
        for (int i = 0; i < Ostrich.ostriches.size(); i++) {
            Ostrich.ostriches.get(i).index=i;
        }
    }
    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public void ostrichMove(double dx, double dy){
        this.setX(this.getX()+dx);
        this.setY(this.getY()+dy);
    }
    public double[] ostrichMoveToEat(double dx, double dy, double xp, double yp)
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
    public void addProduct(int x,int y)
    {
        Product p=new Product(x,y,5,"cloth",2,anchorPane);
        anchorPane.getChildren().add(p);
    }
    public boolean hitTop(double y) { return y<=200; }
    public boolean hitFloor(double y) {
        return y+80 >= 630;
    }
    public boolean hitLeftWall(double x) {
        return x <= 240;
    }
    public boolean hitRightWall(double x) { return x+85 >= 830;}
}