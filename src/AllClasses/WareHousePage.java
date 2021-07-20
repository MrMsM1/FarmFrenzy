package AllClasses;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class WareHousePage implements Initializable {
    private Truck truck=new Truck();
    private WareHouse wareHouse;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    ImageView egg;
    @FXML
    ImageView feather;
    @FXML
    ImageView milk;
    @FXML
    ImageView flour;
    @FXML
    ImageView cloth;
    @FXML
    ImageView pocketMilk;
    @FXML
    ImageView bread;
    @FXML
    ImageView shirt;
    @FXML
    ImageView iceCream;
    @FXML
    Button back;
    @FXML
    Label totalGold;
    @FXML
    Button truckGo;
    @FXML
    Label error;
    ImageView cagedLion=new ImageView();
    Label cagedLionWareHouse=new Label();
    ImageView cagedLionImage=new ImageView();
    Label cagedLionTruck=new Label();
    Button cagedLionButton=new Button();

    ImageView turkey=new ImageView();
    Label turkeyWareHouse=new Label();
    ImageView turkeyImage=new ImageView();
    Label turkeyTruck=new Label();
    Button turkeyButton=new Button();

    ImageView ostrich=new ImageView();
    Label ostrichWareHouse=new Label();
    ImageView ostrichImage=new ImageView();
    Label ostrichTruck=new Label();
    Button ostrichButton=new Button();

    ImageView buffalo=new ImageView();
    Label buffaloWareHouse=new Label();
    ImageView buffaloImage=new ImageView();
    Label buffaloTruck=new Label();
    Button buffaloButton=new Button();

    Label eggTruck=new Label();
    Label featherTruck=new Label();
    Label milkTruck=new Label();
    Label flourTruck=new Label();
    Label clothTruck=new Label();
    Label pocketMilkTruck=new Label();
    Label breadTruck=new Label();
    Label shirtTruck=new Label();
    Label iceCreamTruck=new Label();
    //warehouse number labels
    Label eggWarehouse=new Label();
    Label featherWarehouse=new Label();
    Label milkWarehouse=new Label();
    Label flourWarehouse=new Label();
    Label clothWarehouse=new Label();
    Label pocketWarehouse=new Label();
    Label breadWarehouse=new Label();
    Label shirtWarehouse=new Label();
    Label iceCreamWarehouse=new Label();
    //
    ImageView eggImage=new ImageView();
    ImageView featherImage=new ImageView();
    ImageView milkImage=new ImageView();
    ImageView flourImage=new ImageView();
    ImageView clothImage=new ImageView();
    ImageView pocketMilkImage=new ImageView();
    ImageView breadImage=new ImageView();
    ImageView shirtImage=new ImageView();
    ImageView iceCreamImage=new ImageView();
    Button eggButton = new Button();
    Button featherButton = new Button();
    Button milkButton = new Button();
    Button flourButton = new Button();
    Button clothButton = new Button();
    Button pocketMilkButton = new Button();
    Button breadButton = new Button();
    Button shirtButton = new Button();
    Button iceCreamButton = new Button();




    public void pushBack(ActionEvent actionEvent) throws IOException {
        wareHouse.setEgg(truck.getEgg());
        wareHouse.setFeather(truck.getFeather());
        wareHouse.setMilk(truck.getMilk());
        wareHouse.setFlour(truck.getFlour());
        wareHouse.setCloth(truck.getCloth());
        wareHouse.setPocketMilk(truck.getPocketMilk());
        wareHouse.setBread(truck.getBread());
        wareHouse.setShirt(truck.getShirt());
        wareHouse.setIceCream(truck.getIceCream());
        wareHouse.setLion(truck.getLion());
        wareHouse.setTurkey(truck.getTurkey());
        wareHouse.setOstrich(truck.getOstrich());
        wareHouse.setBuffalo(truck.getBuffalo());
        truck.setEgg(-truck.getEgg());
        truck.setFeather(-truck.getFeather());
        truck.setMilk(-truck.getMilk());
        truck.setFlour(-truck.getFlour());
        truck.setCloth(-truck.getCloth());
        truck.setPocketMilk(-truck.getPocketMilk());
        truck.setBread(-truck.getBread());
        truck.setShirt(-truck.getShirt());
        truck.setIceCream(-truck.getIceCream());
        truck.setLion(-truck.getLion());
        truck.setTurkey(-truck.getTurkey());
        truck.setOstrich(-truck.getOstrich());
        truck.setBuffalo(-truck.getBuffalo());
        String wareHouseData="";

        WareHouseLoader.close();
    }
    public void go(){
        if (!totalGold.getText().equals("0")) {
            String wareHouseData = "";
            wareHouseData += wareHouse.getEgg() + " ";
            wareHouseData += wareHouse.getFeather() + " ";
            wareHouseData += wareHouse.getMilk() + " ";
            wareHouseData += wareHouse.getFlour() + " ";
            wareHouseData += wareHouse.getCloth() + " ";
            wareHouseData += wareHouse.getPocketMilk() + " ";
            wareHouseData += wareHouse.getBread() + " ";
            wareHouseData += wareHouse.getShirt() + " ";
            wareHouseData += wareHouse.getIceCream() + " ";
            wareHouseData += wareHouse.getLion() + " ";
            wareHouseData += wareHouse.getTurkey() + " ";
            wareHouseData += wareHouse.getOstrich() + " ";
            wareHouseData += wareHouse.getBuffalo() + " ";
            try {
                FileWriter oredrDataWriter = new FileWriter("wareHouseData.txt");
                oredrDataWriter.write(wareHouseData);
                oredrDataWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                FileWriter oredrDataWriter = new FileWriter("tempTruck.txt");
                oredrDataWriter.write(totalGold.getText());
                oredrDataWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            WareHouseLoader.close();
        }else {
            error.setText("Please add something to truck first!");
        }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            FileWriter oredrDataWriter = new FileWriter("tempTruck.txt");
            oredrDataWriter.write("0");
            oredrDataWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        totalGold.setText("0");
        totalGold.setStyle("-fx-text-fill: gold");
        String[] readerInfo = new String[12];

        boolean isthere = false;
        try {
            File person = new File("wareHouseData.txt");
            if (person.createNewFile()) {
                Scanner myReader = new Scanner(person);
            }
            Scanner myReader = new Scanner(person);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                readerInfo=data.split("\\s");
            }
            myReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        wareHouse=new WareHouse();
        wareHouse.setEgg(Integer.parseInt(readerInfo[0]));
        wareHouse.setFeather(Integer.parseInt(readerInfo[1]));
        wareHouse.setMilk(Integer.parseInt(readerInfo[2]));
        wareHouse.setFlour(Integer.parseInt(readerInfo[3]));
        wareHouse.setCloth(Integer.parseInt(readerInfo[4]));
        wareHouse.setPocketMilk(Integer.parseInt(readerInfo[5]));
        wareHouse.setBread(Integer.parseInt(readerInfo[6]));
        wareHouse.setShirt(Integer.parseInt(readerInfo[7]));
        wareHouse.setIceCream(Integer.parseInt(readerInfo[8]));
        wareHouse.setLion(Integer.parseInt(readerInfo[9]));
        wareHouse.setTurkey(Integer.parseInt(readerInfo[10]));
        wareHouse.setOstrich(Integer.parseInt(readerInfo[11]));
        wareHouse.setBuffalo(Integer.parseInt(readerInfo[12]));

        int y1=138;
        int x1=35;
        int x2=745,y2=138;
        if (wareHouse.getEgg()>0){
            Image image =new Image(getClass().getResource("../img/products/egg.png").toExternalForm());
            egg.setImage(image);
            egg.setX(x1);
            egg.setY(y1);
            egg.setFitWidth(40);
            egg.setFitHeight(40);
            //price
            Label label=new Label("15");
            label.setLayoutX(x1+150);
            label.setLayoutY(y1);
            label.setPrefWidth(40);
            label.setPrefHeight(40);
            label.setStyle("-fx-font-size: 20");
            anchorPane.getChildren().add(label);
            //number
             eggWarehouse.setText(readerInfo[0]);
            eggWarehouse.setLayoutX(x1+50);
            eggWarehouse.setLayoutY(y1);
            eggWarehouse.setPrefWidth(40);
            eggWarehouse.setPrefHeight(40);
            eggWarehouse.setStyle("-fx-font-size: 20");
            anchorPane.getChildren().add(eggWarehouse);

            Button button=new Button("Add");
            button.setLayoutX(x1+250);
            button.setLayoutY(y1+5);
            button.setOnAction(event -> {
                if (wareHouse.getEgg()>0 && (15-truck.getFullness())>=1){
                    wareHouse.setEgg(-1);
                    eggWarehouse.setText(Integer.toString(wareHouse.getEgg()));
                    totalGold.setText(Integer.toString(Integer.parseInt(totalGold.getText())+15));
                    truck.setEgg(1);
                    truckInfo();
                }
            });
            anchorPane.getChildren().add(button);
            y1+=43;
        }
         if (wareHouse.getFeather()>0){
            Image image =new Image(getClass().getResource("../img/products/feather.png").toExternalForm());
            feather.setImage(image);
            feather.setX(x1);
            feather.setY(y1);
            feather.setFitWidth(40);
            feather.setFitHeight(40);
             Label label=new Label("20");
             label.setLayoutX(x1+150);
             label.setLayoutY(y1);
             label.setPrefWidth(40);
             label.setPrefHeight(40);
             label.setStyle("-fx-font-size: 20");
             //number
             featherWarehouse.setText(readerInfo[1]);
             featherWarehouse.setLayoutX(x1+50);
             featherWarehouse.setLayoutY(y1);
             featherWarehouse.setPrefWidth(40);
             featherWarehouse.setPrefHeight(40);
             featherWarehouse.setStyle("-fx-font-size: 20");
             anchorPane.getChildren().add(featherWarehouse);

             anchorPane.getChildren().add(label);
             Button button=new Button("Add");
             button.setLayoutX(x1+250);
             button.setLayoutY(y1+5);
             button.setOnAction(event -> {
                 if (wareHouse.getFeather()>0 && (15-truck.getFullness())>=1){
                     wareHouse.setFeather(-1);
                     featherWarehouse.setText(Integer.toString(wareHouse.getFeather()));
                     totalGold.setText(Integer.toString(Integer.parseInt(totalGold.getText())+20));
                     truck.setFeather(1);
                     truckInfo();
                 }
             });
             anchorPane.getChildren().add(button);
            y1+=43;
        }
         if (wareHouse.getMilk()>0){

            Image image =new Image(getClass().getResource("../img/products/milk.png").toExternalForm());
            milk.setImage(image);
            milk.setX(x1);
            milk.setY(y1);
            milk.setFitWidth(40);
            milk.setFitHeight(40);
             Label label=new Label("25");
             label.setLayoutX(x1+150);
             label.setLayoutY(y1);
             label.setPrefWidth(40);
             label.setPrefHeight(40);
             label.setStyle("-fx-font-size: 20");
             anchorPane.getChildren().add(label);
             //number
             milkWarehouse.setText(readerInfo[2]);
             milkWarehouse.setLayoutX(x1+50);
             milkWarehouse.setLayoutY(y1);
             milkWarehouse.setPrefWidth(40);
             milkWarehouse.setPrefHeight(40);
             milkWarehouse.setStyle("-fx-font-size: 20");
             anchorPane.getChildren().add(milkWarehouse);
             Button button=new Button("Add");
             button.setLayoutX(x1+250);
             button.setLayoutY(y1+5);
             button.setOnAction(event -> {
                 if (wareHouse.getMilk()>0 && (15-truck.getFullness())>=1){
                     wareHouse.setMilk(-1);
                     milkWarehouse.setText(Integer.toString(wareHouse.getMilk()));
                     totalGold.setText(Integer.toString(Integer.parseInt(totalGold.getText())+25));
                     truck.setMilk(1);
                     truckInfo();
                 }
             });
             anchorPane.getChildren().add(button);
            y1+=43;
        }
         if (wareHouse.getFlour()>0){
            Image image =new Image(getClass().getResource("../img/products/flour.png").toExternalForm());
            flour.setImage(image);
            flour.setX(x1);
            flour.setY(y1);
            flour.setFitWidth(40);
            flour.setFitHeight(40);
             Label label=new Label("40");
             label.setLayoutX(x1+150);
             label.setLayoutY(y1);
             label.setPrefWidth(40);
             label.setPrefHeight(40);
             label.setStyle("-fx-font-size: 20");
             anchorPane.getChildren().add(label);
             //number
             flourWarehouse.setText(readerInfo[3]);
             flourWarehouse.setLayoutX(x1+50);
             flourWarehouse.setLayoutY(y1);
             flourWarehouse.setPrefWidth(40);
             flourWarehouse.setPrefHeight(40);
             flourWarehouse.setStyle("-fx-font-size: 20");
             anchorPane.getChildren().add(flourWarehouse);
             Button button=new Button("Add");
             button.setLayoutX(x1+250);
             button.setLayoutY(y1);
             button.setOnAction(event -> {
                 if (wareHouse.getFlour()>0 && (15-truck.getFullness())>=2){
                     wareHouse.setFlour(-1);
                     flourWarehouse.setText(Integer.toString(wareHouse.getFlour()));
                     totalGold.setText(Integer.toString(Integer.parseInt(totalGold.getText())+40));
                     truck.setFlour(1);
                     truckInfo();
                 }
             });
             anchorPane.getChildren().add(button);
            y1+=43;
        }
         if (wareHouse.getCloth()>0){
            Image image =new Image(getClass().getResource("../img/products/cloth.png").toExternalForm());
            cloth.setImage(image);
            cloth.setX(x1);
            cloth.setY(y1);
            cloth.setFitWidth(40);
            cloth.setFitHeight(40);
             Label label=new Label("50");
             label.setLayoutX(x1+150);
             label.setLayoutY(y1);
             label.setPrefWidth(40);
             label.setPrefHeight(40);
             label.setStyle("-fx-font-size: 20");
             anchorPane.getChildren().add(label);
             //number
             clothWarehouse.setText(readerInfo[4]);
             clothWarehouse.setLayoutX(x1+50);
             clothWarehouse.setLayoutY(y1);
             clothWarehouse.setPrefWidth(40);
             clothWarehouse.setPrefHeight(40);
             clothWarehouse.setStyle("-fx-font-size: 20");
             anchorPane.getChildren().add(clothWarehouse);


             Button button=new Button("Add");
             button.setLayoutX(x1+250);
             button.setLayoutY(y1+5);
             button.setOnAction(event -> {
                 if (wareHouse.getCloth()>0 && (15-truck.getFullness())>=2){
                     wareHouse.setCloth(-1);
                     clothWarehouse.setText(Integer.toString(wareHouse.getCloth()));
                     totalGold.setText(Integer.toString(Integer.parseInt(totalGold.getText())+50));
                     truck.setCloth(1);
                     truckInfo();
                 }
             });
             anchorPane.getChildren().add(button);
            y1+=43;
        }
         if (wareHouse.getPocketMilk()>0){
            Image image =new Image(getClass().getResource("../img/products/pocketMilk.png").toExternalForm());
            pocketMilk.setImage(image);
            pocketMilk.setX(x1);
            pocketMilk.setY(y1);
            pocketMilk.setFitWidth(40);
            pocketMilk.setFitHeight(40);
             Label label=new Label("60");
             label.setLayoutX(x1+150);
             label.setLayoutY(y1);
             label.setPrefWidth(40);
             label.setPrefHeight(40);
             label.setStyle("-fx-font-size: 20");
             anchorPane.getChildren().add(label);
             //number
             pocketWarehouse.setText(readerInfo[5]);
             pocketWarehouse.setLayoutX(x1+50);
             pocketWarehouse.setLayoutY(y1);
             pocketWarehouse.setPrefWidth(40);
             pocketWarehouse.setPrefHeight(40);
             pocketWarehouse.setStyle("-fx-font-size: 20");
             anchorPane.getChildren().add(pocketWarehouse);
             Button button=new Button("Add");
             button.setLayoutX(x1+250);
             button.setLayoutY(y1+5);
             button.setOnAction(event -> {
                 if (wareHouse.getPocketMilk()>0 && (15-truck.getFullness())>=2){
                     wareHouse.setPocketMilk(-1);
                     pocketWarehouse.setText(Integer.toString(wareHouse.getPocketMilk()));
                     totalGold.setText(Integer.toString(Integer.parseInt(totalGold.getText())+60));
                     truck.setPocketMilk(1);
                     truckInfo();
                 }
             });
             anchorPane.getChildren().add(button);
            y1+=43;
        }
         if (wareHouse.getBread()>0){
            Image image =new Image(getClass().getResource("../img/products/bread.png").toExternalForm());
            bread.setImage(image);
            bread.setX(x1);
            bread.setY(y1);
            bread.setFitWidth(40);
            bread.setFitHeight(40);
             Label label=new Label("80");
             label.setLayoutX(x1+150);
             label.setLayoutY(y1);
             label.setPrefWidth(40);
             label.setPrefHeight(40);
             label.setStyle("-fx-font-size: 20");
             anchorPane.getChildren().add(label);
             //number
             breadWarehouse.setText(readerInfo[6]);
             breadWarehouse.setLayoutX(x1+50);
             breadWarehouse.setLayoutY(y1);
             breadWarehouse.setPrefWidth(40);
             breadWarehouse.setPrefHeight(40);
             breadWarehouse.setStyle("-fx-font-size: 20");
             anchorPane.getChildren().add(breadWarehouse);
             Button button=new Button("Add");
             button.setLayoutX(x1+250);
             button.setLayoutY(y1+5);
             button.setOnAction(event -> {
                 if (wareHouse.getBread()>0 && (15-truck.getFullness())>=4){
                     wareHouse.setBread(-1);
                     breadWarehouse.setText(Integer.toString(wareHouse.getBread()));
                     totalGold.setText(Integer.toString(Integer.parseInt(totalGold.getText())+80));
                     truck.setBread(1);
                     truckInfo();
                 }
             });
             anchorPane.getChildren().add(button);
            y1+=43;
        }
         if (wareHouse.getShirt()>0){
            Image image =new Image(getClass().getResource("../img/products/shirt.png").toExternalForm());
            shirt.setImage(image);
            shirt.setX(x1);
            shirt.setY(y1);
            shirt.setFitWidth(40);
            shirt.setFitHeight(40);
             Label label=new Label("100");
             label.setLayoutX(x1+150);
             label.setLayoutY(y1);
             label.setPrefWidth(40);
             label.setPrefHeight(40);
             label.setStyle("-fx-font-size: 20");
             anchorPane.getChildren().add(label);
             //number
             shirtWarehouse.setText(readerInfo[7]);
             shirtWarehouse.setLayoutX(x1+50);
             shirtWarehouse.setLayoutY(y1);
             shirtWarehouse.setPrefWidth(40);
             shirtWarehouse.setPrefHeight(40);
             shirtWarehouse.setStyle("-fx-font-size: 20");
             anchorPane.getChildren().add(shirtWarehouse);
             Button button=new Button("Add");
             button.setLayoutX(x1+250);
             button.setLayoutY(y1+5);
             button.setOnAction(event -> {
                 if (wareHouse.getShirt()>0 && (15-truck.getFullness())>=4){
                     wareHouse.setShirt(-1);
                     shirtWarehouse.setText(Integer.toString(wareHouse.getShirt()));
                     totalGold.setText(Integer.toString(Integer.parseInt(totalGold.getText())+100));
                     truck.setShirt(1);
                     truckInfo();
                 }
             });
             anchorPane.getChildren().add(button);
            y1+=43;
        }
         if (wareHouse.getIceCream()>0){
            Image image =new Image(getClass().getResource("../img/products/iceCream.png").toExternalForm());
            iceCream.setImage(image);
            iceCream.setX(x1);
            iceCream.setY(y1);
            iceCream.setFitWidth(40);
             iceCream.setFitHeight(40);
             Label label=new Label("120");
             label.setLayoutX(x1+150);
             label.setLayoutY(y1);
             label.setPrefWidth(40);
             label.setPrefHeight(40);
             label.setStyle("-fx-font-size: 20");
             anchorPane.getChildren().add(label);
             //number
             iceCreamWarehouse.setText(readerInfo[8]);
             iceCreamWarehouse.setLayoutX(x1+50);
             iceCreamWarehouse.setLayoutY(y1);
             iceCreamWarehouse.setPrefWidth(40);
             iceCreamWarehouse.setPrefHeight(40);
             iceCreamWarehouse.setStyle("-fx-font-size: 20");
             anchorPane.getChildren().add(iceCreamWarehouse);
             Button button=new Button("Add");
             button.setLayoutX(x1+250);
             button.setLayoutY(y1+5);
             button.setOnAction(event -> {
                 if (wareHouse.getIceCream()>0 && (15-truck.getFullness())>=4){
                     wareHouse.setIceCream(-1);
                     iceCreamWarehouse.setText(Integer.toString(wareHouse.getIceCream()));
                     totalGold.setText(Integer.toString(Integer.parseInt(totalGold.getText())+120));
                     truck.setIceCream(1);
                     truckInfo();
                 }
             });
             anchorPane.getChildren().add(button);
            y1+=43;
        }
         if (wareHouse.getLion()>0){
             Image image =new Image(getClass().getResource("../img/products/CagedLion.png").toExternalForm());
             cagedLion.setImage(image);
             cagedLion.setX(x1);
             cagedLion.setY(y1);
             cagedLion.setFitWidth(40);
             cagedLion.setFitHeight(40);
             anchorPane.getChildren().add(cagedLion);
             Label label=new Label("300");
             label.setLayoutX(x1+150);
             label.setLayoutY(y1);
             label.setPrefWidth(40);
             label.setPrefHeight(40);
             label.setStyle("-fx-font-size: 20");
             anchorPane.getChildren().add(label);
             //number
             cagedLionWareHouse.setText(readerInfo[9]);
             cagedLionWareHouse.setLayoutX(x1+50);
             cagedLionWareHouse.setLayoutY(y1);
             cagedLionWareHouse.setPrefWidth(40);
             cagedLionWareHouse.setPrefHeight(40);
             cagedLionWareHouse.setStyle("-fx-font-size: 20");
             anchorPane.getChildren().add(cagedLionWareHouse);
             Button button=new Button("Add");
             button.setLayoutX(x1+250);
             button.setLayoutY(y1+5);
             button.setOnAction(event -> {
                 if (wareHouse.getLion()>0 && (15-truck.getFullness())>=15){
                     wareHouse.setLion(-1);
                     cagedLionWareHouse.setText(Integer.toString(wareHouse.getLion()));
                     totalGold.setText(Integer.toString(Integer.parseInt(totalGold.getText())+300));
                     truck.setLion(1);
                     truckInfo();
                 }
             });
             anchorPane.getChildren().add(button);
             y1+=43;
         }
         if (wareHouse.getTurkey()>0){
             Image image =new Image(getClass().getResource("../img/products/turkey.png").toExternalForm());
             turkey.setImage(image);
             turkey.setX(x2);
             turkey.setY(y2);
             turkey.setFitWidth(40);
             turkey.setFitHeight(40);
             anchorPane.getChildren().add(turkey);
             Label label=new Label("50");
             label.setLayoutX(x2+150);
             label.setLayoutY(y2);
             label.setPrefWidth(40);
             label.setPrefHeight(40);
             label.setStyle("-fx-font-size: 20");
             anchorPane.getChildren().add(label);
             //number
             turkeyWareHouse.setText(readerInfo[10]);
             turkeyWareHouse.setLayoutX(x2+50);
             turkeyWareHouse.setLayoutY(y2);
             turkeyWareHouse.setPrefWidth(40);
             turkeyWareHouse.setPrefHeight(40);
             turkeyWareHouse.setStyle("-fx-font-size: 20");
             anchorPane.getChildren().add(turkeyWareHouse);
             Button button=new Button("Add");
             button.setLayoutX(x2+250);
             button.setLayoutY(y2+5);
             button.setOnAction(event -> {
                 if (wareHouse.getTurkey()>0 && (15-truck.getFullness())>=5){
                     wareHouse.setTurkey(-1);
                     turkeyWareHouse.setText(Integer.toString(wareHouse.getTurkey()));
                     totalGold.setText(Integer.toString(Integer.parseInt(totalGold.getText())+50));
                     truck.setTurkey(1);
                     truckInfo();
                 }
             });
             anchorPane.getChildren().add(button);
             y2+=43;
         }
         if (wareHouse.getOstrich()>0){
             Image image =new Image(getClass().getResource("../img/products/ostrich.png").toExternalForm());
             ostrich.setImage(image);
             ostrich.setX(x2);
             ostrich.setY(y2);
             ostrich.setFitWidth(40);
             ostrich.setFitHeight(40);
             anchorPane.getChildren().add(ostrich);
             Label label=new Label("100");
             label.setLayoutX(x2+150);
             label.setLayoutY(y2);
             label.setPrefWidth(40);
             label.setPrefHeight(40);
             label.setStyle("-fx-font-size: 20");
             anchorPane.getChildren().add(label);
             //number
             ostrichWareHouse.setText(readerInfo[11]);
             ostrichWareHouse.setLayoutX(x2+50);
             ostrichWareHouse.setLayoutY(y2);
             ostrichWareHouse.setPrefWidth(40);
             ostrichWareHouse.setPrefHeight(40);
             ostrichWareHouse.setStyle("-fx-font-size: 20");
             anchorPane.getChildren().add(ostrichWareHouse);
             Button button=new Button("Add");
             button.setLayoutX(x2+250);
             button.setLayoutY(y2+5);
             button.setOnAction(event -> {
                 if (wareHouse.getOstrich()>0 && (15-truck.getFullness())>=5){
                     wareHouse.setOstrich(-1);
                     ostrichWareHouse.setText(Integer.toString(wareHouse.getOstrich()));
                     totalGold.setText(Integer.toString(Integer.parseInt(totalGold.getText())+100));
                     truck.setOstrich(1);
                     truckInfo();
                 }
             });
             anchorPane.getChildren().add(button);
             y2+=43;
         }
         if (wareHouse.getBuffalo()>0){
             Image image =new Image(getClass().getResource("../img/products/buffalo.png").toExternalForm());
             buffalo.setImage(image);
             buffalo.setX(x2);
             buffalo.setY(y2);
             buffalo.setFitWidth(40);
             buffalo.setFitHeight(40);
             anchorPane.getChildren().add(buffalo);
             Label label=new Label("200");
             label.setLayoutX(x2+150);
             label.setLayoutY(y2);
             label.setPrefWidth(40);
             label.setPrefHeight(40);
             label.setStyle("-fx-font-size: 20");
             anchorPane.getChildren().add(label);
             //number
             buffaloWareHouse.setText(readerInfo[12]);
             buffaloWareHouse.setLayoutX(x2+50);
             buffaloWareHouse.setLayoutY(y2);
             buffaloWareHouse.setPrefWidth(40);
             buffaloWareHouse.setPrefHeight(40);
             buffaloWareHouse.setStyle("-fx-font-size: 20");
             anchorPane.getChildren().add(buffaloWareHouse);
             Button button=new Button("Add");
             button.setLayoutX(x2+250);
             button.setLayoutY(y2+5);
             button.setOnAction(event -> {
                 if (wareHouse.getBuffalo()>0 && (15-truck.getFullness())>=5){
                     wareHouse.setBuffalo(-1);
                     buffaloWareHouse.setText(Integer.toString(wareHouse.getBuffalo()));
                     totalGold.setText(Integer.toString(Integer.parseInt(totalGold.getText())+200));
                     truck.setBuffalo(1);

                     truckInfo();
                 }
             });
             anchorPane.getChildren().add(button);
             y2+=43;
         }
    }
    private void truckInfo(){
        anchorPane.getChildren().removeAll(featherImage,featherTruck,featherButton,eggImage,eggTruck,eggButton,
                milkImage,milkTruck,milkButton,flourImage,flourTruck,flourButton,clothImage,clothTruck,clothButton,pocketMilkImage,pocketMilkTruck,pocketMilkButton,
                breadImage,breadTruck,breadButton,shirtImage,shirtTruck,shirtButton,iceCreamImage,iceCreamTruck,iceCreamButton,cagedLionImage,cagedLionTruck,cagedLionButton,
                turkeyImage,turkeyTruck,turkeyButton,ostrichImage,ostrichTruck,ostrichButton,buffaloImage,buffaloTruck,buffaloButton);
        int x=390,y=138;

        if (truck.getEgg()>0){
            Image image =new Image(getClass().getResource("../img/products/egg.png").toExternalForm());
            eggImage.setImage(image);
            eggImage.setX(x);
            eggImage.setY(y);
            eggImage.setFitWidth(40);
            eggImage.setFitHeight(40);
            eggTruck.setText(Integer.toString(truck.getEgg()));
            eggTruck.setLayoutX(x+50);
            eggTruck.setLayoutY(y);
            eggTruck.setPrefWidth(40);
            eggTruck.setPrefHeight(40);

            eggButton.setText("remove");
            eggButton.setLayoutX(x+225);
            eggButton.setLayoutY(y);
            eggButton.setPrefWidth(75);
            eggButton.setPrefHeight(40);
            eggButton.setOnAction(event -> {
                if (truck.getEgg()>0) {
                    truck.setEgg(-1);
                    wareHouse.setEgg(1);
                    eggTruck.setText(Integer.toString(truck.getEgg()));
                    eggWarehouse.setText(Integer.toString(wareHouse.getEgg()));
                    totalGold.setText(Integer.toString(Integer.parseInt(totalGold.getText())-15));
                }
                if (truck.getEgg()==0){
                    anchorPane.getChildren().remove(eggImage);
                    anchorPane.getChildren().remove(eggTruck);
                    anchorPane.getChildren().remove(eggButton);
                }
            });

                anchorPane.getChildren().add(eggImage);
                anchorPane.getChildren().add(eggTruck);
                anchorPane.getChildren().add(eggButton);

            y+=43;
        }
        if (truck.getFeather()>0){

            Image image =new Image(getClass().getResource("../img/products/feather.png").toExternalForm());
            featherImage.setImage(image);
            featherImage.setX(x);
            featherImage.setY(y);
            featherImage.setFitWidth(40);
            featherImage.setFitHeight(40);

            featherTruck.setText(Integer.toString(truck.getFeather()));
            featherTruck.setLayoutX(x+50);
            featherTruck.setLayoutY(y);
            featherTruck.setPrefWidth(40);
            featherTruck.setPrefHeight(40);

            featherButton.setText("remove");
            featherButton.setLayoutX(x+225);
            featherButton.setLayoutY(y);
            featherButton.setPrefWidth(75);
            featherButton.setPrefHeight(40);
            featherButton.setOnAction(event -> {
                if (truck.getFeather()>0) {
                    truck.setFeather(-1);
                    wareHouse.setFeather(1);
                    featherTruck.setText(Integer.toString(truck.getFeather()));
                    featherWarehouse.setText(Integer.toString(wareHouse.getFeather()));
                    totalGold.setText(Integer.toString(Integer.parseInt(totalGold.getText())-20));
                }
                if (truck.getFeather()==0){

                    anchorPane.getChildren().remove(featherImage);
                    anchorPane.getChildren().remove(featherTruck);
                    anchorPane.getChildren().remove(featherButton);
                }
            });

                anchorPane.getChildren().add(featherImage);
                anchorPane.getChildren().add(featherTruck);
                anchorPane.getChildren().add(featherButton);

            y+=43;
        }
        if (truck.getMilk()>0){
            Image image =new Image(getClass().getResource("../img/products/milk.png").toExternalForm());
            milkImage.setImage(image);
            milkImage.setX(x);
            milkImage.setY(y);
            milkImage.setFitWidth(40);
            milkImage.setFitHeight(40);
            milkTruck.setText(Integer.toString(truck.getMilk()));
            milkTruck.setLayoutX(x+50);
            milkTruck.setLayoutY(y);
            milkTruck.setPrefWidth(40);
            milkTruck.setPrefHeight(40);

            milkButton.setText("remove");
            milkButton.setLayoutX(x+225);
            milkButton.setLayoutY(y);
            milkButton.setPrefWidth(75);
            milkButton.setPrefHeight(40);
            milkButton.setOnAction(event -> {
                if (truck.getMilk()>0) {
                    truck.setMilk(-1);
                    wareHouse.setMilk(1);
                    milkTruck.setText(Integer.toString(truck.getMilk()));
                    milkWarehouse.setText(Integer.toString(wareHouse.getMilk()));
                    totalGold.setText(Integer.toString(Integer.parseInt(totalGold.getText())-25));
                }
                if (truck.getMilk()==0){
                    anchorPane.getChildren().remove(milkImage);
                    anchorPane.getChildren().remove(milkTruck);
                    anchorPane.getChildren().remove(milkButton);
                }
            });

            anchorPane.getChildren().add(milkImage);
            anchorPane.getChildren().add(milkTruck);
            anchorPane.getChildren().add(milkButton);

            y+=43;
        }
        if (truck.getFlour()>0){
            Image image =new Image(getClass().getResource("../img/products/flour.png").toExternalForm());
            flourImage.setImage(image);
            flourImage.setX(x);
            flourImage.setY(y);
            flourImage.setFitWidth(40);
            flourImage.setFitHeight(40);
            flourTruck.setText(Integer.toString(truck.getFlour()));
            flourTruck.setLayoutX(x+50);
            flourTruck.setLayoutY(y);
            flourTruck.setPrefWidth(40);
            flourTruck.setPrefHeight(40);

            flourButton.setText("remove");
            flourButton.setLayoutX(x+225);
            flourButton.setLayoutY(y);
            flourButton.setPrefWidth(75);
            flourButton.setPrefHeight(40);
            flourButton.setOnAction(event -> {
                if (truck.getFlour()>0) {
                    truck.setFlour(-1);
                    wareHouse.setFlour(1);
                    flourTruck.setText(Integer.toString(truck.getFlour()));
                    flourWarehouse.setText(Integer.toString(wareHouse.getFlour()));
                    totalGold.setText(Integer.toString(Integer.parseInt(totalGold.getText())-40));
                }
                if (truck.getFlour()==0){
                    anchorPane.getChildren().remove(flourImage);
                    anchorPane.getChildren().remove(flourTruck);
                    anchorPane.getChildren().remove(flourButton);
                }
            });

            anchorPane.getChildren().add(flourImage);
            anchorPane.getChildren().add(flourTruck);
            anchorPane.getChildren().add(flourButton);

            y+=43;
        }
        if (truck.getCloth()>0){
            Image image =new Image(getClass().getResource("../img/products/cloth.png").toExternalForm());
            clothImage.setImage(image);
            clothImage.setX(x);
            clothImage.setY(y);
            clothImage.setFitWidth(40);
            clothImage.setFitHeight(40);

            clothTruck.setText(Integer.toString(truck.getCloth()));
            clothTruck.setLayoutX(x+50);
            clothTruck.setLayoutY(y);
            clothTruck.setPrefWidth(40);
            clothTruck.setPrefHeight(40);

            clothButton.setText("remove");
            clothButton.setLayoutX(x+225);
            clothButton.setLayoutY(y);
            clothButton.setPrefWidth(75);
            clothButton.setPrefHeight(40);
            clothButton.setOnAction(event -> {
                if (truck.getCloth()>0) {
                    truck.setCloth(-1);
                    wareHouse.setCloth(1);
                    clothTruck.setText(Integer.toString(truck.getCloth()));
                    clothWarehouse.setText(Integer.toString(wareHouse.getCloth()));
                    totalGold.setText(Integer.toString(Integer.parseInt(totalGold.getText())-50));
                }
                if (truck.getCloth()==0){
                    anchorPane.getChildren().remove(clothImage);
                    anchorPane.getChildren().remove(clothTruck);
                    anchorPane.getChildren().remove(clothButton);
                }
            });

            anchorPane.getChildren().add(clothImage);
            anchorPane.getChildren().add(clothTruck);
            anchorPane.getChildren().add(clothButton);

            y+=43;
        }
        if (truck.getPocketMilk()>0){
            Image image =new Image(getClass().getResource("../img/products/pocketMilk.png").toExternalForm());
            pocketMilkImage.setImage(image);
            pocketMilkImage.setX(x);
            pocketMilkImage.setY(y);
            pocketMilkImage.setFitWidth(40);
            pocketMilkImage.setFitHeight(40);

            pocketMilkTruck.setText(Integer.toString(truck.getPocketMilk()));
            pocketMilkTruck.setLayoutX(x+50);
            pocketMilkTruck.setLayoutY(y);
            pocketMilkTruck.setPrefWidth(40);
            pocketMilkTruck.setPrefHeight(40);

            pocketMilkButton.setText("remove");
            pocketMilkButton.setLayoutX(x+225);
            pocketMilkButton.setLayoutY(y);
            pocketMilkButton.setPrefWidth(75);
            pocketMilkButton.setPrefHeight(40);
            pocketMilkButton.setOnAction(event -> {
                if (truck.getPocketMilk()>0) {
                    truck.setPocketMilk(-1);
                    wareHouse.setPocketMilk(1);
                    pocketMilkTruck.setText(Integer.toString(truck.getPocketMilk()));
                    pocketWarehouse.setText(Integer.toString(wareHouse.getPocketMilk()));
                    totalGold.setText(Integer.toString(Integer.parseInt(totalGold.getText())-60));
                }
                if (truck.getPocketMilk()==0){
                    anchorPane.getChildren().remove(pocketMilkImage);
                    anchorPane.getChildren().remove(pocketMilkTruck);
                    anchorPane.getChildren().remove(pocketMilkButton);
                }
            });

            anchorPane.getChildren().add(pocketMilkImage);
            anchorPane.getChildren().add(pocketMilkTruck);
            anchorPane.getChildren().add(pocketMilkButton);

            y+=43;
        }
        if (truck.getBread()>0){
            Image image =new Image(getClass().getResource("../img/products/bread.png").toExternalForm());
            breadImage.setImage(image);
            breadImage.setX(x);
            breadImage.setY(y);
            breadImage.setFitWidth(40);
            breadImage.setFitHeight(40);

            breadTruck.setText(Integer.toString(truck.getBread()));
            breadTruck.setLayoutX(x+50);
            breadTruck.setLayoutY(y);
            breadTruck.setPrefWidth(40);
            breadTruck.setPrefHeight(40);

            breadButton.setText("remove");
            breadButton.setLayoutX(x+225);
            breadButton.setLayoutY(y);
            breadButton.setPrefWidth(75);
            breadButton.setPrefHeight(40);
            breadButton.setOnAction(event -> {
                if (truck.getBread()>0) {
                    truck.setBread(-1);
                    wareHouse.setBread(1);
                    breadTruck.setText(Integer.toString(truck.getBread()));
                    breadWarehouse.setText(Integer.toString(wareHouse.getBread()));
                    totalGold.setText(Integer.toString(Integer.parseInt(totalGold.getText())-80));
                }
                if (truck.getBread()==0){
                    anchorPane.getChildren().remove(breadImage);
                    anchorPane.getChildren().remove(breadTruck);
                    anchorPane.getChildren().remove(breadButton);
                }
            });

            anchorPane.getChildren().add(breadImage);
            anchorPane.getChildren().add(breadTruck);
            anchorPane.getChildren().add(breadButton);

            y+=43;
        }
        if (truck.getShirt()>0){
            Image image =new Image(getClass().getResource("../img/products/shirt.png").toExternalForm());
            shirtImage.setImage(image);
            shirtImage.setX(x);
            shirtImage.setY(y);
            shirtImage.setFitWidth(40);
            shirtImage.setFitHeight(40);

            shirtTruck.setText(Integer.toString(truck.getShirt()));
            shirtTruck.setLayoutX(x+50);
            shirtTruck.setLayoutY(y);
            shirtTruck.setPrefWidth(40);
            shirtTruck.setPrefHeight(40);

            shirtButton.setText("remove");
            shirtButton.setLayoutX(x+225);
            shirtButton.setLayoutY(y);
            shirtButton.setPrefWidth(75);
            shirtButton.setPrefHeight(40);
            shirtButton.setOnAction(event -> {
                if (truck.getShirt()>0) {
                    truck.setShirt(-1);
                    wareHouse.setShirt(1);
                    shirtTruck.setText(Integer.toString(truck.getShirt()));
                    shirtWarehouse.setText(Integer.toString(wareHouse.getShirt()));
                    totalGold.setText(Integer.toString(Integer.parseInt(totalGold.getText())-100));
                }
                if (truck.getShirt()==0){
                    anchorPane.getChildren().remove(shirtImage);
                    anchorPane.getChildren().remove(shirtTruck);
                    anchorPane.getChildren().remove(shirtButton);
                }
            });

            anchorPane.getChildren().add(shirtImage);
            anchorPane.getChildren().add(shirtTruck);
            anchorPane.getChildren().add(shirtButton);

            y+=43;
        }
        if (truck.getIceCream()>0){
            Image image =new Image(getClass().getResource("../img/products/iceCream.png").toExternalForm());
            iceCreamImage.setImage(image);
            iceCreamImage.setX(x);
            iceCreamImage.setY(y);
            iceCreamImage.setFitWidth(40);
            iceCreamImage.setFitHeight(40);

            iceCreamTruck.setText(Integer.toString(truck.getIceCream()));
            iceCreamTruck.setLayoutX(x+50);
            iceCreamTruck.setLayoutY(y);
            iceCreamTruck.setPrefWidth(40);
            iceCreamTruck.setPrefHeight(40);

            iceCreamButton.setText("remove");
            iceCreamButton.setLayoutX(x+225);
            iceCreamButton.setLayoutY(y);
            iceCreamButton.setPrefWidth(75);
            iceCreamButton.setPrefHeight(40);
            iceCreamButton.setOnAction(event -> {
                if (truck.getIceCream()>0) {
                    truck.setIceCream(-1);
                    wareHouse.setIceCream(1);
                    iceCreamTruck.setText(Integer.toString(truck.getIceCream()));
                    iceCreamWarehouse.setText(Integer.toString(wareHouse.getIceCream()));
                    totalGold.setText(Integer.toString(Integer.parseInt(totalGold.getText())-120));
                }
                if (truck.getIceCream()==0){
                    anchorPane.getChildren().remove(iceCreamImage);
                    anchorPane.getChildren().remove(iceCreamTruck);
                    anchorPane.getChildren().remove(iceCreamButton);
                }
            });

            anchorPane.getChildren().add(iceCreamImage);
            anchorPane.getChildren().add(iceCreamTruck);
            anchorPane.getChildren().add(iceCreamButton);

            y+=43;
        }
        if (truck.getLion()>0){
            Image image =new Image(getClass().getResource("../img/products/CagedLion.png").toExternalForm());
            cagedLionImage.setImage(image);
            cagedLionImage.setX(x);
            cagedLionImage.setY(y);
            cagedLionImage.setFitWidth(40);
            cagedLionImage.setFitHeight(40);

            cagedLionTruck.setText(Integer.toString(truck.getLion()));
            cagedLionTruck.setLayoutX(x+50);
            cagedLionTruck.setLayoutY(y);
            cagedLionTruck.setPrefWidth(40);
            cagedLionTruck.setPrefHeight(40);

            cagedLionButton.setText("remove");
            cagedLionButton.setLayoutX(x+225);
            cagedLionButton.setLayoutY(y);
            cagedLionButton.setPrefWidth(75);
            cagedLionButton.setPrefHeight(40);
            cagedLionButton.setOnAction(event -> {
                if (truck.getLion()>0) {
                    truck.setLion(-1);
                    wareHouse.setLion(1);
                    cagedLionTruck.setText(Integer.toString(truck.getLion()));
                    cagedLionWareHouse.setText(Integer.toString(wareHouse.getLion()));
                    totalGold.setText(Integer.toString(Integer.parseInt(totalGold.getText())-300));
                }
                if (truck.getLion()==0){
                    anchorPane.getChildren().remove(cagedLionImage);
                    anchorPane.getChildren().remove(cagedLionTruck);
                    anchorPane.getChildren().remove(cagedLionButton);
                }
            });

            anchorPane.getChildren().add(cagedLionImage);
            anchorPane.getChildren().add(cagedLionTruck);
            anchorPane.getChildren().add(cagedLionButton);

            y+=43;
        }
        if (truck.getTurkey()>0){
            Image image =new Image(getClass().getResource("../img/products/turkey.png").toExternalForm());
            turkeyImage.setImage(image);
            turkeyImage.setX(x);
            turkeyImage.setY(y);
            turkeyImage.setFitWidth(40);
            turkeyImage.setFitHeight(40);

            turkeyTruck.setText(Integer.toString(truck.getTurkey()));
            turkeyTruck.setLayoutX(x+50);
            turkeyTruck.setLayoutY(y);
            turkeyTruck.setPrefWidth(40);
            turkeyTruck.setPrefHeight(40);

            turkeyButton.setText("remove");
            turkeyButton.setLayoutX(x+225);
            turkeyButton.setLayoutY(y);
            turkeyButton.setPrefWidth(75);
            turkeyButton.setPrefHeight(40);
            turkeyButton.setOnAction(event -> {
                if (truck.getTurkey()>0) {
                    truck.setTurkey(-1);
                    wareHouse.setTurkey(1);
                    turkeyTruck.setText(Integer.toString(truck.getTurkey()));
                    turkeyWareHouse.setText(Integer.toString(wareHouse.getTurkey()));
                    totalGold.setText(Integer.toString(Integer.parseInt(totalGold.getText())-50));
                }
                if (truck.getTurkey()==0){
                    anchorPane.getChildren().remove(turkeyImage);
                    anchorPane.getChildren().remove(turkeyTruck);
                    anchorPane.getChildren().remove(turkeyButton);
                }
            });

            anchorPane.getChildren().add(turkeyImage);
            anchorPane.getChildren().add(turkeyTruck);
            anchorPane.getChildren().add(turkeyButton);

            y+=43;
        }
        if (truck.getOstrich()>0){
            Image image =new Image(getClass().getResource("../img/products/ostrich.png").toExternalForm());
            ostrichImage.setImage(image);
            ostrichImage.setX(x);
            ostrichImage.setY(y);
            ostrichImage.setFitWidth(40);
            ostrichImage.setFitHeight(40);

            ostrichTruck.setText(Integer.toString(truck.getOstrich()));
            ostrichTruck.setLayoutX(x+50);
            ostrichTruck.setLayoutY(y);
            ostrichTruck.setPrefWidth(40);
            ostrichTruck.setPrefHeight(40);

            ostrichButton.setText("remove");
            ostrichButton.setLayoutX(x+225);
            ostrichButton.setLayoutY(y);
            ostrichButton.setPrefWidth(75);
            ostrichButton.setPrefHeight(40);
            ostrichButton.setOnAction(event -> {
                if (truck.getOstrich()>0) {
                    truck.setOstrich(-1);
                    wareHouse.setOstrich(1);
                    ostrichTruck.setText(Integer.toString(truck.getOstrich()));
                    ostrichWareHouse.setText(Integer.toString(wareHouse.getOstrich()));
                    totalGold.setText(Integer.toString(Integer.parseInt(totalGold.getText())-100));
                }
                if (truck.getOstrich()==0){
                    anchorPane.getChildren().remove(ostrichImage);
                    anchorPane.getChildren().remove(ostrichTruck);
                    anchorPane.getChildren().remove(ostrichButton);
                }
            });

            anchorPane.getChildren().add(ostrichImage);
            anchorPane.getChildren().add(ostrichTruck);
            anchorPane.getChildren().add(ostrichButton);

            y+=43;
        }
        if (truck.getBuffalo()>0){
            Image image =new Image(getClass().getResource("../img/products/buffalo.png").toExternalForm());
            buffaloImage.setImage(image);
            buffaloImage.setX(x);
            buffaloImage.setY(y);
            buffaloImage.setFitWidth(40);
            buffaloImage.setFitHeight(40);

            buffaloTruck.setText(Integer.toString(truck.getBuffalo()));
            buffaloTruck.setLayoutX(x+50);
            buffaloTruck.setLayoutY(y);
            buffaloTruck.setPrefWidth(40);
            buffaloTruck.setPrefHeight(40);

            buffaloButton.setText("remove");
            buffaloButton.setLayoutX(x+225);
            buffaloButton.setLayoutY(y);
            buffaloButton.setPrefWidth(75);
            buffaloButton.setPrefHeight(40);
            buffaloButton.setOnAction(event -> {
                if (truck.getBuffalo()>0) {
                    truck.setBuffalo(-1);
                    wareHouse.setBuffalo(1);
                    buffaloTruck.setText(Integer.toString(truck.getBuffalo()));
                    buffaloWareHouse.setText(Integer.toString(wareHouse.getBuffalo()));
                    totalGold.setText(Integer.toString(Integer.parseInt(totalGold.getText())-200));
                }
                if (truck.getBuffalo()==0){
                    anchorPane.getChildren().remove(buffaloImage);
                    anchorPane.getChildren().remove(buffaloTruck);
                    anchorPane.getChildren().remove(buffaloButton);
                }
            });

            anchorPane.getChildren().add(buffaloImage);
            anchorPane.getChildren().add(buffaloTruck);
            anchorPane.getChildren().add(buffaloButton);
            y+=43;
        }
    }
}
