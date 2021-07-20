package AllClasses;

import javafx.animation.Transition;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.util.Duration;

public class TruckGAnimation extends Transition {

    public TruckG truckG;
    public TruckGAnimation(TruckG truckG)
    {
        this.truckG=truckG;
        setCycleDuration(Duration.millis(5000));
        setCycleCount(1);
    }
    @Override
    protected void interpolate(double frac) {
        if(truckG.hitRightWall(truckG.getX()))
            truckG.dx=-truckG.dx;
        truckG.move(truckG.dx,0);
        try {
            if(truckG.dx>0)
                truckG.setFill(new ImagePattern(new Image(getClass().getResource("../img/truckG/truckGo.png").toExternalForm())));
            else
                truckG.setFill(new ImagePattern(new Image(getClass().getResource("../img/truckG/truckBack.png").toExternalForm())));
        }
        catch (Exception e){}

    }
}