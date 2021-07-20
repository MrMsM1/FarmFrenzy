package AllClasses;

import javafx.animation.Transition;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.util.Duration;

public class BakeryAnimation extends Transition {
    private Bakery bakery;
    public BakeryAnimation(Bakery bakery){
        this.bakery=bakery;
        setCycleDuration(Duration.millis(500));
        setCycleCount(10);
    }
    @Override
    protected void interpolate(double frac) {
        int frame=(int) Math.floor(frac*16);

        try {
            bakery.setFill(new ImagePattern(new Image(getClass().getResource("../img/factories/bakeryLevel"+bakery.level+"/bakery_"+(frame+1)+".png").toExternalForm())));
        }catch (NullPointerException e){

        }

    }
}
