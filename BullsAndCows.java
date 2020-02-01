package main.java.leetCode;

import java.util.HashMap;

/**
 * Created by qiuqian on 8/13/18.
 */
public class BullsAndCows {
    public String getHint(String secret, String guess) {
        int bullsNum = 0;
        int sameNum = 0;
        HashMap<Character, Integer> secretCharMap = new HashMap<>();
        HashMap<Character, Integer> guessCharMap = new HashMap<>();
        for(int i = 0; i < secret.length(); i++) {
            if(secret.charAt(i) == guess.charAt(i)) {
                bullsNum++;
            }

            secretCharMap.putIfAbsent(secret.charAt(i), 0);
            secretCharMap.put(secret.charAt(i), secretCharMap.get(secret.charAt(i)) + 1);

            guessCharMap.putIfAbsent(guess.charAt(i), 0);
            guessCharMap.put(guess.charAt(i), secretCharMap.get(guess.charAt(i)) + 1);
        }

        for(Character c : secretCharMap.keySet()) {
            if(guessCharMap.containsKey(c)) {
                sameNum += Math.min(guessCharMap.get(c), secretCharMap.get(c));
            }
        }
        return new String(bullsNum + "A" + (sameNum - bullsNum) + "B");

    }


}
