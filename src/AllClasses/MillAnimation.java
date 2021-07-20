
package AllClasses;
import javafx.animation.Transition;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.util.Duration;

public class MillAnimation extends Transition {
    private Mill mill;
    public MillAnimation(Mill mill){
        this.mill=mill;
        setCycleDuration(Duration.millis(500));
        setCycleCount(10);
    }
    @Override
    protected void interpolate(double frac) {
        int frame=(int) Math.floor(frac*16);
        try {
            mill.setFill(new ImagePattern(new Image(getClass().getResource("../img/factories/millLevel"+mill.level+"/mill_"+(frame+1)+".png").toExternalForm())));
        }catch (NullPointerException e){

        }

    }
}
