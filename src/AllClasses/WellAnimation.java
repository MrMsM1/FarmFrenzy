package AllClasses;

import javafx.animation.Transition;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.util.Duration;

public class WellAnimation extends Transition {
    private Well well;
    public WellAnimation(Well well){
        this.well=well;
        setCycleDuration(Duration.millis(500));
        setCycleCount(10);
    }
    @Override
    protected void interpolate(double frac) {
        int frame=(int) Math.floor(frac*16);
        try {
            well.setFill(new ImagePattern(new Image(getClass().getResource("../img/well/"+(frame+1)+".png").toExternalForm())));
        }catch (NullPointerException e){

        }

    }
}
