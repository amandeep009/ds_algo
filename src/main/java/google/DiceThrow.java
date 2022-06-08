package google;

import java.util.ArrayList;

public class DiceThrow {
    public static void main(String[] args) {
        ArrayList<String> strings = diceThrow(4,
                "", new ArrayList<String>());
        System.out.println(strings.toString());
    }

    static ArrayList<String> diceThrow(int target, String processed,ArrayList<String> answer){
        if(target==0){
            answer.add(processed);
            System.out.println(processed);
            return answer; // Always return answer here - This is imp point. Dont return processed...
        }
        for (int i = 1; i <=6 && i<=target ; i++) {
                diceThrow(target-i,processed+i,answer);
        }
        return answer;
    }
}
