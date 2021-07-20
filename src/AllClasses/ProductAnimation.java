package AllClasses;

import javafx.animation.Transition;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.util.Duration;

public class ProductAnimation extends Transition {
    private Product product;
    public ProductAnimation(Product products)
    {
        this.product=products;
        setCycleDuration(Duration.millis(product.getTimeOfDestruction()*1000));
            setCycleCount(1);

    }
    @Override
    public void interpolate(double v) {
        int frame=(int) Math.floor(v*1);

            if (!product.isRemoved()) {
                if (product.getName().equals("egg")) {
                    product.ShowP(product.getX(), product.getY());
                    product.setFill(new ImagePattern(new Image(getClass().getResource("../img/products/egg.png").toExternalForm())));
                }
                else  if (product.getName().equals("bread")) {
                    product.ShowP(product.getX(), product.getY());
                    product.setFill(new ImagePattern(new Image(getClass().getResource("../img/products/bread.png").toExternalForm())));
                }
                else  if (product.getName().equals("flour")) {
                    product.ShowP(product.getX(), product.getY());
                    product.setFill(new ImagePattern(new Image(getClass().getResource("../img/products/flour.png").toExternalForm())));
                }
                else  if (product.getName().equals("cloth")) {
                    product.ShowP(product.getX(), product.getY());
                    product.setFill(new ImagePattern(new Image(getClass().getResource("../img/products/cloth.png").toExternalForm())));
                }
                else  if (product.getName().equals("milk")) {
                    product.ShowP(product.getX(), product.getY());
                    product.setFill(new ImagePattern(new Image(getClass().getResource("../img/products/milk.png").toExternalForm())));
                }
                else  if (product.getName().equals("iceCream")) {
                    product.ShowP(product.getX(), product.getY());
                    product.setFill(new ImagePattern(new Image(getClass().getResource("../img/products/iceCream.png").toExternalForm())));
                }
                else  if (product.getName().equals("pocketMilk")) {
                    product.ShowP(product.getX(), product.getY());
                    product.setFill(new ImagePattern(new Image(getClass().getResource("../img/products/pocketMilk.png").toExternalForm())));
                }
                else  if (product.getName().equals("shirt")) {
                    product.ShowP(product.getX(), product.getY());
                    product.setFill(new ImagePattern(new Image(getClass().getResource("../img/products/shirt.png").toExternalForm())));
                }
                else  if (product.getName().equals("feather")) {
                    product.ShowP(product.getX(), product.getY());
                    product.setFill(new ImagePattern(new Image(getClass().getResource("../img/products/feather.png").toExternalForm())));
                }
            }
    }
}
