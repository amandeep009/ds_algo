package google;

import java.util.ArrayList;
import java.util.HashMap;

public class PhoneNumberPattern {
    static int count = 0;
    public static void main(String[] args) {

        HashMap<Integer,Character[]> map = new HashMap<>();
        map.put(2,new Character[] {'a','b','c'});
        map.put(3,new Character[] {'d','e','f'});
        map.put(4,new Character[] {'g','h','i'});
        map.put(5,new Character[] {'j','k','l'});
        map.put(6,new Character[] {'m','n','o'});
        map.put(7,new Character[] {'p','q','r','s'});
        map.put(8,new Character[] {'t','u','v'});
        map.put(9,new Character[] {'w','x','y','z'});
        ArrayList<String> patterns = pattern("", "98", new ArrayList<String>(), map);
        System.out.println(patterns.toString());
        System.out.println(count);
    }

    static ArrayList<String> pattern(String processed, String unProcessed,ArrayList<String> answer,HashMap<Integer,Character[]> map){
        count++;
        if(unProcessed.isEmpty()){
            answer.add(processed);
            return answer;
        }
        int c = Integer.parseInt(unProcessed.charAt(0)+"");
        Character[] characters = map.get(c);

        for(int i=0;i<characters.length;i++){
            pattern(processed+characters[i],unProcessed.substring(1),answer,map);
        }
        return answer;
    }


}

