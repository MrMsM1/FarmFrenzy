package AllClasses;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.ImagePattern;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Game implements Initializable {
    @FXML
    private AnchorPane anchorPane;
    private Well well=new Well("../img/well/1.png");
    private Bakery bakery;
    private FabricWeaving fabricWeaving;
    private Tailoring tailoring;
    private WareHouse wareHouse=new WareHouse();
    private IceCreamShop iceCreamShop;
    private Mill mill;
    private MilkPacking milkPacking;
    MediaPlayer mediaPlayer;
    Lion lion;
    @FXML
    private Label time;
    @FXML
    private Button addTurkey;
    @FXML
    private Button addOstrich;
    @FXML
    private Button addBuffalo;
    @FXML
    private Button addDog;
    @FXML
    private Button addCat;
    @FXML
    private Button wellButton;
    @FXML
    private Button millWork;
    private Product product;
    @FXML
    private Button showWareHouse;
    @FXML
    private ImageView fabricWeavingImage;
    @FXML
    private ImageView iceCreamShopImage;
    @FXML
    private ImageView bakeryImage;
    @FXML
    private ImageView millImage;
    @FXML
    private ImageView tailoringImage;
    @FXML
    private ImageView milkPackingImage;
    @FXML
    private Button buildMill;
    @FXML
    private Button buildBakery;
    @FXML
    private Button buildIceCreamShop;
    @FXML
    private Button buildFabricWeaving;
    @FXML
    private Button buildMilkPacking;
    @FXML
    private Button buildTailoring;
    @FXML
    private Label gold;

    @FXML
    private ImageView task1;
    @FXML
    private ImageView task2;
    @FXML
    private ImageView task3;
    @FXML
    private Label task01;
    @FXML
    private Label task02;
    @FXML
    private Label task03;
    private int coin;
    private boolean truck=false;
    @FXML
    private Button menu;
    private Incubator incubator;
    public void pushMenu(ActionEvent actionEvent) throws IOException {
        stopAll();
        PauseLoader.display();
        for (int i = 0; i < Cat.catAnimation.size(); i++) {
            Cat.catAnimation.get(i).play();
        }
        for (int i = 0; i < Dog.dogAnimations.size(); i++) {
            Dog.dogAnimations.get(i).play();
        }
        for (int i = 0; i < Lion.lionAnimations.size(); i++) {
            Lion.lionAnimations.get(i).play();
        }
        for (int i = 0; i < Turkey.turkeyAnimations.size(); i++) {
            Turkey.turkeyAnimations.get(i).play();
        }
        for (int i = 0; i < Ostrich.ostrichAnimations.size(); i++) {
            Ostrich.ostrichAnimations.get(i).play();
        }
        for (int i = 0; i < Buffalo.buffaloAnimations.size(); i++) {
            Buffalo.buffaloAnimations.get(i).play();
        }
        for (int i = 0; i < Product.productAnimations.size(); i++) {
            Product.productAnimations.get(i).play();
        }
        time1.play();
    }
    public void buildMill(){
        if (coin>=100) {
            anchorPane.getChildren().removeAll(buildMill, millImage);
            mill = new Mill(Product.products, anchorPane);
            mill.setFill(new ImagePattern(new Image(getClass().getResource("../img/factories/millLevel1/mill_1.png").toExternalForm())));
            mill.setOnMouseClicked(event -> {
                if (wareHouse.getEgg()>0) {
                    mill.Start();
                    wareHouse.setEgg(-1);
                }
            });
            anchorPane.getChildren().add(mill);
            coin-=100;
            gold.setText(Integer.toString(coin));
        }
    }
    public void buildBakery(){
        if (coin>200) {
            anchorPane.getChildren().removeAll(buildBakery, bakeryImage);
            bakery = new Bakery(Product.products, anchorPane);
            bakery.setFill(new ImagePattern(new Image(getClass().getResource("../img/factories/bakeryLevel1/bakery_1.png").toExternalForm())));
            bakery.setOnMouseClicked(event -> {
                if (wareHouse.getFlour()>0) {
                    bakery.Start();
                    wareHouse.setFlour(-1);
                }
            });
            anchorPane.getChildren().add(bakery);
            coin-=200;
            gold.setText(Integer.toString(coin));
        }
    }
    public void buildFabricWeaving(){
        if (coin>200) {
            anchorPane.getChildren().removeAll(buildFabricWeaving, fabricWeavingImage);
            fabricWeaving = new FabricWeaving(Product.products, anchorPane);
            fabricWeaving.setFill(new ImagePattern(new Image(getClass().getResource("../img/factories/fabricWeavingLevel1/fabricWeaving_1.png").toExternalForm())));
            fabricWeaving.setOnMouseClicked(event -> {
                if (wareHouse.getCloth()>0) {
                    fabricWeaving.Start();
                    wareHouse.setCloth(-1);
                }
            });
            anchorPane.getChildren().add(fabricWeaving);
            coin-=200;
            gold.setText(Integer.toString(coin));
        }
    }
    public void buildTailoring(){
        if (coin>=100) {
            anchorPane.getChildren().removeAll(buildTailoring, tailoringImage);
            tailoring = new Tailoring(Product.products, anchorPane);
            tailoring.setFill(new ImagePattern(new Image(getClass().getResource("../img/factories/tailoringLevel1/tailoring_1.png").toExternalForm())));
            tailoring.setOnMouseClicked(event -> {
                if (wareHouse.getFeather()>0){
                    tailoring.Start();
                    wareHouse.setFeather(-1);
                }

            });
            anchorPane.getChildren().add(tailoring);
            coin-=100;
            gold.setText(Integer.toString(coin));
        }
    }
    public void buildIceCream(){
        if (coin>=200) {
            anchorPane.getChildren().removeAll(buildIceCreamShop, iceCreamShopImage);
            iceCreamShop = new IceCreamShop(Product.products, anchorPane);
            iceCreamShop.setFill(new ImagePattern(new Image(getClass().getResource("../img/factories/iceCreamShop/iceCream_1.png").toExternalForm())));
            iceCreamShop.setOnMouseClicked(event -> {
                if (wareHouse.getPocketMilk()>0) {
                    iceCreamShop.Start();
                    wareHouse.setPocketMilk(-1);
                }
            });
            anchorPane.getChildren().add(iceCreamShop);
            coin-=200;
            gold.setText(Integer.toString(coin));
        }
    }
    public void buildMilkPacking(){
        if (coin>=100) {
            anchorPane.getChildren().removeAll(buildMilkPacking, milkPackingImage);
            milkPacking = new MilkPacking(Product.products, anchorPane);
            milkPacking.setFill(new ImagePattern(new Image(getClass().getResource("../img/factories/milkPacking/milkPacking_1.png").toExternalForm())));
            milkPacking.setOnMouseClicked(event -> {
                if (wareHouse.getMilk()>0){
                    milkPacking.Start();
                    wareHouse.setMilk(-1);
                }

            });
            anchorPane.getChildren().add(milkPacking);
            coin-=100;
            gold.setText(Integer.toString(coin));
        }
    }



    // private Cat cat=new Cat(500,500);
    public void pushAddTurkey(ActionEvent actionEvent){
        if (coin>=100) {
            Turkey t = new Turkey(350, 300, anchorPane);
            t.setFill(new ImagePattern(new Image(getClass().getResource("../img/turkey/turkeyLeft/left_1.png").toExternalForm())));
            anchorPane.getChildren().add(t);
            coin-=100;
            gold.setText(Integer.toString(coin));
        }
    }
    public void pushAddOstrich(ActionEvent actionEvent){
        if (coin>=200) {
            Ostrich o = new Ostrich(500, 400, anchorPane);
            o.setFill(new ImagePattern(new Image(getClass().getResource("../img/ostrich/ostrichLeft/left_1.png").toExternalForm())));
            anchorPane.getChildren().add(o);
            coin-=200;
            gold.setText(Integer.toString(coin));
        }
    }
    public void pushAddBuffalo(ActionEvent actionEvent){
        if (coin>=400) {
            Buffalo b = new Buffalo(300, 300, anchorPane);
            b.setFill(new ImagePattern(new Image(getClass().getResource("../img/factories/bakeryLevel1/bakery_1.png").toExternalForm())));
            anchorPane.getChildren().add(b);
            coin-=400;
            gold.setText(Integer.toString(coin));
        }
    }
    public void pushAddDog(ActionEvent actionEvent){
        if (coin>=100) {
            Dog d = new Dog(400, 400, anchorPane);
            d.setFill(new ImagePattern(new Image(getClass().getResource("../img/dog/dogLeft/left_1.png").toExternalForm())));
            anchorPane.getChildren().add(d);
            coin-=100;
            gold.setText(Integer.toString(coin));
        }
    }
    public void pushAddCat(ActionEvent actionEvent){
        if (coin>=150) {
            Cat cat1 = new Cat(500, 500, anchorPane, wareHouse);
            cat1.setFill(new ImagePattern(new Image(getClass().getResource("../img/cat/catLeft/left_1.png").toExternalForm())));
            anchorPane.getChildren().addAll(cat1);
            coin-=150;
            gold.setText(Integer.toString(coin));
        }
    }
    public void pushWareHouse() throws IOException {
        if (!truck) {
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
            wareHouseData += Turkey.turkeys.size() + " ";
            wareHouseData += Ostrich.ostriches.size() + " ";
            wareHouseData += Buffalo.buffalo.size() + " ";
            try {
                FileWriter oredrDataWriter = new FileWriter("wareHouseData.txt");
                oredrDataWriter.write(wareHouseData);
                oredrDataWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            stopAll();
            WareHouseLoader.display("asd", "asd", "asd");
            String readerInfo = "";
            try {
                File person = new File("tempTruck.txt");
                if (person.createNewFile()) {
                    Scanner myReader = new Scanner(person);
                }
                Scanner myReader = new Scanner(person);
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    readerInfo = data;
                }
                myReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (Integer.parseInt(readerInfo) > 0) {
                truck=true;
                TruckG truckG=new TruckG(anchorPane);
                String finalReaderInfo = readerInfo;
                TruckG.truckGAnimation.setOnFinished(event -> {
                    truck=false;
                    anchorPane.getChildren().remove(truckG);
                    String[] qqbanbang = new String[12];

                    boolean isthere = false;
                    try {
                        File person = new File("wareHouseData.txt");
                        if (person.createNewFile()) {
                            Scanner myReader = new Scanner(person);
                        }
                        Scanner myReader = new Scanner(person);
                        while (myReader.hasNextLine()) {
                            String data = myReader.nextLine();
                            qqbanbang =data.split("\\s");
                        }
                        myReader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    wareHouse.setEgg(Integer.parseInt(qqbanbang[0])-wareHouse.getEgg());
                    wareHouse.setFeather(Integer.parseInt(qqbanbang[1])-wareHouse.getFeather());
                    wareHouse.setMilk(Integer.parseInt(qqbanbang[2])-wareHouse.getMilk());
                    wareHouse.setFlour(Integer.parseInt(qqbanbang[3])-wareHouse.getFlour());
                    wareHouse.setCloth(Integer.parseInt(qqbanbang[4])-wareHouse.getCloth());
                    wareHouse.setPocketMilk(Integer.parseInt(qqbanbang[5])-wareHouse.getPocketMilk());
                    wareHouse.setBread(Integer.parseInt(qqbanbang[6])-wareHouse.getBread());
                    wareHouse.setShirt(Integer.parseInt(qqbanbang[7])-wareHouse.getShirt());
                    wareHouse.setIceCream(Integer.parseInt(qqbanbang[8])-wareHouse.getIceCream());
                    wareHouse.setLion(Integer.parseInt(qqbanbang[9])-wareHouse.getLion());
                    coin+=Integer.parseInt(finalReaderInfo);
                    gold.setText(Integer.toString(coin));
                    for (int i = 0; i < Turkey.turkeys.size()-Integer.parseInt(qqbanbang[10]); i++) {
                        Turkey.turkeyAnimations.get(0).turkey.remove(Turkey.turkeyAnimations.get(0).turkey,0);
                    }

                });
                truckG.play();

            }
            for (int i = 0; i < Cat.catAnimation.size(); i++) {
                Cat.catAnimation.get(i).play();
            }
            for (int i = 0; i < Dog.dogAnimations.size(); i++) {
                Dog.dogAnimations.get(i).play();
            }
            for (int i = 0; i < Lion.lionAnimations.size(); i++) {
                Lion.lionAnimations.get(i).play();
            }
            for (int i = 0; i < Turkey.turkeyAnimations.size(); i++) {
                Turkey.turkeyAnimations.get(i).play();
            }
            for (int i = 0; i < Ostrich.ostrichAnimations.size(); i++) {
                Ostrich.ostrichAnimations.get(i).play();
            }
            for (int i = 0; i < Buffalo.buffaloAnimations.size(); i++) {
                Buffalo.buffaloAnimations.get(i).play();
            }
            for (int i = 0; i < Product.productAnimations.size(); i++) {
                Product.productAnimations.get(i).play();
            }
            time1.play();
        }
    }
    public  void pushMill(ActionEvent actionEvent){
        mill.Start();
    }
    public void pushWellButton(ActionEvent actionEvent){
        if (well.fullness==0) {
            well.fillTheWell();
        }
    }
    static Time time1;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        Random random=new Random();
        time1=new Time(time,anchorPane);
        time1.play();
        incubator=new Incubator(Product.products,anchorPane);
        incubator.setFill(new ImagePattern(new Image(getClass().getResource("../img\\factories\\incubator/1.png").toExternalForm())));
        incubator.setOnMouseClicked(event -> {
            if (wareHouse.getEgg()>0) {
                incubator.Start();
                wareHouse.setEgg(-1);
            }
        });
        anchorPane.getChildren().add(incubator);
        //reading level info
        if (Menu.chosenLevel==1){
            Image image=new Image(getClass().getResource("../img/products/egg.png").toExternalForm());
            task1.setImage(image);
            task01.setText(wareHouse.getEgg()+"/5");
            image=new Image(getClass().getResource("../img/products/flour.png").toExternalForm());
            task2.setImage(image);
            task02.setText(wareHouse.getFlour()+"/2");
            image=new Image(getClass().getResource("../img/products/bread.png").toExternalForm());
            task3.setImage(image);
            task03.setText(wareHouse.getBread()+"/1");
            coin=2600;
            gold.setText(Integer.toString(coin));
        }
        else if (Menu.chosenLevel==2){
            Image image=new Image(getClass().getResource("../img/products/egg.png").toExternalForm());
            task1.setImage(image);
            task01.setText(wareHouse.getEgg()+"/10");
            image=new Image(getClass().getResource("../img/products/milk.png").toExternalForm());
            task2.setImage(image);
            task02.setText(wareHouse.getMilk()+"/3");
            image=new Image(getClass().getResource("../img/products/pocketMilk.png").toExternalForm());
            task3.setImage(image);
            task03.setText(wareHouse.getPocketMilk()+"/1");
            coin=3000;
            gold.setText(Integer.toString(coin));
        }
        else if (Menu.chosenLevel==3){
            Image image=new Image(getClass().getResource("../img/products/feather.png").toExternalForm());
            task1.setImage(image);
            task01.setText(wareHouse.getFeather()+"/5");
            image=new Image(getClass().getResource("../img/products/cloth.png").toExternalForm());
            task2.setImage(image);
            task02.setText(wareHouse.getCloth()+"/3");
            image=new Image(getClass().getResource("../img/products/shirt.png").toExternalForm());
            task3.setImage(image);
            task03.setText(wareHouse.getShirt()+"/1");
            coin=2600;
            gold.setText(Integer.toString(coin));
        }
        else if (Menu.chosenLevel==4){
            Image image=new Image(getClass().getResource("../img/products/flour.png").toExternalForm());
            task1.setImage(image);
            task01.setText(wareHouse.getFlour()+"/5");
            image=new Image(getClass().getResource("../img/products/cloth.png").toExternalForm());
            task2.setImage(image);
            task02.setText(wareHouse.getCloth()+"/5");
            image=new Image(getClass().getResource("../img/products/pocketMilk.png").toExternalForm());
            task3.setImage(image);
            task03.setText(wareHouse.getPocketMilk()+"/5");
            coin=2600;
            gold.setText(Integer.toString(coin));
        }
        else if (Menu.chosenLevel==5){
            Image image=new Image(getClass().getResource("../img/products/bread.png").toExternalForm());
            task1.setImage(image);
            task01.setText(wareHouse.getBread()+"/5");
            image=new Image(getClass().getResource("../img/products/shirt.png").toExternalForm());
            task2.setImage(image);
            task02.setText(wareHouse.getShirt()+"/5");
            image=new Image(getClass().getResource("../img/products/iceCream.png").toExternalForm());
            task3.setImage(image);
            task03.setText(wareHouse.getIceCream()+"/5");
            coin=2600;
            gold.setText(Integer.toString(coin));
        }



        anchorPane.getChildren().addAll(well,wareHouse);//,bakery,fabricWeaving,tailoring,mill,wareHouse,iceCreamShop,milkPacking);
        well.setFill(new ImagePattern(new Image(getClass().getResource("../img/well/1.png").toExternalForm())));
        wareHouse.setFill(new ImagePattern(new Image(getClass().getResource("../img/wareHouse.png").toExternalForm())));
        wareHouse.setOnMousePressed(event -> {
            try {
                pushWareHouse();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        anchorPane.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                boolean find=false;
                int index=0;
                for (int i=0;i<Product.products.size();i++)
                {
                    if(Math.abs(event.getX()-Product.products.get(i).getX())<50 && Math.abs(event.getY()-Product.products.get(i).getY())<50 && Product.products.get(i).getSize()<=30-wareHouse.getFullness())
                    {
                        find=true;
                        if (Product.products.get(i).getName().equals("egg")){
                            wareHouse.setEgg(1);
                        }
                        else if (Product.products.get(i).getName().equalsIgnoreCase("flour")){
                            wareHouse.setFlour(1);
                        }
                        else if (Product.products.get(i).getName().equalsIgnoreCase("milk")){
                            wareHouse.setMilk(1);
                        }
                        else if (Product.products.get(i).getName().equalsIgnoreCase("bread")){
                            wareHouse.setBread(1);
                        }
                        else if (Product.products.get(i).getName().equalsIgnoreCase("shirt")){
                            wareHouse.setShirt(1);
                        }
                        else if (Product.products.get(i).getName().equalsIgnoreCase("pocketMilk")){
                            wareHouse.setPocketMilk(1);
                        }
                        else if (Product.products.get(i).getName().equalsIgnoreCase("feather")){
                            wareHouse.setFeather(1);
                        }
                        else if (Product.products.get(i).getName().equalsIgnoreCase("iceCream")){
                            wareHouse.setIceCream(1);
                        }
                        else if (Product.products.get(i).getName().equalsIgnoreCase("cloth")){
                            wareHouse.setCloth(1);
                        }
                        if (Menu.chosenLevel==1) {
                            if (!task01.getText().equals("5/5")) {
                                task01.setText(wareHouse.getEgg() + "/5");
                            }
                            if (!task02.getText().equals("2/2")) {
                                task02.setText(wareHouse.getFlour() + "/2");
                            }
                            if (!task03.getText().equals("1/1")) {
                                task03.setText(wareHouse.getBread() + "/1");
                            }
                        }
                        if (Menu.chosenLevel==2){
                            if (!task01.getText().equals("10/10")) {
                                task01.setText(wareHouse.getEgg() + "/10");
                            }
                            if (!task02.getText().equals("3/3")){
                                task02.setText(wareHouse.getMilk() + "/3");
                            }
                            if (!task03.getText().equals("1/1")){
                                task03.setText(wareHouse.getPocketMilk() + "/1");
                            }
                        }
                        else if (Menu.chosenLevel==3){
                            if (!task01.getText().equals("5/5")) {
                                task01.setText(wareHouse.getFeather() + "/5");
                            }
                            if (!task02.getText().equals("3/3")){
                                task02.setText(wareHouse.getCloth() + "/3");
                            }
                            if (!task03.getText().equals("1/1")){
                                task03.setText(wareHouse.getShirt() + "/1");
                            }
                        }
                        else if (Menu.chosenLevel==4){
                            if (!task01.getText().equals("5/5")) {
                                task01.setText(wareHouse.getFlour() + "/5");
                            }
                            if (!task02.getText().equals("5/5")){
                                task02.setText(wareHouse.getCloth() + "/5");
                            }
                            if (!task03.getText().equals("5/5")){
                                task03.setText(wareHouse.getPocketMilk() + "/5");
                            }
                        }
                        else if (Menu.chosenLevel==5){
                            if (!task01.getText().equals("5/5")) {
                                task01.setText(wareHouse.getBread()+"/5");
                            }
                            if (!task02.getText().equals("5/5")){
                                task02.setText(wareHouse.getShirt()+"/5");
                            }
                            if (!task03.getText().equals("5/5")){
                                task03.setText(wareHouse.getIceCream()+"/5");
                            }
                        }
                        try {
                            checkLevelFinished();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        anchorPane.getChildren().remove(Product.products.get(i));
                        Product.products.remove(i);
                        Product.productAnimations.get(i).stop();
                        Product.productAnimations.remove(i);

                    }
                    else if(Math.abs(event.getX()-Product.products.get(i).getX())<50 && Math.abs(event.getY()-Product.products.get(i).getY())<50)
                        find=true;
                }
                if(!find) {
                    if (event.getX()>240&&event.getX()<830 && event.getY()>230 &&event.getY()<620 && well.getFullness()>0) {
                         well.setFullness(well.getFullness()-1);
                         Grass g = new Grass((int) event.getX(), (int) event.getY(), anchorPane);
                    }
                }

                for (int i = 0; i < Lion.lionAnimations.size(); i++) {
                    if(Math.abs(event.getX()-Lion.lionAnimations.get(i).lion.getX())<100 && Math.abs(event.getY()-Lion.lionAnimations.get(i).lion.getY())<100 ) {
                        if (Lion.lionAnimations.get(i).added) {
                            Lion.lionAnimations.get(i).cage.level++;
                            if (Lion.lionAnimations.get(i).cage.level>=3) {
                                Lion.lionAnimations.get(i).clone=Lion.lionAnimations.get(i).cage.level;
                                if (Lion.lionAnimations.get(i).cage.level==4){
                                    wareHouse.setLion(1);
                                }
                                Lion.lionAnimations.get(i).cage.level = 3;

                            }

                            Lion.lionAnimations.get(i).cage.setFill(new ImagePattern(new Image(getClass().getResource("../img/cage/" + Lion.lionAnimations.get(i).cage.level + ".png").toExternalForm())));

                            if(Lion.lionAnimations.get(i).cage.level>=3)
                                Lion.lionAnimations.get(i).cage.level=Lion.lionAnimations.get(i).clone;
                        }
                        if (Lion.lionAnimations.get(i).addcage) {
                            Lion.lionAnimations.get(i).cage = new Cage((int) Lion.lionAnimations.get(i).lion.getX() - 60, (int) Lion.lionAnimations.get(i).lion.getY() - 50, anchorPane, 0);
                            Lion.lionAnimations.get(i).addcage = false;
                            Lion.lionAnimations.get(i).added = true;

                        }
                    }
                }



            }
        });

    }
    private void stopAll(){
        for (int i = 0; i < Cat.catAnimation.size(); i++) {
            Cat.catAnimation.get(i).stop();
        }
        for (int i = 0; i < Dog.dogAnimations.size(); i++) {
            Dog.dogAnimations.get(i).stop();
        }
        for (int i = 0; i < Lion.lionAnimations.size(); i++) {
            Lion.lionAnimations.get(i).stop();
        }
        for (int i = 0; i < Turkey.turkeyAnimations.size(); i++) {
            Turkey.turkeyAnimations.get(i).stop();
        }
        for (int i = 0; i < Ostrich.ostrichAnimations.size(); i++) {
            Ostrich.ostrichAnimations.get(i).stop();
        }
        for (int i = 0; i < Buffalo.buffaloAnimations.size(); i++) {
            Buffalo.buffaloAnimations.get(i).stop();
        }
        for (int i = 0; i < Product.productAnimations.size(); i++) {
            Product.productAnimations.get(i).stop();
        }
        time1.stop();
    }
    private void checkLevelFinished() throws IOException {
        if (Menu.chosenLevel==1){
            if (task01.getText().equals("5/5") && task02.getText().equals("2/2") && task03.getText().equals("1/1")){
                stopAll();
                PrizeLoader.display();
                Main main=new Main();
                main.changeScene("../fxml/Menu.fxml");
                if (Login.person.getLevel()==Menu.chosenLevel){
                    Login.person.setLevel(Login.person.getLevel()+1);
                }
                saveUsers();
            }
        }
        else if (Menu.chosenLevel==2){
            if (task01.getText().equals("10/10") && task02.getText().equals("3/3") && task03.getText().equals("1/1")){//10 egg 3 milk 1 pocket
                stopAll();
                PrizeLoader.display();
                Main main=new Main();
                main.changeScene("../fxml/Menu.fxml");
                if (Login.person.getLevel()==Menu.chosenLevel){
                    Login.person.setLevel(Login.person.getLevel()+1);
                }
                saveUsers();
            }
        }
        else if (Menu.chosenLevel==3){
            if (task01.getText().equals("5/5") && task02.getText().equals("3/3") && task03.getText().equals("1/1")){ //5 feather 3 cloth 1 shirt
                stopAll();
                PrizeLoader.display();
                Main main=new Main();
                main.changeScene("../fxml/Menu.fxml");
                if (Login.person.getLevel()==Menu.chosenLevel){
                    Login.person.setLevel(Login.person.getLevel()+1);
                }
                saveUsers();
            }
        }
        else if (Menu.chosenLevel==4){
            if (task01.getText().equals("5/5") && task02.getText().equals("5/5") && task03.getText().equals("5/5")){ //5 flour 5 cloth 5 pocketMilk
                stopAll();
                PrizeLoader.display();
                Main main=new Main();
                main.changeScene("../fxml/Menu.fxml");
                if (Login.person.getLevel()==Menu.chosenLevel){
                    Login.person.setLevel(Login.person.getLevel()+1);
                }
                saveUsers();
            }
        }
        else if (Menu.chosenLevel==5){
            if (task01.getText().equals("5/5") && task02.getText().equals("5/5") && task03.getText().equals("5/5")){ //5 bread 5 shirt 5 iceCream
                stopAll();
                PrizeLoader.display();
                Main main=new Main();
                main.changeScene("../fxml/Menu.fxml");
                if (Login.person.getLevel()==Menu.chosenLevel){
                    Login.person.setLevel(Login.person.getLevel()+1);
                }
                saveUsers();
            }
        }
    }
    private void saveUsers(){
        String userData="";
        for (int i = 0; i < Login.people.size(); i++) {
            userData+= Login.people.get(i).getUsername()+" "+Login.people.get(i).getPassword()+" "+Login.people.get(i).getMoney()+" "+Login.people.get(i).getLevel()+" "+Login.people.get(i).getName()+"\n";
        }
        try {
            FileWriter oredrDataWriter =new FileWriter("people.txt");
            oredrDataWriter.write(userData);
            oredrDataWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void music(String name)
    {
        String s=getClass().getResource(name).getPath();
        Media m=new Media(new File(s).toURI().toString());
        mediaPlayer = new MediaPlayer(m);
        mediaPlayer.setCycleCount(-1);
        mediaPlayer.play();
    }
}
