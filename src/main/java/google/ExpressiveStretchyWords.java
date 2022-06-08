package google;

public class ExpressiveStretchyWords {

    public static void main(String[] args) {
        String [] words = new String[]{"hello","hi","helo"};
        System.out.println(expressiveWords("heeeellooo",words));
    }

    public static  int expressiveWords(String s, String[] words) {
        int result = 0;
        for(int i=0;i<words.length;i++){
            if(isExpressiveWord(s,words[i]))
                result++;
        }
        return result;
    }

    public static boolean isExpressiveWord(String sample, String word) {

        int sampleIndex = 0;
        int wordIndex = 0;
        int stretchCount = 0;
        boolean isProbableStretch = false;
        while(sampleIndex<sample.length()){
            if(sample.charAt(sampleIndex)!=word.charAt(wordIndex)
                    && wordIndex>0 && word.charAt(wordIndex-1)==sample.charAt(sampleIndex)){
                stretchCount++;
            }
            else if(sample.charAt(sampleIndex)==word.charAt(wordIndex)){
                if(wordIndex<word.length()-1)
                    wordIndex++;
                if(stretchCount>=3){
                    isProbableStretch = true;
                }
                stretchCount=1;
            } else if(sample.charAt(sampleIndex)!=word.charAt(wordIndex)){
                return false;
            }
            sampleIndex++;
        }

        if(sampleIndex==sample.length() && wordIndex==word.length()-1 && isProbableStretch)
            return true;
        return false;

    }

}
