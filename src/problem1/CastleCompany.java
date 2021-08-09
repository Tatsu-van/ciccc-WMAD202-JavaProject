package problem1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class CastleCompany {
    public static void run() throws FileNotFoundException{
        System.out.println("--------- Problem1 ----------");


        try{
            File inputFile = new File("/Users/tatsu/IdeaProjects/WMAD202Structure/WMAD202-project/src/problem1/castle.txt");
            Scanner in = new Scanner(inputFile);

            String line;

            ArrayList<Integer> land = new ArrayList<>();
            ArrayList<Castle> castles = new ArrayList<>();

            while (in.hasNext()) {
                line = in.next();
                if (line.length() == 2) {
                    Castle c = new Castle(land);
                    castles.add(c);
                    land = new ArrayList<>();
                } else {
                    line = line.replace("[", "");
                    line = line.replace("]", "");
                    String[] stringNum = line.split(",");
                    for (String s : stringNum) {
                        int num = Integer.parseInt(s);
                        land.add(num);
                    }
                    Castle c = new Castle(land);
                    castles.add(c);
                    land = new ArrayList<>();
                }
            }
            in.close();

            try{
                int landCount = 1;
                Iterator<Castle> iterator = castles.iterator();
                while (iterator.hasNext()){
                    System.out.println("Land No." + landCount);
                    Castle nextItem = iterator.next();
                    nextItem.numberOfCastle();
                    landCount++;
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        } catch (FileNotFoundException e){
            System.out.println("The file doesn't exist...");
        } finally {
            System.out.println("---------- END ----------");
        }

    }
}
