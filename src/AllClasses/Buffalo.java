package AllClasses;

import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class Buffalo extends Rectangle {
    public static ArrayList<Buffalo> buffalo=new ArrayList<>();
    public static ArrayList<BuffaloAnimation> buffaloAnimations =new ArrayList<>();
    double theta;
    public boolean eat=true;
    AnchorPane anchorPane;
    private int counter;
    private int health;
    public int eating=0;
    public int shomarande=0;
    public int index;
    public int death=0;
    public Buffalo(int x, int y, AnchorPane anchorPane){
        super(x,y,130,100);
        theta=-90;
        this.counter=0;
        this.health=10;
        this.anchorPane=anchorPane;
        buffalo.add(this);
        this.index=buffalo.size()-1;
        buffaloAnimations.add(new BuffaloAnimation(this,anchorPane));
        buffaloAnimations.get(buffaloAnimations.size()-1).play();
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void buffaloMove(double dx, double dy){
        this.setX(this.getX()+dx);
        this.setY(this.getY()+dy);
    }

    public void remove(Buffalo b,int index)
    {
        buffalo.remove(b);
        buffaloAnimations.get(index).stop();
        buffaloAnimations.remove(index);
        anchorPane.getChildren().remove(b);
        for (int i = 0; i < Buffalo.buffalo.size(); i++) {
            Buffalo.buffalo.get(i).index=i;
        }
    }
    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
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
        xy[0]=xn-30;
        xy[1]=yn-50;
        return xy;
    }
    public double[] buffaloMoveToEat(double dx, double dy, double xp, double yp)
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
    public boolean hitTop(double y) { return y<=230; }
    public boolean hitFloor(double y) {
        return y+80 >= 700;
    }
    public boolean hitLeftWall(double x) {
        return x <= 240;
    }
    public boolean hitRightWall(double x) { return x+85 >= 830;}
}