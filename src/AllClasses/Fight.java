package AllClasses;

import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class Fight extends Rectangle {
    public static ArrayList<Fight> fights=new ArrayList<>();
    public static ArrayList<FightAnimation> fightAnimations =new ArrayList<>();
    public int index;
    AnchorPane anchorPane;
    public Fight(double v, double v1, double v2, double v3,AnchorPane anchorPane) {
        super(v-50,v1-50,200,200);
        this.anchorPane=anchorPane;
        fights.add(this);
        this.index=fights.size()-1;
        fightAnimations.add(new FightAnimation(this));
        fightAnimations.get(fightAnimations.size()-1).play();
        anchorPane.getChildren().add(this);
    }
    public void move(double dx,double dy)
    {
        this.setX(this.getX()+dx);
        this.setY(this.getY()+dy);
    }
    public void remove(Fight fight)
    {
        fights.remove(0);
        fightAnimations.get(0).stop();
        fightAnimations.remove(0);
        anchorPane.getChildren().remove(fight);

    }
    public boolean hitRightWall(double x) { return x+85 >= 1100;}
}
