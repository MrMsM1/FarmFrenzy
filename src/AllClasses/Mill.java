
package AllClasses;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class Mill extends Rectangle {

    public int level;
    private ArrayList<Product> products;
    private AnchorPane anchorPane;
    public Mill(ArrayList<Product> products, AnchorPane anchorPane){
        super(800,310,200,170);
        this.level=1;
        this.products=products;
        this.anchorPane=anchorPane;
    }
    public void Start(){
        MillAnimation millAnimation =new MillAnimation(this);
        millAnimation.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Product product=new Product(740,380,5,"flour",2,anchorPane);
                product.setFill(new ImagePattern(new Image(getClass().getResource("../img/products/flour.png").toExternalForm())));
                anchorPane.getChildren().add(product);

            }
        });
        millAnimation.play();
    }
}

