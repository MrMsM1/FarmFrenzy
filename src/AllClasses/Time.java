package AllClasses;

import javafx.animation.Transition;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class Time extends Transition {
    public Label label;
    public int counter=0;
    private Lion lion;
    private AnchorPane anchorPane;
    public Time (Label label,AnchorPane anchorPane)
    {
        this.label=label;
        this.anchorPane=anchorPane;
        setCycleDuration(Duration.millis(1000));
        setCycleCount(-1);
    }
    @Override
    protected void interpolate(double v) {
        if(v==1)
            counter++;
        label.setText(Integer.toString(counter));
        if (counter%40==0 && v==1){
            lion = new Lion(300, 300, anchorPane);
            anchorPane.getChildren().add(lion);
        }
    }
}