
package AllClasses;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class Bakery extends Rectangle {

    public int level;
    private ArrayList<Product> products;
    private AnchorPane anchorPane;
    public Bakery(ArrayList<Product> products, AnchorPane anchorPane){
        super(45,310,200,170);
        this.level=1;
        this.products=products;
        this.anchorPane=anchorPane;
    }
    public void Start(){
        BakeryAnimation bakeryAnimation =new BakeryAnimation(this);
        bakeryAnimation.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Product product=new Product(250,380,6,"bread",4,anchorPane);
                product.setFill(new ImagePattern(new Image(getClass().getResource("../img/products/bread.png").toExternalForm())));
                anchorPane.getChildren().add(product);

            }
        });
        bakeryAnimation.play();
    }
}

