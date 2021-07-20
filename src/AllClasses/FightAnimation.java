package AllClasses;

import javafx.animation.Transition;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.util.Duration;

public class FightAnimation extends Transition {

    public Fight fight;
    public FightAnimation(Fight fight)
    {
        this.fight=fight;
        setCycleDuration(Duration.millis(1000));
        setCycleCount(-1);
    }
    @Override
    protected void interpolate(double frac) {
        int frame=(int) Math.floor(frac*20);
        fight.move(2,0);
        try {
            fight.setFill(new ImagePattern(new Image(getClass().getResource("../img/fight/battle_" + (frame + 1) + ".png").toExternalForm())));
        }
        catch (Exception e){}
        if(fight.hitRightWall(fight.getX()))
        {
            fight.remove(fight);
        }

    }
}
