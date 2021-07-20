
package AllClasses;
import javafx.animation.Transition;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.util.Duration;

public class MilkPackingAnimation extends Transition {
    private MilkPacking milkPacking;
    public MilkPackingAnimation(MilkPacking milkPacking){
        this.milkPacking=milkPacking;
        setCycleDuration(Duration.millis(500));
        setCycleCount(10);
    }
    @Override
    protected void interpolate(double frac) {
        int frame=(int) Math.floor(frac*16);
        try {
            milkPacking.setFill(new ImagePattern(new Image(getClass().getResource("../img/factories/milkPacking/milkPacking_"+(frame+1)+".png").toExternalForm())));
        }catch (NullPointerException e){

        }

    }
}
