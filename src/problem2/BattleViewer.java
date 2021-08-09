package problem2;

import java.util.HashMap;

public class BattleViewer {
    public static void courageAndStrength(Transformer autobot, Transformer decepticon){
        HashMap<String, Integer> courageAndStrengthA = new HashMap<>();
        HashMap<String, Integer> courageAndStrengthD = new HashMap<>();
        courageAndStrengthA.put("Courage", autobot.getCourage());
        courageAndStrengthA.put("Strength", autobot.getStrength());
        courageAndStrengthD.put("Courage", decepticon.getCourage());
        courageAndStrengthD.put("Strength", decepticon.getStrength());
        System.out.println(autobot.getName() + ":" + courageAndStrengthA);
        System.out.println(decepticon.getName() + ": " + courageAndStrengthD);
    }

    public static void skill(Transformer autobot, Transformer decepticon){
        HashMap<String, Integer> skillA = new HashMap<>();
        HashMap<String, Integer> skillD = new HashMap<>();
        skillA.put("Skill", autobot.getSkill());
        skillD.put("Skill", decepticon.getSkill());
        System.out.println(autobot.getName() + ":" + skillA);
        System.out.println(decepticon.getName() + ": " + skillD);
    }
}
