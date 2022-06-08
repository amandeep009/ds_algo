package sliding_window.fixed;

import java.util.HashMap;

public class CountNumberOfAnagrams {
    public static void main(String[] args) {
        System.out.println(countAnagrams("abcabc","abc"));
        System.out.println(countAnagrams("abcabcd","abcd"));

        System.out.println(countAnagrams("aaaa","a"));
        System.out.println(countAnagrams("aaaa","aaaaaa"));
    }

    //Important trick is uniqueElements...
    static int countAnagrams(String str1, String str2){
        if(str2.length()>str1.length()){
            return 0;
        }
        int l=0;
        int count = 0;
        int r=0;
        HashMap<Character,Integer> targetFreqMap = getTargetFreqMap(str2);
        int uniqueElements = targetFreqMap.size();

        for (int i = 0; i <str1.length() ; i++) {
            //Do calculations that is reduce the frequency
            if(targetFreqMap.get(str1.charAt(i))!=null) {
                targetFreqMap.put(str1.charAt(i), targetFreqMap.get(str1.charAt(i)) - 1);
            }
            if(targetFreqMap.get(str1.charAt(i))!=null && targetFreqMap.get(str1.charAt(i))==0){
                uniqueElements--;
            }

            if(r-l+1==str2.length()){
                if(uniqueElements==0){
                    count++;
                }
                targetFreqMap.put(str1.charAt(l), targetFreqMap.get(str1.charAt(l)) + 1);
                if(targetFreqMap.get(str1.charAt(l))==1){
                    uniqueElements++;
                }
                l++;
            }
            r++;
        }

        return count;
    }




    static HashMap<Character,Integer> getTargetFreqMap(String str){
        HashMap<Character,Integer> targetFreq = new HashMap<>();
        for (int i = 0; i <str.length() ; i++) {
            populateMap(str, targetFreq, i);
        }
        return targetFreq;
    }

    private static void populateMap(String str, HashMap<Character, Integer> targetFreq, int i) {
        if(targetFreq.containsKey(str.charAt(i) ) && targetFreq.get(str.charAt(i))>0){
            targetFreq.put(str.charAt(i),targetFreq.get(str.charAt(i)+1));
        }else{
            targetFreq.put(str.charAt(i),1);
        }
    }
}
