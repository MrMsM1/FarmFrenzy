package AllClasses;

import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class Dog extends Rectangle {
    public static ArrayList<Dog> dogs=new ArrayList<>();
    public static ArrayList<DogAnimation> dogAnimations =new ArrayList<>();
    double theta;
    public boolean defend=false;
    public int index;
    AnchorPane anchorPane;
    public Dog(int x,int y,AnchorPane anchorPane){
        super(x,y,82,68);
        theta=-90;
        this.anchorPane=anchorPane;
        dogs.add(this);
        this.index=dogs.size()-1;
        dogAnimations.add(new DogAnimation(this));
        dogAnimations.get(dogAnimations.size()-1).play();
    }
    public void dogMove(double dx,double dy){
        this.setX(this.getX()+dx);
        this.setY(this.getY()+dy);
    }
    public double[] goToFight(double dx,double dy,double xp,double yp)
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
    public void fighting(double x,double y,Dog dog,int index)
    {
     Fight fight=new Fight(x,y,0,0,anchorPane);
     dogs.remove(dog);
     dogAnimations.get(index).stop();
     dogAnimations.remove(index);
     anchorPane.getChildren().remove(dog);
     anchorPane.getChildren().remove(Lion.lions.get(0));
     Lion.lions.remove(0);
     Lion.lionAnimations.get(0).stop();
     Lion.lionAnimations.remove(0);
    }
    public double[] dogMoveDefend(double dx,double dy,double xp,double yp)
    {
        if(dx==0)
            dx=0.5;
        if(dy==0)
            dy=0.5;
        if(this.getX()==xp)
            dx=0;
        if(this.getY()==yp)
            dy=0;
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