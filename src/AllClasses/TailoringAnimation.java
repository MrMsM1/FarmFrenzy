
package AllClasses;

import javafx.animation.Transition;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.util.Duration;

public class TailoringAnimation extends Transition {
    private Tailoring tailoring;
    public TailoringAnimation(Tailoring tailoring){
        this.tailoring=tailoring;
        setCycleDuration(Duration.millis(500));
        setCycleCount(10);
    }
    @Override
    protected void interpolate(double frac) {
        int frame=(int) Math.floor(frac*16);

        try {
            tailoring.setFill(new ImagePattern(new Image(getClass().getResource("../img/factories/tailoringLevel"+tailoring.level+"/tailoring_"+(frame+1)+".png").toExternalForm())));
        }catch (NullPointerException e){

        }

    }
}
