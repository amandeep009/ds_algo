package sliding_window.variable;

import java.util.HashMap;

public class LargestSubstringWithoutRepeatingChars {
    public static void main(String[] args) {

        System.out.println(largestSubstringWithoutRepeatingChars("abccccdadaaaaa"));
        System.out.println(largestSubstringWithoutRepeatingChars("aaaaa"));
        System.out.println(largestSubstringWithoutRepeatingChars("aaaaabca"));
        System.out.println(largestSubstringWithoutRepeatingChars("babc"));
    }

    private static String largestSubstringWithoutRepeatingChars(String str) {
        int l=0,r=0;
        HashMap<Character,Integer> freqMap = new HashMap<>();
        int maxLength = Integer.MIN_VALUE;
        String maxString = "";
        for (int i = 0; i <str.length() ; i++) {
            populateMap(str, freqMap, i);
            if(freqMap.get(str.charAt(i))>1){
             //Move the left pointer to index next character observed... This is important point...
                 while(l<=i && freqMap.get(str.charAt(i))>1){
                     freqMap.put(str.charAt(l),freqMap.get(str.charAt(l))-1);
                     if(freqMap.get(str.charAt(l))==0){
                         freqMap.remove(str.charAt(l));
                     }
                     l++;
                 }
            }
            if(freqMap.get(str.charAt(i))==1){
                //Potential answer
                if(r-l+1>maxLength){
                    maxLength = r-l+1;
                    maxString = str.substring(l,r+1);
                }
            }
            r++;
        }
        return maxString;
    }

    private static void populateMap(String str, HashMap<Character, Integer> freqMap, int i) {
        if(freqMap.containsKey(str.charAt(i))){
            freqMap.put(str.charAt(i),freqMap.get(str.charAt(i))+1);
        }else{
            freqMap.put(str.charAt(i),1);
        }
    }
}
