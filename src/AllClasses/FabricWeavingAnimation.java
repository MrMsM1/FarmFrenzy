package AllClasses;

import javafx.animation.Transition;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.util.Duration;

public class FabricWeavingAnimation extends Transition {
    private FabricWeaving fabricWeaving;
    public FabricWeavingAnimation(FabricWeaving fabricWeaving){
        this.fabricWeaving=fabricWeaving;
        setCycleDuration(Duration.millis(500));
        setCycleCount(10);
    }
    @Override
    protected void interpolate(double frac) {
        int frame=(int) Math.floor(frac*16);
        try {
            fabricWeaving.setFill(new ImagePattern(new Image(getClass().getResource("../img/factories/fabricWeavingLevel"+fabricWeaving.level+"/fabricWeaving_"+(frame+1)+".png").toExternalForm())));
        }catch (NullPointerException e){

        }

    }
}
