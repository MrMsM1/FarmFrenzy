
package AllClasses;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class Incubator extends Rectangle {

    public int level;
    private ArrayList<Product> products;
    private AnchorPane anchorPane;
    public Incubator(ArrayList<Product> products, AnchorPane anchorPane){
        super(200,600,190,170);
        this.level=1;
        this.products=products;
        this.anchorPane=anchorPane;
    }
    public void Start(){
        IncubatorAnimation millAnimation =new IncubatorAnimation(this);
        millAnimation.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Turkey turkey=new Turkey(750,250,anchorPane);
                turkey.setFill(new ImagePattern(new Image(getClass().getResource("../img/turkey/turkeyLeft/left_1.png").toExternalForm())));

                anchorPane.getChildren().add(turkey);

            }
        });
        millAnimation.play();
    }
}

