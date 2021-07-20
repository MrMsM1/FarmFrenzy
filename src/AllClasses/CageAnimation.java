package AllClasses;

import javafx.animation.Transition;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.util.Duration;

public class CageAnimation extends Transition {

    public Cage cage;
    AnchorPane anchorPane;
    public CageAnimation(Cage cage,AnchorPane anchorPane)
    {
        this.cage=cage;
        setCycleDuration(Duration.millis(1000));
        setCycleCount(10);
    }
    @Override
    protected void interpolate(double frac) {
        int frame=(int) Math.floor(frac*24);
        try {
            cage.setFill(new ImagePattern(new Image(getClass().getResource("../img/cageBreak/cageBreak_"+ (frame + 1)+".png").toExternalForm())));
        }
        catch (Exception e){}


    }
}
