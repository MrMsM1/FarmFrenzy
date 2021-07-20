package AllClasses;

import java.util.ArrayList;

public class Help {
    public static ArrayList<Integer> ostrich=new ArrayList<>();
    public static ArrayList<Integer> turkey=new ArrayList<>();
    public static ArrayList<Integer> buffalo=new ArrayList<>();

    public Help() {
        for (int i=0;i<100;i++)
        {
            ostrich.add(0);
            System.out.println(ostrich.size());
        }
    }
}
