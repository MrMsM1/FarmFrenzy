
package AllClasses;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class MilkPacking extends Rectangle {

    public int level;
    private ArrayList<Product> products;
    private AnchorPane anchorPane;
    public MilkPacking(ArrayList<Product> products, AnchorPane anchorPane){
        super(800,490,200,170);
        this.level=1;
        this.products=products;
        this.anchorPane=anchorPane;
    }
    public void Start(){
        MilkPackingAnimation milkPackingAnimation =new MilkPackingAnimation(this);
        milkPackingAnimation.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Product product=new Product(740,560,5,"pocketMilk",2,anchorPane);
                product.setFill(new ImagePattern(new Image(getClass().getResource("../img/products/pocketMilk.png").toExternalForm())));
                anchorPane.getChildren().add(product);

            }
        });
        milkPackingAnimation.play();
    }
}

