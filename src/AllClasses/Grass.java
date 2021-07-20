package AllClasses;

import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class Grass extends Rectangle {
    AnchorPane anchorPane;
    public static ArrayList<Grass> grasses=new ArrayList<>();
    private int level;

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Grass(int x, int y, AnchorPane anchorPane){
            super(x - 30, y - 30, 60, 60);
            int[] gra=new int[2];
                    gra=check(x-30,y-30);
        level = 1;
        grasses.add(this);
        this.anchorPane = anchorPane;
        if(gra[0]!=1) {
            Start(1);
        }
        else
            Start(2);

    }
    public void Start(int level){
        try {
            if(level==1)
            this.setFill(new ImagePattern(new Image(getClass().getResource("../img/grass/grass_1.png").toExternalForm())));
            else
                this.setFill(new ImagePattern(new Image(getClass().getResource("../img/grass/grass_16.png").toExternalForm())));
            anchorPane.getChildren().add(1,this);
        }catch (NullPointerException e){
        }
    }
    public int[] check(int x,int y)
    {
        int[] g=new int[2];
        for (int i = 0; i < grasses.size(); i++) {
            if(Math.abs(x-grasses.get(i).getX())<10 && Math.abs(y-grasses.get(i).getY())<10) {
                g[0]=1;
                g[1]=i;
                grasses.get(i).level++;
            }
        }
        return g;
    }
}
