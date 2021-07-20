
package AllClasses;
import javafx.animation.Transition;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.util.Duration;

public class IceCreamShopAnimation extends Transition {
    private IceCreamShop iceCreamShop;
    public IceCreamShopAnimation(IceCreamShop iceCreamShop){
        this.iceCreamShop=iceCreamShop;
        setCycleDuration(Duration.millis(500));
        setCycleCount(10);
    }
    @Override
    protected void interpolate(double frac) {
        int frame=(int) Math.floor(frac*16);
        try {
            iceCreamShop.setFill(new ImagePattern(new Image(getClass().getResource("../img/factories/iceCreamShop/iceCream_"+(frame+1)+".png").toExternalForm())));
        }catch (NullPointerException e){
        }

    }
}
