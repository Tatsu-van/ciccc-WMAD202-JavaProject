package problem1;

import java.util.ArrayList;
import java.util.Comparator;

public class Castle {
    ArrayList<Integer> sequence;

    public Castle(ArrayList<Integer> sequence){
        this.sequence = sequence;
    }

    public ArrayList<Integer> getSequence() {
        return sequence;
    }

    // Exception is optional. Please read line 90.
    public void numberOfCastle() throws ExceptionNullArray {
        int len = this.sequence.size();
        ArrayList<Integer> peakIndexes = new ArrayList<>();
        ArrayList<Integer> valleyIndexes = new ArrayList<>();
        NumberComparator comp = new NumberComparator();

        // Initialize the number of castle we can create
        int buildCount = 0;

        if(len > 0) {
            // If there are any numbers in the sequence, you can build castle at least one. so add 1 to buildCount
            buildCount++;

            for (int i = 1; i < len - 1; i++) {
                // Initialize condition of isPeak and isValley
                boolean isPeak = false;
                boolean isValley = false;

                // Assign current, previous, and next value
                int currentNum = sequence.get(i);
                int previousNum = sequence.get(i-1);
                int nextNum = sequence.get(i+1);

                // compare three numbers by using Comparator
                if(comp.compare(currentNum, previousNum) == 0 && comp.compare(currentNum, nextNum) == 0){
                    if(isAllSameNum()){
                        continue;
                    } else{
                        // If the below condition is true, which means it's peak, isPeak is going to be true
                        if(sequence.get(i) > sequence.get(i-2) && sequence.get(i) > sequence.get(i+2)){
                            isPeak = true;
                            peakIndexes.add(i);
                            // Otherwise, the below condition is true that is it's valley, isValley will be true
                        } else if(sequence.get(i) < sequence.get(i-2) && sequence.get(i) < sequence.get(i + 2)){
                            isValley = true;
                            valleyIndexes.add(i);
                        }
                    }
                    // doing the same things as above
                } else {
                    if (sequence.get(i) >= sequence.get(i-1) && sequence.get(i) >= sequence.get(i+1)){
                        isPeak = true;
                        peakIndexes.add(i);
                    } else if(sequence.get(i) <= sequence.get(i-1) && sequence.get(i) <= sequence.get(i+1)){
                        isValley = true;
                        valleyIndexes.add(i);
                    }
                }

                // If isPeak or isValley is true or both are true, it's going to add one to buildCount
                if(isPeak || isValley){
                    buildCount++;
                }
            }

            System.out.println("The land is: " + sequence);

            if(peakIndexes.size() == 0){
                System.out.println("There is no peak.");
            } else {
                System.out.print("Peak: ");
                for(Integer i: peakIndexes){
                    System.out.print(sequence.get(i) + ", ");
                }
                System.out.println();
            }

            if(valleyIndexes.size() == 0){
                System.out.println("There is no valley.");
            } else {
                System.out.print("Valley: ");
                for(Integer i: valleyIndexes){
                    System.out.print(sequence.get(i) + ", ");
                }
                System.out.println();
            }

            System.out.println("You can built " + buildCount + " castle(s)");
        } else {
            /*
              If want to show error massage for null sequence, use below code
//            -->  throw new ExceptionNullArray("The given Array is Null...");
            */
            System.out.println("The land is: " + sequence + " <-- Null");
            System.out.println("You can't build any castles. Sequence is null");
        }
    }

    public boolean isAllSameNum(){
        for(int i = 0; i < sequence.size()-1; i++){
            if(!sequence.get(i).equals(sequence.get(i + 1))){
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return "Castle{" +
                "sequence=" + sequence +
                '}';
    }

    public static class NumberComparator implements Comparator<Integer>{

        @Override
        public int compare(Integer i1, Integer i2) {
            if(i1.equals(i2)){
                return 0;
            } else if(i1 > i2){
                return 1;
            } else {
                return -1;
            }
        }
    }
}
