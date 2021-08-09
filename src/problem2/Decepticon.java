package problem2;

import java.util.HashMap;

// Decepticon --> Is A Transformer
public class Decepticon extends Transformer{
    public Decepticon(Type type, String name,  int strength, int intelligence, int speed, int endurance, int rank, int courage, int firepower, int skill) {
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

    @Override
    public int getTotalRating() {
        return super.getTotalRating();
    }

    // setter (optional)
    @Override
    public void setRating() {
        super.setRating();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    // Inner Class for 'Predaking'
    // Predeking --> Is A Decepticon and Transformer
    public static class Predaking extends Decepticon{

        public Predaking(Type type, String name ,int strength, int intelligence, int speed, int endurance, int rank, int courage, int firepower, int skill) {
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
