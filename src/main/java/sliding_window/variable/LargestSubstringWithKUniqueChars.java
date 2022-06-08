package sliding_window.variable;

import java.util.HashMap;

public class LargestSubstringWithKUniqueChars {
    public static void main(String[] args) {
        String str = "abccccdadaaaaa";
//        System.out.println(longestSubStringWithKUniqeChars(str,4));
//        System.out.println(longestSubStringWithKUniqeChars(str,3));
        System.out.println(longestSubStringWithKUniqeChars(str,2));
    }

    private static String longestSubStringWithKUniqeChars(String str, int k) {
        int l=0,r=0;
        HashMap<Character,Integer> freqMap = new HashMap<>();
        int maxLength = Integer.MIN_VALUE;
        String maxString = "";
        for (int i = 0; i <str.length() ; i++) {
            populateMap(str, freqMap, i);
            if(freqMap.size()==k){
                if(r-l+1>maxLength){
                    maxLength = r-l+1;
                    maxString = str.substring(l,r+1); // Important point, substring is inclusive.
                }
            }
            if(freqMap.size()>k){
                freqMap.put(str.charAt(l), freqMap.get(str.charAt(l)) - 1);
                if (freqMap.get(str.charAt(l)) == 0) {
                    freqMap.remove(str.charAt(l));
                }
                l++;
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
