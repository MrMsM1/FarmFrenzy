package AllClasses;

public class Person {
    private String username;
    private String password;
    private String name;
    private int Level;
    private int money;
    private int[] levelTime=new int[5];

    public Person(String username, String password,int money,int level,String name) {
        this.username = username;
        this.password = password;
        this.money = money;
        this.Level=level;
        this.name=name;
        for (int i = 0; i < 5; i++) {
            levelTime[i]=-1;
        }
    }

    public int[] getLevelTime() {
        return levelTime;
    }

    public void setLevelTime(int[] levelTime) {
        this.levelTime = levelTime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getLevel() {
        return Level;
    }

    public void setLevel(int level) {
        Level = level;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
