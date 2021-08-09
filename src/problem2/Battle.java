package problem2;

import java.time.Year;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class Battle {
    public static void battle(ArrayList<Transformer> autobots, ArrayList<Transformer> decepticons, int numberOfBattles) throws Exception{

        // define the max number of battles which is used to discover an error
        int maxNumberOfBattles = Math.min(autobots.size(), decepticons.size());
        // if the number of battles is greater than expected --> throw to Exception
        if(numberOfBattles > maxNumberOfBattles){
            throw new Exception("Error with the number of battles");
        }

        System.out.print("Team Autobots: ");

        // sorting by rank using comparator which is defined by anonymous class
        Collections.sort(autobots, new Comparator<Transformer>() {
            @Override
            public int compare(Transformer t1, Transformer t2) {
                if (t1.getRank() == t2.getRank()) {
                    return 0;
                } else if (t1.getRank() > t2.getRank()) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });

        // Print initial condition of team Autobots using iterator
        Iterator<Transformer> autobotIterator = autobots.iterator();
        while (autobotIterator.hasNext()) {
            Transformer nextItem = autobotIterator.next();
            System.out.print(nextItem.getName() + ", ");
        }

        System.out.println();

        System.out.print("Team Decepticons: ");

        // Sort by Lambda expression
        Collections.sort(decepticons, ((t1, t2) -> {
            if (t1.getRank() == t2.getRank()) {
                return 0;
            } else if (t1.getRank() > t2.getRank()) {
                return 1;
            } else {
                return -1;
            }
        }));

         /*
             If want to use Sorter Class --> ' Collections.sort(teamDecepticon, new TransformerSorter()); '
         */

        // Print initial condition of team Decepticons using iterator
        Iterator<Transformer> decepticonsIterator = decepticons.iterator();
        while (decepticonsIterator.hasNext()) {
            Transformer nextItem = decepticonsIterator.next();
            System.out.print(nextItem.getName() + ", ");
        }
        System.out.println();

        // Create instance objects which will be used for deciding winner
        BattleComparator comp = new BattleComparator();
        BattleComparatorWithCourageAndStrength compBySpecific = new BattleComparatorWithCourageAndStrength();
        BattleComparatorWithSkill compBySkill = new BattleComparatorWithSkill();
        CheckOptimusAndPredaking compByLeader = new CheckOptimusAndPredaking();

        // initialize score
        int countEliminatedByAutobot = 0;
        int countEliminatedByDecepticon = 0;

        // Following list will be used to how many transformer are left
        ArrayList<Transformer> restOfAutobot = (ArrayList<Transformer>) autobots.clone();
        ArrayList<Transformer> restOfDeceotiocon = (ArrayList<Transformer>) decepticons.clone();


        int battleCount = 1;
        // Start fighting one by one
        for(int i = 0; i < numberOfBattles; i++){
            // assign current transformers
            Transformer autobot = autobots.get(i);
            Transformer decepticon = decepticons.get(i);

            // Showing what round is going on and either transformers information
            System.out.println("Round "+ battleCount);
            System.out.println(autobot.getName() + ": " + autobot.getTotalRating() + " VS " + decepticon.getName() + ": " + decepticon.getTotalRating());

            // Rule 1:  Any Transformer named Optimus Prime or Predaking wins his fight automatically regardless of any other criteria
            if(compByLeader.compare(autobot, decepticon) == 0){
                // In this case, they are draw, so both will be destroyed
                System.out.println("Both are destroyed...");
                restOfAutobot.remove(autobot);
                restOfDeceotiocon.remove(decepticon);
                countEliminatedByAutobot++;
                countEliminatedByDecepticon++;
            } else if(compByLeader.compare(autobot, decepticon) == 1){
                // Autobot won, therefore transformer who belongs to Decepricons should be destroyed
                System.out.println("Optimus Prime must be winner!!");
                restOfDeceotiocon.remove(decepticon);
                countEliminatedByAutobot++;
            } else if(compByLeader.compare(autobot, decepticon) == -1){
                // Decepticon won, therefore transformer who belongs to Autobot should be destroyed
                System.out.println("Predaking must be winner!!");
                restOfAutobot.remove(autobot);
                countEliminatedByDecepticon++;
            }

            // Rule 2: If any fighter is down 4 or more points of courage and 3 or more points of
            // strength compared to their opponent, the opponent automatically wins the
            // face-off regardless of overall rating (opponent has ran away)
            else {
                if(compBySpecific.compare(autobot, decepticon) == 1){
                    BattleViewer.courageAndStrength(autobot, decepticon);
                    System.out.println("Winner: " + autobot.getName() + " (Opponent has runaway)");
                    restOfDeceotiocon.remove(decepticon);
                    countEliminatedByAutobot++;
                } else if((compBySpecific.compare(autobot, decepticon) == -1)){
                    BattleViewer.courageAndStrength(autobot, decepticon);
                    System.out.println("Winner: " + decepticon.getName() + " (Opponent has runaway)");
                    restOfAutobot.remove(autobot);
                    countEliminatedByDecepticon++;
                }

                // Rule 3: Otherwise, if one of the fighters is 3 or more points of skill above their
                //opponent, they win the fight regardless of overall rating
                else {
                    if(compBySkill.compare(autobot, decepticon) == 1){
                        BattleViewer.skill(autobot, decepticon);
                        System.out.println("Winner: " + autobot.getName() + " (Having greater skill)");
                        restOfDeceotiocon.remove(decepticon);
                        countEliminatedByAutobot++;
                    } else if((compBySkill.compare(autobot, decepticon) == -1)){
                        BattleViewer.skill(autobot, decepticon);
                        System.out.println("Winner: " + decepticon.getName() + " (Having greater skill)");
                        restOfAutobot.remove(autobot);
                        countEliminatedByDecepticon++;
                    }

                    // Rule 4: The winner is the Transformer with the highest overall rating
                    else {
                        if(comp.compare(autobot,decepticon) == 0){
                            System.out.println("Both are destroyed...");
                            restOfAutobot.remove(autobot);
                            restOfDeceotiocon.remove(decepticon);
                            countEliminatedByAutobot++;
                            countEliminatedByDecepticon++;
                        } else if(comp.compare(autobot, decepticon) == 1){
                            System.out.println("Winner: " + autobot.getName());
                            restOfDeceotiocon.remove(decepticon);
                            countEliminatedByAutobot++;
                        } else if(comp.compare(autobot, decepticon) == -1){
                            System.out.println("Winner: " + decepticon.getName());
                            restOfAutobot.remove(autobot);
                            countEliminatedByDecepticon++;

                        }
                    }
                }

            }
            // Showing current score
            System.out.println("Autobot " + countEliminatedByAutobot + " VS " + countEliminatedByDecepticon + " Decepticon");
            // at the end of battle, battle count -> +1
            battleCount++;
            System.out.println("---------------------------------");
        }

        // Checking winner
        int winner = winner(countEliminatedByAutobot, countEliminatedByDecepticon);
        System.out.println("----- Result -----");
        if(winner == 0) {
            System.out.println("Draw...");
        } else if(winner == 1) {
            // Print result
            System.out.println("The number of battles: " + numberOfBattles);
            System.out.println("The winning team: Autobot");
            System.out.print("Survivor of Decepticons: ");

            // Print all survivor using Iterator
            Iterator<Transformer> decepticonSurvivorIterator = restOfDeceotiocon.iterator();
            while (decepticonSurvivorIterator.hasNext()){
                Transformer nextItem = decepticonSurvivorIterator.next();
                System.out.print(nextItem.getName() + ", ");
            }
            System.out.println();
        } else {
            // Print result
            System.out.println("The number of battles: " + numberOfBattles);
            System.out.println("The winning team: Decepticon");
            System.out.print("Survivor of Autobots: ");

            // Print all survivor using Iterator
            Iterator<Transformer> autobotSurvivorIterator = restOfAutobot.iterator();
            while (autobotIterator.hasNext()){
                Transformer nextItem = autobotIterator.next();
                System.out.print(nextItem.getName() + ", ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int winner(int autobot, int deception){
        if(autobot == deception){
            return 0;
        } else if(autobot > deception){
            return 1;
        } else {
            return -1;
        }
    }


    // define Comparator classes as Inner class
    public static class BattleComparatorWithCourageAndStrength implements Comparator<Transformer>{

        @Override
        public int compare(Transformer t1, Transformer t2) {
            if(t1.getCourage() - t2.getCourage() > 4 || t1.getStrength() - t2.getStrength() > 3){
                return 1;
            }
            else if(t2.getCourage() - t1.getCourage() > 4 || t2.getStrength() - t1.getStrength() > 3){
                return -1;
            }
            return 0;
        }
    }

    public static class BattleComparatorWithSkill implements Comparator<Transformer>{

        @Override
        public int compare(Transformer t1, Transformer t2) {
            if(t1.getSkill() - t2.getSkill() > 3){
                return 1;
            }
            else if(t2.getSkill() - t1.getSkill() > 3){
                return -1;
            }
            return 0;
        }
    }


    public static class BattleComparator implements Comparator<Transformer> {

        @Override
        public int compare(Transformer autobot, Transformer decepticon) {
            if(autobot.getTotalRating() == decepticon.getTotalRating()){
                return 0;
            } else if(autobot.getTotalRating() > decepticon.getTotalRating()){
                return 1;
            } else {
                return -1;
            }
        }
    }

    public static class CheckOptimusAndPredaking implements Comparator<Transformer>{

        public int compare(Transformer autobot, Transformer decepticon) {
            if(autobot instanceof Autobot.OptimusPrime && decepticon instanceof Decepticon.Predaking){
                return 0;
            } else if(autobot instanceof Autobot.OptimusPrime){
                return 1;
            } else if(decepticon instanceof Decepticon.Predaking){
                return -1;
            }
            return 100;
        }
    }
}
