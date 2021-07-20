package AllClasses;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class Cage extends Rectangle {
    public static ArrayList<Cage> cages=new ArrayList<>();
    public static ArrayList<CageAnimation> cageAnimations =new ArrayList<>();
    int level;
    int index;
    AnchorPane anchorPane;

    public Cage(int x, int y, AnchorPane anchorPane,Lion lion,int index){
        super(x,y,240,200);
        this.anchorPane=anchorPane;
        this.level=1;
        cages.add(this);
        this.index=cages.size()-1;
        cageAnimations.add(new CageAnimation(this,anchorPane));
        if (!cages.isEmpty())
            cageAnimations.get(cageAnimations.size()-1).setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (!cages.isEmpty()) {
                    System.err.println("sik");
                    anchorPane.getChildren().remove(cages.get(0));
                    cages.remove(cages.size() - 1);
                    cageAnimations.get(cageAnimations.size() - 1).stop();
                    cageAnimations.remove(0);
                    anchorPane.getChildren().remove(lion);
                    Lion.lions.remove(lion);
                    Lion.lionAnimations.get(index).stop();
                    Lion.lionAnimations.remove(Lion.lionAnimations.size() - 1);
                }
            }
        });
        cageAnimations.get(cageAnimations.size()-1).play();

    }
    public Cage(int x, int y,AnchorPane anchorPane,int level){
        super(x,y,240,200);
        cages.add(this);
        this.anchorPane=anchorPane;
        this.level=1;
        Start(this.level);
    }
    public void Start(int level){
        try {
                this.setFill(new ImagePattern(new Image(getClass().getResource("../img/cage/"+level+".png").toExternalForm())));

            anchorPane.getChildren().add(this);
        }catch (NullPointerException e){
        }
    }
     public void finish_remove(Lion lion,int index)
     {
         anchorPane.getChildren().remove(cages.get(cages.size()-1));
         cages.remove(cages.size()-1);
         cageAnimations.get(cageAnimations.size()-1).stop();
         cageAnimations.remove(0);
         anchorPane.getChildren().remove(lion);
         Lion.lions.remove(lion);
         Lion.lionAnimations.get(index).stop();
         Lion.lionAnimations.remove(Lion.lionAnimations.size()-1);
     }
    public void remove(Cage o)
    {
        cages.remove(o);
//        cageAnimations.get(index).stop();
//        cageAnimations.remove(index);
        anchorPane.getChildren().remove(o);


    }
    public void move(double dx, double dy){
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
}