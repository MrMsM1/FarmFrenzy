package AllClasses;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Login implements Initializable {
    public static Person person;
    Main main=new Main();
    public static ArrayList<Person> people=new ArrayList<>();
    @FXML
    private TextField signUpUsername;
    @FXML
    private TextField loginUsername;
    @FXML
    private PasswordField signUpPassword;
    @FXML
    private PasswordField loginPassword;
    @FXML
    private TextField nameSignUp;
    @FXML
    private Button signUpButton;
    @FXML
    private Button loginButton;
    @FXML
    private Label login;
    @FXML
    private Label signUp;

    public void login(ActionEvent actionEvent) throws IOException {
        if(!loginUsername.getText().isEmpty() && !loginPassword.getText().isEmpty())
        {
            boolean isthere = false;
            String password = "";
            for (int i = 0; i < people.size(); i++) {
                if (people.get(i).getUsername().equals(loginUsername.getText()))
                {
                    person=people.get(i);
                    password = people.get(i).getPassword();
                    isthere = true;
                    break;
                }
            }
            if (isthere && password.equals(loginPassword.getText())) {
                String tempUserData= person.getUsername()+" "+person.getPassword()+" "+person.getMoney()+" "+person.getLevel()+" "+person.getLevel();
                main.changeScene("../fxml/Menu.fxml");
            } else {
                login.setText("Wrong Username or Password");
            }
        }
        else
            login.setText("Please fill the field");

    }
    public void signUp(ActionEvent actionEvent) throws IOException {
        if(!signUpPassword.getText().isEmpty() && !signUpUsername.getText().isEmpty() && !nameSignUp.getText().isEmpty())
        {
            boolean isthere = false;
            for (int i = 0; i < people.size(); i++) {
                if (people.get(i).getUsername().equals(signUpUsername.getText())) {
                    isthere = true;
                    person=people.get(i);
                    break;
                }
            }
            if (isthere) {
                signUp.setTextFill(Color.RED);
                signUp.setText("This username was added");
            } else {
                people.add(new Person(signUpUsername.getText(),signUpPassword.getText(),600,1,nameSignUp.getText()));
                person=people.get(people.size()-1);
                String userData="";
                for (int i = 0; i < people.size(); i++) {
                    userData+=people.get(i).getUsername()+" "+people.get(i).getPassword()+" "+people.get(i).getMoney()+" "+people.get(i).getLevel()+" "+people.get(i).getName()+"\n";
                }
                try {
                    FileWriter oredrDataWriter =new FileWriter("people.txt");
                    oredrDataWriter.write(userData);
                    oredrDataWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                main.changeScene("../fxml/Menu.fxml");
            }
        }
        else
            signUp.setText("Please fill the field");

    }
    public static Person Player()
    {
        return person;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String[] readerInfo;

        try {
            File person = new File("people.txt");
            if (person.createNewFile()) {
                Scanner myReader = new Scanner(person);
            }
            Scanner myReader = new Scanner(person);

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                readerInfo = data.split("\\s");
                people.add(new Person(readerInfo[0], readerInfo[1], Integer.parseInt(readerInfo[2]), Integer.parseInt(readerInfo[3]), readerInfo[4]));
            }
            myReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
