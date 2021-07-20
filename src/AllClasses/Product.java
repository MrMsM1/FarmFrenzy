package AllClasses;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class Product extends Rectangle {
    public static ArrayList<Product> products=new ArrayList<>();
    public static ArrayList<ProductAnimation> productAnimations =new ArrayList<>();
    private String name;
    private int sellPrice;
    private int timeOfDestruction;
    private int timeOfCreation;
    private boolean removed;
    private int size;
     int index;
    AnchorPane anchorPane;
    public Product(int x,int y,int timeOfDestruction,String name,int size,AnchorPane anchorPane){
        super(x,y,50,50);
        this.timeOfDestruction=timeOfDestruction;
        this.timeOfCreation=0;
        this.name=name;
        this.anchorPane=anchorPane;
        this.removed=false;
        this.size=size;
        products.add(this);
        this.index=products.size()-1;
        productAnimations.add(new ProductAnimation(this));
        productAnimations.get(index).setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                anchorPane.getChildren().remove(products.get(index));
                products.remove(products.get(index));
                productAnimations.get(index).stop();
                productAnimations.remove(index);
                for (int i = 0; i < products.size(); i++) {
                    products.get(i).index=i;
                }
            }
        });
        productAnimations.get(productAnimations.size()-1).play();

    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void ShowP(double x, double y)
    {
        this.setX(x);
        this.setY(y);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isRemoved() {
        return removed;
    }

    public void setRemoved(boolean removed) {
        this.removed = removed;
    }

    public int getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(int sellPrice) {
        this.sellPrice = sellPrice;
    }

    public int getTimeOfDestruction() {
        return timeOfDestruction;
    }

    public void setTimeOfDestruction(int timeOfDestruction) {
        this.timeOfDestruction = timeOfDestruction;
    }

    public int getTimeOfCreation() {
        return timeOfCreation;
    }

    public void setTimeOfCreation(int timeOfCreation) {
        this.timeOfCreation = timeOfCreation;
    }
}
