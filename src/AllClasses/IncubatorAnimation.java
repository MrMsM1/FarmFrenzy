
package AllClasses;
import javafx.animation.Transition;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.util.Duration;

public class IncubatorAnimation extends Transition {
    private Incubator incubator;
    public IncubatorAnimation(Incubator incubator){
        this.incubator=incubator;
        setCycleDuration(Duration.millis(1250));
        setCycleCount(4);
    }
    @Override
    protected void interpolate(double frac) {
        int frame=(int) Math.floor(frac*10);

        try {
            incubator.setFill(new ImagePattern(new Image(getClass().getResource("../img/factories/incubator/"+(frame+1)+".png").toExternalForm())));
        }catch (NullPointerException e){

        }

    }
}
