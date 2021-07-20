package AllClasses;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class Prize implements Initializable {
    @FXML
    private Label level=new Label();
    @FXML
    private Label username= new Label();
    @FXML
    private Label time=new Label();
    @FXML
    private Button OK;
    public void pushOk(ActionEvent actionEvent){
        PrizeLoader.close();
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Person person=Login.Player();
        level.setText(Integer.toString(Menu.chosenLevel));
        username.setText(person.getUsername());
        time.setText(Integer.toString(Game.time1.counter));
    }
}
