package AllClasses;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class Pause {
    @FXML
    private Button Menu;
    @FXML
    private Button Exit;
    @FXML
    private Button Continue;
    public void pushContinue(ActionEvent actionEvent){
        PauseLoader.close();
    }
    public void pushExit(ActionEvent actionEvent){
        Main main =new Main();
        PauseLoader.close();
        main.close();
    }
    public void pushMenu(ActionEvent actionEvent) throws IOException {
        Main main=new Main();
        main.changeScene("../fxml/Menu.fxml");
        PauseLoader.close();
    }
}
