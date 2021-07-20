package AllClasses;

import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class Lion extends Rectangle {
    public static ArrayList<Lion> lions=new ArrayList<>();
    public static ArrayList<LionAnimation> lionAnimations =new ArrayList<>();
    double theta;
    public boolean eat=false;
    public int counter;
    AnchorPane anchorPane;
    public int health;
    public int eating=0;
    public int shomarande=0;
    public int index;
    public int death=0;
    boolean addcage=true;
    int clone;
    Cage cage;
    boolean add=true;
    boolean added=false;
    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public Lion(int x, int y, AnchorPane anchorPane){
        super(x,y,130,100);
        this.anchorPane=anchorPane;
        theta=-90;
        this.counter=0;
        this.health=5;
        lions.add(this);
        this.index=lions.size()-1;
        lionAnimations.add(new LionAnimation(this,anchorPane));
        lionAnimations.get(lionAnimations.size()-1).play();
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
        xy[0]=xn-50;
        xy[1]=yn-50;
        return xy;
    }
    public void remove(Ostrich o,int index)
    {
        lions.remove(o);
        lionAnimations.get(index).stop();
        lionAnimations.remove(index);
        anchorPane.getChildren().remove(o);

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
    public boolean hitTop(double y) { return y<=200; }
    public boolean hitFloor(double y) {
        return y+80 >= 630;
    }
    public boolean hitLeftWall(double x) {
        return x <= 240;
    }
    public boolean hitRightWall(double x) { return x+85 >= 830;}
    public void kill(Lion lion)
    {
        for (int i = 0; i < Buffalo.buffaloAnimations.size(); i++)
            if(Math.abs(lion.getX()-Buffalo.buffaloAnimations.get(i).buffalo.getX())<50 && Math.abs(lion.getY()-Buffalo.buffaloAnimations.get(i).buffalo.getY())<50)
                Buffalo.buffaloAnimations.get(i).buffalo.setHealth(0);
        for (int i = 0; i < Ostrich.ostrichAnimations.size(); i++)
            if(Math.abs(lion.getX()-Ostrich.ostrichAnimations.get(i).ostrich.getX())<50 && Math.abs(lion.getY()-Ostrich.ostrichAnimations.get(i).ostrich.getY())<50)
                Ostrich.ostrichAnimations.get(i).ostrich.setHealth(0);
        for (int i = 0; i < Turkey.turkeyAnimations.size(); i++)
            if(Math.abs(lion.getX()-Turkey.turkeyAnimations.get(i).turkey.getX())<50 && Math.abs(lion.getY()-Turkey.turkeyAnimations.get(i).turkey.getY())<50)
                Turkey.turkeyAnimations.get(i).turkey.setHealth(0);

        for (int i = 0; i < Buffalo.buffalo.size(); i++) {
            Buffalo.buffalo.get(i).index=i;
        }
        for (int i = 0; i < Ostrich.ostriches.size(); i++) {
            Ostrich.ostriches.get(i).index=i;
        }
        for (int i = 0; i < Turkey.turkeys.size(); i++) {
            Turkey.turkeys.get(i).index=i;
        }

    }
}