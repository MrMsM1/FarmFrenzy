package AllClasses;

import javafx.fxml.FXMLLoader;
import javafx.stage.*;
import javafx.scene.*;

import java.io.IOException;

public class WareHouseLoader {
    private static Stage window;
    public static void display(String title, String message,String buttonMessage) throws IOException {
        window = new Stage();

        //Block events to other windows
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
//        window.setMinWidth(250);
//        window.setMaxHeight(350);
        Parent root= FXMLLoader.load(WareHouseLoader.class.getResource("../fxml/WareHouse.fxml"));


        //Display window and wait for it to be closed before returning
        Scene scene = new Scene(root,1100,800);
        //scene.getStylesheets().add("css//Style.css");
        window.setScene(scene);
        window.setResizable(false);
        window.showAndWait();
    }
    public static void close(){
        window.close();
    }

}