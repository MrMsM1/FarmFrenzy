package AllClasses;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class TruckG extends Rectangle {
    public static TruckG truckG;
    public static TruckGAnimation truckGAnimation;
    public int index;
    AnchorPane anchorPane;
    double dx=1.25;
    boolean a;
    public TruckG(AnchorPane anchorPane) {
        super(880,55,30,30);
        this.anchorPane=anchorPane;
        truckG=this;
        truckGAnimation=new TruckGAnimation(this);
        anchorPane.getChildren().add(this);
        start();
        truckGAnimation.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                dx=1.25;
                start();
            }
        });
    }
    public void start()
    {
        truckG.setFill(new ImagePattern(new Image(getClass().getResource("../img/truckG/truckGo.png").toExternalForm())));
    }
    public void move(double dx,double dy)
    {
        this.setX(this.getX()+dx);
        this.setY(this.getY()+dy);
    }
    public void play()
    {
        truckGAnimation.play();
    }

    public boolean hitRightWall(double x) { return x+30 >= 1100;}
}