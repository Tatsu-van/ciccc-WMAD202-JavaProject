package problem2;

import java.util.HashMap;

// Autobot --> Is a Transformer
public class Autobot extends Transformer{
    public Autobot(Type type, String name, int strength, int intelligence, int speed, int endurance, int rank, int courage, int firepower, int skill) {
        super(type, name, strength, intelligence, speed, endurance, rank, courage, firepower, skill);
        super.setRating();
    }

    // getter
    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public HashMap<String, Integer> getRating() {
        return super.getRating();
    }

    @Override
    public Type getType() {
        return super.getType();
    }

    @Override
    public int getRank() {
        return super.getRank();
    }

    @Override
    public int getStrength() {
        return super.getStrength();
    }

    @Override
    public int getIntelligence() {
        return super.getIntelligence();
    }

    @Override
    public int getSpeed() {
        return super.getSpeed();
    }

    @Override
    public int getEndurance() {
        return super.getEndurance();
    }

    @Override
    public int getCourage() {
        return super.getCourage();
    }

    @Override
    public int getFirepower() {
        return super.getFirepower();
    }

    @Override
    public int getSkill() {
        return super.getSkill();
    }

    public int getTotalRating(){
        return super.getTotalRating();
    }

    // setter(optional)
    @Override
    public void setRating() {
        super.setRating();
    }

    @Override
    public String toString() {
        return super.toString();
    }


    // Inner Class for 'Optimus Prime'
    // And OptimusPrime --> is a autobot and is a Transformer
    public static class OptimusPrime extends Autobot{

        public OptimusPrime(Type type, String name, int strength, int intelligence, int speed, int endurance, int rank, int courage, int firepower, int skill) {
            super(type, name, strength, intelligence, speed, endurance, rank, courage, firepower, skill);
        }

        @Override
        public String getName() {
            return super.getName();
        }

        @Override
        public int getRank() {
            return super.getRank();
        }


        @Override
        public HashMap<String, Integer> getRating() {
            return super.getRating();
        }

        public int getTotalRating(){
            return super.getTotalRating();
        }

        @Override
        public void setRating() {
            super.setRating();
        }

        @Override
        public String toString() {
            return super.toString();
        }
    }
}
