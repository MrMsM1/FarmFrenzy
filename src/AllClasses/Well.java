package AllClasses;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.shape.Rectangle;

public class Well extends Rectangle {
    int fullness;
    public Well(String url){
        super(463,27,180,200);
        fullness=5;

    }
    public void fillTheWell(){
        WellAnimation wellAnimation =new WellAnimation(this);
        wellAnimation.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                fullness=5;
            }
        });
        wellAnimation.play();

    }

    public int getFullness() {
        return fullness;
    }

    public void setFullness(int fullness) {
        this.fullness = fullness;
    }
}
