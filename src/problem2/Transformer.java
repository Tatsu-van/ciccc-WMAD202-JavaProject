package problem2;

import java.util.ArrayList;
import java.util.HashMap;

public class Transformer {

    // Type
    enum Type{Autobot, Decepticon};

    private Type type;
    private String name;
    private int strength, intelligence, speed, endurance, rank, courage, firepower, skill;

    // put key and value later
    private HashMap<String, Integer> rating = new HashMap<>();

    // Constructor
    public Transformer(Type type, String name, int strength, int intelligence, int speed, int endurance, int rank, int courage, int firepower, int skill){
        this.type = type;
        this.name = name;
        this.strength = strength;
        this.intelligence = intelligence;
        this.speed = speed;
        this.endurance = endurance;
        this.rank = rank;
        this.courage = courage;
        this.firepower = firepower;
        this.skill = skill;
        setRating();
    }

    // getter
    public String getName() {
        return name;
    }

    public int getRank() {
        return rank;
    }

    public int getStrength() {
        return strength;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getSpeed() {
        return speed;
    }

    public int getEndurance() {
        return endurance;
    }

    public int getCourage() {
        return courage;
    }

    public int getFirepower() {
        return firepower;
    }

    public int getSkill() {
        return skill;
    }

    public HashMap<String, Integer> getRating() {
        return rating;
    }

    public Type getType() {
        return type;
    }

    // setter
    public void setRating() {
        // receive each score and put in Hashmap
        this.rating.put("Strength", strength);
        this.rating.put("Intelligence", intelligence);
        this.rating.put("Speed", speed);
        this.rating.put("Endurance", endurance);
        this.rating.put("Rank", rank);
        this.rating.put("Courage", courage);
        this.rating.put("Firepower", firepower);
        this.rating.put("Skill", skill);
    }

    // Calculating total rating
    public int getTotalRating(){
        int totalRate = 0;
        for(Integer values: getRating().values()){
            totalRate += values;
        }
        return totalRate;
    }

    @Override
    public String toString() {
        return "{"+
                "Type: " + type + ' ' +
                "Name: '" + name + '\'' +
                ", Rating: " + rating + ' ' +
                "Total Rate: " + getTotalRating() + ' ' +
                "}";
    }
}
