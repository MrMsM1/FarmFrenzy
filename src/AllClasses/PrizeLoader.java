package AllClasses;

import javafx.fxml.FXMLLoader;
import javafx.stage.*;
import javafx.scene.*;

import java.io.IOException;

public class PrizeLoader {
    private static Stage window;

    public static void display() throws IOException {
        Person person=Login.Player();
        window = new Stage();


        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Prize");
        Parent root= FXMLLoader.load(WareHouseLoader.class.getResource("../fxml/Prize.fxml"));



        Scene scene = new Scene(root,500,600);

        window.setScene(scene);
        window.setResizable(false);
        window.showAndWait();
    }
    public static void close(){
        window.close();
    }

}