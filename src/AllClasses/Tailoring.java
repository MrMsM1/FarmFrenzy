
package AllClasses;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class Tailoring extends Rectangle {

    public int level;
    private ArrayList<Product> products;
    private AnchorPane anchorPane;
    public Tailoring(ArrayList<Product> products, AnchorPane anchorPane){
        super(95,120,200,170);
        this.level=1;
        this.products=products;
        this.anchorPane=anchorPane;
    }
    public void Start(){
        TailoringAnimation tailoringAnimation =new TailoringAnimation(this);
        tailoringAnimation.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Product product=new Product(280,260,6,"cloth",4,anchorPane);
                product.setFill(new ImagePattern(new Image(getClass().getResource("../img/products/cloth.png").toExternalForm())));
                anchorPane.getChildren().add(product);

            }
        });
        tailoringAnimation.play();
    }
}

