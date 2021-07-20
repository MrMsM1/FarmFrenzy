
package AllClasses;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class IceCreamShop extends Rectangle {

    public int level;
    private ArrayList<Product> products;
    private AnchorPane anchorPane;
    public IceCreamShop(ArrayList<Product> products, AnchorPane anchorPane){
        super(800,120,200,170);
        this.level=1;
        this.products=products;
        this.anchorPane=anchorPane;
    }
    public void Start(){
        IceCreamShopAnimation iceCreamShopAnimation =new IceCreamShopAnimation(this);
        iceCreamShopAnimation.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Product product=new Product(720,240,6,"iceCream",4,anchorPane);
                product.setFill(new ImagePattern(new Image(getClass().getResource("../img/products/iceCream.png").toExternalForm())));
                anchorPane.getChildren().add(product);

            }
        });
        iceCreamShopAnimation.play();
    }
}

