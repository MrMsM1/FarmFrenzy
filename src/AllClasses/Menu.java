package AllClasses;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class Menu {

    Main main=new Main();
    Person person=Login.Player();
    @FXML
    private Button level1;
    @FXML
    private Button level2;
    @FXML
    private Button level3;
    @FXML
    private Button level4;
    @FXML
    private Button level5;
    @FXML
    private Button awarad;
    @FXML
    private Button exit;
    @FXML
    private Button logout;
    public void pushExit(ActionEvent actionEvent){
        main.close();
    }
    public void pushLogout(ActionEvent actionEvent) throws IOException {
        main.changeScene("../fxml/Login.fxml");
    }
     static int chosenLevel=0;
    public void StartGame(ActionEvent actionEvent) throws IOException {
        int Level= person.getLevel();
        if(actionEvent.getSource().equals(level1))
        {
            chosenLevel=1;
            GoToGame();
        }
        else if(actionEvent.getSource().equals(level2))
        {
            if (Level>=2) {
                chosenLevel=2;
                GoToGame();

            }
            else
                AlertBox.display("Error","You haven't achieved this Level & your Level is "+Level,"Ok");

        }
        else if(actionEvent.getSource().equals(level3))
        {

            if (Level>=3) {
                chosenLevel=3;
                GoToGame();
            }
            else
                AlertBox.display("Error","You haven't achieved this Level & your Level is "+Level,"Ok");

        }
        else if(actionEvent.getSource().equals(level4))
        {

            if (Level>=4) {
                chosenLevel=4;
                GoToGame();

            }
            else
                AlertBox.display("Error","You haven't achieved this Level & your Level is "+Level,"Ok");

        }
        else if(actionEvent.getSource().equals(level5))
        {

            if (Level>=5) {
                chosenLevel=5;
                GoToGame();

            }
            else
                AlertBox.display("Error","You haven't achieved this Level & your Level is "+Level,"Ok");

        }
    }
    public void AwaredPlayer(ActionEvent actionEvent)
    {

    }
    public void GoToGame() throws IOException {
        main.changeScene("../fxml/Game.fxml");
    }
}