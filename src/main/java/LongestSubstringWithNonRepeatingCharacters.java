import java.util.HashMap;

public class LongestSubstringWithNonRepeatingCharacters {

    public static void main(String[] args) {
        System.out.println(getMaxSubStringWithNonRepeatingChars("abba"));
        System.out.println(getMaxSubStringWithNonRepeatingChars("abcabcbb"));
        System.out.println(getMaxSubStringWithNonRepeatingChars("bbbbb"));
        System.out.println(getMaxSubStringWithNonRepeatingChars("pwwkew"));

    }

    public static int getMaxSubStringWithNonRepeatingChars(String str){
        int left = 0,right=0,max=0;
        HashMap<Character,Integer> charsByIndex = new HashMap<>();
        while(right<str.length()){
            if(charsByIndex.containsKey(str.charAt(right))){
                left = Math.max(charsByIndex.get(str.charAt(right)), left);
            }
            charsByIndex.put(str.charAt(right),right+1);
            max = Math.max(max,right-left+1);
            right++;
        }
        return max;
    }


}
