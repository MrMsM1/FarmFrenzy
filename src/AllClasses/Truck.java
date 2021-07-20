package AllClasses;

public class Truck {
    private int capacity;
    private int fullness;
    private int egg;
    private int feather;
    private int milk;
    private int iceCream;
    private int cloth;
    private int bread;
    private int lion;
    private int tiger;
    private int bear;
    private int shirt;
    private int flour;
    private int pocketMilk;
    private int turkey;
    private int ostrich;
    private int buffalo;
    private int cat;
    private int dog;
    public Truck() {
        this.capacity = 15;
        this.fullness = 0;
        this.egg = 0;
        this.feather = 0;
        this.milk = 0;
        this.iceCream = 0;
        this.cloth = 0;
        this.bread = 0;
        this.lion = 0;
        this.tiger = 0;
        this.bear = 0;
        this.shirt = 0;
        this.flour = 0;
        this.pocketMilk =0;
    }
    public int getTurkey() {
        return turkey;
    }

    public void setTurkey(int turkey) {
        this.turkey += turkey;
        setFullness(egg+feather+milk+ iceCream *4+cloth*2+bread*4+lion*15+tiger*15+bear*15+shirt*4+flour*2+ pocketMilk *4 + ostrich*5 + this.turkey*5 + buffalo*5);
    }

    public int getOstrich() {
        return ostrich;
    }

    public void setOstrich(int ostrich) {
        this.ostrich += ostrich;
        setFullness(egg+feather+milk+ iceCream *4+cloth*2+bread*4+lion*15+tiger*15+bear*15+shirt*4+flour*2+ pocketMilk *4 + this.ostrich*5 + turkey*5 + buffalo*5);
    }

    public int getBuffalo() {
        return buffalo;
    }

    public void setBuffalo(int buffalo) {
        this.buffalo += buffalo;
        setFullness(egg+feather+milk+ iceCream *4+cloth*2+bread*4+lion*15+tiger*15+bear*15+shirt*4+flour*2+ pocketMilk *4 + ostrich*5 + turkey*5 + this.buffalo*5);
    }

    public int getCat() {
        return cat;
    }

    public void setCat(int cat) {
        this.cat = cat;
    }

    public int getDog() {
        return dog;
    }

    public void setDog(int dog) {
        this.dog = dog;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getFullness() {
        return fullness;
    }

    public void setFullness(int fullness) {
        this.fullness = fullness;
    }

    public int getEgg() {
        return egg;
    }

    public void setEgg(int egg) {

        this.egg +=egg;
        setFullness(this.egg+feather+milk+ iceCream *4+cloth*2+bread*4+lion*15+tiger*15+bear*15+shirt*4+flour*2+ pocketMilk *4 + ostrich*5 + turkey*5 + buffalo*5);

    }

    public int getFeather() {
        return feather;
    }

    public void setFeather(int feather) {
        this.feather += feather;
        setFullness(egg+this.feather+milk+ iceCream *4+cloth*2+bread*4+lion*15+tiger*15+bear*15+shirt*4+flour*2+ pocketMilk *4 + ostrich*5 + turkey*5 + buffalo*5);
    }

    public int getMilk() {
        return milk;
    }

    public void setMilk(int milk) {
        this.milk += milk;
        setFullness(egg+feather+this.milk+ iceCream *4+cloth*2+bread*4+lion*15+tiger*15+bear*15+shirt*4+flour*2+ pocketMilk *4 + ostrich*5 + turkey*5 + buffalo*5);
    }

    public int getIceCream() {
        return iceCream;
    }

    public void setIceCream(int iceCream) {
        this.iceCream += iceCream;
        setFullness(egg+feather+milk+this.iceCream *4+cloth*2+bread*4+lion*15+tiger*15+bear*15+shirt*4+flour*2+ pocketMilk *4 + ostrich*5 + turkey*5 + buffalo*5);
    }

    public int getCloth() {
        return cloth;
    }

    public void setCloth(int cloth) {
        this.cloth += cloth;
        setFullness(egg+feather+milk+ iceCream *4+this.cloth*2+bread*4+lion*15+tiger*15+bear*15+shirt*4+flour*2+ pocketMilk *4 + ostrich*5 + turkey*5 + buffalo*5);
    }

    public int getBread() {
        return bread;
    }

    public void setBread(int bread) {
        this.bread += bread;
        setFullness(egg+feather+milk+ iceCream *4+cloth*2+this.bread*4+lion*15+tiger*15+bear*15+shirt*4+flour*2+ pocketMilk *4 + ostrich*5 + turkey*5 + buffalo*5);
    }

    public int getLion() {
        return lion;
    }

    public void setLion(int lion) {
        this.lion += lion;
        setFullness(egg+feather+milk+ iceCream *4+cloth*2+bread*4+this.lion*15+tiger*15+bear*15+shirt*4+flour*2+ pocketMilk *4 + ostrich*5 + turkey*5 + buffalo*5);
    }

    public int getTiger() {
        return tiger;
    }

    public void setTiger(int tiger) {
        this.tiger += tiger;
        setFullness(egg+feather+milk+ iceCream *4+cloth*2+bread*4+lion*15+this.tiger*15+bear*15+shirt*4+flour*2+ pocketMilk *4 + ostrich*5 + turkey*5 + buffalo*5);
    }

    public int getBear() {
        return bear;
    }

    public void setBear(int bear) {
        this.bear += bear;
        setFullness(egg+feather+milk+ iceCream *4+cloth*2+bread*4+lion*15+tiger*15+this.bear*15+shirt*4+flour*2+ pocketMilk *4 + ostrich*5 + turkey*5 + buffalo*5);
    }

    public int getShirt() {
        return shirt;
    }

    public void setShirt(int shirt) {
        this.shirt += shirt;
        setFullness(egg+feather+milk+ iceCream *4+cloth*2+bread*4+lion*15+tiger*15+bear*15+this.shirt*4+flour*2+ pocketMilk *4 + ostrich*5 + turkey*5 + buffalo*5);
    }

    public int getFlour() {
        return flour;
    }

    public void setFlour(int flour) {
        this.flour += flour;
        setFullness(egg+feather+milk+ iceCream *4+cloth*2+bread*4+lion*15+tiger*15+bear*15+shirt*4+this.flour*2+ pocketMilk *4 + ostrich*5 + turkey*5 + buffalo*5);
    }

    public int getPocketMilk() {
        return pocketMilk;
    }

    public void setPocketMilk(int pocketMilk) {
        this.pocketMilk += pocketMilk;
        setFullness(egg+feather+milk+ iceCream *4+cloth*2+bread*4+lion*15+tiger*15+bear*15+shirt*4+flour*2+this.pocketMilk *4 + ostrich*5 + turkey*5 + buffalo*5);
    }

}
