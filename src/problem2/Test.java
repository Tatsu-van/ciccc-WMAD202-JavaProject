package problem2;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.Year;
import java.util.*;

public class Test {
    public static void run() throws FileNotFoundException, Exception {
        System.out.println("--------- Problem2 ---------");

        try {

            // Create an object of the File class
            File inputFile = new File("/Users/tatsu/IdeaProjects/WMAD202Structure/WMAD202-project/src/problem2/transformer.txt");
            // Create an object of the scanner class
            Scanner in = new Scanner(inputFile);
            // Using delimiter to divide each line
            in.useDelimiter("[*\n]");
            String line;

            // Create two ArrayList which are used to store Autobot and Decepticon objects
            ArrayList<Transformer> teamAutobots = new ArrayList<>();
            ArrayList<Transformer> teamDecepticons = new ArrayList<>();

            while (in.hasNext()) {
                // input for get information
                line = in.next();

                Transformer.Type Type;
                Transformer t;
                // input data until it's blank (break line)
                if (!line.equals("")) {
                    // split line to read each information
                    String[] info = line.split("[,]");
                    String name = info[0];
                    String typeString = info[1];

                    int Strength = Integer.parseInt(info[2]);
                    int Intelligence = Integer.parseInt(info[3]);
                    int Speed = Integer.parseInt(info[4]);
                    int Endurance = Integer.parseInt(info[5]);
                    int Rank = Integer.parseInt(info[6]);
                    int Courage = Integer.parseInt(info[7]);
                    int Firepower = Integer.parseInt(info[8]);
                    int Skill = Integer.parseInt(info[9]);

                    // if the name is Optimus, it will be created an Optimus object
                    if (name.toLowerCase().contains("optimus")) {
                        Type = Transformer.Type.Autobot;
                        t = new Autobot.OptimusPrime(Type, name, Strength, Intelligence, Speed, Endurance, Rank, Courage, Firepower, Skill);
                        teamAutobots.add(t);
                        // if the name is Predaking, it will be created an Predaking object
                    } else if (name.toLowerCase().contains("predaking")) {
                        Type = Transformer.Type.Decepticon;
                        t = new Decepticon.Predaking(Type, name, Strength, Intelligence, Speed, Endurance, Rank, Courage, Firepower, Skill);
                        teamDecepticons.add(t);
                        // if type is A, which means it is Transformer belongs to Autobot, it will be created an Autobot object
                    } else if (typeString.equals("A")) {
                        Type = Transformer.Type.Autobot;
                        t = new Autobot(Type, name, Strength, Intelligence, Speed, Endurance, Rank, Courage, Firepower, Skill);
                        teamAutobots.add(t);
                        // if the type is D, that is it is Transformer belongs to Decepticons, it will be created an Decepticon object
                    } else if (typeString.equals("D")) {
                        Type = Transformer.Type.Decepticon;
                        t = new Decepticon(Type, name, Strength, Intelligence, Speed, Endurance, Rank, Courage, Firepower, Skill);
                        teamDecepticons.add(t);
                    } else{
                        throw new Exception("You need Transformer Type...");
                    }
                } else {

                    try {
                        Battle.battle(teamAutobots, teamDecepticons, Math.min(teamAutobots.size(), teamDecepticons.size()));

                        // if the number of battle is greater than the number of either teams,
                        // it will show an error message by Exception
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    //
                    teamAutobots.clear();
                    teamDecepticons.clear();
                }
            }
            try {
                Battle.battle(teamAutobots, teamDecepticons, Math.min(teamAutobots.size(), teamDecepticons.size()));

                // if the number of battle is greater than the number of either teams,
                // it will show an error message by Exception
            } catch (Exception e) {
                e.printStackTrace();
            }
            in.close();
        } catch (java.lang.Exception e){
            e.printStackTrace();
        } finally {
            System.out.println("---------- END ----------");
        }
    }
}
